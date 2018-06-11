package com.ums.mbr.service.core.service.impl;

import com.ums.mbr.enums.TradeStatus;
import com.ums.mbr.enums.TradeTypes;
import com.ums.mbr.service.core.example.TradeInfExample;
import com.ums.mbr.service.core.mapper.TradeInfMapper;
import com.ums.mbr.service.core.service.TradeInfService;
import com.ums.mbr.service.domain.TradeInf;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TradeInfServiceImpl implements TradeInfService {
    @Resource
    private TradeInfMapper tradeInfMapper;

    @Override
    public int insert(TradeInf tradeInf) {
        return tradeInfMapper.insertSelective(tradeInf);
    }

    @Override
    public int updateByPrimaryKeySelective(TradeInf tradeInf) {
        return tradeInfMapper.updateByPrimaryKeySelective(tradeInf);
    }

    @Override
    public int updateByTradeNoSelective(TradeInf tradeInf) {
        return tradeInfMapper.updateByTradeNoSelective(tradeInf);
    }

    @Override
    public List<TradeInf> selectByOrderNo(String orderNo) {
        TradeInfExample example = new TradeInfExample();
        TradeInfExample.Criteria criteria = example.createCriteria();
        criteria.andOldOrderNoEqualTo(orderNo);

        List<TradeInf> lists = tradeInfMapper.selectByExample(example);
        return lists;
    }

    @Override
    public TradeInf selectByTradeNo(String tradeNo) {
        TradeInfExample example = new TradeInfExample();
        TradeInfExample.Criteria criteria = example.createCriteria();
        criteria.andTradeNoEqualTo(tradeNo);

        List<TradeInf> lists = tradeInfMapper.selectByExample(example);

        if (null == lists || lists.size() <= 0) return null;

        return lists.get(0);
    }

    @Override
    public TradeInf findRecordByTradeNo(String mchtId, String termId, String tradeNo) {

        TradeInfExample example = new TradeInfExample();
        TradeInfExample.Criteria criteria = example.createCriteria();
        criteria.andMchtnoEqualTo(mchtId);
        criteria.andTermnoEqualTo(termId);
        criteria.andTradeNoEqualTo(tradeNo);

        List<TradeInf> lists = tradeInfMapper.selectByExample(example);

        if (null == lists || lists.size() <= 0) return null;

        return lists.get(0);
    }

    @Override
    public List<TradeInf> findRecordsByOrderNo(String mchtId, String termId, String orderNo, boolean isCanceled) {
        TradeInfExample example = new TradeInfExample();
        TradeInfExample.Criteria criteria = example.createCriteria();
        criteria.andMchtnoEqualTo(mchtId);
        criteria.andTermnoEqualTo(termId);
        criteria.andOrderNoEqualTo(orderNo);

        // 撤销订单
        if (isCanceled) {
            criteria.andTransTypeEqualTo(TradeTypes.VOID.getName());
        } else {
            // 核销订单
            criteria.andTransTypeEqualTo(TradeTypes.SALE.getName());
        }

        criteria.andStatusEqualTo(TradeStatus.SUCCESS.getName());

        return tradeInfMapper.selectByExample(example);
    }
}
