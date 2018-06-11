package com.ums.mbr.service.core.facade;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ums.mbr.RequestBean;
import com.ums.mbr.TransResult;
import com.ums.mbr.beans.request.CouponRequestSubBody;
import com.ums.mbr.beans.request.MixQueryRequestBody;
import com.ums.mbr.beans.request.SubmitPaymentRequestBody;
import com.ums.mbr.beans.response.*;
import com.ums.mbr.enums.*;
import com.ums.mbr.packer.GdaTransactionImpl;
import com.ums.mbr.packer.HyouTransactionImpl;
import com.ums.mbr.packer.gda.*;
import com.ums.mbr.packer.gda.request.GdaOrderSubmitSubRequestBody;
import com.ums.mbr.packer.hyou.HyouMemberQueryResponseBody;
import com.ums.mbr.packer.hyou.HyouMixQueryResponseBody;
import com.ums.mbr.packer.hyou.HyouValidateRequestSubBody;
import com.ums.mbr.packer.hyou.HyouVerificationResponseBody;
import com.ums.mbr.result.ServiceResult;
import com.ums.mbr.service.core.service.*;
import com.ums.mbr.service.domain.*;
import com.ums.mbr.service.facade.TransactionFacade;
import com.ums.mbr.utils.DateUtils;
import com.ums.mbr.utils.MemberUtils;
import com.ums.mbr.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * 国大的验证交易接口实现部分
 * Author: jcouyang@chinaums.com
 * Date: 2018/3/7 9:51
 */
@Service
public class GdaTransactionFacadeImpl extends BaseFacade implements TransactionFacade {

    private static final Logger logger = LoggerFactory.getLogger(GdaTransactionFacadeImpl.class);
    private static final BigDecimal zeroAmount = new BigDecimal(0.00);
    private static final String QUERY_SIGN_SUCCESS = "1";
    private static final String QUERY_SIGN_FAIL = "0";

    @Value("${gda.appid}")
    private String appId;
    @Value("${gda.secureKey}")
    private String secureKey;
    @Value("${gda.baseUrl}")
    private String baseUrl;
    @Value("${hyou.appid}")
    private String appIdHyou;
    @Value("${hyou.secureKey}")
    private String secureKeyHyou;
    @Value("${hyou.baseUrl}")
    private String baseUrlHyou;

    @Resource
    private TransLogService transLogService;
    @Resource
    private GdaTransactionImpl gdaTransaction;
    @Resource
    private HyouTransactionImpl hyouTxnFacade;
    @Resource
    private OrderInfService orderInfService;
    @Resource
    private CustomerService customerService;
    @Resource
    private CouponService couponService;
    @Resource
    private PayInfService payInfService;
    @Resource
    private TradeInfService tradeInfService;
    @Resource
    private TradeCouponService tradeCouponService;
    @Resource
    private CardService cardService;

    private ObjectMapper objectMapper;

    public GdaTransactionFacadeImpl() {
        objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        // 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    @Override
    public ServiceResult posValidate(TransLog transLog, String qrcode) {

        ServiceResult result = new ServiceResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());
        Map<String, String> retMap = new HashMap<>();

        try {
            String mchtId = transLog.getMchtno();
            String termId = transLog.getTermno();

            // 1 记录transLog
            String retserial = createTransLog(transLogService, transLog);

            //返回错误的的流水号，表示outTradeNo唯一性检查失败
            if (ERROR_RETSERIAL.equals(retserial)) {
                logger.error("外部交易号=[{}]重复", transLog.getOutTradeNo());

                result.setCode(ErrorCodes.SYS_OUT_TRADE_NO_REPEAT.getCode());
                result.setMessage(ErrorCodes.SYS_OUT_TRADE_NO_REPEAT.getMessage());

                return result;
            }

            transLog = new TransLog(retserial);

            // 2 发起验证请求
            RequestBean bean = new RequestBean();
            bean.setMchtId(mchtId);
            bean.setTermId(termId);
            bean.setAppId(appId);
            bean.setSecureKey(secureKey);
            bean.setBaseUrl(baseUrl);
            bean.setManagerId(qrcode);

            TransResult tr = gdaTransaction.posValidate(bean);

            // 3.对返回信息进行处理：补充交易的subcode
            transLog.setSubCode(tr.getCode());
            transLog.setSubMessage(tr.getMessage());

            // 国大交易成功，则向终端返回tradeNo和storeName
            if (ErrorCodes.SYS_SUCCESS.getCode().equals(tr.getCode())) {
                GdaPosValidateResponseBody rb = (GdaPosValidateResponseBody) tr.getBody();

                // do something here
                retMap.put("tradeNo", retserial);
                retMap.put("storeName", rb.getStoreName());
                result.setRetMap(retMap);
            }
            // 交易失败，会员系统的错误代码使用国大的
            else {
                logger.info("POS验证返回失败");
                result.setCode(tr.getCode());
                result.setMessage(tr.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("系统错误：", e);
            result.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
            result.setMessage("系统错误：" + e.getMessage());
        }

        // 4.获取最终的系统处理结果，并更新transLog
        transLog.setCode(result.getCode());
        transLog.setMessage(result.getMessage());

        transLog.setRetTime(DateUtils.formatNowTime());
        transLogService.updateByPrimaryKey(transLog);

        return result;
    }

    @Override
    public ServiceResult posRegister(TransLog transLog, String qrcode) {

        ServiceResult result = new ServiceResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());
        Map<String, String> retMap = new HashMap<>();

        try {
            String mchtId = transLog.getMchtno();
            String termId = transLog.getTermno();

            // 1 记录transLog
            String retserial = createTransLog(transLogService, transLog);

            if (ERROR_RETSERIAL.equals(retserial)) {
                logger.error("外部交易号=[{}]重复", transLog.getOutTradeNo());

                result.setCode(ErrorCodes.SYS_OUT_TRADE_NO_REPEAT.getCode());
                result.setMessage(ErrorCodes.SYS_OUT_TRADE_NO_REPEAT.getMessage());

                return result;
            }

            transLog = new TransLog(retserial);

            // 2 发起注册请求
            RequestBean bean = new RequestBean();
            bean.setMchtId(mchtId);
            bean.setTermId(termId);
            bean.setAppId(appId);
            bean.setSecureKey(secureKey);
            bean.setBaseUrl(baseUrl);
            bean.setManagerId(qrcode);

            TransResult tr = gdaTransaction.posRegister(bean);

            // 3.对返回信息进行处理：补充交易的subcode
            transLog.setSubCode(tr.getCode());
            transLog.setSubMessage(tr.getMessage());

            // 国大交易成功，则向终端返回outTradeNo和tradeNo
            if (ErrorCodes.SYS_SUCCESS.getCode().equals(tr.getCode())) {
                retMap.put("tradeNo", retserial);
                result.setRetMap(retMap);
            }
            // 交易失败，会员系统的错误代码使用国大的
            else {
                logger.info("POS验证返回失败");
                result.setCode(tr.getCode());
                result.setMessage(tr.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
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

    @Override
    public ServiceResult memberQuery(TransLog transLog, Customer customer) {
        ServiceResult result = new ServiceResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());

        // 按照不同交易进行分别送到不同的接口
        try {
            // 1 如果是国大的会员，走慧优的接口查询
            if (CustomerTypes.MEMBER.getName().equals(customer.getCustomerType())) {

                // 会员查询须强制上送金额
                if (StringUtils.isEmpty(customer.getOrderAmount())) {
                    logger.error("会员查询：订单金额没有上送或无效");

                    result.setCode(ErrorCodes.SYS_ORDER_AMOUNT_ERROR.getCode());
                    result.setMessage(ErrorCodes.SYS_ORDER_AMOUNT_ERROR.getMessage());

                    return result;
                }
                return memberQueryByHyou(transLog, customer);
            }

            //国大的其他查询接口，通过支付的类型(BizChannel)来判断
            switch (transLog.getBizChannel()) {

                //国大员工餐卡查询
                case "umszj.paycode.emplyee":
                    result = emplyeeQuery(transLog, customer);
                    break;

                //国大的优惠券查询--和储值卡调用统一接口
                case "umszj.paycode.coupon":

               //国大的手工券查询--和储值卡调用统一接口
                case "umszj.paycode.handmade":

               //国大的其他券查询--和储值卡调用统一接口
                case "umszj.paycode.otherpay":

               //国大储值卡查询
                case "umszj.paycode.deposit":
                    result = dcQuery(transLog, customer);
                    break;

                //国大停车券查询
                case "umszj.paycode.parking":
                    result = parkingQuery(transLog, customer);
                    break;

                default:
                    result = new ServiceResult(ErrorCodes.SYS_UNKNOWN_BIZ_CHANNEL.getCode(), ErrorCodes.SYS_UNKNOWN_BIZ_CHANNEL.getMessage());
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("出现系统错误" + e.getMessage(), e);
            result.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
            result.setMessage("系统错误：" + e.getMessage());
        }

        return result;
    }
    //国大核销体系
    @Override
    public ServiceResult verificationTrade(TransLog transLog, TradeInf tradeInf, String couponList) {
        ServiceResult result = new ServiceResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());

        try {
            // 金额/积分判断，判断规则：交易金额大于0；折扣金额、积分不小于0；交易金额不小于折扣金额
            int result1 = tradeInf.getTradeAmount().compareTo(zeroAmount);
            int result2 = tradeInf.getDisAmount().compareTo(zeroAmount);
            int result3 = tradeInf.getScore().compareTo(zeroAmount);
            int result4 = tradeInf.getTradeAmount().compareTo(tradeInf.getDisAmount());
            if (0 >= result1 || -1 == result2 || -1 == result3 || -1 == result4){
                logger.error("金额或积分输入错误");

                result.setCode(ErrorCodes.SYS_AMUNT_OR_SCORE_ERROR.getCode());
                result.setMessage(ErrorCodes.SYS_AMUNT_OR_SCORE_ERROR.getMessage());

                return result;
            }

            // 订单号有效性、存在性判断
            OrderInf _orderInf = orderInfService.getOrderByOrderNo(transLog.getMchtno(), transLog.getTermno(), transLog.getOrderNo());
            if (null == _orderInf
                    || !OrderStatus.PAYING.getName().equals(_orderInf.getState())
                    ){//|| null == _orderInf.getEffectiveTime()
                    //|| 0 < DateUtils.formatNowTime().compareTo(DateUtils.addMinitues(new Date(), Integer.parseInt(_orderInf.getEffectiveTime())))) {
                logger.error("订单不存在或状态出错");

                result.setCode(ErrorCodes.SYS_ORDER_STATE_ERROR.getCode());
                result.setMessage(ErrorCodes.SYS_ORDER_STATE_ERROR.getMessage());

                return result;
            }

            // 核销接口选择
            if (CustomerTypes.MEMBER.getName().equals(tradeInf.getCustomerType())) {
                return memberVerificationByHyou(transLog, tradeInf, couponList);
            }
            switch (transLog.getBizChannel()) {

                //国大员工餐卡交易
                case "umszj.paycode.emplyee":
                    result = emplyeeVerification(transLog, tradeInf);
                    break;

                //国大的优惠券核销，同下
                case "umszj.paycode.coupon":

                //国大停车券核销，同下
                case "umszj.paycode.parking":

                //国大储值卡核销  D: deposit ；P: parking ；C: coupon
                case "umszj.paycode.deposit":
                    result = dpcVerification(transLog, tradeInf);
                    break;

                default:
                    result = new ServiceResult(ErrorCodes.SYS_UNKNOWN_BIZ_CHANNEL.getCode(), ErrorCodes.SYS_UNKNOWN_BIZ_CHANNEL.getMessage());
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            result.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
            result.setMessage("系统错误：" + e.getMessage());
        }

        return result;
    }

    //交易提交
    @Override
    public ServiceResult orderCommit(TransLog transLog, Payinf payinf, List<SubmitPaymentRequestBody> txns) {

        ServiceResult result = new ServiceResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());
        Map<String, String> retMap = new HashMap<>();

        try {
            String mchtId     = transLog.getMchtno();
            String termId     = transLog.getTermno();
            String transType;
            List<TradeInf> memberRecords;
            transLog.setOrderNo(payinf.getOrderNo());

            // 订单号有效性、存在性判断
            OrderInf _orderInf = orderInfService.getOrderByOrderNo(mchtId, termId, transLog.getOrderNo());
            if (null == _orderInf
                    || !OrderStatus.PAYING.getName().equals(_orderInf.getState())
                    ){//||  null == _orderInf.getEffectiveTime()
                    //|| 0 < DateUtils.formatNowTime().compareTo(DateUtils.addMinitues(new Date(), Integer.parseInt(_orderInf.getEffectiveTime())))) {
                logger.error("订单不存在或状态出错");

                result.setCode(ErrorCodes.SYS_ORDER_STATE_ERROR.getCode());
                result.setMessage(ErrorCodes.SYS_ORDER_STATE_ERROR.getMessage());

                return result;
            }

            // 1 记录transLog并生成流水号
            String retserial = createTransLog(transLogService, transLog);
            String tradeNo   = transLog.getTradeNo();

            // 2 返回错误的的流水号，表示outTradeNo唯一性检查失败
            if (ERROR_RETSERIAL.equals(retserial)) {
                logger.error("外部交易号=[{}]重复", transLog.getOutTradeNo());

                result.setCode(ErrorCodes.SYS_OUT_TRADE_NO_REPEAT.getCode());
                result.setMessage(ErrorCodes.SYS_OUT_TRADE_NO_REPEAT.getMessage());

                return result;
            }

            String orderNo = transLog.getOrderNo();

            // 4 打包数据，发起交易请求
            RequestBean bean = new RequestBean();
            switch (payinf.getOrderType()) {
                // 正常的销售类型
                case "order_comsume":
                    bean.setOrderType("1");
                    transType = TradeTypes.SALE.getName();
                    memberRecords = tradeInfService.findRecordsByOrderNo(mchtId, termId, orderNo,false);
                    break;
                case "order_refund":
                    bean.setOrderType("4");
                    transType = TradeTypes.VOID.getName();
                    bean.setOriginalOrderNo(payinf.getOriginalOrderNo());
                    memberRecords = tradeInfService.findRecordsByOrderNo(mchtId, termId, orderNo,true);
                    break;
                default:
                    bean.setOrderType("1");
                    transType = TradeTypes.SALE.getName();
                    memberRecords = tradeInfService.findRecordsByOrderNo(mchtId, termId, orderNo,false);
                    break;
            }

            // 5.2 记录交易信息
            List<GdaOrderSubmitSubRequestBody> oSubBodyList = new ArrayList<>(); // 将终端上送的交易信息转换成国大后端能识别的payment
            for (SubmitPaymentRequestBody item : txns) {

                // 查询该支付交易是否存在
                Payinf temPayinf = payInfService.findPayInfByOutTradeNo(item.getSub_out_trade_no(), transType);
                if (null == temPayinf) { // 交易不存在则进行插入
                    logger.info("支付交易[{}]-[{}]未记库，正在进行数据存储...", item.getSub_out_trade_no(), transType);

                    String _retserial = DateUtils.formatNowId() + String.format("%06d", (int) (Math.random() * 1000000));
                    temPayinf = payinf;
                    temPayinf.setRetserial(_retserial);
                    temPayinf.setTransType(transType);
                    temPayinf.setState(TradeStatus.SUCCESS.getName());
                    temPayinf.setBuyerPayAmount(new BigDecimal(item.getSub_fact_amount()));
                    temPayinf.setScore(StringUtils.isEmpty(item.getSub_score()) ? zeroAmount : new BigDecimal(item.getSub_score()));
                    temPayinf.setCardNo(item.getCard_no());

                    temPayinf.setPaycode(item.getPay_code());
                    temPayinf.setMailTradeNo(item.getSub_trade_no());
                    temPayinf.setOutTradeNo(item.getSub_out_trade_no());
                    temPayinf.setPayTime(item.getPay_time());
                    temPayinf.setNote(item.getNote());

                    temPayinf.setPhoneCode(item.getPhone_code());
                    temPayinf.setCenterNo(item.getCenter_no());
                    temPayinf.setCreateTime(DateUtils.formatNowTime());
                    temPayinf.setRefernceNo(item.getReference_no());
                    temPayinf.setBankName(item.getBank_name());

                    temPayinf.setAcquierName(item.getAcquier_name());
                    temPayinf.setMachine(item.getMachine());
                    temPayinf.setTraceno(item.getTrace_no());
                    temPayinf.setBatchno(item.getBatch_no());
                    temPayinf.setAuthCode(item.getAuth_code());

                    temPayinf.setMchtno(mchtId);
                    temPayinf.setTermno(termId);

                    payInfService.insertSelective(temPayinf);
                } else { // 交易存在
                    logger.info("支付交易[{}]-[{}]已记库", item.getSub_out_trade_no(), transType);
                }

                //  撤销提交：更新原来的正向交易状态为撤销
                if ("order_refund".equals(payinf.getOrderType())) {
                    Payinf _payinf = new Payinf();
                    _payinf.setOutTradeNo(item.getSub_out_trade_no());
                    _payinf.setTransType(TradeTypes.SALE.getName());
                    _payinf.setState(TradeStatus.CANCELED.getName());
                    payInfService.updateByOutTradeNoSelective(_payinf);
                }

                // 进行提交国大打包
                GdaOrderSubmitSubRequestBody oSubBody = new GdaOrderSubmitSubRequestBody();
                oSubBody.setPayDate(item.getPay_time());
                oSubBody.setPayCode(item.getPay_code());
                oSubBody.setPayAmount(item.getSub_fact_amount());
                oSubBody.setPayCardNo(item.getCard_no());
                oSubBody.setTransNo(temPayinf.getRetserial());  // 由于没有对支付类交易分配单独的交易号，这里使用系统流水号上送交易号
                oSubBody.setPayResult(MemberUtils.termcase2memberCase(item.getTrade_state()));

                oSubBodyList.add(oSubBody);
            }
            bean.setMchtId(mchtId);
            bean.setTermId(termId);
            bean.setAppId(appId);
            bean.setSecureKey(secureKey);
            bean.setBaseUrl(baseUrl);
            bean.setOrderNo(payinf.getOrderNo());
            bean.setCustomerId(payinf.getCustomerId());
            bean.setOrderAmount(payinf.getTotalAmount()+"");
            bean.setReceiptAmount(payinf.getFactAmount());
            bean.setDiscountAmount(payinf.getDiscountAmount());

            String memberId        = null;
            String memberTelephone = null;
            if (null != memberRecords && memberRecords.size() > 0) {
                logger.info("已经查到满足要求的交易，正在进行渠道上送打包...");
                for (TradeInf item : memberRecords) {
                    GdaOrderSubmitSubRequestBody _oSubBody = new GdaOrderSubmitSubRequestBody();

                    _oSubBody.setTransNo(item.getTradeNo());
                    _oSubBody.setPayDate(item.getRetTime());
                    _oSubBody.setPayResult(item.getStatus());
                    _oSubBody.setPayCode(item.getPayCode());

                    // 金额上送：会员送积分，储值卡送交易金额，其他核销用总金额减折扣
                    // 卡号上送：会员不送，储值卡送查询返回的卡号，其他送核销号
                    if (CustomerTypes.MEMBER.getName().equals(item.getCustomerType())) {
                        _oSubBody.setPayAmount(item.getScore()+""); // 会员送积分信息
                    } else if(CustomerTypes.DEPOSIT.getName().equals(item.getCustomerType())){
                        _oSubBody.setPayCardNo(item.getCardNo()); // 会员的卡号不送，其他都照常送
                        _oSubBody.setPayAmount(item.getTradeAmount()+""); // 会员送积分信息
                    } else {
                        BigDecimal factAmount = item.getTradeAmount().subtract(item.getDisAmount());

                        _oSubBody.setPayCardNo(item.getCardNo()); // 会员的卡号不送，其他都照常送
                        _oSubBody.setPayAmount(factAmount+"");
                    }

                    oSubBodyList.add(_oSubBody);

                    //如果有慧优的交易信息则在这里打包，一并送给慧优
                    if (CustomerTypes.MEMBER.getName().equals(item.getCustomerType())) {
                        logger.info("已经查到会员交易，准备提交...");
                        memberId        = item.getMemberId();
                        memberTelephone = item.getTelephone();
                    }
                }
            } else {
                logger.info("会员系统没有查到满足要求的核销交易，请核对！");
            }

            bean.setPayInfo(oSubBodyList);

            final String _memberId        = memberId;
            final String _memberTelephone = memberTelephone;
            //如果会员信息不为空，则表示需要进行慧优交易的提交
            if (("order_comsume".equals(payinf.getOrderType())) && (StringUtils.isNotEmpty(_memberId)
                    || StringUtils.isNotEmpty(_memberTelephone))) {
                new Thread(() -> {
                    RequestBean beanHyou = new RequestBean();
                    beanHyou.setMchtId(mchtId);
                    beanHyou.setTermId(termId);
                    beanHyou.setAppId(appIdHyou);
                    beanHyou.setSecureKey(secureKeyHyou);
                    beanHyou.setBaseUrl(baseUrlHyou);
                    beanHyou.setEntityCardId(_memberId);
                    beanHyou.setMemberPhone(_memberTelephone);
                    beanHyou.setOrderNo(payinf.getOrderNo());
                    beanHyou.setTotalFee(payinf.getTotalAmount().toString());
                    beanHyou.setPayFee(payinf.getFactAmount());
                    beanHyou.setGroupFee(payinf.getDiscountAmount());
                    TransResult trHyou = hyouTxnFacade.orderCommit(beanHyou);
                    if (ErrorCodes.SYS_SUCCESS.getCode().equals(trHyou.getCode())) {
                        logger.info("慧优订单提交成功");
                    } else {
                        logger.error("慧优订单提交返回失败");
                        result.setCode(trHyou.getCode());
                        result.setMessage("慧优订单提交返回失败：" + trHyou.getMessage());
                    }
                }).start();
            }

            bean.setCustomerId(payinf.getCustomerId()); // 上送国大需要的会员号
            TransResult tr = gdaTransaction.orderCommit(bean);

            // 3 新建更新对象
            transLog = new TransLog(retserial);
            // 4.2 对返回信息进行处理：补充交易的subcode
            transLog.setSubCode(tr.getCode());
            transLog.setSubMessage(tr.getMessage());

            // 5 订单提交成功，则向终端返回outTradeNo和tradeNo
            if (ErrorCodes.SYS_SUCCESS.getCode().equals(tr.getCode())) {
                // 5.1 更新订单表状态orderType
                OrderInf orderInf = new OrderInf();
                orderInf.setOrderNo(payinf.getOrderNo());
                orderInf.setState(OrderStatus.SUCCESS.getName());
                orderInf.setRefreshTime(DateUtils.formatNowTime());
                if (0 < orderInfService.updateByOrderNoSelective(orderInf)) {
                    logger.info("订单状态更新成功");
                } else {
                    logger.info("订单状态更新失败");
                }

                GdaOrderSubmitResponseBody body = (GdaOrderSubmitResponseBody) tr.getBody();

                retMap.put("tradeNo", tradeNo);
                retMap.put("remark", body.getRemark());
                result.setRetMap(retMap);
            }
            // 6 交易失败，会员系统的错误代码使用国大的
            else {
                logger.error("国大订单提交返回失败");
                result.setCode(tr.getCode());
                result.setMessage(tr.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("系统错误" + e.getMessage(), e);
            result.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
            result.setMessage("系统错误：" + e.getMessage());
        }

        // 7 更新transLog
        transLog.setCode(result.getCode());
        transLog.setMessage(result.getMessage());
        transLog.setRetTime(DateUtils.formatNowTime());

        transLogService.updateByPrimaryKey(transLog);

        return result;
    }

    //交易撤销
    @Override
    public ServiceResult verificationCancel(TransLog transLog, String outTradeNo,
                                            String orderNo, String oldTradeNo, String oldOrderNo) {
        ServiceResult result = new ServiceResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());

        try {
            String mchtId    = transLog.getMchtno();
            String termId    = transLog.getTermno();

            // 订单号有效性、存在性判断
            OrderInf _orderInf = orderInfService.getOrderByOrderNo(transLog.getMchtno(), transLog.getTermno(), transLog.getOrderNo());
            if ( null == _orderInf
                    || (!OrderStatus.PAYING.getName().equals(_orderInf.getState()) && !OrderStatus.SUCCESS.getName().equals(_orderInf.getState()))
                    ){//|| null == _orderInf.getEffectiveTime()
                    //|| 0 < DateUtils.formatNowTime().compareTo(DateUtils.addMinitues(new Date(), Integer.parseInt(_orderInf.getEffectiveTime())))) {
                logger.error("订单不存在或状态出错");

                result.setCode(ErrorCodes.SYS_ORDER_STATE_ERROR.getCode());
                result.setMessage(ErrorCodes.SYS_ORDER_STATE_ERROR.getMessage());

                return result;
            }

            // 1 记录transLog
            String retserial = createTransLog(transLogService, transLog);
            String tradeNo   = transLog.getTradeNo();

            //返回错误的的流水号，表示outTradeNo唯一性检查失败
            if (ERROR_RETSERIAL.equals(retserial)) {
                logger.error("外部交易号=[{}]重复", transLog.getOutTradeNo());

                result.setCode(ErrorCodes.SYS_OUT_TRADE_NO_REPEAT.getCode());
                result.setMessage(ErrorCodes.SYS_OUT_TRADE_NO_REPEAT.getMessage());

                return result;
            }

            // 撤销单笔交易（如果原订单号为空则说明是撤销单笔交易）
            if (StringUtils.isEmpty(oldOrderNo)) {
                logger.info("单笔交易撤销开始...");

                // 1 查找原交易
                TradeInf origTradeInf = tradeInfService.findRecordByTradeNo(mchtId, termId, oldTradeNo);
                if (null == origTradeInf) {
                    logger.info("找不到原交易tradeNo=[{}]", oldTradeNo);
                    result.setCode(ErrorCodes.SYS_TRANS_NOT_FOUND.getCode());
                    result.setMessage(ErrorCodes.SYS_TRANS_NOT_FOUND.getMessage());

                    // 获取最终的系统处理结果，并更新transLog
                    transLog = new TransLog(retserial);
                    transLog.setCode(result.getCode());
                    transLog.setMessage(result.getMessage());
                    transLog.setRetTime(DateUtils.formatNowTime());
                    transLogService.updateByPrimaryKey(transLog);

                    return result;
                }

                // 检查交易的状态
                if (!TradeStatus.SUCCESS.getName().equals(origTradeInf.getStatus())) { // 不是成功的，理解为已经撤销
                    logger.info("交易已撤销tradeNo=[{}]", oldTradeNo);
                    result.setCode(ErrorCodes.SYS_TRANS_ALREADY_CANCEL.getCode());
                    result.setMessage(ErrorCodes.SYS_TRANS_ALREADY_CANCEL.getMessage());

                    // 获取最终的系统处理结果，并更新transLog
                    transLog = new TransLog(retserial);
                    transLog.setCode(result.getCode());
                    transLog.setMessage(result.getMessage());
                    transLog.setRetTime(DateUtils.formatNowTime());
                    transLogService.updateByPrimaryKey(transLog);

                    return result;
                }

                result = cancalOneTrade(transLog, origTradeInf);

                logger.info("单笔交易撤销结束...");
            }
            // 撤销整笔订单
            else {
                logger.info("整笔订单撤销开始...");

                List<TradeInf> origInfs = tradeInfService.findRecordsByOrderNo(mchtId, termId, oldOrderNo, false);
                if (null == origInfs || origInfs.size() <= 0) {
                    logger.info("找不到原订单orderNo=[{}]对应的交易", oldOrderNo);
                    result.setCode(ErrorCodes.SYS_TRANS_NOT_FOUND.getCode());
                    result.setMessage(ErrorCodes.SYS_TRANS_NOT_FOUND.getMessage());

                    // 获取最终的系统处理结果，并更新transLog
                    transLog = new TransLog(retserial);
                    transLog.setCode(result.getCode());
                    transLog.setMessage(result.getMessage());
                    transLog.setRetTime(DateUtils.formatNowTime());
                    transLogService.updateByPrimaryKey(transLog);

                    return result;
                }

                // 遍历，撤销该订单对应的所有交易
                for (TradeInf item : origInfs) {
                    result = cancalOneTrade(transLog, item);
                }

                // 整笔订单撤销完成，需要去更新订单的状态
                if (ErrorCodes.SYS_SUCCESS.getCode().equals(result.getCode())) {
                    OrderInf orderInf = new OrderInf();
                    orderInf.setMchtno(mchtId);
                    orderInf.setTermno(termId);
                    orderInf.setOrderNo(oldOrderNo);
                    orderInf.setState(OrderStatus.CANCELED.getName());
                    orderInf.setRefreshTime(DateUtils.formatNowTime());

                    if (orderInfService.updateByPrimaryKeySelective(orderInf) > 0) {
                        logger.info("订单更新为撤销成功");
                    }
                    else {
                        logger.info("订单更新为撤销失败");
                    }
                }

                logger.info("整笔订单撤销结束...");
            }

            // 撤单成功
            if (ErrorCodes.SYS_SUCCESS.getCode().equals(result.getCode())) {
                logger.info("撤销交易成功");
                Map<String, String> retMap = new HashMap<>();
                retMap.put("tradeNo",tradeNo);
                result.setRetMap(retMap);
            }
            // 交易失败，会员系统的错误代码使用国大的
            else {
                logger.info("国大撤销交易返回失败");
                result.setCode(result.getCode());
                result.setMessage(result.getMessage());
            }

        }catch (Exception e) {
            e.printStackTrace();
            logger.error("系统错误："+e.getMessage(), e);
            result.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
            result.setMessage("系统错误：" + e.getMessage());
        }

        // 获取最终的系统处理结果，并更新transLog
        transLog.setCode(result.getCode());
        transLog.setMessage(result.getMessage());
        transLog.setRetTime(DateUtils.formatNowTime());

        transLogService.updateByPrimaryKey(transLog);

        return result;
    }

    private ServiceResult cancalOneTrade(TransLog transLog, TradeInf origTradeInf) {

        String customerType = origTradeInf.getCustomerType();

        // 记录撤销本身这笔交易
        String tradeInfKey = "VDK" +  DateUtils.formatNowId() + String.format("%06d", (int) (Math.random() * 1000000));
        TradeInf tradeInf = new TradeInf();
        tradeInf.setRetserial(tradeInfKey);
        tradeInf.setMchtno(transLog.getMchtno());
        tradeInf.setTermno(transLog.getTermno());
        tradeInf.setTradeNo(transLog.getTradeNo());
        tradeInf.setOutTradeNo(origTradeInf.getOutTradeNo());
        tradeInf.setOrderNo(transLog.getOrderNo());
        tradeInf.setCardNo(origTradeInf.getCardNo());
        tradeInf.setTelephone(origTradeInf.getTelephone());
        tradeInf.setBizType(transLog.getBizType());
        tradeInf.setPayCode(origTradeInf.getPayCode());
        tradeInf.setCustomerType(customerType);
        tradeInf.setInputType(origTradeInf.getInputType());
        tradeInf.setOldTradeNo(origTradeInf.getTradeNo());
        tradeInf.setOldOrderNo(origTradeInf.getOrderNo());

        tradeInf.setCreateTime(DateUtils.formatNowTime());
        tradeInf.setCreateIp(MemberUtils.getLocalNetWorkIp());
        tradeInf.setTransType(TradeStatus.START.getName());
        tradeInf.setStatus(TradeStatus.START.getName());
        tradeInf.setRetCode(TradeStatus.START.getName());
        tradeInf.setRetMsg(TradeStatus.START.getMessage());

        tradeInf.setTradeAmount(origTradeInf.getTradeAmount());
        tradeInf.setDisAmount(origTradeInf.getDisAmount());
        tradeInf.setScore(origTradeInf.getScore());

        // 交易前记库
        tradeInfService.insert(tradeInf);

        ServiceResult result = null;
        // 判断原来的交易渠道，发起撤销
        switch (customerType) {
            case "CUSTOMER_MEMBER": // 慧优撤销
                result = verificationCancelByHyou(origTradeInf);
                break;

            case "CUSTOMER_EMPLOYEE": // 国大员工卡撤销
                result = employeeCancel(origTradeInf);
                break;

            default: // 国大券码撤销
                result = couponCancel(origTradeInf, transLog.getTradeNo());
                break;
        }

        tradeInf.setRetserial(tradeInfKey);
        tradeInf.setTransType(TradeTypes.VOID.getName());
        tradeInf.setStatus(TradeStatus.SUCCESS.getName());
        tradeInf.setRetCode(result.getCode());
        tradeInf.setRetMsg(result.getMessage());
        tradeInf.setRetTime(DateUtils.formatNowTime());
        tradeInf.setQuerySign("1");

        tradeInfService.updateByPrimaryKeySelective(tradeInf);

        // 更新原交易
        if (ErrorCodes.SYS_SUCCESS.getCode().equals(result.getCode())) {
            logger.info("撤销交易成功，发起对原交易的更新");
            TradeInf _origTradeInf = new TradeInf();
            _origTradeInf.setRetserial(origTradeInf.getRetserial());
            _origTradeInf.setStatus(TradeStatus.CANCELED.getName());
            _origTradeInf.setRefreshTime(DateUtils.formatNowTime());

            tradeInfService.updateByPrimaryKeySelective(_origTradeInf);
        }


        return result;
    }

    //交易查询
    @Override
    public ServiceResult mixQuery(TransLog transLog, MixQueryRequestBody qBody){
        ServiceResult result       = new ServiceResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());
        TransResult transResult    = new TransResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());;
        Map<String, String> retMap = new HashMap<>();

        try {
            String mchtId                                      = transLog.getMchtno();
            String termId                                      = transLog.getTermno();
            String customerType                                = MemberUtils.termcase2memberCase(qBody.getCustomer_type());
            List<GdaMixQueryResponseSubBody> gdaTermMQueryList = new ArrayList<>(); // 该列表用来存储查询信息

            // 如果终端上送了原订单号且没有上送原交易号，则是按照订单查询。否则按单笔交易查询
            if (StringUtils.isNotEmpty(qBody.getQuery_order_no()) && StringUtils.isEmpty(qBody.getQuery_trade_no())) {

                List<TradeInf> tradeInfList = tradeInfService.selectByOrderNo(qBody.getQuery_order_no());

                for (TradeInf item : tradeInfList) {
                    // 不需要进行后台查询的交易，直接用会员系统存储的信息返回即可
                    GdaMixQueryResponseBody mixBody = queryByTradeNo(item.getTradeNo(), mchtId, termId);
                    gdaTermMQueryList.add(mixBody.getSubBody()); // 添加到返回终端的信息主体

                    // 查询中如果出现单笔错误，结果当失败返回，但不影响查询信息的正常返回
                    if (!ErrorCodes.SYS_SUCCESS.getCode().equals(mixBody.getCode())) {
                        result.setCode(mixBody.getCode());
                        result.setMessage(mixBody.getMessage());
                    }
                }
            } else {  // 单笔查询

                // 先处理：国大员工消费查询
                if (CustomerTypes.EMPLOYEE.getName().equals(customerType)) {
                    GdaMixQueryResponseBody mixBody       = mixEmployeeQuery(transLog.getMchtno(), transLog.getTermno(), qBody);
                    gdaTermMQueryList = mixBody.getSubBodyList();

                // 非员工查询的交易：国大和慧优的核销查询
                } else {
                    GdaMixQueryResponseBody mixBody = queryByTradeNo(qBody.getQuery_trade_no(), mchtId, termId);
                    gdaTermMQueryList.add(mixBody.getSubBody()); // 添加到返回终端的信息主体
                }

                result.setCode(transResult.getCode());
                result.setMessage(transResult.getMessage());
            }

            // 查询成功：打包返回信息
            if (ErrorCodes.SYS_SUCCESS.getCode().equals(result.getCode())) {
                logger.info("查询交易返回成功");
                retMap.put("orderInfo",objectMapper.writeValueAsString(gdaTermMQueryList));
                result.setRetMap(retMap);

            } else { // 查询失败
                logger.error("查询交易返回失败");
            }

        }catch (Exception e) {
            e.printStackTrace();
            logger.error("系统错误："+e.getMessage(), e);
            result.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
            result.setMessage("系统错误：" + e.getMessage());
        }

        return result;
    }

    @Override
    public ServiceResult couponBuilt(TransLog transLog, String amount) {
        ServiceResult result = new ServiceResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());

        try {

            // 1 记录transLog并生成流水号
            String retserial = createTransLog(transLogService, transLog);
            String tradeNo   = transLog.getTradeNo();

            // 2 返回错误的的流水号，表示outTradeNo唯一性检查失败
            if (ERROR_RETSERIAL.equals(retserial)) {
                logger.error("外部交易号=[{}]重复", transLog.getOutTradeNo());

                result.setCode(ErrorCodes.SYS_OUT_TRADE_NO_REPEAT.getCode());
                result.setMessage(ErrorCodes.SYS_OUT_TRADE_NO_REPEAT.getMessage());

                return result;
            }

            RequestBean bean = new RequestBean();
            bean.setAppId(appId);
            bean.setSecureKey(secureKey);
            bean.setBaseUrl(baseUrl);
            bean.setMchtId(transLog.getMchtno());
            bean.setTermId(transLog.getTermno());
            bean.setAmount(amount);

            TransResult tr = gdaTransaction.generateParkingCoupon(bean);

            if (ErrorCodes.SYS_SUCCESS.getCode().equals(tr.getCode())) {
                logger.info("停车券生成成功");
                GdaParkingInfResponseBody body = (GdaParkingInfResponseBody) tr.getBody();

                // 5.1 组装返回体
                Map<String, String> retMap = new HashMap<>();
                retMap.put("tradeNo"  , tradeNo);
                retMap.put("verifyNo" , body.getBillNo());
                retMap.put("amount"   , amount);
                retMap.put("storeName", body.getStoreName());
                retMap.put("remark", body.getRemark());

                result.setRetMap(retMap);
            }
            // 6 交易失败，会员系统的错误代码使用国大的
            else {
                logger.error("停车券生成失败");

                result.setCode(tr.getCode());
                result.setMessage(tr.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("系统错误："+e.getMessage(), e);
            result.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
            result.setMessage("系统错误：" + e.getMessage());
        }

        // 8 更新transLog
        transLog.setCode(result.getCode());
        transLog.setMessage(result.getMessage());
        transLog.setRetTime(DateUtils.formatNowTime());
        transLogService.updateByPrimaryKey(transLog);

        return result;
    }
    //国大会员撤销走慧优接口
    public ServiceResult verificationCancelByHyou(TradeInf origTradeInf) {
        ServiceResult result = new ServiceResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());

        try {
            // 发起验证请求
            RequestBean bean = new RequestBean();
            bean.setMchtId(origTradeInf.getMchtno());
            bean.setTermId(origTradeInf.getTermno());
            bean.setAppId(appIdHyou);
            bean.setSecureKey(secureKeyHyou);
            bean.setBaseUrl(baseUrlHyou);
            bean.setMemberPhone(origTradeInf.getTelephone());
            bean.setEntityCardId(origTradeInf.getCardNo());
            bean.setTransNo(origTradeInf.getTradeNo());

            TransResult tr = hyouTxnFacade.verificationCancel(bean);

            // 对返回信息进行处理
            result.setCode(tr.getCode());
            result.setMessage(tr.getMessage());

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("系统错误："+e.getMessage(), e);
            result.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
            result.setMessage("系统错误：" + e.getMessage());
        }

        return result;
    }

    //国大员工餐卡查询
    public ServiceResult emplyeeQuery(TransLog transLog, Customer customer) {

        ServiceResult result = new ServiceResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());
        Map<String, String> retMap;

        try {
            String mchtId       = transLog.getMchtno();
            String termId       = transLog.getTermno();
            String customerId   = customer.getCustomerId();
            String customerType = customer.getCustomerType();

            // 1 组装交易报文，向渠道发起查询交易
            RequestBean bean = new RequestBean();
            bean.setMchtId(mchtId);
            bean.setTermId(termId);
            bean.setAppId(appId);
            bean.setBaseUrl(baseUrl);
            bean.setSecureKey(secureKey);
            bean.setCustomerId(customerId);

            TransResult tr = gdaTransaction.emplyeeQuery(bean);

            // 2 查询成功，记录查询信息并打包返回体
            if (ErrorCodes.SYS_SUCCESS.getCode().equals(tr.getCode())) {
                logger.info("员工餐卡查询成功");

                // 2.1 打包返回的主体信息
                GdamemberQueryResponseBody<GdamemberQueryResponseSubBody> rb = (GdamemberQueryResponseBody<GdamemberQueryResponseSubBody>) tr.getBody();
                retMap = new HashMap<>();
                retMap.put("gender"     , rb.getGender());
                retMap.put("telephone"  , rb.getTelephone());

                //和国大确认过：员工查询只有一张卡返回，打包到会员信息中即可
                GdamemberQueryResponseSubBody mSubBody =  rb.getCard().get(0);
                retMap.put("cardNo"      , mSubBody.getCardNo());
                retMap.put("discount"    , mSubBody.getDiscount());
                retMap.put("cardName"    , mSubBody.getCardName());
                retMap.put("remainAmount", mSubBody.getRemianCash());

                result.setRetMap(retMap);

                // 2.2 记录客户信息 : 2.2.1 不存在时新建客户信息
                Card _card = cardService.findByCstmerTypeAndCardNo(customerType, mSubBody.getCardNo());
                if (null == _card) {
                    logger.info("员工未记库，进行新员工的记录");
                    _card = new Card();
                    String _retserial = "CARD" + DateUtils.formatNowId() + String.format("%06d", (int) (Math.random() * 1000000));

                    _card.setRetserial(_retserial);
                    _card.setCardNo(mSubBody.getCardNo());
                    _card.setRemainCash(new BigDecimal(mSubBody.getRemianCash()));
                    //REMAIN_SCORE 剩余积分  本表已经删除
                    _card.setMallName(BizAgencys.GDA.getDesc());

                    _card.setCustomerType(customerType);
                    _card.setCardName(mSubBody.getCardName());
                    _card.setCustomerId(rb.getMemberId());
                    _card.setDiscount(new BigDecimal(mSubBody.getDiscount()));
                    _card.setTelephone(rb.getTelephone());

                    _card.setGender(rb.getGender());
                    _card.setBirthday(rb.getBirthday());
                    _card.setCustomerName(rb.getName());
                    // MEMBER_PWD 用户密码
                    _card.setCreateTime(DateUtils.formatNowTime());

                    // REFRESH_TIME 更新时间

                    cardService.insertSelective(_card);
                }
                else {
                    logger.info("员工已记库，更新余额");
                    // 2.2.2 更新查询记录:时间和剩余金额（员工卡只有金额项）
                    _card.setRemainCash(new BigDecimal(mSubBody.getRemianCash()));
                    _card.setRefreshTime(DateUtils.formatNowTime());

                    cardService.updateByPrimaryKeySelective(_card);
                }
            }
            // 6 交易失败，会员系统的错误代码使用国大的
            else {
                logger.error("员工餐卡查询返回失败");
                result.setCode(tr.getCode());
                result.setMessage(tr.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("系统错误:" + e.getMessage(), e);
            result.setMessage("系统错误：" + e.getMessage());
            result.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
        }

        // 3 不需要更新transLog，直接返回信息体即可
        return result;
    }

    //国大员工餐卡消费
    public ServiceResult emplyeeVerification(TransLog transLog, TradeInf tradeInf) {

        ServiceResult result = new ServiceResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());
        Map<String, String> retMap;

        try {
            String mchtId     = transLog.getMchtno();
            String termId     = transLog.getTermno();
            String customerId = tradeInf.getMemberId();

            // 1 记录transLog并生成流水号
            String retserial  = createTransLog(transLogService, transLog);
            String tradeNo    = transLog.getTradeNo();

            // 2 返回错误的的流水号，表示outTradeNo唯一性检查失败
            if (ERROR_RETSERIAL.equals(retserial)) {
                logger.error("外部交易号=[{}]重复", transLog.getOutTradeNo());

                result.setCode(ErrorCodes.SYS_OUT_TRADE_NO_REPEAT.getCode());
                result.setMessage(ErrorCodes.SYS_OUT_TRADE_NO_REPEAT.getMessage());

                return result;
            }

            // 3 补充核销交易记录数据，并记录核销交易前的数据
            String gdretserial = "GD" + retserial;
            tradeInf.setTradeNo(tradeNo);
            tradeInf.setRetserial(gdretserial);
            tradeInf.setStatus(TradeStatus.START.getName());
            tradeInf.setRetCode(TradeStatus.START.getName());
            tradeInf.setTransType(TradeStatus.START.getName());
            tradeInf.setRetMsg(TradeStatus.START.getMessage());
            tradeInf.setCreateTime(DateUtils.formatNowTime());

            if (tradeInfService.insert(tradeInf) <= 0) {
                logger.error("数据库异常");

                result.setCode(ErrorCodes.SYS_DATABASE_ERROR.getCode());
                result.setMessage(ErrorCodes.SYS_DATABASE_ERROR.getMessage());

                return result;
            }
            else {
                logger.info("正常记录：[{}]",gdretserial);
            }

            // 4 发起核销请求
            RequestBean bean = new RequestBean();
            bean.setMchtId(mchtId);
            bean.setTermId(termId);
            bean.setAppId(appId);
            bean.setBaseUrl(baseUrl);
            bean.setSecureKey(secureKey);
            bean.setCustomerId(customerId);
            bean.setBillNo(tradeNo);
            bean.setMemberPhone(tradeInf.getTelephone());
            bean.setAmount(tradeInf.getTradeAmount()+"");
            bean.setDiscountAmount(tradeInf.getDisAmount()+"");

            TransResult tr = gdaTransaction.emplyeeVerification(bean);

            // 4.1 补充translog的subcode
            transLog.setSubCode(tr.getCode());
            transLog.setSubMessage(tr.getMessage());

            // 3.1 用于translog和核销交易更新结果
            tradeInf = new TradeInf();
            transLog = new TransLog(retserial);
            tradeInf.setRetserial(gdretserial);

            // 5 核销成功
            if (ErrorCodes.SYS_SUCCESS.getCode().equals(tr.getCode())) {
                logger.info("员工餐卡核销成功");
                tradeInf.setTransType(TradeTypes.SALE.getName());
                tradeInf.setStatus(TradeStatus.SUCCESS.getName());

                // 5.1 组装返回体
                retMap = new HashMap<>();
                retMap.put("tradeNo"     , tradeNo);
                GdaEmployeeVerificationfResponsbody rb = (GdaEmployeeVerificationfResponsbody) tr.getBody();
                retMap.put("cardNo"      , customerId);
                retMap.put("remainAmount", rb.getRemainCash());

                result.setRetMap(retMap);
                tradeInf.setRemainAmount(new BigDecimal(rb.getRemainCash())); //给核销交易设置余额
            }
            // 6 交易失败，会员系统的错误代码使用国大的
            else {
                logger.error("员工餐卡核销返回失败");

                result.setCode(tr.getCode());
                result.setMessage(tr.getMessage());
                tradeInf.setTransType(TradeTypes.SALE.getName());
                tradeInf.setStatus(TradeStatus.FAILED.getName());
            }

            // 7 更新核销交易
            tradeInf.setQuerySign("1"); //核销交易后明确结果时，将其查询标志置1

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("系统错误:" + e.getMessage(), e);
            result.setMessage("系统错误：" + e.getMessage());
            result.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
            tradeInf.setStatus(TradeStatus.FAILED.getName());
        }

        tradeInf.setRetCode(result.getCode());
        tradeInf.setRetMsg(result.getMessage());
        tradeInf.setRetTime(DateUtils.formatNowTime());
        tradeInfService.updateByPrimaryKeySelective(tradeInf);

        // 8 更新transLog
        transLog.setCode(result.getCode());
        transLog.setMessage(result.getMessage());
        transLog.setRetTime(DateUtils.formatNowTime());
        transLogService.updateByPrimaryKey(transLog);

        return result;
    }

    //国大储值卡(D)、停车券(P)和优惠券(C)的消费
    public ServiceResult dpcVerification(TransLog transLog, TradeInf tradeInf) {
        ServiceResult result = new ServiceResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());

        try {
            String mchtId  = transLog.getMchtno();
            String termId  = transLog.getTermno();
            String payCode = transLog.getBizChannel();

            // 1 记录transLog并生成流水号
            String retserial = createTransLog(transLogService, transLog);
            String tradeNo   = transLog.getTradeNo();

            // 2 返回错误的的流水号，表示outTradeNo唯一性检查失败
            if (ERROR_RETSERIAL.equals(retserial)) {
                logger.error("外部交易号=[{}]重复", transLog.getOutTradeNo());

                result.setCode(ErrorCodes.SYS_OUT_TRADE_NO_REPEAT.getCode());
                result.setMessage(ErrorCodes.SYS_OUT_TRADE_NO_REPEAT.getMessage());

                return result;
            }

            // 3 补充核销交易记录数据，并记录核销交易前的数据
            String tfretserial = "DP" + retserial;
            tradeInf.setMchtno(mchtId);
            tradeInf.setTermno(termId);
            tradeInf.setTradeNo(tradeNo);
            tradeInf.setRetserial(tfretserial);
            tradeInf.setStatus(TradeStatus.START.getName());
            tradeInf.setRetCode(TradeStatus.START.getName());
            tradeInf.setRetMsg(TradeStatus.START.getMessage());
            tradeInf.setTransType(TradeStatus.START.getName());
            tradeInf.setCreateTime(DateUtils.formatNowTime());

            if (tradeInfService.insert(tradeInf) <= 0) {
                logger.error("数据库异常");

                result.setCode(ErrorCodes.SYS_DATABASE_ERROR.getCode());
                result.setMessage(ErrorCodes.SYS_DATABASE_ERROR.getMessage());

                return result;
            }

            // 4 组装交易报文，向渠道发起核销交易
            RequestBean bean = new RequestBean();
            bean.setMchtId(mchtId);
            bean.setTermId(termId);
            bean.setTransNo(tradeNo);
            bean.setPayCode(payCode);
            bean.setAppId(appId);
            bean.setBaseUrl(baseUrl);
            bean.setSecureKey(secureKey);
            bean.setCardNo(tradeInf.getCardNo());
            bean.setBillNo(tradeInf.getOrderNo());
            bean.setCustomerId(tradeInf.getMemberId());
            bean.setAmount(tradeInf.getTradeAmount()+"");
            switch (tradeInf.getInputType()) {
                case "INPUT_HAND":
                    bean.setInputType(InputTypes.HAND.getCode());
                    break;
                case "INPUT_CARD":
                    bean.setInputType(InputTypes.CARD.getCode());
                    break;
                case "INPUT_SCAN":
                    bean.setInputType(InputTypes.SCAN.getCode());
                    break;
                case "INPUT_COUPON":
                    bean.setInputType(InputTypes.COUPON.getCode());
                    break;
                default:
                    bean.setInputType(InputTypes.HAND.getCode());
                    break;
            }

            TransResult tr = gdaTransaction.dpcVerification(bean);

            // 4.2 补充translog的subcode
            tradeInf = new TradeInf();
            transLog = new TransLog(retserial);
            transLog.setSubCode(tr.getCode());
            transLog.setSubMessage(tr.getMessage());
            tradeInf.setRetserial(tfretserial);

            // 5 核销成功
            if (ErrorCodes.SYS_SUCCESS.getCode().equals(tr.getCode())) {
                logger.info("国大券码核销成功");
                // 5.1 组装返回体
                Map<String, String> retMap = new HashMap<>();
                GdaPaymentResponseBody rb = (GdaPaymentResponseBody) tr.getBody();
                retMap.put("tradeNo"     , tradeNo);
                retMap.put("verifyNo"    , rb.getCardNo());
                retMap.put("remainAmount", rb.getRemainCash().toString());

                tradeInf.setTransType(TradeTypes.SALE.getName());
                tradeInf.setCardNo(rb.getCardNo()); // 不能用终端上送的卡号，需要用国大返回的储值卡，在订单啊提交时上送给国大
                tradeInf.setStatus(TradeStatus.SUCCESS.getName());
                tradeInf.setRemainAmount(StringUtils.isEmpty(rb.getRemainCash()) ? zeroAmount : rb.getRemainCash()); //设置核销交易的余额
                result.setRetMap(retMap);

            }
            // 6 交易失败，会员系统的错误代码使用渠道的
            else {
                logger.error("国大券码核销返回失败");

                result.setCode(tr.getCode());
                result.setMessage(tr.getMessage());
                tradeInf.setTransType(TradeTypes.SALE.getName());
                tradeInf.setStatus(TradeStatus.FAILED.getName());
            }

            // 7 更新核销交易
            tradeInf.setQuerySign("1"); //核销交易后明确结果时，将其查询标志置1

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("系统错误：" + e.getMessage(), e);
            result.setMessage("系统错误：" + e.getMessage());
            result.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
            tradeInf.setStatus(TradeStatus.FAILED.getName());
        }

        tradeInf.setRetTime(DateUtils.formatNowTime());
        tradeInf.setRetCode(result.getCode());
        tradeInf.setRetMsg(result.getMessage());
        tradeInfService.updateByPrimaryKeySelective(tradeInf);

        // 8 更新transLog
        transLog.setCode(result.getCode());
        transLog.setMessage(result.getMessage());
        transLog.setRetTime(DateUtils.formatNowTime());
        transLogService.updateByPrimaryKey(transLog);

        return result;
    }

    //国大储值卡、现金券查询。现金券只能核销一次，储值卡可以多次核销。但是储值卡按照customer_type为deposit存储在t_customer表；
    // 现金券存储在t_coupon中
    public ServiceResult dcQuery(TransLog transLog, Customer customer) {

        ServiceResult result = new ServiceResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());
        Map<String, String> retMap;

        try {
            String mchtId       = transLog.getMchtno();
            String termId       = transLog.getTermno();
            String payCode      = transLog.getBizChannel();
            String customerType = CustomerTypes.DEPOSIT.getName();

            // 1 组装交易报文，向渠道发起查询交易
            RequestBean bean = new RequestBean();
            bean.setMchtId(mchtId);
            bean.setTermId(termId);
            bean.setAppId(appId);
            bean.setBaseUrl(baseUrl);
            bean.setSecureKey(secureKey);

            switch (customer.getInputType()) {
                case "INPUT_SCAN":
                    bean.setInputType(InputTypes.SCAN.getCode());
                    break;
                case "INPUT_CARD":
                    bean.setInputType(InputTypes.CARD.getCode());
                    break;
                case "INPUT_COUPON":
                    bean.setInputType(InputTypes.COUPON.getCode());
                    break;
                case "INPUT_HAND":
                    bean.setInputType(InputTypes.HAND.getCode());
                    break;
                 default:
                     result.setCode(ErrorCodes.SYS_INPUT_TYPE_ERROR.getCode());
                     result.setMessage(ErrorCodes.SYS_INPUT_TYPE_ERROR.getMessage());
                     return result;
            }
            bean.setIdkeyword(customer.getCardNo());
            TransResult tr = gdaTransaction.dcQuery(bean);

            // 2 查询成功，记录查询信息并打包返回体
            if (ErrorCodes.SYS_SUCCESS.getCode().equals(tr.getCode())) {
                logger.info("国大储值卡/优惠券查询成功");

                // 2.1 打包返回的主体信息
                GdaDcQueryResponseBody gbody = (GdaDcQueryResponseBody) tr.getBody();
                String cardNo = gbody.getCardNo();
                retMap = new HashMap<>();
                retMap.put("cardNo"      , cardNo);
                retMap.put("cardName"    , gbody.getCardName());
                retMap.put("remainAmount", gbody.getRemainAmount());
                result.setRetMap(retMap);

                // 2.2 记录储值卡信息
                if (BizChannels.DEPOSIT.getName().equals(payCode)) {
                    Card _card = cardService.findByCstmerTypeAndCardNo(customerType, cardNo);
                    if (null == _card) {
                        logger.info("储值卡未记库，进行新储值卡记录");
                        _card = new Card();
                        String retserial = "DEP" + DateUtils.formatNowId() + String.format("%06d", (int) (Math.random() * 1000000));

                        _card.setRetserial(retserial);
                        _card.setCardNo(cardNo);
                        _card.setRemainCash(new BigDecimal(gbody.getRemainAmount()));
                        // REMAIN_SCORE 剩余积分，本表此字段已删除
                        _card.setMallName(BizAgencys.GDA.getDesc());

                        _card.setCustomerType(customerType);
                        _card.setCardName(gbody.getCardName());
                        // CUSTOMER_ID 用户ID
                        // CUSTOMER_ID 折扣
                        // TELEPHONE 手机号

                        // GENDER  用户性别
                        // BIRTHDAY 用户生日
                        // CUSTOMER_NAME 用户名称
                        // MEMBER_PWD 用户密码
                        _card.setCreateTime(DateUtils.formatNowTime());

                        // REFRESH_TIME 更新时间

                        cardService.insertSelective(_card);
                    } else {
                        logger.info("储值卡已记库，刷新余额");
                        // 2.2.2 更如果会员已经存在，则更新余额和刷新时间
                        _card.setRemainCash(new BigDecimal(gbody.getRemainAmount()));
                        _card.setRefreshTime(DateUtils.formatNowTime());

                        cardService.updateByPrimaryKeySelective(_card);
                    }
                }
                // 2.2 记录现金券信息
                else if (BizChannels.COUPON.getName().equals(payCode)) {
                    Coupon coupon = couponService.findByMVPD(null, cardNo, payCode, null);
                    if (null == coupon) {
                        logger.info("现金券未记库，进行新券的记录");
                        coupon = new Coupon();
                        String _retserial = "COUPON" + DateUtils.formatNowId();

                        coupon.setRetserial(_retserial);
                        // CUSTOMER_TYPE 客户类型
                        // CUSTOMER_ID 客户号
                        coupon.setPayCode(payCode);
                        coupon.setCouponNo(cardNo);

                        coupon.setCouponValue(StringUtils.isEmpty(gbody.getRemainAmount())?zeroAmount : new BigDecimal(gbody.getRemainAmount()));
                        coupon.setCouponNum(1);
                        coupon.setCouponName(BizAgencys.GDA.getDesc() + ":" + gbody.getCardName());
                        // 中间内容全部没有
                        coupon.setCreateTime(DateUtils.formatNowTime());

                        // REFRESH_TIME 刷新时间

                        couponService.insertSelective(coupon);
                    }
                    // 更新券值和刷新时间
                    else {
                        logger.info("现金券已记库，进行余额更新");
                        coupon.setCouponValue(StringUtils.isEmpty(gbody.getRemainAmount())?zeroAmount : new BigDecimal(gbody.getRemainAmount()));
                        coupon.setRefreshTime(DateUtils.formatNowTime());

                        couponService.updateByPrimaryKeySelective(coupon);
                    }
                }
            }
            // 3 交易失败，会员系统的错误代码使用渠道的
            else {
                logger.error("国大储值卡/优惠券查询返回失败");
                result.setCode(tr.getCode());
                result.setMessage(tr.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("系统错误:", e.getMessage(), e);
            result.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
            result.setMessage("系统错误：" + e.getMessage());
        }

        // 4 直接返回结果即可
        return result;
    }

    //国大停车券查询
    public ServiceResult parkingQuery(TransLog transLog, Customer _customer) {

        ServiceResult result = new ServiceResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());
        Map<String, String> retMap;

        try {
            String mchtId  = transLog.getMchtno();
            String termId  = transLog.getTermno();
            String payCode = BizChannels.PARKING.getName();

            // 1 组装交易报文，向渠道发起查询交易
            RequestBean bean = new RequestBean();
            bean.setMchtId(mchtId);
            bean.setTermId(termId);
            bean.setAppId(appId);
            bean.setBaseUrl(baseUrl);
            bean.setSecureKey(secureKey);
            bean.setPageNo(_customer.getPageNo());
            bean.setEndDate(_customer.getEndTime());
            bean.setPageSize(_customer.getPageSize());
            bean.setStartDate(_customer.getStartTime());

            TransResult tr = gdaTransaction.parkingQuery(bean);

            // 2 查询成功，记录查询信息并打包返回体
            if (ErrorCodes.SYS_SUCCESS.getCode().equals(tr.getCode())) {
                logger.info("停车券查询成功");

                // 2.1 把慧优的优惠券，转换成会员系统返回终端的优惠券，并在解析过程中记录券
                List<GdaParkingInfResponseBody> gdaParkingInfList = (List<GdaParkingInfResponseBody>) tr.getBodyList();
                List<ParkingResponseSubBody> parkingCouponList = new ArrayList<>();

                for(GdaParkingInfResponseBody item : gdaParkingInfList) {
                    Coupon coupon = couponService.findByMVPD(null, item.getBillNo(), payCode, null);
                    if (null == coupon) {
                        logger.info("停车券未记库，进行新券记录");
                        coupon = new Coupon();
                        String _retserial = "COUPON" + DateUtils.formatNowId();

                        coupon.setRetserial(_retserial);
                        // CUSTOMER_TYPE 客户类型
                        // CUSTOMER_ID 客户号
                        coupon.setPayCode(payCode);
                        coupon.setCouponNo(item.getBillNo());

                        coupon.setCouponValue(StringUtils.isEmpty(item.getAmount())?zeroAmount : new BigDecimal(item.getAmount()));
                        // COUPON_NUM 可用券数量
                        coupon.setCouponName(BizAgencys.GDA.getDesc() + "：" +BizChannels.PARKING.getDesc());
                        coupon.setStatrtTime(item.getRqsj());
                        // END_TIME 有效期结束时间

                        // SERVICE_AMOUNT 起用金额
                        coupon.setCreateShop(item.getStoreName());
                        // VERIFY_STATE 优惠券状态
                        // IS_LIMITED_SHOP 是否有门店限制
                        // LIMMITED_SHOP 使用门店名称

                        // COUPON_DESC 使用说明
                        // COUPON_IMAGE 优惠券图片路径
                        coupon.setCreateTime(DateUtils.formatNowTime());
                        // REFRESH_TIME 刷新时间

                        couponService.insertSelective(coupon);
                    }
                    // 更新价值和刷新时间
                    else {
                        logger.info("停车券已记库，进行数量和券值更新");
                        coupon.setPayCode(payCode);
                        coupon.setCouponNo(item.getBillNo());
                        coupon.setRefreshTime(DateUtils.formatNowTime());
                        coupon.setCouponValue(StringUtils.isEmpty(item.getAmount())?zeroAmount : new BigDecimal(item.getAmount()));

                        couponService.updateByPrimaryKeySelective(coupon);
                    }

                    // 组包：返回终端的停车券信息
                    ParkingResponseSubBody rspParking = new ParkingResponseSubBody();
                    rspParking.setStart_time(item.getRqsj());
                    rspParking.setVerify_no(item.getBillNo());
                    rspParking.setCoupon_value(item.getAmount());
                    rspParking.setStroe_name(item.getStoreName());
                    rspParking.setPay_code(transLog.getBizChannel());

                    parkingCouponList.add(rspParking);
                }
                retMap = new HashMap<>();
                retMap.put("parkingInfo", objectMapper.writeValueAsString(parkingCouponList));
                result.setRetMap(retMap);
            }
            // 3 交易失败，会员系统的错误代码使用国大的
            else {
                logger.error("停车券查询返回失败");
                result.setCode(tr.getCode());
                result.setMessage(tr.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("系统错误:", e.getMessage(), e);
            result.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
            result.setMessage("系统错误：" + e.getMessage());
        }

        // 4 不更新transLog，直接返回结果即可
        return result;
    }

    //国大会员查询接口（慧优）
    public ServiceResult memberQueryByHyou(TransLog transLog, Customer customer) {
        ServiceResult result = new ServiceResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());
        Map<String, String> retMap ;

        try {
            String mchtId          = transLog.getMchtno();
            String termId          = transLog.getTermno();
            String customerType    = customer.getCustomerType();
            String payCode         = BizChannels.COUPON.getName(); //目前慧优只为国大上了该券

            // 1 组装交易报文，向渠道发起查询交易
            RequestBean bean = new RequestBean();
            bean.setMchtId(mchtId);
            bean.setTermId(termId);
            bean.setAppId(appIdHyou);
            bean.setBaseUrl(baseUrlHyou);
            bean.setSecureKey(secureKeyHyou);
            bean.setEntityCardId(customer.getCardNo());
            bean.setMemberPhone(customer.getTelephone());
            bean.setOrderAmount(customer.getOrderAmount());

            TransResult tr = hyouTxnFacade.memberQuery(bean);

            // 2 查询成功，记录查询信息并打包返回体
            if (ErrorCodes.SYS_SUCCESS.getCode().equals(tr.getCode())) {
                logger.info("会员查询成功");

                // 2.1 打包返回的主体信息
                HyouMemberQueryResponseBody body = (HyouMemberQueryResponseBody) tr.getBodyHyou();
                String cardNo                    = body.getEntityCardId();
                String telephone                 = body.getMemberPhone();

                retMap = new HashMap<>();
                retMap.put("cardNo"      , cardNo);
                retMap.put("telephone"   , telephone);
                retMap.put("discount"    , body.getMemberDiscount());
                retMap.put("remainScore" , body.getBalanceScore());
                retMap.put("remainAmount", body.getGroupBalance());

                // 2.2 记录客户信息： 2.2.1慧优的手机号和卡号是成对的。这里用卡号和客户类型进行查询可以保证唯一
                Customer _customer = customerService.findByCstmerTypeAndCardNo(customerType, cardNo);
                if (null == _customer) {
                    logger.info("会员未记库，对新会员进行记录");
                    _customer = new Customer();
                    String retserial = "CUST" + DateUtils.formatNowId() + String.format("%06d", (int) (Math.random() * 1000000));

                    _customer.setRetserial(retserial);
                    _customer.setCardNo(cardNo);
                    _customer.setRemainCash(new BigDecimal(body.getGroupBalance()));
                    _customer.setRemainScore(new BigDecimal(body.getBalanceScore()));
                    _customer.setMallName(BizAgencys.HYOU.getDesc());

                    _customer.setCustomerType(customerType);
                    _customer.setCardName(CustomerTypes.MEMBER.getDesc());
                    _customer.setCustomerId(body.getMemberPhone());
                    // CUSTOMER_ID 折扣
                    _customer.setTelephone(body.getMemberPhone());

                    // GENDER  用户性别
                    // BIRTHDAY 用户生日
                    // CUSTOMER_NAME 用户名称
                    // MEMBER_PWD 用户密码
                    _customer.setCreateTime(DateUtils.formatNowTime());

                    // REFRESH_TIME 更新时间

                    customerService.insertSelective(_customer);
                } else {
                    logger.info("会员已记库，更新余额和积分");
                    // 2.2.2 更如会员已经存在，则更新余额，剩余积分和刷新时间
                    _customer.setRemainScore(new BigDecimal(body.getBalanceScore()));
                    _customer.setRemainCash(new BigDecimal(body.getGroupBalance()));
                    _customer.setRefreshTime(DateUtils.formatNowTime());

                    customerService.updateByPrimaryKeySelective(_customer);
                }

                // 2.3 把慧优的优惠券，转换成会员系统返回终端的优惠券，并在解析过程中记录券
                List<CouponResponseSubBody> rspCouponList = new ArrayList<>();
                for(HyouMemberQueryResponseSubBody item : body.getListMemberCoupon()) {
                    // 如果该券不存在，则记录
                    Coupon coupon = couponService.findByMVPD(customerType, item.getCouponId(), payCode, telephone);
                    if (null == coupon) {
                        logger.info("优惠券未记库，对新券进行记录");
                        coupon = new Coupon();
                        String _retserial = "COUPON" + DateUtils.formatNowId();

                        coupon.setRetserial(_retserial);
                        coupon.setCustomerType(customerType);
                        coupon.setCustomerId(telephone);
                        coupon.setPayCode(payCode);
                        coupon.setCouponNo(item.getCouponId());

                        coupon.setCouponValue(StringUtils.isEmpty(item.getCouponValue())?zeroAmount : new BigDecimal(item.getCouponValue()));
                        coupon.setCouponNum(StringUtils.isEmpty(item.getCouponNum())?1 : Integer.valueOf(item.getCouponNum()));
                        coupon.setCouponName(BizAgencys.HYOU.getDesc() + "：" + item.getCouponName());
                        coupon.setStatrtTime(item.getStartTime());
                        coupon.setEndTime(item.getEndTime());

                        coupon.setServiceAmount(StringUtils.isEmpty(item.getServiceAmount())?zeroAmount : new BigDecimal(item.getServiceAmount()));
                        // CREATE_SHOP 生成门店名称
                        coupon.setVerifyState(item.getState());
                        coupon.setIsLimitedShop(item.getIsLimitedShop());
                        coupon.setLimmitedShop(item.getLimitedShop());

                        coupon.setCouponDesc(item.getCouponDesc());
                        coupon.setCouponImage(item.getCouponImage());
                        coupon.setCreateTime(DateUtils.formatNowTime());
                        // REFRESH_TOIME  刷新时间

                        couponService.insertSelective(coupon);
                    }
                    // 更新数量、价值和刷新时间
                    else {
                        logger.info("优惠券已记库，更新数量和券值");
                        coupon.setCustomerType(customerType);
                        coupon.setCouponNo(item.getCouponId());
                        coupon.setPayCode(payCode);
                        coupon.setCustomerId(telephone);
                        coupon.setCouponValue(StringUtils.isEmpty(item.getCouponValue())?zeroAmount : new BigDecimal(item.getCouponValue()));
                        coupon.setCouponNum(StringUtils.isEmpty(item.getCouponNum())?1 : Integer.valueOf(item.getCouponNum()));
                        coupon.setRefreshTime(DateUtils.formatNowTime());

                        couponService.updateByPrimaryKeySelective(coupon);
                    }

                    // 返回终端的优惠券格式
                    CouponResponseSubBody rspCoupon = new CouponResponseSubBody();

                    rspCoupon.setVerify_no(item.getCouponId());
                    rspCoupon.setVerify_state(item.getState());
                    rspCoupon.setCoupon_name(item.getCouponName());
                    rspCoupon.setPay_code(payCode);
                    rspCoupon.setService_amount(item.getServiceAmount());

                    rspCoupon.setCoupon_value(item.getCouponValue());
                    rspCoupon.setCoupon_image(item.getCouponImage());
                    rspCoupon.setStart_time(item.getStartTime());
                    rspCoupon.setEnd_time(item.getEndTime());
                    rspCoupon.setCoupon_desc(item.getCouponDesc());

                    rspCoupon.setIs_limited_shop(item.getIsLimitedShop());
                    rspCoupon.setLimited_shop(item.getLimitedShop());
                    rspCoupon.setCoupon_num(item.getCouponNum());

                    rspCouponList.add(rspCoupon);
                }

                retMap.put("couponInfo", objectMapper.writeValueAsString(rspCouponList));
                result.setRetMap(retMap);

            }
            // 3 交易失败，会员系统的错误代码使用国大的
            else {
                logger.error("会员查询返回失败");
                result.setCode(tr.getCode());
                result.setMessage(tr.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("系统错误:" + e.getMessage(), e);
            result.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
            result.setMessage("系统错误：" + e.getMessage());
        }

        //  4 不更新transLog，直接返回结果即可
        return result;
    }

    //国大会员核销（慧优）交易
    public ServiceResult memberVerificationByHyou(TransLog transLog, TradeInf tradeInf, String couponList) {
        ServiceResult result = new ServiceResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());
        String telephone     = null;
        String memberId      = null;
        Map<String, String> retMap;

        try {
            String mchtId    = transLog.getMchtno();
            String termId    = transLog.getTermno();
            String orderNo   = tradeInf.getOrderNo();

            // 1 记录transLog并生成流水号
            String retserial = createTransLog(transLogService, transLog);
            String tradeNo   = transLog.getTradeNo();

            // 2 返回错误的的流水号，表示outTradeNo唯一性检查失败
            if (ERROR_RETSERIAL.equals(retserial)) {
                logger.error("外部交易号=[{}]重复", transLog.getOutTradeNo());

                result.setCode(ErrorCodes.SYS_OUT_TRADE_NO_REPEAT.getCode());
                result.setMessage(ErrorCodes.SYS_OUT_TRADE_NO_REPEAT.getMessage());

                return result;
            }

            // 3 补充核销交易记录数据，并记录核销交易前的数据
            String hyretserial = "HY" + retserial;
            tradeInf.setTradeNo(tradeNo);
            tradeInf.setRetserial(hyretserial);
            tradeInf.setStatus(TradeStatus.START.getName());
            tradeInf.setRetCode(TradeStatus.START.getName());
            tradeInf.setTransType(TradeStatus.START.getName());
            tradeInf.setRetMsg(TradeStatus.START.getMessage());
            tradeInf.setCreateTime(DateUtils.formatNowTime());

            if (tradeInfService.insert(tradeInf) <= 0) {
                logger.error("数据库异常");

                result.setCode(ErrorCodes.SYS_DATABASE_ERROR.getCode());
                result.setMessage(ErrorCodes.SYS_DATABASE_ERROR.getMessage());

                return result;
            }

            // 4 组装交易报文，向渠道发起核销交易
            RequestBean bean = new RequestBean();
            bean.setMchtId(mchtId);
            bean.setTermId(termId);
            bean.setAppId(appIdHyou);
            bean.setBaseUrl(baseUrlHyou);
            bean.setSecureKey(secureKeyHyou);

            bean.setTransNo(tradeNo);
            bean.setOrderNo(orderNo);
            bean.setScore(tradeInf.getScore()+"");
            bean.setOrderNo(tradeInf.getOrderNo());
            bean.setEntityCardId(tradeInf.getCardNo());
            bean.setAmount(tradeInf.getTradeAmount()+"");

            bean.setMemberPhone(tradeInf.getTelephone());

            // 4.1 将终端上送的优惠券，打包成慧优核销所需要的格式
            List<CouponRequestSubBody> rqCouponList = null;
            if (StringUtils.isNotEmpty(couponList)) {
                rqCouponList = objectMapper.readValue(couponList, new TypeReference<List<CouponRequestSubBody>>() {});
                List<HyouValidateRequestSubBody> hCouponList = new ArrayList<>();
                for (CouponRequestSubBody item : rqCouponList) {
                    HyouValidateRequestSubBody hbody = new HyouValidateRequestSubBody();

                    hbody.setCouponId(item.getVerify_no());
                    hbody.setState(item.getVerify_state());
                    hbody.setCouponNum(item.getVerify_num());

                    hCouponList.add(hbody);
                }
                bean.setCouponGDDTOInf(hCouponList);
            }

            TransResult tr = hyouTxnFacade.verification(bean);

            // 3.1 用于translog和核销交易更新结果
            tradeInf = new TradeInf();
            transLog = new TransLog(retserial);
            tradeInf.setRetserial(hyretserial);

            // 4 补充translog的subcode
            transLog.setSubCode(tr.getCode());
            transLog.setSubMessage(tr.getMessage());

            // 5 核销成功
            if (ErrorCodes.SYS_SUCCESS.getCode().equals(tr.getCode())) {
                logger.info("会员核销成功");

                tradeInf.setTransType(TradeTypes.SALE.getName());
                tradeInf.setStatus(TradeStatus.SUCCESS.getName());

                // 5.1 组装返回体
                HyouVerificationResponseBody body = (HyouVerificationResponseBody) tr.getBodyHyou();
                retMap = new HashMap<>();
                retMap.put("tradeNo"         , tradeNo);
                retMap.put("remainScore"     , body.getBalanceScore());
                retMap.put("remainAmount"    , body.getGroupBalance());
                result.setRetMap(retMap);
                telephone = body.getMemberPhone();
                memberId  = body.getEntityCardId();

                // 5.2 将核销的券存入核销券表中
                String _retserial; //核销表中的流水号单独生成
                if (null != rqCouponList && rqCouponList.size() > 0) {
                    for (CouponRequestSubBody item : rqCouponList) {
                        _retserial = DateUtils.formatNowId() + String.format("%06d", (int) (Math.random() * 1000000));
                        TradeCoupon tradeCoupon = new TradeCoupon();

                        // 5.2.1 设置核销券表的所有信息
                        tradeCoupon.setTradeNo(tradeNo);
                        tradeCoupon.setOrderNo(orderNo);
                        tradeCoupon.setRetserial(_retserial);
                        tradeCoupon.setVerifyNo(item.getVerify_no());
                        tradeCoupon.setVerifyState(item.getVerify_state());
                        tradeCoupon.setVerifyNum(Long.parseLong(item.getVerify_num()));

                        tradeCouponService.insert(tradeCoupon);
                    }
                }
            }
            // 6 交易失败，会员系统的错误代码使用渠道的
            else {
                logger.error("会员核销返回失败");
                result.setCode(tr.getCode());
                result.setMessage(tr.getMessage());
                tradeInf.setTransType(TradeTypes.SALE.getName());
                tradeInf.setStatus(TradeStatus.FAILED.getName());
            }

            tradeInf.setQuerySign("1"); //核销交易后明确结果时，将其查询标志置1

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("系统错误:" + e.getMessage(), e);
            result.setMessage("系统错误:" + e.getMessage());
            result.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());

            tradeInf.setStatus(TradeStatus.FAILED.getName());
        }

        tradeInf.setMemberId(memberId);
        tradeInf.setTelephone(telephone);
        tradeInf.setRetCode(result.getCode());
        tradeInf.setRetMsg(result.getMessage());
        tradeInf.setRetTime(DateUtils.formatNowTime());
        tradeInfService.updateByPrimaryKeySelective(tradeInf);

        // 8 更新transLog
        transLog.setCode(result.getCode());
        transLog.setMessage(result.getMessage());
        transLog.setRetTime(DateUtils.formatNowTime());
        transLogService.updateByPrimaryKey(transLog);

        return result;
    }

    //国大员工卡撤销接口
    private ServiceResult employeeCancel(TradeInf origTradeInf) {
        ServiceResult result = new ServiceResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());

        try {
            // 发起验证请求s
            RequestBean bean = new RequestBean();
            bean.setMchtId(origTradeInf.getMchtno());
            bean.setTermId(origTradeInf.getTermno());
            bean.setAppId(appId);
            bean.setSecureKey(secureKey);
            bean.setBaseUrl(baseUrl);
            bean.setCustomerId(origTradeInf.getMemberId());
            bean.setOldTradeNo(origTradeInf.getTradeNo());

            TransResult tr = gdaTransaction.employeeCancel(bean);

            // 3.对返回信息进行处理：补充交易的subcode
            result.setCode(tr.getCode());
            result.setMessage(tr.getMessage());

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("系统错误："+e.getMessage(), e);
            result.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
            result.setMessage("系统错误：" + e.getMessage());
        }

        return result;
    }
    //国大的券码撤销接口
    private ServiceResult couponCancel(TradeInf origTradeInf, String tradeNo) {
        ServiceResult result = new ServiceResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());

        try {
            // 发起验证请求
            RequestBean bean = new RequestBean();
            bean.setMchtId(origTradeInf.getMchtno());
            bean.setTermId(origTradeInf.getTermno());
            bean.setAppId(appId);
            bean.setSecureKey(secureKey);
            bean.setBaseUrl(baseUrl);
            bean.setOldTradeNo(origTradeInf.getTradeNo());
            bean.setTransNo(tradeNo);

            TransResult tr = gdaTransaction.couponCancel(bean);

            result.setCode(tr.getCode());
            result.setMessage(tr.getMessage());

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("系统错误：" + e.getMessage(), e);
            result.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
            result.setMessage("系统错误：" + e.getMessage());
        }

        return result;
    }

    //慧优的券码撤销查询接口
    public GdaMixQueryResponseBody mixQueryByHyou(String queryTradeNo, String mchtId, String termId) {
        GdaMixQueryResponseBody mixBody  = new GdaMixQueryResponseBody(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());
        TransResult result               = new TransResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());

        try {
            // 发起查询请求
            RequestBean bean = new RequestBean();
            bean.setMchtId(mchtId);
            bean.setTermId(termId);
            bean.setAppId(appIdHyou);
            bean.setSecureKey(secureKeyHyou);
            bean.setBaseUrl(baseUrlHyou);
            bean.setOldTradeNo(queryTradeNo);

            result = hyouTxnFacade.mixQuery(bean);

            TradeInf _tradeInf = new TradeInf();
            _tradeInf.setTradeNo(queryTradeNo); // 这个是唯一标识号
            mixBody.setCode(result.getCode());
            mixBody.setMessage(result.getMessage());

            // 交易成功
            if (ErrorCodes.SYS_SUCCESS.getCode().equals(result.getCode())) {
                logger.info("会员核销查询成功");
                _tradeInf.setQuerySign(QUERY_SIGN_SUCCESS);

                GdaMixQueryResponseSubBody gbody = new GdaMixQueryResponseSubBody();
                HyouMixQueryResponseBody hbody   = ((HyouMixQueryResponseBody)result.getBodyHyou());
                // 转换慧优返回信息，返回终端
                gbody.setSub_trade_no(hbody.getPay_order()); // 交易号
                switch (hbody.getPay_state()) {
                    case "REFUND" :
                        gbody.setSub_trade_type(TradeStatus.CANCELED.getName());
                        break;
                    case "PAY" :
                        gbody.setSub_trade_type(TradeStatus.SUCCESS.getName());
                        break;
                    case "PAYFAIL" :
                        gbody.setSub_trade_type(TradeStatus.FAILED.getName());
                        break;
                    default:
                        break;
                }
                gbody.setRefund_amount(hbody.getPay_fee());
                gbody.setRefund_score(hbody.getScore());
                gbody.setCard_no(hbody.getEntity_card_id());

                // 添加返回信息的主体
                mixBody.setSubBody(gbody);

                tradeInfService.updateByTradeNoSelective(_tradeInf); // 更新查询状态，只有成功时才更新
            } else {
                logger.error("会员核销查询返回失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("系统错误："+ e.getMessage(),e);
            result.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
            result.setMessage("系统错误："+ e.getMessage());
        }

        return mixBody;
    }

    //国大的员工交易查询
    public GdaMixQueryResponseBody mixEmployeeQuery(String mchtId, String termId, MixQueryRequestBody qBody) {
        TransResult result              = new TransResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());
        GdaMixQueryResponseBody mixBody = new GdaMixQueryResponseBody(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());
        try {
            // 发起查询请求
            RequestBean bean = new RequestBean();
            bean.setMchtId(mchtId);
            bean.setTermId(termId);
            bean.setAppId(appId);
            bean.setSecureKey(secureKey);
            bean.setBaseUrl(baseUrl);
            bean.setPageSize("10");
            bean.setPageNo("1");
            bean.setCustomerId(qBody.getCustomer_id());
            bean.setStartDate(qBody.getStart_date());
            bean.setEndDate(qBody.getEnd_date());

            result = gdaTransaction.mixEmployeeQuery(bean);

            TradeInf _tradeInf = new TradeInf();
            _tradeInf.setTradeNo(qBody.getQuery_trade_no()); // 作为唯一标识
            mixBody.setCode(result.getCode());
            mixBody.setMessage(result.getMessage());

            // 交易失败，会员系统的错误代码使用国大的
            if (ErrorCodes.SYS_SUCCESS.getCode().equals(result.getCode())) {
                _tradeInf.setQuerySign(QUERY_SIGN_SUCCESS);
                List<GdaMixEmployeeResponseBody> eList = (List<GdaMixEmployeeResponseBody>)result.getBodyList();
                List<GdaMixQueryResponseSubBody> tList = new ArrayList<>();

                for (GdaMixEmployeeResponseBody item : eList) {
                    GdaMixQueryResponseSubBody titem = new GdaMixQueryResponseSubBody();

                    titem.setSub_trade_no(item.getBillNo());
                    titem.setSub_trade_type(TradeStatus.SUCCESS.getName());
                    titem.setPay_time(item.getCreateTime());
                    titem.setPay_code("umszj.paycode.emplyee");
                    titem.setCard_no(item.getMemberId());
                    titem.setTrade_amount(item.getTotalAmount());
                    titem.setFact_amount(item.getReciptAmount());

                    tList.add(titem);
                }

                mixBody.setSubBodyList(tList);
                tradeInfService.updateByTradeNoSelective(_tradeInf);
            } else {
                logger.error("国大核销查询返回失败");
                _tradeInf.setQuerySign(QUERY_SIGN_FAIL);
                result.setCode(result.getCode());
                result.setMessage(result.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("系统错误："+ e.getMessage(),e);
            result.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
            result.setMessage("系统错误："+ e.getMessage());
        }

        return mixBody;
    }
    //国大的核销查询交易
    public GdaMixQueryResponseBody mixQueryByGda(String queryTradeNo, String mchtId, String termId) {
        TransResult result               = new TransResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());
        GdaMixQueryResponseBody mixBody  = new GdaMixQueryResponseBody(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());
        try {
            // 发起查询请求
            RequestBean bean = new RequestBean();
            bean.setMchtId(mchtId);
            bean.setTermId(termId);
            bean.setAppId(appId);
            bean.setSecureKey(secureKey);
            bean.setBaseUrl(baseUrl);
            bean.setTransNo(queryTradeNo);

            result = gdaTransaction.mixQuery(bean);

            TradeInf _tradeInf = new TradeInf();
            _tradeInf.setTradeNo(queryTradeNo); // 用于插入的唯一性标识码
            mixBody.setCode(result.getCode());
            mixBody.setMessage(result.getMessage());

            // 交易成功
            if (ErrorCodes.SYS_SUCCESS.getCode().equals(result.getCode())) {
                logger.info("国大核销查询成功");
                _tradeInf.setQuerySign(QUERY_SIGN_SUCCESS);

                GdaMixQueryResponseSubBody gbody = new GdaMixQueryResponseSubBody();
                gbody                          = new GdaMixQueryResponseSubBody();
                GdaMixQuerryResponseBody rbody = ((GdaMixQuerryResponseBody)result.getBody());
                // 转换国大的返回信息，给终端打包
                gbody.setSub_trade_no(rbody.getOriginalTransNo());
                gbody.setSub_order_no(rbody.getOriginalOrderNo());
                switch (rbody.getBillType()) {
                    case "1" :
                        gbody.setSub_trade_type(TradeStatus.SUCCESS.getName());
                        break;
                    case "4" :
                        gbody.setSub_trade_type(TradeStatus.CANCELED.getName());
                        break;
                    default:
                        break;
                }
                gbody.setPay_time(rbody.getPayDate());
                gbody.setPay_code(rbody.getPayCode());
                gbody.setCard_no(rbody.getCardNo());
                gbody.setRefund_amount(rbody.getAmount());

                // 设置返回信息的主体
                mixBody.setSubBody(gbody);

                tradeInfService.updateByTradeNoSelective(_tradeInf); // 查询成功时。才更新状态

            } else {
                logger.error("国大核销查询返回失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("系统错误："+ e.getMessage(),e);
            result.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
            result.setMessage("系统错误："+ e.getMessage());
        }

        return mixBody;
    }

    //单笔核销交易查询
    public GdaMixQueryResponseBody queryByTradeNo(String queryTradeNo, String mchtId, String termId) {
        GdaMixQueryResponseBody mixBody = new GdaMixQueryResponseBody(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());

        try {
            TradeInf tradeInf   =  tradeInfService.selectByTradeNo(queryTradeNo);

            // 未查到交易
            if (null == tradeInf) {
                logger.error("没有查到交易：[{}]",queryTradeNo);

                mixBody.setCode(ErrorCodes.SYS_QUERY_TRANS_ERROR.getCode());
                mixBody.setMessage(ErrorCodes.SYS_QUERY_TRANS_ERROR.getMessage());
                return mixBody;
            }
            GdaMixQueryResponseSubBody gSubBody = new GdaMixQueryResponseSubBody();
            // 获得subBody
            if (QUERY_SIGN_SUCCESS.equals(tradeInf.getQuerySign())) {
                // 信息打包
                gSubBody.setSub_trade_no(tradeInf.getTradeNo());
                gSubBody.setSub_order_no(tradeInf.getOrderNo());
                gSubBody.setSub_trade_type(tradeInf.getTransType());
                gSubBody.setPay_time(tradeInf.getCreateTime());
                gSubBody.setPay_code(tradeInf.getPayCode());
                gSubBody.setCard_no(tradeInf.getCardNo());
                gSubBody.setTrade_amount(tradeInf.getTradeAmount() + "");
                //  fact_amount 实付款
                gSubBody.setScore(tradeInf.getScore() + "");

                mixBody.setSubBody(gSubBody);

            } else {
                String customerType = tradeInf.getCustomerType();
                // 慧优核销查询
                if (CustomerTypes.MEMBER.getName().equals(customerType)) {
                    mixBody = mixQueryByHyou(queryTradeNo, mchtId, termId);

                }  else { // 国大核销查询
                    mixBody = mixQueryByGda(queryTradeNo, mchtId, termId);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("系统错误：" + e.getMessage(), e);
            mixBody.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
            mixBody.setMessage("系统错误" + e.getMessage());
        }

        return mixBody;
    }
}
