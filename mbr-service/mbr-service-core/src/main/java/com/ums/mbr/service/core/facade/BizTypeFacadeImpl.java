package com.ums.mbr.service.core.facade;

import com.alibaba.dubbo.config.annotation.Service;
import com.ums.mbr.service.core.service.BizTypeService;
import com.ums.mbr.service.domain.BizType;
import com.ums.mbr.service.facade.BizTypeFacade;

import javax.annotation.Resource;

/**
 * 交易类型表对消费者提供的接口实现
 * Author: pwwu@chinaums.com
 * Date:   2018/03/08 11:22
 */
@Service
public class BizTypeFacadeImpl implements BizTypeFacade {

    @Resource
    private BizTypeService bizTypeService;

    @Override
    public BizType findByCode(String Code) {
        return bizTypeService.findByCode(Code);
    }
}
