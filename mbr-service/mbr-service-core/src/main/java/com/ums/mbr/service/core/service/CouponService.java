package com.ums.mbr.service.core.service;

import com.ums.mbr.service.domain.Coupon;

public interface CouponService {

    /**
     * 根据客户类型支付代码和券码号进行会员的券查询。M:member; V:verifyNo；P:payCode; D：customerId
     * @param payCode 支付代码
     * @param verifyNo  券码号
     * @return
     */
    Coupon findByMVPD(String customerType, String verifyNo, String payCode, String customerId);

    /**
     * 插入券码信息
     * @param coupon 券码信息
     * @return
     */
    int insertSelective(Coupon coupon);

    /**更新
     * @param coupon
     * @return
     */
    public int updateByPrimaryKeySelective(Coupon coupon);

//    /**
//     * 更新客户信息
//     * @param customer 客户信息
//     * @return
//     */
//    int updateByPrimaryKey(Customer customer);
}
