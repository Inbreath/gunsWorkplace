package com.ums.mbr.service.core.service.impl;

import com.ums.mbr.service.core.mapper.MchtMapper;
import com.ums.mbr.service.core.service.MchtService;
import com.ums.mbr.service.domain.Mcht;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MchtServiceImpl implements MchtService {

    @Resource
    private MchtMapper mchtMapper;

    @Override
    public Mcht findByMchtno(String mchtno) {
        return mchtMapper.selectByPrimaryKey(mchtno);
    }
}
