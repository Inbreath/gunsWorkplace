package com.ums.mbr.service.core.service.impl;



import com.ums.mbr.service.core.example.PayCodeExample;
import com.ums.mbr.service.core.mapper.PayCodeMapper;
import com.ums.mbr.service.core.service.PayCodeService;
import com.ums.mbr.service.domain.PayCode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PayCodeServiceImpl implements PayCodeService {
    @Resource
    private PayCodeMapper payCodeMapper;

    @Override
    public PayCode findByPayCodeCode(String PayCodeCode) {

        PayCodeExample example = new PayCodeExample();
        PayCodeExample.Criteria criteria = example.createCriteria();
        criteria.andCodeEqualTo(PayCodeCode);

        List<PayCode> lists = payCodeMapper.selectByExample(example);

        if (null == lists || lists.size() == 0) return null;

        return lists.get(0);

    }
}
