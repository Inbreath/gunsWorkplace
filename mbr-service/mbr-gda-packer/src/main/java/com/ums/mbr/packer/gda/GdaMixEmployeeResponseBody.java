package com.ums.mbr.packer.gda;

public class GdaMixEmployeeResponseBody extends GdaResponseBody{

    private String billNo;
    private String memberId;
    private String telephone;
    private String storeId;
    private String terminaNo;
    private String orderType;
    private String totalAmount;
    private String reciptAmount;
    private String discountAmount;
    private String createTime;

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getTerminaNo() {
        return terminaNo;
    }

    public void setTerminaNo(String terminaNo) {
        this.terminaNo = terminaNo;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getReciptAmount() {
        return reciptAmount;
    }

    public void setReciptAmount(String reciptAmount) {
        this.reciptAmount = reciptAmount;
    }

    public String getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

}
