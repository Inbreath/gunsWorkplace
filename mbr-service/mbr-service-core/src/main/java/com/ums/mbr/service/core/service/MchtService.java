package com.ums.mbr.service.core.service;

import com.ums.mbr.service.domain.Mcht;

public interface MchtService {
    /**
     * 根据商户号查找商户信息
     * @param mchtno 商户号
     * @return
     */
    Mcht findByMchtno(String mchtno);
}
