package com.ums.mbr.service.core.service;


import com.ums.mbr.service.domain.OrderInf;

import java.util.HashMap;

public interface OrderInfService {

    /**
     * 订单表插入记录
     * @param orderInf
     * @return
     */
    int insertSelective(OrderInf orderInf);

    /**
     * 通过系统流水号号更新某笔交易
     * @param orderInf
     * @return
     */
    int updateByPrimaryKeySelective(OrderInf orderInf);

    /**
     * 通过订单号更新某笔交易
     * @param orderInf
     * @return
     */
    int updateByOrderNoSelective(OrderInf orderInf);

    /**
     * 通过订单号精确查找某一笔订单
     * @param mchtId 商户号
     * @param termId 终端号
     * @param orderNo 订单号
     * @return
     */
    OrderInf getOrderByOrderNo(String mchtId, String termId, String orderNo);

}
