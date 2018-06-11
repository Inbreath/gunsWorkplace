package com.ums.mbr.service.core.service.impl;

import com.ums.mbr.service.core.example.MallExample;
import com.ums.mbr.service.core.mapper.MallMapper;
import com.ums.mbr.service.core.service.MallService;
import com.ums.mbr.service.domain.Mall;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MallServiceImpl implements MallService {

    @Resource
    private MallMapper mallMapper;

    @Override
    public Mall findByMallCode(String mallcode) {

        MallExample example = new MallExample();
        MallExample.Criteria criteria = example.createCriteria();
        criteria.andCodeEqualTo(mallcode);

        List<Mall> lists = mallMapper.selectByExample(example);

        if (null == lists || lists.size() == 0) return null;

        return lists.get(0);

    }
}
