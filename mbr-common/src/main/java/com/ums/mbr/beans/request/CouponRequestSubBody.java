package com.ums.mbr.beans.request;

/**
 * Title: VerifyCoupon
 * Description: 终端上送的优惠券信息体
 */
public class CouponRequestSubBody {

    //接受终端参数
    private String verify_no;
    private String verify_state;
    private String verify_type;
    private String verify_num;
    private String input_type;

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

    public String getVerify_type() {
        return verify_type;
    }

    public void setVerify_type(String verify_type) {
        this.verify_type = verify_type;
    }

    public String getVerify_num() {
        return verify_num;
    }

    public void setVerify_num(String verify_num) {
        this.verify_num = verify_num;
    }

    public String getInput_type() {
        return input_type;
    }

    public void setInput_type(String input_type) {
        this.input_type = input_type;
    }

}
