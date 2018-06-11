package com.ums.mbr.service.facade;

import com.ums.mbr.beans.request.MixQueryRequestBody;
import com.ums.mbr.beans.request.SubmitPaymentRequestBody;
import com.ums.mbr.result.ServiceResult;
import com.ums.mbr.service.domain.*;

import java.util.List;
import java.util.Map;

/**
 * Author: jcouyang@chinaums.com
 * Date: 2018/3/7 9:09
 */
public interface TransactionFacade {

    /**
     * 终端验证接口，参见接口文档3.2.1
     * @param transLog 终端上送的请求报文
     * @param qrcode 营管员二维码
     * @return
     */
    ServiceResult posValidate(TransLog transLog, String qrcode);

    /**
     * 终端注册接口，参见接口文档3.2.2
     * @param transLog 终端上送的请求报文
     * @return
     */
    ServiceResult posRegister(TransLog transLog, String qrcode);

    /**
     * 会员查询接口
     * @param transLog 终端上送的请求报文
     * @param customer 请求的客户信息
     * @return
     */
    ServiceResult memberQuery(TransLog transLog, Customer customer);

    /**
     * 核销交易接口
     * @param transLog 终端上送的请求报文
     * @param tradeInf
     * @return
     */
    ServiceResult verificationTrade(TransLog transLog, TradeInf tradeInf, String couponList);

    /**
     * 交易提交接口
     * @param transLog 终端上送的请求报文
     * @param payinf
     * @param txns
     * @return
     */
    ServiceResult orderCommit(TransLog transLog, Payinf payinf, List<SubmitPaymentRequestBody> txns);


    /**
     * 交易撤销接口
     * @param transLog
     * @param outTradeNo 外部交易号
     * @param orderNo 单笔交易撤销对应的订单
     * @param oldTradeNo 原平台交易号
     * @param oldOrderNo 整比订单撤销的原订单号
     * @return
     */
    ServiceResult verificationCancel(TransLog transLog, String outTradeNo,
                                     String orderNo, String oldTradeNo, String oldOrderNo);

    /**
     * 交易查询
     * @param transLog 终端上送的请求报文
     * @param qbody
     * @return
     */
    ServiceResult mixQuery(TransLog transLog, MixQueryRequestBody qbody);


    ServiceResult couponBuilt(TransLog transLog, String amount);

}
