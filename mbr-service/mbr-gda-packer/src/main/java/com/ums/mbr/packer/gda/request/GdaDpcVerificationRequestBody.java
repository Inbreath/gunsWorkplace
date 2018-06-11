package com.ums.mbr.packer.gda.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Author: jcouyang@chinaums.com
 * Date: 2018/4/13 15:41
 */
public class GdaDpcVerificationRequestBody extends GdaBaseRequestBody {

    private String billNo;
    private String cid;
    private String payDate;
    private String transNo;
    private String payCode;
    private String inputType;
    private String cardNo;
    @JsonProperty("Amount")
    private String amount;

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public String getTransNo() {
        return transNo;
    }

    public void setTransNo(String transNo) {
        this.transNo = transNo;
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
