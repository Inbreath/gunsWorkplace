package com.ums.mbr.service.core.service.impl;

import com.ums.mbr.service.core.mapper.RootKeyMapper;
import com.ums.mbr.service.core.service.RootkeyService;
import com.ums.mbr.service.domain.RootKey;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Author: jcouyang@chinaums.com
 * Date: 2018/3/8 14:23
 */
@Service
public class RootkeyServiceImpl implements RootkeyService {

    @Resource
    private RootKeyMapper rootKeyMapper;

    @Override
    public RootKey getRootKey(int idx) {
        return rootKeyMapper.selectByPrimaryKey(idx);
    }
}
