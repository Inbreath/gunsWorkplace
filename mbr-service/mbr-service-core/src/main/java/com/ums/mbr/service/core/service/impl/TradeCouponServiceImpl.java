package com.ums.mbr.service.core.service.impl;

import com.ums.mbr.service.core.mapper.TradeCouponMapper;
import com.ums.mbr.service.core.service.TradeCouponService;
import com.ums.mbr.service.domain.TradeCoupon;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
    public class TradeCouponServiceImpl implements TradeCouponService {
    @Resource
    private TradeCouponMapper tradeCouponMapper;

    @Override
    public int insert(TradeCoupon tradeCoupon) {

        return tradeCouponMapper.insert(tradeCoupon);
    }
}
