package com.ums.mbr.service.core.service.impl;


import com.ums.mbr.service.core.example.TransLogExample;
import com.ums.mbr.service.core.mapper.TransLogMapper;
import com.ums.mbr.service.core.service.TransLogService;
import com.ums.mbr.service.domain.TransLog;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TransLogServiceImpl implements TransLogService {

    @Resource
    private TransLogMapper transLogMapper;

    @Override
    public int insert(TransLog transLog) {
        return transLogMapper.insert(transLog);
    }

    @Override
    public int updateByPrimaryKey(TransLog transLog) {
        return transLogMapper.updateByPrimaryKeySelective(transLog);
    }

    @Override
    public long countByOutTradeNo(String mchtId, String outTradeNo) {

        TransLogExample example = new TransLogExample();
        TransLogExample.Criteria criteria = example.createCriteria();
        criteria.andMchtnoEqualTo(mchtId);
        criteria.andOutTradeNoEqualTo(outTradeNo);

        return transLogMapper.countByExample(example);
    }
}
