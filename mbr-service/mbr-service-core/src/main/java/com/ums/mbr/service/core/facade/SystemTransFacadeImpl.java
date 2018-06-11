package com.ums.mbr.service.core.facade;

import com.chinaums.otaserver.OTAServer;
import com.chinaums.security.rsa.core.UmsKeyType;
import com.ums.mbr.enums.ErrorCodes;
import com.ums.mbr.result.ServiceResult;
import com.ums.mbr.service.core.service.OrderInfService;
import com.ums.mbr.service.core.service.RootkeyService;
import com.ums.mbr.service.core.service.TermService;
import com.ums.mbr.service.core.service.TransLogService;
import com.ums.mbr.service.core.utils.RsaUtils;
import com.ums.mbr.service.domain.RootKey;
import com.ums.mbr.service.domain.Term;
import com.ums.mbr.service.domain.TransLog;
import com.ums.mbr.service.facade.SystemTransFacade;
import com.ums.mbr.utils.DateUtils;
import com.ums.mbr.utils.MemberUtils;
import com.ums.mbr.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: jcouyang@chinaums.com
 * Date: 2018/3/8 14:17
 */
@Service
public class SystemTransFacadeImpl extends BaseFacade implements SystemTransFacade {

    private static final Logger logger = LoggerFactory.getLogger(SystemTransFacadeImpl.class);
    private static final String SIGN_FORMAT_PEM = "pem";
    private static final String SIGN_FORMAT_XML = "xml";
    private static final long EIGHT_HOURS_SECND = 28800000; // 8小时的毫秒数=8*60*60*1000

    @Value("${member.publicKey}")
    private String memberPublicKey;

    @Resource
    private RootkeyService rootkeyService;
    @Resource
    private TermService termService;
    @Resource
    private TransLogService transLogService;
    @Resource
    private OrderInfService orderInfService;

    @Override
    public ServiceResult ota(TransLog transLog, int idx, String chkval, String randval) {
        // 默认成功，如果失败后面将其替换
        ServiceResult result = new ServiceResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());

        Term term = termService.findByPrimaryKey(transLog.getMchtno(), transLog.getTermno());
        boolean firstOTA = false;
        // 默认时间为空，则说明是第一次初始化
        if (StringUtils.isEmpty(term.getOtaTime())) {
            firstOTA = true;
            term.setOtaTime(DateUtils.formatNowTime());
        }

        long timeGap = new Date().getTime() - DateUtils.toDateTime(term.getOtaTime()).getTime();
        // 时间间隔在8小时内，但是执行次数超过允许的次数，即8小时OTA次数超限
        // 次数超限不进行记库，因为OTA本身是不要签名的，防止恶意插入数据来攻击数据库
        if ((timeGap < EIGHT_HOURS_SECND) && (term.getOtaAdmit() <= term.getOtaCount())) {
            logger.error("8小时内OTA次数超限，允许次数=[{}]", term.getOtaAdmit());

            result.setCode(ErrorCodes.SYS_OTA_COUNT_OVERFLOW.getCode());
            result.setMessage(ErrorCodes.SYS_OTA_COUNT_OVERFLOW.getMessage());

            return result;
        }

        transLog.setMachine(MemberUtils.getHostNameForLiunx());
        transLog.setCreateIp(MemberUtils.getLocalNetWorkIp());

        // 第一步，记录transLog操作日志
        String retserial = createTransLog(transLogService, transLog);
        String tradeNo = retserial;

        if (ERROR_RETSERIAL.equals(retserial)) {
            logger.error("外部交易号=[{}]重复", transLog.getOutTradeNo());

            result.setCode(ErrorCodes.SYS_OUT_TRADE_NO_REPEAT.getCode());
            result.setMessage(ErrorCodes.SYS_OUT_TRADE_NO_REPEAT.getMessage());

            return result;
        }

        // 第二部，算校验值对不对
        RootKey rootkey = rootkeyService.getRootKey(idx);

        if (!OTAServer.checkval(chkval, randval, transLog.getTermno(), rootkey.getDbkey())) {
            logger.error("校验值出错，dbkey=[{}],randval=[{}],chkval=[{}]", rootkey.getDbkey(), randval, chkval);
            result.setCode(ErrorCodes.SYS_OTA_CHKVAL_ERROR.getCode());
            result.setCode(ErrorCodes.SYS_OTA_CHKVAL_ERROR.getMessage());

            transLog = new TransLog(retserial);
            transLog.setCode(ErrorCodes.SYS_OTA_CHKVAL_ERROR.getCode());
            transLog.setMessage(ErrorCodes.SYS_OTA_CHKVAL_ERROR.getMessage());
            transLog.setRetTime(DateUtils.formatNowTime());
            transLogService.updateByPrimaryKey(transLog);

            return result;
        }

        // 第三部，生成公司钥
        Map<String, String> map = null;
        // RSA密钥格式兼容性问题
        String signFormat = transLog.getSignFormat();
        if (SIGN_FORMAT_PEM.equalsIgnoreCase(signFormat)) {
            map = RsaUtils.generateKey(UmsKeyType.PEM);
        } else if (SIGN_FORMAT_XML.equalsIgnoreCase(signFormat)) {
            map = RsaUtils.generateKey(UmsKeyType.XML);
        } else {
            // 默认Java的pkcs8格式
            map = RsaUtils.generateKey();
        }

        logger.info("生成的公司钥对=[{}]", map.toString());

        // 第四部，更新原终端的OTA控制信息
        Term updateTerm = new Term(transLog.getMchtno(), transLog.getTermno());
        updateTerm.setOtaCount(term.getOtaCount()+1>term.getOtaAdmit()?1:term.getOtaCount()+1);
        if (timeGap > EIGHT_HOURS_SECND) {
            updateTerm.setOtaCount(1);
            updateTerm.setOtaTime(DateUtils.formatNowTime());
        }
        updateTerm.setOtaAdmit(term.getOtaAdmit());
        updateTerm.setPrivateKey(map.get("private_key"));
        updateTerm.setPublicKey(map.get("public_key"));
        if (firstOTA) updateTerm.setOtaTime(DateUtils.formatNowTime());

        termService.updateByPrimaryKey(updateTerm);

        // 对数据进行加密，终端解密后才可以使用
        map = OTAServer.generateKeys(randval, map.get("private_key"), memberPublicKey, rootkey.getDbkey());
        map.put("trade_no",tradeNo);
        result.setRetMap(map);

        // 第五步，更新交易记录表
        transLog = new TransLog(retserial);
        transLog.setCode(ErrorCodes.SYS_SUCCESS.getCode());
        transLog.setMessage(ErrorCodes.SYS_SUCCESS.getMessage());
        transLog.setRetTime(DateUtils.formatNowTime());
        transLogService.updateByPrimaryKey(transLog);

        return result;
    }

    @Override
    public ServiceResult orderRequest(TransLog transLog) {

        ServiceResult result = new ServiceResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());
        Map<String, String> retMap = new HashMap<>();

        try {
            String mchtId = transLog.getMchtno();
            String termId = transLog.getTermno();

            // 1 判断外部流水号，不重复则记录transLog
            String retserial = createTransLog(transLogService, transLog);

            if (ERROR_RETSERIAL.equals(retserial)) {
                logger.error("外部交易号=[{}]重复", transLog.getOutTradeNo());

                result.setCode(ErrorCodes.SYS_OUT_TRADE_NO_REPEAT.getCode());
                result.setMessage(ErrorCodes.SYS_OUT_TRADE_NO_REPEAT.getMessage());

                return result;
            }

            transLog = new TransLog(retserial);

            //生成订单号
            String orderNo = createOrerinf(mchtId, termId, orderInfService);

            // 2.若订单号生成成功，订单号随结果返回
            if (orderNo != null) {
                retMap.put("orderNo", orderNo);
                result.setRetMap(retMap);

                transLog.setOrderNo(orderNo);
            }
            // 交易失败，进行相关处理
            else {
                logger.info("订单号请求失败");
                result.setCode(ErrorCodes.SYS_ORDER_NO_REQUEST_ERROR.getCode());
                result.setMessage(ErrorCodes.SYS_ORDER_NO_REQUEST_ERROR.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("出现系统异常：" + e.getMessage(), e);
            result.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
            result.setMessage("系统错误：" + e.getMessage());
        }

        // 4.更新transLog
        transLog.setCode(result.getCode());
        transLog.setMessage(result.getMessage());
        transLog.setRetTime(DateUtils.formatNowTime());

        transLogService.updateByPrimaryKey(transLog);

        return result;
    }
}
