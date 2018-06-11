package com.ums.mbr.service.core.service.impl;


import com.ums.mbr.service.core.example.BizTypeExample;
import com.ums.mbr.service.core.mapper.BizTypeMapper;
import com.ums.mbr.service.core.service.BizTypeService;
import com.ums.mbr.service.domain.BizType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BizTypeServiceImpl implements BizTypeService {

    @Resource
    private BizTypeMapper bizTypeMapper;


    @Override
    public BizType findByCode(String code) {

        BizTypeExample example = new BizTypeExample();
        BizTypeExample.Criteria criteria = example.createCriteria();
        criteria.andCodeEqualTo(code);

        List<BizType> lists = bizTypeMapper.selectByExample(example);

        if (null == lists || lists.size() == 0) return null;

        return lists.get(0);

    }
}
