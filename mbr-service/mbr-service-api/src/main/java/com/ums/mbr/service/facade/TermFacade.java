package com.ums.mbr.service.facade;

import com.ums.mbr.service.domain.Term;

public interface TermFacade {

    /**
     * 根据商户号和终端号查询终端
     * @param mchtId 商户号
     * @param termId 终端号
     * @return
     */
    Term findOneRecord(String mchtId, String termId);

}
