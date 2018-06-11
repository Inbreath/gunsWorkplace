package com.ums.mbr.packer.gda.request;

import java.io.Serializable;

/**
 * 用于封装国大交易提交时，需要的交易信息
 * Author: pwwu@chinaums.com
 * Date: 2018/3/27 14:03
 */

public class GdaOrderSubmitSubRequestBody implements Serializable {

    private String transNo;
    private String payResult;
    private String payDate;
    private String payCode;
//    private String payName;
    private String payCardNo;
    private String payAmount;

    public String getTransNo() {
        return transNo;
    }

    public void setTransNo(String transNo) {
        this.transNo = transNo;
    }

    public String getPayResult() {
        return payResult;
    }

    public void setPayResult(String payResult) {
        this.payResult = payResult;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }

//    public String getPayName() {
//        return payName;
//    }
//
//    public void setPayName(String payName) {
//        this.payName = payName;
//    }

    public String getPayCardNo() {
        return payCardNo;
    }

    public void setPayCardNo(String payCardNo) {
        this.payCardNo = payCardNo;
    }

    public String getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount;
    }
}
