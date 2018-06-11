package com.ums.mbr.service.core.service;

import com.ums.mbr.service.domain.BizType;

public interface BizTypeService {

    /**
     * 根据交易代码查找
     *
     * @param Code 交易代码
     * @return
     */
    BizType findByCode(String Code);

}
