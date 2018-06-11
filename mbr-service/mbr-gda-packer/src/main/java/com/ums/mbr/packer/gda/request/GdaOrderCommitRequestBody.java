package com.ums.mbr.packer.gda.request;

/**
 * Author: jcouyang@chinaums.com
 * Date: 2018/4/13 16:10
 */
public class GdaOrderCommitRequestBody extends GdaBaseRequestBody {
    private String billType;
    private String billNo;
    private String amount;
    private String billDate;
    private String discountAmount;
    private String factAmount;
    private String payList;
    private String originalBillNo;
    private String cid;

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getFactAmount() {
        return factAmount;
    }

    public void setFactAmount(String factAmount) {
        this.factAmount = factAmount;
    }

    public String getPayList() {
        return payList;
    }

    public void setPayList(String payList) {
        this.payList = payList;
    }

    public String getOriginalBillNo() {
        return originalBillNo;
    }

    public void setOriginalBillNo(String originalBillNo) {
        this.originalBillNo = originalBillNo;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
}
