package com.ums.mbr.service.facade;

import com.ums.mbr.service.domain.Mcht;

public interface MchtFacade {

    /**
     * 根据商户号进行查询
     * @param mchtno 商户号
     * @return
     */
    Mcht findByMchtno(String mchtno);
}
