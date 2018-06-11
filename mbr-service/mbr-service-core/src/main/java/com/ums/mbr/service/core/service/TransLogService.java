package com.ums.mbr.service.core.service;


import com.ums.mbr.service.domain.TransLog;

public interface TransLogService {

    /**
     * 在t_translog表中插入交易
     * @param transLog 需要插入的交易对象
     * @return
     */
    int insert(TransLog transLog);

    /**
     * 在t_translog表中更新交易
     * @param transLog 需要更新的交易对象
     * @return
     */
    int updateByPrimaryKey(TransLog transLog);

    /**
     * 商户下得outTradeNo保持唯一
     * @param mchtId
     * @param outTradeNo
     * @return
     */
    long countByOutTradeNo(String mchtId, String outTradeNo);

}
