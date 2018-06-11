package com.ums.mbr.service.core.service;

import com.ums.mbr.service.domain.TradeCoupon;


public interface TradeCouponService {

    /**
     * 在t_tradeCoupon表中插入核销券码
     * @param tradeCoupon 需要插入的券码对象
     * @return
     */
    int insert(TradeCoupon tradeCoupon);

}
