package com.ums.mbr.service.core.service;


import com.ums.mbr.service.domain.PayCode;

public interface PayCodeService {

    /**
     * 根据交代码编号查找交易代码
     * @param PayCodeCode 交易代码编号
     * @return
     */
    PayCode findByPayCodeCode(String PayCodeCode);

}
