package com.ums.mbr.service.core.service;


import com.ums.mbr.service.domain.Mall;

public interface MallService {
    /**
     * 根据综合体编号查找综合体
     *
     * @param MallCode 综合体编号
     * @return
     */
    Mall findByMallCode(String MallCode);

}
