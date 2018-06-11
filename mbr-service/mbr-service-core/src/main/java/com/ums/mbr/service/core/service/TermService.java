package com.ums.mbr.service.core.service;

import com.ums.mbr.service.domain.Term;

public interface TermService {

    /**
     * 根据商户号和终端号查找终端
     * @param mchtNo 商户号
     * @param termNo 终端号
     * @return
     */
    Term findByPrimaryKey(String mchtNo, String termNo);

    /**
     * 根据商户号和终端号更新终端信息
     * @param term 终端信息
     * @return
     */
    int updateByPrimaryKey(Term term);

}
