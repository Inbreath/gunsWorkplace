package com.ums.mbr.beans.response;

/**
 * Title: HyouMemberQueryResponseSubBody
 * Description: 用于接收查询得到的慧优优惠券，返回终端
 * @author pwwu@chinaums.com
 * Date: 2018/3/29
 */


public class HyouMemberQueryResponseSubBody {

    private String couponId;
    private String couponName;
    private String couponTypeKind;
    private String serviceAmount;
    private String couponValue;
    private String couponImage;
    private String startTime;
    private String endTime;
    private String couponDesc;
    private String isLimitedShop;
    private String limitedShop;
    private String couponNum;
    private String state;

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public String getCouponTypeKind() {
        return couponTypeKind;
    }

    public void setCouponTypeKind(String couponTypeKind) {
        this.couponTypeKind = couponTypeKind;
    }

    public String getServiceAmount() {
        return serviceAmount;
    }

    public void setServiceAmount(String serviceAmount) {
        this.serviceAmount = serviceAmount;
    }

    public String getCouponValue() {
        return couponValue;
    }

    public void setCouponValue(String couponValue) {
        this.couponValue = couponValue;
    }

    public String getCouponImage() {
        return couponImage;
    }

    public void setCouponImage(String couponImage) {
        this.couponImage = couponImage;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCouponDesc() {
        return couponDesc;
    }

    public void setCouponDesc(String couponDesc) {
        this.couponDesc = couponDesc;
    }

    public String getIsLimitedShop() {
        return isLimitedShop;
    }

    public void setIsLimitedShop(String isLimitedShop) {
        this.isLimitedShop = isLimitedShop;
    }

    public String getLimitedShop() {
        return limitedShop;
    }

    public void setLimitedShop(String limitedShop) {
        this.limitedShop = limitedShop;
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
