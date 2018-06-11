package com.ums.mbr.beans.response;

public class ParkingResponseSubBody {

    private String stroe_name;
    private String verify_no ;
    private String start_time;
    private String coupon_value;
    private String pay_code;

    public String getStroe_name() {
        return stroe_name;
    }

    public void setStroe_name(String stroe_name) {
        this.stroe_name = stroe_name;
    }

    public String getVerify_no() {
        return verify_no;
    }

    public void setVerify_no(String verify_no) {
        this.verify_no = verify_no;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getCoupon_value() {
        return coupon_value;
    }

    public void setCoupon_value(String coupon_value) {
        this.coupon_value = coupon_value;
    }

    public String getPay_code() {
        return pay_code;
    }

    public void setPay_code(String pay_code) {
        this.pay_code = pay_code;
    }
}
