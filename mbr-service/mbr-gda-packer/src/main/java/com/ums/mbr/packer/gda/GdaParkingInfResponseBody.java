package com.ums.mbr.packer.gda;

/**
 * Title:GdaParkingInfResponseBody
 * Description: 接收国大停车券返回信息主体
 */
public class GdaParkingInfResponseBody extends GdaResponseBody{

    private String billNo;
    private String rqsj;
    private String storeName;
    private String amount;
    private String remark;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getRqsj() {
        return rqsj;
    }

    public void setRqsj(String rqsj) {
        this.rqsj = rqsj;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
