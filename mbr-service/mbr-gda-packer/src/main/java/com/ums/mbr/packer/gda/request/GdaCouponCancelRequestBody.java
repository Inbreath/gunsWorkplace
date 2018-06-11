package com.ums.mbr.packer.gda.request;

/**
 * Author: jcouyang@chinaums.com
 * Date: 2018/4/13 16:19
 */
public class GdaCouponCancelRequestBody extends GdaBaseRequestBody {

    private String transNo;
    private String cancelDate;
    private String originalBillNo;
    private String originalTransNo;
    private String amount;

    public String getTransNo() {
        return transNo;
    }

    public void setTransNo(String transNo) {
        this.transNo = transNo;
    }

    public String getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(String cancelDate) {
        this.cancelDate = cancelDate;
    }

    public String getOriginalBillNo() {
        return originalBillNo;
    }

    public void setOriginalBillNo(String originalBillNo) {
        this.originalBillNo = originalBillNo;
    }

    public String getOriginalTransNo() {
        return originalTransNo;
    }

    public void setOriginalTransNo(String originalTransNo) {
        this.originalTransNo = originalTransNo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
