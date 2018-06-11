package com.ums.mbr.service.core.service.impl;

import com.ums.mbr.service.core.example.PayinfExample;
import com.ums.mbr.service.core.mapper.PayinfMapper;
import com.ums.mbr.service.core.service.PayInfService;
import com.ums.mbr.service.domain.Payinf;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PayInfServiceImpl implements PayInfService {
    @Resource
    private PayinfMapper payInfMapper;

    @Override
    public int insertSelective(Payinf payinf) {

        return payInfMapper.insertSelective(payinf);
    }

    @Override
    public int updateByPrimaryKeySelective(Payinf payinf) {

        return payInfMapper.updateByPrimaryKeySelective(payinf);
    }

    @Override
    public int updateByOutTradeNoSelective(Payinf payinf) {

        return payInfMapper.updateByOutTradeNoSelective(payinf);
    }

    @Override
    public Payinf findPayInfByOutTradeNo(String outTradeNo, String transType) {

        PayinfExample example = new PayinfExample();
        PayinfExample.Criteria criteria = example.createCriteria();
        criteria.andOutTradeNoEqualTo(outTradeNo);
        criteria.andTransTypeEqualTo(transType);

        List<Payinf> lists = payInfMapper.selectByExample(example);

        if (null == lists || lists.size() <= 0) return null;

        return lists.get(0);
    }

}
