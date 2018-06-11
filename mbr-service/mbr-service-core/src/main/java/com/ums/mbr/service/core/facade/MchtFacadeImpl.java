package com.ums.mbr.service.core.facade;

import com.alibaba.dubbo.config.annotation.Service;
import com.ums.mbr.service.core.service.MchtService;
import com.ums.mbr.service.domain.Mcht;
import com.ums.mbr.service.facade.MchtFacade;

import javax.annotation.Resource;

/**
 * 商户表对消费者提供的接口实现
 * Author: jcouyang@chinaums.com
 * Date:   2018/03/01 14:41
 */
@Service
public class MchtFacadeImpl implements MchtFacade {

    @Resource
    private MchtService mchtService;

    @Override
    public Mcht findByMchtno(String mchtno) {
        return mchtService.findByMchtno(mchtno);
    }

}
