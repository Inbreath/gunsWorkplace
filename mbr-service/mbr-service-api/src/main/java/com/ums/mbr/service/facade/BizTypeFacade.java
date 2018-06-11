package com.ums.mbr.service.facade;

import com.ums.mbr.service.domain.BizType;

public interface BizTypeFacade {

    /**
     * 根据交易代码进行查询
     * @param Code 交易代码
     * @return
     */
    BizType findByCode(String Code);
}
