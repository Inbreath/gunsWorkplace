package com.ums.mbr.packer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ums.mbr.ITransaction;
import com.ums.mbr.RequestBean;
import com.ums.mbr.TransResult;
import com.ums.mbr.enums.ErrorCodes;
import com.ums.mbr.packer.gda.*;
import com.ums.mbr.packer.gda.request.*;
import com.ums.mbr.utils.CipherUtils;
import com.ums.mbr.utils.DateUtils;
import com.ums.mbr.utils.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: jcouyang@chinaums.com
 * Date: 2018/3/7 10:02
 */
@Service
public class GdaTransactionImpl implements ITransaction {

    private static final Logger logger = LoggerFactory.getLogger(GdaTransactionImpl.class);
    private static final String MESSAGE_TYPE = "json";
    private static final String CHAR_SET = "UTF-8";
    private static final int CONNET_TIMEOUT = 10000;
    private static final int READ_TIMEOUT = 60000;
    private static final String GDA_SUCCESS_CODE = "200";
    private static final String GDA_SIGNERR_CODE1 = "0001"; // 签名错误
    private static final String GDA_SIGNERR_CODE2 = "0002"; // 签名超时

    private ObjectMapper objectMapper;

    public GdaTransactionImpl() {
        objectMapper = new ObjectMapper();
        // 忽略掉值为空或者空字符串的字段（但是对Map不生效）
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        // 忽略掉mapper中值为NULL的属性，但是不能忽略值为空的属性
        objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        // 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    //收发国大的终端验证交易
    public TransResult posValidate(RequestBean bean) {
        TransResult transResult = new TransResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());
        try {
            GdaPosValidateRequestBody body = new GdaPosValidateRequestBody();
            body.setAccessToken(getAccessToken(bean.getBaseUrl(), bean.getAppId(), bean.getSecureKey()));
            body.setStoreId(bean.getMchtId());
            body.setTerminalNo(bean.getTermId());
            body.setQrcode(bean.getManagerId());

            String request = objectMapper.writeValueAsString(body);
            String url = bean.getBaseUrl() + "/pos/validateService";
            logger.info("POS验证的请求地址=[{}]", url);
            logger.info("POS验证的请求报文=[{}]", request);

//            String response = doPost(url, request);
            String response = wrapperPost(url, body, bean);
            logger.info("POS验证接收到后端返回数据=[{}]", response);

            GdaResponse<GdaPosValidateResponseBody> result = objectMapper.readValue(response, new TypeReference<GdaResponse<GdaPosValidateResponseBody>>() {});

            //国大验证交易失败（因为成功时已经默认为会员系统的成功代码做返回码），返回国大的返回码
            if (!GDA_SUCCESS_CODE.equals(result.getAjaxErrorCode())) {
                transResult.setCode(result.getAjaxErrorCode());
                transResult.setMessage(result.getMessage());
            }

            //当交易失败时，data是空
            transResult.setBody(result.getData());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("出现系统异常=[{}]", e.getMessage());
            transResult.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
            transResult.setMessage("系统错误："+e.getMessage());
        }

        return transResult;
    }

    //收发国大的终端注册交易
    public TransResult posRegister(RequestBean bean) {
        TransResult transResult = new TransResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());
        try {
            GdaPosRegisterRequestBody body = new GdaPosRegisterRequestBody();
            body.setAccessToken(getAccessToken(bean.getBaseUrl(), bean.getAppId(), bean.getSecureKey()));
            body.setStoreId(bean.getMchtId());
            body.setTerminalNo(bean.getTermId());
            body.setQrcode(bean.getManagerId());
            body.setCreateTime(DateUtils.formatNowTime());

            String request = objectMapper.writeValueAsString(body);
            String url = bean.getBaseUrl() + "/pos/register";

            logger.info("pos注册的请求地址=[{}]", url);
            logger.info("pos注册的请求报文=[{}]", request);

            String response = wrapperPost(url, body, bean);
            logger.info("pos注册接收到后端返回数据=[{}]", response);

            GdaResponse<GdaPosRegisterResponseBody> result = objectMapper.readValue(response, new TypeReference<GdaResponse<GdaPosRegisterResponseBody>>() {});

            //国大注册交易失败
            if (!GDA_SUCCESS_CODE.equals(result.getAjaxErrorCode())) {
                transResult.setCode(result.getAjaxErrorCode());
                transResult.setMessage(result.getMessage());
            }

            transResult.setBody(result.getData());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("出现系统异常=[{}]", e.getMessage());
            transResult.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
            transResult.setMessage("系统错误："+e.getMessage());
        }

        return transResult;
    }

    //收发国大的员工卡查询交易
    public TransResult emplyeeQuery(RequestBean bean) {
        TransResult transResult = new TransResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());
        try {
            GdaEmplyeeQueryRequestBody body = new GdaEmplyeeQueryRequestBody();
            body.setAccessToken(getAccessToken(bean.getBaseUrl(), bean.getAppId(), bean.getSecureKey()));
            body.setStoreId(bean.getMchtId());
            body.setTerminalNo(bean.getTermId());
            body.setQrcode(bean.getCustomerId());

            String url = bean.getBaseUrl() + "/pos/getEmployeeInfo";
            String request = objectMapper.writeValueAsString(body);
            logger.info("员工卡查询的请求地址=[{}]", url);
            logger.info("员工卡查询的请求报文=[{}]", request);

            String response = wrapperPost(url, body, bean);
            logger.info("员工卡查询接收到后端返回数据=[{}]", response);

            //result是国大返回信息体的data部分
            GdaResponse<GdamemberQueryResponseBody<GdamemberQueryResponseSubBody>> result = objectMapper.readValue(response, new TypeReference<GdaResponse<GdamemberQueryResponseBody<GdamemberQueryResponseSubBody>>>() {});

            //国大验证交易失败（因为成功时已经默认为会员系统的成功代码做返回码），返回国大的返回码
            if (!GDA_SUCCESS_CODE.equals(result.getAjaxErrorCode())) {
                transResult.setCode(result.getAjaxErrorCode());
                transResult.setMessage(result.getMessage());
            }

            //当交易失败时，data是空
            transResult.setBody(result.getData());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("出现系统异常=[{}]", e.getMessage());
            transResult.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
            transResult.setMessage("系统错误："+e.getMessage());
        }

        return transResult;
    }

    //收发国大的储值卡查询交易
    public TransResult dcQuery(RequestBean bean) {
        TransResult transResult = new TransResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());
        try {
            GdaDcQueryRequestBody body = new GdaDcQueryRequestBody();
            body.setAccessToken(getAccessToken(bean.getBaseUrl(), bean.getAppId(), bean.getSecureKey()));
            body.setStoreId(bean.getMchtId());
            body.setTerminalNo(bean.getTermId());
            body.setInputType(bean.getInputType());
            body.setIdKeyword(bean.getIdkeyword());

            String url = bean.getBaseUrl() + "/pos/getCardInfo";
            String request = objectMapper.writeValueAsString(body);
            logger.info("储值卡查询的请求地址=[{}]", url);
            logger.info("储值卡查询的请求报文=[{}]", request);

            String response = wrapperPost(url, body, bean);
            logger.info("储值卡查询接收到后端返回数据=[{}]", response);

            //result是国大返回信息体的data部分
            GdaResponse<GdaDcQueryResponseBody> result = objectMapper.readValue(response, new TypeReference<GdaResponse<GdaDcQueryResponseBody>>() {});

            //国大验证交易失败（因为成功时已经默认为会员系统的成功代码做返回码），返回国大的返回码
            if (!GDA_SUCCESS_CODE.equals(result.getAjaxErrorCode())) {
                transResult.setCode(result.getAjaxErrorCode());
                transResult.setMessage(result.getMessage());
            }

            //当交易失败时，data是空
            transResult.setBody(result.getData());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("出现系统异常=[{}]", e.getMessage());
            transResult.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
            transResult.setMessage("系统错误："+e.getMessage());
        }

        return transResult;
    }

    //收发国大的停车券查询交易
    public TransResult parkingQuery(RequestBean bean) {
        TransResult transResult = new TransResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());
        try {
            GdaParkingQueryRequestBody body = new GdaParkingQueryRequestBody();
            body.setAccessToken(getAccessToken(bean.getBaseUrl(), bean.getAppId(), bean.getSecureKey()));
            body.setStoreId(bean.getMchtId());
            body.setTerminalNo(bean.getTermId());
            body.setPageSize(bean.getPageSize());
            body.setPageNo(bean.getPageNo());
            body.setStartDate(bean.getStartDate());
            body.setEndDate(bean.getEndDate());

            String url = bean.getBaseUrl() + "/pos/getParkingCouponList";
            String request = objectMapper.writeValueAsString(body);
            logger.info("停车券查询的请求地址=[{}]", url);
            logger.info("停车券查询的请求报文=[{}]", request);

            String response = wrapperPost(url, body, bean);
            logger.info("停车券查询接收到后端返回数据=[{}]", response);

            //result是国大返回信息体的data部分
            GdaResponse<List<GdaParkingInfResponseBody>> result = objectMapper.readValue(response, new TypeReference<GdaResponse<List<GdaParkingInfResponseBody>>>() {});

            //国大交易失败（因为成功时已经默认为会员系统的成功代码做返回码），返回国大的返回码
            if (!GDA_SUCCESS_CODE.equals(result.getAjaxErrorCode())) {
                transResult.setCode(result.getAjaxErrorCode());
                transResult.setMessage(result.getMessage());
            }

            //当交易失败时，data是空
            transResult.setBodyList(result.getData());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("出现系统异常=[{}]", e.getMessage());
            transResult.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
            transResult.setMessage("系统错误："+e.getMessage());
        }

        return transResult;
    }

    //停车券生成
    public TransResult generateParkingCoupon(RequestBean bean) {
        TransResult transResult = new TransResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());
        try {
            GdaGenerateParkingCouponRequestBody body = new GdaGenerateParkingCouponRequestBody();
            body.setAccessToken(getAccessToken(bean.getBaseUrl(), bean.getAppId(), bean.getSecureKey()));
            body.setStoreId(bean.getMchtId());
            body.setTerminalNo(bean.getTermId());
            body.setAmount(bean.getAmount());

            String url = bean.getBaseUrl() + "/pos/getParkingCoupon";
            String request = objectMapper.writeValueAsString(body);
            logger.info("停车券生成的请求地址=[{}]", url);
            logger.info("停车券生成的请求报文=[{}]", request);

            String response = wrapperPost(url, body, bean);
            logger.info("停车券生成接收到后端返回数据=[{}]", response);

            //result是国大返回信息体的data部分
            GdaResponse<GdaParkingInfResponseBody> result = objectMapper.readValue(response, new TypeReference<GdaResponse<GdaParkingInfResponseBody>>() {});


            //国大交易失败（因为成功时已经默认为会员系统的成功代码做返回码），返回国大的返回码
            if (!GDA_SUCCESS_CODE.equals(result.getAjaxErrorCode())) {
                transResult.setCode(result.getAjaxErrorCode());
                transResult.setMessage(result.getMessage());
            }

            //当交易失败时，data是空
            transResult.setBody(result.getData());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("出现系统异常=[{}]", e.getMessage());
            transResult.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
            transResult.setMessage("系统错误："+e.getMessage());
        }

        return transResult;
    }

    //收发国大的员工卡消费交易
    public TransResult emplyeeVerification(RequestBean bean) {
        TransResult transResult = new TransResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());
        try {
            GdaEmplyeeVerificationRequestBody body = new GdaEmplyeeVerificationRequestBody();
            body.setAccessToken(getAccessToken(bean.getBaseUrl(), bean.getAppId(), bean.getSecureKey()));
            body.setStoreId(bean.getMchtId());
            body.setTerminalNo(bean.getTermId());
            body.setBillNo(bean.getBillNo());
            body.setMemberId(bean.getCustomerId());
            body.setTelephone(bean.getMemberPhone());
            body.setTotalAmount(bean.getAmount());
            body.setBillType("1");
            body.setReceiptAmount(bean.getReceiptAmount());
            body.setDiscountAmount(bean.getDiscountAmount());


            String url = bean.getBaseUrl() + "/pos/eOrderSubmit";
            String request = objectMapper.writeValueAsString(body);
            logger.info("员工卡消费的请求地址=[{}]", url);
            logger.info("员工卡消费的请求报文=[{}]", request);

            String response = wrapperPost(url, body, bean);
            logger.info("员工卡消费接收到后端返回数据=[{}]", response);

            //result是国大返回信息体的data部分
            GdaResponse<GdaEmployeeVerificationfResponsbody> result = objectMapper.readValue(response, new TypeReference<GdaResponse<GdaEmployeeVerificationfResponsbody>>() {});


            //国大交易失败（因为成功时已经默认为会员系统的成功代码做返回码），返回国大的返回码
            if (!GDA_SUCCESS_CODE.equals(result.getAjaxErrorCode())) {
                transResult.setCode(result.getAjaxErrorCode());
                transResult.setMessage(result.getMessage());
            }

            //当交易失败时，data是空
            transResult.setBody(result.getData());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("出现系统异常=[{}]", e.getMessage());
            transResult.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
            transResult.setMessage("系统错误："+e.getMessage());
        }

        return transResult;
    }

    //国大储值卡(D)、停车券(P)和优惠券(C)的消费
    public TransResult dpcVerification(RequestBean bean) {
        TransResult transResult = new TransResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());
        try {
            GdaDpcVerificationRequestBody body = new GdaDpcVerificationRequestBody();
            body.setAccessToken(getAccessToken(bean.getBaseUrl(), bean.getAppId(), bean.getSecureKey()));
            body.setStoreId(bean.getMchtId());
            body.setTerminalNo(bean.getTermId());
            body.setBillNo(bean.getBillNo());
            body.setCid(bean.getCustomerId());
            body.setPayDate(DateUtils.formatNowTime());
            body.setTransNo(bean.getTransNo());
            body.setPayCode(bean.getPayCode());
            body.setInputType(bean.getInputType());
            body.setCardNo(bean.getCardNo());
            body.setAmount(bean.getAmount());

            String url = bean.getBaseUrl() + "/pos/payment";
            String request = objectMapper.writeValueAsString(body);
            logger.info("国大支付交易（券码核销）的请求地址=[{}]", url);
            logger.info("国大支付交易（券码核销）的请求报文=[{}]", request);

            String response = wrapperPost(url, body, bean);
            logger.info("国大支付交易（券码核销）接收到后端返回数据=[{}]", response);

            //result是国大返回信息体的data部分
            GdaResponse<GdaPaymentResponseBody> result = objectMapper.readValue(response, new TypeReference<GdaResponse<GdaPaymentResponseBody>>() {});


            //国大交易失败（因为成功时已经默认为会员系统的成功代码做返回码），返回国大的返回码
            if (!GDA_SUCCESS_CODE.equals(result.getAjaxErrorCode())) {
                transResult.setCode(result.getAjaxErrorCode());
                transResult.setMessage(result.getMessage());
            }

            //当交易失败时，data是空
            transResult.setBody(result.getData());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("出现系统异常=[{}]", e.getMessage());
            transResult.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
            transResult.setMessage("系统错误："+e.getMessage());
        }

        return transResult;
    }

    //收发国大的订单提交交易
    public TransResult orderCommit(RequestBean bean) {
        TransResult transResult = new TransResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());
        try {
            GdaOrderCommitRequestBody body = new GdaOrderCommitRequestBody();
            body.setAccessToken(getAccessToken(bean.getBaseUrl(), bean.getAppId(), bean.getSecureKey()));
            body.setStoreId(bean.getMchtId());
            body.setTerminalNo(bean.getTermId());
            body.setBillType(bean.getOrderType());
            body.setBillNo(bean.getOrderNo());
            body.setAmount(bean.getOrderAmount());
            body.setBillDate(DateUtils.formatNowTime());
            body.setDiscountAmount(bean.getDiscountAmount());
            body.setFactAmount(bean.getReceiptAmount());
            body.setOriginalBillNo(bean.getOriginalOrderNo());
            body.setCid(bean.getCustomerId());
            if (bean.getPayInfo() == null || bean.getPayInfo().size() <= 0) {
                transResult.setCode(ErrorCodes.SYS_PARAMETER_INVALID.getCode());
                transResult.setMessage("上送的交易信息为空，请检查订单下是否存在交易或确认订单号是否正确");
                logger.error("上送的交易信息为空，请检查订单下是否存在交易或确认订单号是否正确");
                return transResult;
            }

            body.setPayList(objectMapper.writeValueAsString(bean.getPayInfo()));

            String url = bean.getBaseUrl() + "/pos/orderSubmit";
            String request = objectMapper.writeValueAsString(body);
            logger.info("国大订单提交的请求地址=[{}]", url);
            logger.info("国大订单提交的请求报文=[{}]", request);

            String response = wrapperPost(url, body, bean);
            logger.info("国大订单提交接收到后端返回数据=[{}]", response);

            GdaResponse<GdaOrderSubmitResponseBody> result = objectMapper.readValue(response, new TypeReference<GdaResponse<GdaOrderSubmitResponseBody>>() {});

            //国大订单提交交易失败
            if (!GDA_SUCCESS_CODE.equals(result.getAjaxErrorCode())) {
                transResult.setCode(result.getAjaxErrorCode());
                transResult.setMessage(result.getMessage());
            }

            transResult.setBody(result.getData()); //返回OK/NG无实际意义，不做设置
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("出现系统异常=[{}]", e.getMessage());
            transResult.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
            transResult.setMessage("系统错误："+e.getMessage());
        }

        return transResult;
    }

    //收发国大的员工撤销交易
    public TransResult employeeCancel(RequestBean bean) {
        TransResult transResult = new TransResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());
        try {
            GdaEmployeeCancelRequestBody body = new GdaEmployeeCancelRequestBody();
            body.setAccessToken(getAccessToken(bean.getBaseUrl(), bean.getAppId(), bean.getSecureKey()));
            body.setStoreId(bean.getMchtId());
            body.setTerminalNo(bean.getTermId());
            body.setCid(bean.getCustomerId());
            body.setOrderId(bean.getOldTradeNo());
            body.setTotalAmount(bean.getOrderAmount());
            body.setReceiptAmount(bean.getReceiptAmount());
            body.setDiscountAmount(bean.getDiscountAmount());
            body.setCreateTime(DateUtils.formatNowTime());

            String url = bean.getBaseUrl() + "/pos/eOrderCancel";
            String request = objectMapper.writeValueAsString(body);
            logger.info("员工消费撤销的请求地址=[{}]", url);
            logger.info("员工消费撤销的请求报文=[{}]", request);

            String response = wrapperPost(url, body, bean);
            logger.info("员工消费撤销接收到后端返回数据=[{}]", response);

            //result是国大返回信息体的data部分，撤销返回的内容元素和GdaPosRegisterResponseBody一样
            GdaResponse<GdaPosRegisterResponseBody> result = objectMapper.readValue(response, new TypeReference<GdaResponse<GdaPosRegisterResponseBody>>() {});

            //国大验证交易失败（因为成功时已经默认为会员系统的成功代码做返回码），返回国大的返回码
            if (!GDA_SUCCESS_CODE.equals(result.getAjaxErrorCode())) {
                transResult.setCode(result.getAjaxErrorCode());
                transResult.setMessage(result.getMessage());
            }

            //当交易失败时，data是空
            transResult.setBody(result.getData());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("出现系统异常=[{}]", e.getMessage());
            transResult.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
            transResult.setMessage("系统错误："+e.getMessage());
        }

        return transResult;
    }

    //收发国大的卡券撤销交易
    public TransResult couponCancel(RequestBean bean) {
        TransResult transResult = new TransResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());
        try {
            GdaCouponCancelRequestBody body = new GdaCouponCancelRequestBody();
            body.setAccessToken(getAccessToken(bean.getBaseUrl(), bean.getAppId(), bean.getSecureKey()));
            body.setStoreId(bean.getMchtId());
            body.setTerminalNo(bean.getTermId());
            body.setTransNo(bean.getTransNo());
            body.setCancelDate(DateUtils.formatNowTime());
//            body.setOriginalBillNo(bean.getOldOrderNo());
            body.setOriginalTransNo(bean.getOldTradeNo());
            body.setAmount(bean.getOrderAmount());

            String url = bean.getBaseUrl() + "/pos/orderCancel";
            String request = objectMapper.writeValueAsString(body);
            logger.info("卡券核销撤销的请求地址=[{}]", url);
            logger.info("卡券核销撤销的请求报文=[{}]", request);

            String response = wrapperPost(url, body, bean);
            logger.info("卡券核销撤销接收到后端返回数据=[{}]", response);

            //result是国大返回信息体的data部分，撤销返回的内容元素和GdaPosRegisterResponseBody一样
            GdaResponse<GdaPosRegisterResponseBody> result = objectMapper.readValue(response, new TypeReference<GdaResponse<GdaPosRegisterResponseBody>>() {});

            //国大验证交易失败（因为成功时已经默认为会员系统的成功代码做返回码），返回国大的返回码
            if (!GDA_SUCCESS_CODE.equals(result.getAjaxErrorCode())) {
                transResult.setCode(result.getAjaxErrorCode());
                transResult.setMessage(result.getMessage());
            }

            //当交易失败时，data是空
            transResult.setBody(result.getData());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("出现系统异常=[{}]", e.getMessage());
            transResult.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
            transResult.setMessage("系统错误："+e.getMessage());
        }

        return transResult;
    }

    //收发国大的核销查询交易
    public TransResult mixQuery(RequestBean bean) {
        TransResult transResult = new TransResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());
        try {
            GdaMixQueryRequestBody body = new GdaMixQueryRequestBody();
            body.setAccessToken(getAccessToken(bean.getBaseUrl(), bean.getAppId(), bean.getSecureKey()));
            body.setStoreId(bean.getMchtId());
            body.setTerminalNo(bean.getTermId());
            body.setTransNo(bean.getTransNo());

            String request = objectMapper.writeValueAsString(body);
            logger.info("核销查询的请求报文=[{}]", request);

            String url = bean.getBaseUrl() + "/pos/transOrderQuery";
            String response = wrapperPost(url, body, bean);
            logger.info("核销查询接收到后端返回数据=[{}]", response);

            GdaResponse<List<GdaMixQuerryResponseBody>> result = objectMapper.readValue(response, new TypeReference<GdaResponse<List<GdaMixQuerryResponseBody>>>() {});

            //国大查询失败
            if (!GDA_SUCCESS_CODE.equals(result.getAjaxErrorCode())) {
                transResult.setCode(result.getAjaxErrorCode());
                transResult.setMessage(result.getMessage());
            }

            //已经和国大沟通，返回的是数组。但是因为是单笔，只取第一个即可
            transResult.setBody(result.getData().get((0)));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("出现系统异常=[{}]", e.getMessage());
            transResult.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
            transResult.setMessage("系统错误："+e.getMessage());
        }

        return transResult;
    }

    //收发国大的核销查询交易
    public TransResult mixEmployeeQuery(RequestBean bean) {
        TransResult transResult = new TransResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());
        try {

            GdaMixEmployeeRequestBody body = new GdaMixEmployeeRequestBody();
            body.setAccessToken(getAccessToken(bean.getBaseUrl(), bean.getAppId(), bean.getSecureKey()));
            body.setStoreId(bean.getMchtId());
            body.setTerminalNo(bean.getTermId());
            body.setPageSize(bean.getPageSize());
            body.setPageNo(bean.getPageNo());
            body.setCid(bean.getCustomerId());
            body.setStartDate(bean.getStartDate());
            body.setEndDate(bean.getEndDate());

            String request = objectMapper.writeValueAsString(body);
            logger.info("员工查询的请求报文=[{}]", request);

            String url = bean.getBaseUrl() + "/pos/eOrderList";
            String response = wrapperPost(url, body, bean);
            logger.info("员工查询接收到后端返回数据=[{}]", response);

            GdaResponse<List<GdaMixEmployeeResponseBody>> result = objectMapper.readValue(response, new TypeReference<GdaResponse<List<GdaMixEmployeeResponseBody>>>() {});

            //国大查询失败
            if (!GDA_SUCCESS_CODE.equals(result.getAjaxErrorCode())) {
                transResult.setCode(result.getAjaxErrorCode());
                transResult.setMessage(result.getMessage());
            }

            //已经和国大沟通，返回的是数组。但是因为是单笔，只取第一个即可
            transResult.setBodyList(result.getData());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("出现系统异常=[{}]", e.getMessage());
            transResult.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
            transResult.setMessage("系统错误："+e.getMessage());
        }

        return transResult;
    }

    public String getAccessToken(String transUrl, String appId, String secureKey) throws Exception {
        return getAccessToken(transUrl, appId, secureKey, false);
    }

    /**
     * 获取AccessToken
     *
     * @param appId     国大分配
     * @param secureKey 国大分配
     * @param forceUpdate 强制更新
     * @return
     */
    public String getAccessToken(String transUrl, String appId, String secureKey, boolean forceUpdate) throws Exception {
        String fileName = "token.txt";
        File file = new File(fileName);

        // 文件已经存在了，检查token是否过期
        if (!forceUpdate && file.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String ctx = br.readLine();
            String accessToken = ctx.split("\\|")[0];
            String timeExpire = ctx.split("\\|")[1];
            br.close();

            long tmp = file.lastModified() + Long.parseLong(timeExpire) * 1000;

            if (System.currentTimeMillis() - tmp < 0) {
                logger.info("已经获取到的AccessToken尚未过期，直接返回");
                return accessToken;
            }

            logger.info("现有的accessToken已经过期，重新获取");
        }

        Map<String, String> map = new HashMap<>();
        map.put("appid", appId);
        map.put("timestamp", System.currentTimeMillis() + "");
        map.put("sign", getSign(appId, secureKey, map.get("timestamp")));

        String request = objectMapper.writeValueAsString(map);

        logger.info("获取accessToken的请求报文=[{}]", request);

        String url = transUrl + "/getAccessToken";
        String response = doPost(url, request);
        logger.info("获取accessToken接收到后端返回数据=[{}]", response);

        GdaResponse<GdaAccessTokenResponseBody> result = objectMapper.readValue(response, new TypeReference<GdaResponse<GdaAccessTokenResponseBody>>() {
        });

        String token = null;
        if (GDA_SUCCESS_CODE.equals(result.getAjaxErrorCode())) {
            GdaAccessTokenResponseBody body = result.getData();
            // 存储在文件当中
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fileName)));
            bw.write(body.getAccess_token() + "|" + body.getExpire_time() / 2);
            bw.close();

            token = body.getAccess_token();
        }

        return token;
    }

    /**
     * 对反会的数据进行一次检查，如果是签名错误的话强制更新token再次发起交易
     * @param url
     * @param body
     * @param bean
     * @return
     * @throws Exception
     */
    private String wrapperPost(String url, GdaBaseRequestBody body, RequestBean bean) throws Exception {
        String request = objectMapper.writeValueAsString(body);
        String response = doPost(url, request);

        HashMap<String, Object> result = objectMapper.readValue(response, new TypeReference<HashMap<String, Object>>() {});

        String code = result.get("ajaxErrorCode")+"";

        if (GDA_SIGNERR_CODE1.equals(code) || GDA_SIGNERR_CODE2.equals(code)) {
            logger.info("返回数据=[{}]", response);
            logger.info("后端返回签名错误护超时，需要强制更新accessToken");
            body.setAccessToken(getAccessToken(bean.getBaseUrl(), bean.getAppId(), bean.getSecureKey(), true));
            response = doPost(url, objectMapper.writeValueAsString(body));
        }

        return response;
    }

    private String getSign(String appId, String secureKey, String timestamp) {
        return CipherUtils.md5(appId + secureKey + timestamp + appId);
    }

    private String doPost(String url, String request) {
        try {
            return WebUtils.doPost(url, request, MESSAGE_TYPE, CHAR_SET, CONNET_TIMEOUT, READ_TIMEOUT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
