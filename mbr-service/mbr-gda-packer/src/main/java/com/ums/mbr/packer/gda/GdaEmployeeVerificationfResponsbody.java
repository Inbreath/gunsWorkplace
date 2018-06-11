package com.ums.mbr.packer.gda;

public class GdaEmployeeVerificationfResponsbody extends  GdaResponseBody{

    private String billNo;
    private String remainCash;
    private String billDate;


    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getRemainCash() {
        return remainCash;
    }

    public void setRemainCash(String remainCash) {
        this.remainCash = remainCash;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

}
