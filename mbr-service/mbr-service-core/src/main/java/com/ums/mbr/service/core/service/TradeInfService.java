package com.ums.mbr.service.core.service;

import com.ums.mbr.service.domain.TradeInf;

import java.util.List;

public interface TradeInfService {

    /**
     * 在t_tradeInf表中插入核销交易
     * @param tradeInf 需要插入的交易对象
     * @return
     */
    int insert(TradeInf tradeInf);

    /**
     * 在t_tradeInf表中插入核销交易
     * @param tradeInf 需要插入的交易对象
     * @return
     */
    int updateByPrimaryKeySelective(TradeInf tradeInf);

    int updateByTradeNoSelective(TradeInf tradeInf);


    /**
     * 在t_tradeInf表中按订单号查询h核销交易
     * @param orderNo 需要查询的订单号
     * @return
     */
    List<TradeInf> selectByOrderNo(String orderNo);

    /**
     * 在t_tradeInf表中按交易号查询核销交易
     * @param tradeNo
     * @return
     */
    TradeInf selectByTradeNo(String tradeNo);

    /**
     * 通过平台交易号查找某笔指定的交易
     * @param mchtId 商户号
     * @param termId 终端号
     * @param tradeNo 交易号
     * @return
     */
    TradeInf findRecordByTradeNo(String mchtId, String termId, String tradeNo);

    /**
     * 通过订单号查询相关联的交易
     * @param mchtId 商户号
     * @param termId 终端号
     * @param orderNo 订单号
     * @return
     */
    List<TradeInf> findRecordsByOrderNo(String mchtId, String termId, String orderNo, boolean isCanceled);
}
