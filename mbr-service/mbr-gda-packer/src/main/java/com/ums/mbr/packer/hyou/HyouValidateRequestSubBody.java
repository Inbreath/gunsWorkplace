package com.ums.mbr.packer.hyou;

/**
 * 上送慧优核销的优惠券信息体
 * Author: pwwu@chinaums.com
 * Date: 2018/3/24 15:36
 */

public class HyouValidateRequestSubBody {

    private String couponId; //优惠券主键ID
    private String couponNum; //使用数量
    private String state; //优惠券类别

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getCouponNum() {
        return couponNum;
    }

    public void setCouponNum(String couponNum) {
        this.couponNum = couponNum;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
