package com.ums.mbr.service.core.facade;

import com.alibaba.dubbo.config.annotation.Service;
import com.ums.mbr.service.core.service.TermService;
import com.ums.mbr.service.domain.Term;
import com.ums.mbr.service.facade.TermFacade;

import javax.annotation.Resource;

/**
 * 交易代码表对消费者提供的接口实现
 * Author: jcouyang@chinaums.com
 * Date:   2018/03/01 14:41
 */
@Service
public class TermFacadeImpl implements TermFacade {

    @Resource
    private TermService termService;

    @Override
    public Term findOneRecord(String mchtId, String termId) {
        return termService.findByPrimaryKey(mchtId, termId);
    }
}
