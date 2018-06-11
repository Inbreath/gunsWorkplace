package com.ums.mbr.beans.response;

/**
 * Title: CouponResponseSubBody
 * Description: 会员系统返回终端的优惠券格式
 * @author pwwu@chinaums.com
 * Date: 2018/3/29 20:24
 */
public class  CouponResponseSubBody {

    private String verify_no ;
    private String verify_state;
    private String coupon_name;
    private String pay_code;
    private String service_amount;
    private String coupon_value;
    private String coupon_image;
    private String start_time;
    private String end_time;
    private String coupon_desc;
    private String is_limited_shop;
    private String limited_shop;
    private String coupon_num;
    private String stroe_name;

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

    public String getVerify_state() {
        return verify_state;
    }

    public void setVerify_state(String verify_state) {
        this.verify_state = verify_state;
    }

    public String getCoupon_name() {
        return coupon_name;
    }

    public void setCoupon_name(String coupon_name) {
        this.coupon_name = coupon_name;
    }

    public String getPay_code() {
        return pay_code;
    }

    public void setPay_code(String pay_code) {
        this.pay_code = pay_code;
    }

    public String getService_amount() {
        return service_amount;
    }

    public void setService_amount(String service_amount) {
        this.service_amount = service_amount;
    }

    public String getCoupon_value() {
        return coupon_value;
    }

    public void setCoupon_value(String coupon_value) {
        this.coupon_value = coupon_value;
    }

    public String getCoupon_image() {
        return coupon_image;
    }

    public void setCoupon_image(String coupon_image) {
        this.coupon_image = coupon_image;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getCoupon_desc() {
        return coupon_desc;
    }

    public void setCoupon_desc(String coupon_desc) {
        this.coupon_desc = coupon_desc;
    }

    public String getIs_limited_shop() {
        return is_limited_shop;
    }

    public void setIs_limited_shop(String is_limited_shop) {
        this.is_limited_shop = is_limited_shop;
    }

    public String getLimited_shop() {
        return limited_shop;
    }

    public void setLimited_shop(String limited_shop) {
        this.limited_shop = limited_shop;
    }

    public String getCoupon_num() {
        return coupon_num;
    }

    public void setCoupon_num(String coupon_num) {
        this.coupon_num = coupon_num;
    }

}
