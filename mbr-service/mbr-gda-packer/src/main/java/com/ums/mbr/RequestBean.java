package com.ums.mbr;

import com.ums.mbr.packer.gda.request.GdaOrderSubmitSubRequestBody;
import com.ums.mbr.packer.hyou.HyouValidateRequestSubBody;

import java.util.List;

/**
 * 外部参数传入全部放在这里，以便
 * Author: jcouyang@chinaums.com
 * Date: 2018/3/7 11:33
 */
public class RequestBean {

    private String baseUrl;
    private String appId;
    private String secureKey;
    private String mchtId;
    private String termId;
    private String managerId; // 营管员授权
    private String customerId; // 客户号
    private String inputType; //输入方式
    private String idkeyword; //认证关键字
    private String startDate; //开始时间
    private String endDate; //结束时间
    private String pageSize; //查询条数
    private String pageNo; //起始页码

    private String billNo; //单据号
    private String transNo; //交易号
    private String cardNo; //卡号
    private String Amount; //消费金额
    private String payCode; //消费金额
    private String receiptAmount; //实付金额
    private String discountAmount; //折扣金额
    private String orderNo; //订单类型
    private String orderType; //订单类型
    private String orderAmount; // 订单总金额
    private String originalOrderNo; // 原订单号
    private String oldTradeNo; //需撤销的交易号
    private String oldOrderNo; //需撤销的订单号
    private List<GdaOrderSubmitSubRequestBody> payInfo; // 交易信息


    //以下字段供慧优使用
    private String appSecret;
    private String timestamp;
    private String memberPhone;
    private String entityCardId; //关联实体卡ID
    private String score;
    private String totalFee;
    private String payFee;
    private String groupFee;
    private List<HyouValidateRequestSubBody> couponGDDTOInf; //使用优惠券列表

    public RequestBean() {}

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }

    public String getPayFee() {
        return payFee;
    }

    public void setPayFee(String payFee) {
        this.payFee = payFee;
    }

    public String getGroupFee() {
        return groupFee;
    }

    public void setGroupFee(String groupFee) {
        this.groupFee = groupFee;
    }

    public String getOldTradeNo() {
        return oldTradeNo;
    }

    public void setOldTradeNo(String oldTradeNo) {
        this.oldTradeNo = oldTradeNo;
    }

    public String getOldOrderNo() {
        return oldOrderNo;
    }

    public void setOldOrderNo(String oldOrderNo) {
        this.oldOrderNo = oldOrderNo;
    }

    public String getOriginalOrderNo() {
        return originalOrderNo;
    }

    public void setOriginalOrderNo(String originalOrderNo) {
        this.originalOrderNo = originalOrderNo;
    }

    public List<GdaOrderSubmitSubRequestBody> getPayInfo() {
        return payInfo;
    }

    public void setPayInfo(List<GdaOrderSubmitSubRequestBody> payInfo) {
        this.payInfo = payInfo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getReceiptAmount() {
        return receiptAmount;
    }

    public void setReceiptAmount(String receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    public String getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getTransNo() {
        return transNo;
    }

    public void setTransNo(String transNo) {
        this.transNo = transNo;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public String getEntityCardId() {
        return entityCardId;
    }

    public void setEntityCardId(String entityCardId) {
        this.entityCardId = entityCardId;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<HyouValidateRequestSubBody> getCouponGDDTOInf() {
        return couponGDDTOInf;
    }

    public void setCouponGDDTOInf(List<HyouValidateRequestSubBody> couponGDDTOInf) {
        this.couponGDDTOInf = couponGDDTOInf;
    }

    public String getInputType() {
        switch (inputType) {
            case "hand":
                inputType = "0";
                break;
            case "scan":
                inputType = "1";
                break;
            case "card":
                inputType = "A";
                break;
            case "coupon":
                inputType = "C";
                break;
            default:
                break;
        }
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public String getIdkeyword() {
        return idkeyword;
    }

    public void setIdkeyword(String idkeyword) {
        this.idkeyword = idkeyword;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecureKey() {
        return secureKey;
    }

    public void setSecureKey(String secureKey) {
        this.secureKey = secureKey;
    }

    public String getMchtId() {
        return mchtId;
    }

    public void setMchtId(String mchtId) {
        this.mchtId = mchtId;
    }

    public String getTermId() {
        return termId;
    }

    public void setTermId(String termId) {
        this.termId = termId;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
