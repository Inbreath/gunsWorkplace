package com.ums.mbr.packer.gda;

public class GdaOrderSubmitResponseBody extends GdaResponseBody {

    private String result; //国大执行结果
    private String billNo;
    private String remark;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }
}
