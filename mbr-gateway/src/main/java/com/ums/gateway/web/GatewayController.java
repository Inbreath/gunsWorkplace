package com.ums.gateway.web;

import com.fasterxml.jackson.core.type.TypeReference;
import com.ums.gateway.basic.CustomObjectMapper;
import com.ums.mbr.beans.MemberRequest;
import com.ums.mbr.beans.MemberResponse;
import com.ums.mbr.beans.request.*;
import com.ums.mbr.enums.*;
import com.ums.mbr.result.ServiceResult;
import com.ums.mbr.service.domain.*;
import com.ums.mbr.service.facade.*;
import com.ums.mbr.utils.Base64;
import com.ums.mbr.utils.DateUtils;
import com.ums.mbr.utils.MemberUtils;
import com.ums.mbr.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class GatewayController {

    private static final Logger logger = LoggerFactory.getLogger(GatewayController.class);
    private static final BigDecimal zeroAmount = new BigDecimal(0.00);

    @Value("${member.publicKey}")
    private String memberPublicKey;
    @Value("${member.privateKey}")
    private String memberPrivateKey;

    @Resource
    private CustomObjectMapper objectMapper;
    @Resource
    private MchtFacade mchtFacade;
    @Resource
    private TermFacade termFacade;
    @Resource
    private BizTypeFacade bizTypeFacade;
    @Resource
    private TransactionFacade gdaTxnFacade;
    @Resource
    private SystemTransFacade sysTxnFacade;

    @RequestMapping(value = "/gateway", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object index(MemberRequest request) {
        long startTime = System.currentTimeMillis();
        logger.info("接收到前端请求报文=[{}]", objectMapper.toJsonString(request));

        MemberResponse response = MemberUtils.getMemberResponse(request);

        try {
            String mchtId = request.getMerchant_id();
            String termId = request.getTerminal_id();
            String bizTypeName = request.getBiz_type();
            String bizChannel = request.getBiz_channel();

            // 检查商户是否存在
            Mcht mcht = mchtFacade.findByMchtno(mchtId);

            if (null == mcht) {
                logger.error("商户=[{}]不存在", mchtId);
                response.setCode(ErrorCodes.SYS_MCHT_NOT_EXIST.getCode());
                response.setMessage(ErrorCodes.SYS_MCHT_NOT_EXIST.getMessage());

                String signature = MemberUtils.getTermSign(MemberUtils.convertBean(response), memberPrivateKey);
                response.setSign(signature);

                logger.info("返回到前端的数据=[{}]", objectMapper.toJsonString(response));

                return response;
            }

            // 不是开启状态
            if (!CommStatus.ON.getStat().equals(mcht.getState())) {
                logger.error("商户=[{}]状态非开启=[{}]", mchtId, mcht.getState());
                response.setCode(ErrorCodes.SYS_MCHT_STAT_ERROR.getCode());
                response.setMessage(ErrorCodes.SYS_MCHT_STAT_ERROR.getMessage());

                String signature = MemberUtils.getTermSign(MemberUtils.convertBean(response), memberPrivateKey);
                response.setSign(signature);

                logger.info("返回到前端的数据=[{}]", objectMapper.toJsonString(response));

                return response;
            }

            // 检查终端是否存在
            Term term = termFacade.findOneRecord(mchtId, termId);
            if (null == term) {
                logger.error("终端=[{}]=[{}]不存在", mchtId, termId);
                response.setCode(ErrorCodes.SYS_TERM_NOT_EXIST.getCode());
                response.setMessage(ErrorCodes.SYS_TERM_NOT_EXIST.getMessage());

                String signature = MemberUtils.getTermSign(MemberUtils.convertBean(response), memberPrivateKey);
                response.setSign(signature);

                logger.info("返回到前端的数据=[{}]", objectMapper.toJsonString(response));

                return response;
            }

            // 终端不是开启状态
            if (!CommStatus.ON.getStat().equals(term.getState())) {
                logger.error("终端=[{}]-[{}]状态非开启=[{}]", mchtId, termId, term.getState());
                response.setCode(ErrorCodes.SYS_TERM_STAT_ERROR.getCode());
                response.setMessage(ErrorCodes.SYS_TERM_STAT_ERROR.getMessage());

                String signature = MemberUtils.getTermSign(MemberUtils.convertBean(response), memberPrivateKey);
                response.setSign(signature);

                logger.info("返回到前端的数据=[{}]", objectMapper.toJsonString(response));

                return response;
            }

            // 检查交易是否存在
            BizType bizType = bizTypeFacade.findByCode(bizTypeName);
            if (null == bizType) {
                logger.error("交易类型=[{}]不存在", bizTypeName);
                response.setCode(ErrorCodes.SYS_UNKNOWN_BIZ_TYPE.getCode());
                response.setMessage(ErrorCodes.SYS_UNKNOWN_BIZ_TYPE.getMessage());

                String signature = MemberUtils.getTermSign(MemberUtils.convertBean(response), memberPrivateKey);
                response.setSign(signature);

                logger.info("返回到前端的数据=[{}]", objectMapper.toJsonString(response));

                return response;
            }

            // 交易不是开启状态
            if (!CommStatus.ON.getStat().equals(bizType.getState())) {
                logger.error("交易类型=[{}]状态非开启=[{}]", bizTypeName, bizType.getState());
                response.setCode(ErrorCodes.SYS_BIZ_TYPE_STATUS_ERROR.getCode());
                response.setMessage(ErrorCodes.SYS_BIZ_TYPE_STATUS_ERROR.getMessage());

                String signature = MemberUtils.getTermSign(MemberUtils.convertBean(response), memberPrivateKey);
                response.setSign(signature);

                logger.info("返回到前端的数据=[{}]", objectMapper.toJsonString(response));

                return response;
            }

            // 非OTA交易，验证签名
            if (!"umszj.member.otainit".equals(request.getBiz_type())) {
                boolean result = MemberUtils.verify(MemberUtils.convertBean(request, true), term.getPublicKey());

                if (!result) {
                    logger.error("验签失败[{}]-[{}]", mchtId, termId);

                    response.setTimestamp(DateUtils.formatNowTime());
                    response.setCode(ErrorCodes.SYS_SIGNATURE_ERROR.getCode());
                    response.setMessage(ErrorCodes.SYS_SIGNATURE_ERROR.getMessage());

                    String signature = MemberUtils.getTermSign(MemberUtils.convertBean(response), memberPrivateKey);
                    response.setSign(signature);

                    logger.info("返回到前端的数据=[{}]", objectMapper.toJsonString(response));

                    return response;
                }

                logger.info("验签通过，开始下一步操作");
            }

            // bizContent部分转化为HaspMap对象
            Map<String, String> bizCtx = objectMapper.readValue(request.getBiz_content(), new TypeReference<HashMap<String, String>>() {});
            String outTradeNo = bizCtx.get("out_trade_no");
            Map<String, String> bizMap = new HashMap<>();
            ServiceResult result = null;

            TransLog transLog = new TransLog();

            // RETSERIAL       系统跟踪流水
            transLog.setMchtno(mchtId);
            transLog.setTermno(termId);
            // exmchtno
            // extermno

            transLog.setRequestId(request.getRequest_id());
            // TRADE_NO        会员系统定义的交易号
            transLog.setOutTradeNo(outTradeNo);
            // ORDER_NO        订单号，由会员系统生成
            transLog.setBizType(request.getBiz_type());

            transLog.setBizChannel(bizChannel);
            // BIZ_AGENCY      代理渠道
            transLog.setSignType(request.getSign_type());
            // SIGN            OTA交易默认上送1234
            transLog.setSignFormat(request.getSign_format());

            // CHARSET         报文字符编码
            transLog.setVersion(request.getVersion());
            transLog.setAppInfo(request.getApp_info());
            // MACHINE         运行机器名称
            transLog.setDeviceId(request.getDevice_id());

            transLog.setCreateIp(MemberUtils.getLocalNetWorkIp());
            transLog.setNotifyUrl(request.getNotify_url());
            transLog.setRequestTime(request.getTimestamp());
            // RET_TIME        返回时间
            transLog.setCreateTime(DateUtils.formatNowTime());

            // SUB_CODE        业务返回码
            // SUB_MESSAGE     业务返回码说明
            // CODE            网关返回码
            // MESSAGE         网关返回码说明
            // RESERVE         预留

            switch (bizTypeName) {
                case "umszj.member.otainit":
                    int idx = Integer.parseInt(bizCtx.get("idx"));
                    String chkval = bizCtx.get("chkval");
                    String randval = bizCtx.get("randval");

                    result = sysTxnFacade.ota(transLog, idx, chkval, randval);

                    if (null != result.getRetMap()) {
                        bizMap.put("private_key", result.getRetMap().get("private_key"));
                        bizMap.put("public_key", result.getRetMap().get("public_key"));
                        bizMap.put("trade_no", result.getRetMap().get("trade_no"));
                        response.setBiz_content(objectMapper.toJsonString(bizMap));
                    }

                    logger.info("map=[{}]", result.getRetMap());

                    break;

                case "umszj.member.posValidate":

                    String qrcode = bizCtx.get("manager_id");
                    result = gdaTxnFacade.posValidate(transLog, qrcode);

                    if (null != result.getRetMap()) {
                        bizMap = MemberUtils.upcase2underLine(result.getRetMap());

                        bizMap.put("out_trade_no", outTradeNo);
                        response.setBiz_content(objectMapper.toJsonString(bizMap));
                    }

                    break;

                case "umszj.member.posRegister":
                    qrcode = bizCtx.get("manager_id");
                    result = gdaTxnFacade.posRegister(transLog, qrcode);

                    if (null != result.getRetMap()) {
                        bizMap = MemberUtils.upcase2underLine(result.getRetMap());

                        bizMap.put("out_trade_no", outTradeNo);
                        response.setBiz_content(objectMapper.toJsonString(bizMap));
                    }

                    break;

                case "umszj.member.orderRequest":

                    result = sysTxnFacade.orderRequest(transLog);

                    if (null != result.getRetMap()) {
                        bizMap = MemberUtils.upcase2underLine(result.getRetMap());

                        bizMap.put("out_trade_no", outTradeNo);
                        response.setBiz_content(objectMapper.toJsonString(bizMap));
                    }

                    break;

                case "umszj.member.memberQuery":

                    MemberQueryRequestBody mbody = objectMapper.readValue(request.getBiz_content(), new TypeReference<MemberQueryRequestBody>() {});
                    Customer customer = new Customer();

                    customer.setCustomerType(MemberUtils.termcase2memberCase(mbody.getCustomer_type()));
                    customer.setCustomerId(mbody.getCustomer_id());
                    customer.setCardNo(mbody.getCard_no());
                    customer.setTelephone(mbody.getTelephone());
                    customer.setInputType(MemberUtils.termcase2memberCase(mbody.getInput_type()));

                    customer.setPageSize(mbody.getPage_size());
                    customer.setPageNo(mbody.getPage_no());
                    customer.setStartTime(mbody.getStart_time());
                    customer.setEndTime(mbody.getEnd_time());
                    customer.setOrderAmount(mbody.getOrder_amount());

                    result = gdaTxnFacade.memberQuery(transLog, customer);

                    if (null != result.getRetMap()) {
                        bizMap = MemberUtils.upcase2underLine(result.getRetMap());

                        bizMap.put("out_trade_no", outTradeNo);
                        response.setBiz_content(objectMapper.toJsonString(bizMap));
                    }
                    break;

                case "umszj.member.verificationTrade":

                    VerificationTradeRequestBody vbody = objectMapper.readValue(request.getBiz_content(), new TypeReference<VerificationTradeRequestBody>(){});

                    TradeInf vinf = new TradeInf();

                    //初始化以及获取公共部分的参数
                    vinf.setMchtno(transLog.getMchtno());
                    vinf.setTermno(transLog.getTermno());
                    vinf.setPayCode(transLog.getBizChannel());
                    vinf.setCreateIp(transLog.getCreateIp());
                    vinf.setBizType(transLog.getBizType());

                    //bizcontent参数
                    vinf.setOutTradeNo(vbody.getOut_trade_no());
                    vinf.setOrderNo(vbody.getOrder_no());
                    transLog.setOrderNo(vbody.getOrder_no());
                    vinf.setCustomerType(MemberUtils.termcase2memberCase(vbody.getCustomer_type()));
                    vinf.setInputType(MemberUtils.termcase2memberCase(vbody.getInput_type()));
                    //对以下参数预处理
                    vinf.setMemberId(vbody.getCustomer_id());
                    vinf.setCardNo(vbody.getCard_no());
                    vinf.setTelephone(vbody.getTelephone());

                    vinf.setTradeAmount(StringUtils.isEmpty(vbody.getTrade_amount()) ? zeroAmount : new BigDecimal(vbody.getTrade_amount()));
                    vinf.setDisAmount(StringUtils.isEmpty(vbody.getDis_amount()) ? zeroAmount : new BigDecimal(vbody.getDis_amount()));
                    vinf.setScore(StringUtils.isEmpty(vbody.getScore()) ? zeroAmount : new BigDecimal(vbody.getScore()));

                    result = gdaTxnFacade.verificationTrade(transLog, vinf, vbody.getCoupon_list());

                    if (null != result.getRetMap()) {
                        bizMap = MemberUtils.upcase2underLine(result.getRetMap());

                        bizMap.put("out_trade_no", outTradeNo);
                        response.setBiz_content(objectMapper.toJsonString(bizMap));
                    }

                    break;

                case "umszj.member.orderCommit":

                    OrderCommitRequestBody obody = objectMapper.readValue(request.getBiz_content(), new TypeReference<OrderCommitRequestBody>(){});

                    Payinf pinf = new Payinf();
                    List<SubmitPaymentRequestBody> txns = null;
                    pinf.setMchtno(transLog.getMchtno());
                    pinf.setTermno(transLog.getTermno());
                    pinf.setMachine(transLog.getMachine());
                    pinf.setCreateIp(transLog.getCreateIp());
                    pinf.setVersion(transLog.getVersion());

                    pinf.setOutTradeNo(obody.getOut_trade_no());
                    pinf.setOrderNo(obody.getOrder_no());
                    pinf.setOriginalOrderNo(obody.getOld_order_no());
                    pinf.setOrderType(obody.getOrder_type());
                    pinf.setTotalAmount(StringUtils.isEmpty(obody.getTrade_amount()) ? zeroAmount : new BigDecimal(obody.getTrade_amount()));

                    pinf.setFactAmount(obody.getFact_amount());
                    pinf.setDiscountAmount(obody.getDiscount_amount());
                    pinf.setCustomerId(obody.getCustomer_id());

                    if (StringUtils.isNotEmpty(obody.getPay_info())) {
                        txns = objectMapper.readValue(obody.getPay_info(), new TypeReference<List<SubmitPaymentRequestBody>>(){});
                    }

                    result = gdaTxnFacade.orderCommit(transLog, pinf, txns);

                    if (null != result.getRetMap()) {
                        bizMap = MemberUtils.upcase2underLine(result.getRetMap());

                        bizMap.put("out_trade_no", outTradeNo);
                        response.setBiz_content(objectMapper.toJsonString(bizMap));
                    }

                    break;

                case "umszj.member.verificationCancel":

                    VerificationCancelRequestBody dbody = objectMapper.readValue(request.getBiz_content(), new TypeReference<VerificationCancelRequestBody>(){});

                    String _outTradeNo = dbody.getOut_trade_no();
                    String _orderNo    = dbody.getOrder_no();
                    String _oldTradeNo = dbody.getOld_trade_no();
                    String _oldOrderNo = dbody.getOld_order_no();
                    transLog.setOrderNo(_orderNo);

                    result = gdaTxnFacade.verificationCancel(transLog, _outTradeNo, _orderNo, _oldTradeNo, _oldOrderNo);

                    if (null != result.getRetMap()) {
                        bizMap = MemberUtils.upcase2underLine(result.getRetMap());

                        bizMap.put("out_trade_no", outTradeNo);
                        response.setBiz_content(objectMapper.toJsonString(bizMap));
                    }

                    break;

                case "umszj.member.transQuery":

                    MixQueryRequestBody qbody = objectMapper.readValue(request.getBiz_content(), new TypeReference<MixQueryRequestBody>(){});
                    result = gdaTxnFacade.mixQuery(transLog, qbody);

                    if (null != result.getRetMap()) {
                        bizMap = MemberUtils.upcase2underLine(result.getRetMap());

                        bizMap.put("out_trade_no", outTradeNo);
                        response.setBiz_content(objectMapper.toJsonString(bizMap));
                    }

                    break;

                case "umszj.member.couponBuilt":
                    CouponBuiltRequestBody bbody = objectMapper.readValue(request.getBiz_content(), new TypeReference<CouponBuiltRequestBody>(){});

                    Coupon coupon = new Coupon();

                    coupon.setPayCode("umszj.paycode.parking"); //默认只有停车券生成
                    coupon.setCouponValue(new BigDecimal(bbody.getAmount()));
                    coupon.setCouponName("停车券");
                    coupon.setCreateTime(DateUtils.formatNowTime());

                    result = gdaTxnFacade.couponBuilt(transLog, bbody.getAmount());

                    if (null != result.getRetMap()) {
                        bizMap = MemberUtils.upcase2underLine(result.getRetMap());

                        bizMap.put("out_trade_no", outTradeNo);
                        response.setBiz_content(objectMapper.toJsonString(bizMap));
                    }


                    break;

                default:
                    result = new ServiceResult(ErrorCodes.SYS_UNKNOWN_BIZ_TYPE.getCode(), ErrorCodes.SYS_UNKNOWN_BIZ_TYPE.getMessage());
                    break;
            }

            response.setCode(ErrorCodes.SYS_SUCCESS.getCode());
            response.setMessage(ErrorCodes.SYS_SUCCESS.getMessage());

            response.setSub_code(result.getCode());
            response.setSub_message(result.getMessage());
            response.setTimestamp(DateUtils.formatNowTime());

            String signature = MemberUtils.getTermSign(MemberUtils.convertBean(response), memberPrivateKey);
            response.setSign(signature);
            request.setBiz_channel(bizChannel);

        } catch (Exception e) {
            logger.error("出现异常=[{}]", e.getMessage());
            e.printStackTrace();
            response.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
            response.setMessage(ErrorCodes.SYS_SYSTEM_ERROR.getMessage());
            response.setTimestamp(DateUtils.formatNowTime());

            String signature = null;
            try {
                signature = MemberUtils.getTermSign(MemberUtils.convertBean(response), memberPrivateKey);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            response.setSign(signature);
        }

        logger.info("返回到前端的数据=[{}]", objectMapper.toJsonString(response));

        long endTime = System.currentTimeMillis();

        logger.info("本次交易耗时=[{}]毫秒", endTime - startTime);

        return response;
    }

}
