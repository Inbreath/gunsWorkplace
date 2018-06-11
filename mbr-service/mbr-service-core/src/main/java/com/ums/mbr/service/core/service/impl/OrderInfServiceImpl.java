package com.ums.mbr.service.core.service.impl;

import com.ums.mbr.service.core.example.OrderInfExample;
import com.ums.mbr.service.core.mapper.OrderInfMapper;
import com.ums.mbr.service.core.service.OrderInfService;
import com.ums.mbr.service.domain.OrderInf;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderInfServiceImpl implements OrderInfService {

    @Resource
    private OrderInfMapper orderInfMapper;

    @Override
    public int insertSelective(OrderInf orderInf) {
        return  orderInfMapper.insertSelective(orderInf);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderInf orderInf) {
        return orderInfMapper.updateByPrimaryKeySelective(orderInf);
    }

    @Override
    public int updateByOrderNoSelective(OrderInf orderInf) {
        return orderInfMapper.updateByOrderNoSelective(orderInf);
    }

    @Override
    public OrderInf getOrderByOrderNo(String mchtId, String termId, String orderNo) {
        OrderInfExample example = new OrderInfExample();
        OrderInfExample.Criteria criteria = example.createCriteria();
        criteria.andMchtnoEqualTo(mchtId);
        criteria.andTermnoEqualTo(termId);
        criteria.andOrderNoEqualTo(orderNo);

        List<OrderInf> lists = orderInfMapper.selectByExample(example);

        if (null == lists || lists.size() <= 0) return null;

        return lists.get(0);
    }
}
