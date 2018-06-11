package com.ums.mbr.service.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Payinf implements Serializable {
    private String originalOrderNo;

    public String getOriginalOrderNo() {
        return originalOrderNo;
    }

    public void setOriginalOrderNo(String originalOrderNo) {
        this.originalOrderNo = originalOrderNo;
    }
    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 系统跟踪流水
     * This field corresponds to the database table umsmember..t_payinf
     *
     * @mbg.generated
     */
    private String retserial;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 订单号
     * This field corresponds to the database table umsmember..t_payinf
     *
     * @mbg.generated
     */
    private String orderNo;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 银商商户号
     * This field corresponds to the database table umsmember..t_payinf
     *
     * @mbg.generated
     */
    private String mchtno;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 银商终端号
     * This field corresponds to the database table umsmember..t_payinf
     *
     * @mbg.generated
     */
    private String termno;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 渠道商户代码
     * This field corresponds to the database table umsmember..t_payinf
     *
     * @mbg.generated
     */
    private String exmchtno;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 渠道终端号
     * This field corresponds to the database table umsmember..t_payinf
     *
     * @mbg.generated
     */
    private String extermno;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 支付渠道
     * This field corresponds to the database table umsmember..t_payinf
     *
     * @mbg.generated
     */
    private String paycode;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 交易的类型
     * This field corresponds to the database table umsmember..t_payinf
     *
     * @mbg.generated
     */
    private String transType;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 交易金额，单位为元
     * This field corresponds to the database table umsmember..t_payinf
     *
     * @mbg.generated
     */
    private BigDecimal totalAmount;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 实际支付金额，单位为元
     * This field corresponds to the database table umsmember..t_payinf
     *
     * @mbg.generated
     */
    private BigDecimal buyerPayAmount;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 实际支付的积分
     * This field corresponds to the database table umsmember..t_payinf
     *
     * @mbg.generated
     */
    private BigDecimal score;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 交易币种
     * This field corresponds to the database table umsmember..t_payinf
     *
     * @mbg.generated
     */
    private String currency;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 支付宝微信的授权码，或者银行卡交易的卡号
     * This field corresponds to the database table umsmember..t_payinf
     *
     * @mbg.generated
     */
    private String cardNo;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 渠道交易号
     * This field corresponds to the database table umsmember..t_payinf
     *
     * @mbg.generated
     */
    private String mailTradeNo;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 终端发起交易时的外部订单号
     * This field corresponds to the database table umsmember..t_payinf
     *
     * @mbg.generated
     */
    private String outTradeNo;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 撤销交易的原外部订单号
     * This field corresponds to the database table umsmember..t_payinf
     *
     * @mbg.generated
     */
    private String originalTradeNo;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 用户手机上显示的订单号
     * This field corresponds to the database table umsmember..t_payinf
     *
     * @mbg.generated
     */
    private String phoneCode;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 支付宝微信等中心的订单号
     * This field corresponds to the database table umsmember..t_payinf
     *
     * @mbg.generated
     */
    private String centerNo;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 创建时间
     * This field corresponds to the database table umsmember..t_payinf
     *
     * @mbg.generated
     */
    private String createTime;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 支付时间
     * This field corresponds to the database table umsmember..t_payinf
     *
     * @mbg.generated
     */
    private String payTime;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 银行卡交易的授权号
     * This field corresponds to the database table umsmember..t_payinf
     *
     * @mbg.generated
     */
    private String authCode;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 批次号
     * This field corresponds to the database table umsmember..t_payinf
     *
     * @mbg.generated
     */
    private String batchno;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 流水号
     * This field corresponds to the database table umsmember..t_payinf
     *
     * @mbg.generated
     */
    private String traceno;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 交易参考号
     * This field corresponds to the database table umsmember..t_payinf
     *
     * @mbg.generated
     */
    private String refernceNo;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 原交易信息
     * This field corresponds to the database table umsmember..t_payinf
     *
     * @mbg.generated
     */
    private String oldInfo;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 发卡行
     * This field corresponds to the database table umsmember..t_payinf
     *
     * @mbg.generated
     */
    private String bankName;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 收单行
     * This field corresponds to the database table umsmember..t_payinf
     *
     * @mbg.generated
     */
    private String acquierName;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 交易状态
     * This field corresponds to the database table umsmember..t_payinf
     *
     * @mbg.generated
     */
    private String state;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 交易状态
     * This field corresponds to the database table umsmember..t_payinf
     *
     * @mbg.generated
     */
    private String stateDesc;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 产生交易的机器IP
     * This field corresponds to the database table umsmember..t_payinf
     *
     * @mbg.generated
     */
    private String createIp;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 当前机器的名称
     * This field corresponds to the database table umsmember..t_payinf
     *
     * @mbg.generated
     */
    private String machine;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 交易备注
     * This field corresponds to the database table umsmember..t_payinf
     *
     * @mbg.generated
     */
    private String note;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 支付前置的版本
     * This field corresponds to the database table umsmember..t_payinf
     *
     * @mbg.generated
     */
    private String version;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_payinf.RETSERIAL
     *
     * @return the value of umsmember..t_payinf.RETSERIAL
     *
     * @mbg.generated
     */
    public String getRetserial() {
        return retserial;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_payinf.RETSERIAL
     *
     * @param retserial the value for umsmember..t_payinf.RETSERIAL
     *
     * @mbg.generated
     */
    public void setRetserial(String retserial) {
        this.retserial = retserial == null ? null : retserial.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_payinf.ORDER_NO
     *
     * @return the value of umsmember..t_payinf.ORDER_NO
     *
     * @mbg.generated
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_payinf.ORDER_NO
     *
     * @param orderNo the value for umsmember..t_payinf.ORDER_NO
     *
     * @mbg.generated
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_payinf.MCHTNO
     *
     * @return the value of umsmember..t_payinf.MCHTNO
     *
     * @mbg.generated
     */
    public String getMchtno() {
        return mchtno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_payinf.MCHTNO
     *
     * @param mchtno the value for umsmember..t_payinf.MCHTNO
     *
     * @mbg.generated
     */
    public void setMchtno(String mchtno) {
        this.mchtno = mchtno == null ? null : mchtno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_payinf.TERMNO
     *
     * @return the value of umsmember..t_payinf.TERMNO
     *
     * @mbg.generated
     */
    public String getTermno() {
        return termno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_payinf.TERMNO
     *
     * @param termno the value for umsmember..t_payinf.TERMNO
     *
     * @mbg.generated
     */
    public void setTermno(String termno) {
        this.termno = termno == null ? null : termno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_payinf.EXMCHTNO
     *
     * @return the value of umsmember..t_payinf.EXMCHTNO
     *
     * @mbg.generated
     */
    public String getExmchtno() {
        return exmchtno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_payinf.EXMCHTNO
     *
     * @param exmchtno the value for umsmember..t_payinf.EXMCHTNO
     *
     * @mbg.generated
     */
    public void setExmchtno(String exmchtno) {
        this.exmchtno = exmchtno == null ? null : exmchtno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_payinf.EXTERMNO
     *
     * @return the value of umsmember..t_payinf.EXTERMNO
     *
     * @mbg.generated
     */
    public String getExtermno() {
        return extermno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_payinf.EXTERMNO
     *
     * @param extermno the value for umsmember..t_payinf.EXTERMNO
     *
     * @mbg.generated
     */
    public void setExtermno(String extermno) {
        this.extermno = extermno == null ? null : extermno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_payinf.PAYCODE
     *
     * @return the value of umsmember..t_payinf.PAYCODE
     *
     * @mbg.generated
     */
    public String getPaycode() {
        return paycode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_payinf.PAYCODE
     *
     * @param paycode the value for umsmember..t_payinf.PAYCODE
     *
     * @mbg.generated
     */
    public void setPaycode(String paycode) {
        this.paycode = paycode == null ? null : paycode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_payinf.TRANS_TYPE
     *
     * @return the value of umsmember..t_payinf.TRANS_TYPE
     *
     * @mbg.generated
     */
    public String getTransType() {
        return transType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_payinf.TRANS_TYPE
     *
     * @param transType the value for umsmember..t_payinf.TRANS_TYPE
     *
     * @mbg.generated
     */
    public void setTransType(String transType) {
        this.transType = transType == null ? null : transType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_payinf.TOTAL_AMOUNT
     *
     * @return the value of umsmember..t_payinf.TOTAL_AMOUNT
     *
     * @mbg.generated
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_payinf.TOTAL_AMOUNT
     *
     * @param totalAmount the value for umsmember..t_payinf.TOTAL_AMOUNT
     *
     * @mbg.generated
     */
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_payinf.BUYER_PAY_AMOUNT
     *
     * @return the value of umsmember..t_payinf.BUYER_PAY_AMOUNT
     *
     * @mbg.generated
     */
    public BigDecimal getBuyerPayAmount() {
        return buyerPayAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_payinf.BUYER_PAY_AMOUNT
     *
     * @param buyerPayAmount the value for umsmember..t_payinf.BUYER_PAY_AMOUNT
     *
     * @mbg.generated
     */
    public void setBuyerPayAmount(BigDecimal buyerPayAmount) {
        this.buyerPayAmount = buyerPayAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_payinf.SCORE
     *
     * @return the value of umsmember..t_payinf.SCORE
     *
     * @mbg.generated
     */
    public BigDecimal getScore() {
        return score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_payinf.SCORE
     *
     * @param score the value for umsmember..t_payinf.SCORE
     *
     * @mbg.generated
     */
    public void setScore(BigDecimal score) {
        this.score = score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_payinf.CURRENCY
     *
     * @return the value of umsmember..t_payinf.CURRENCY
     *
     * @mbg.generated
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_payinf.CURRENCY
     *
     * @param currency the value for umsmember..t_payinf.CURRENCY
     *
     * @mbg.generated
     */
    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_payinf.CARD_NO
     *
     * @return the value of umsmember..t_payinf.CARD_NO
     *
     * @mbg.generated
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_payinf.CARD_NO
     *
     * @param cardNo the value for umsmember..t_payinf.CARD_NO
     *
     * @mbg.generated
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_payinf.MAIL_TRADE_NO
     *
     * @return the value of umsmember..t_payinf.MAIL_TRADE_NO
     *
     * @mbg.generated
     */
    public String getMailTradeNo() {
        return mailTradeNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_payinf.MAIL_TRADE_NO
     *
     * @param mailTradeNo the value for umsmember..t_payinf.MAIL_TRADE_NO
     *
     * @mbg.generated
     */
    public void setMailTradeNo(String mailTradeNo) {
        this.mailTradeNo = mailTradeNo == null ? null : mailTradeNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_payinf.OUT_TRADE_NO
     *
     * @return the value of umsmember..t_payinf.OUT_TRADE_NO
     *
     * @mbg.generated
     */
    public String getOutTradeNo() {
        return outTradeNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_payinf.OUT_TRADE_NO
     *
     * @param outTradeNo the value for umsmember..t_payinf.OUT_TRADE_NO
     *
     * @mbg.generated
     */
    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo == null ? null : outTradeNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_payinf.ORIGINAL_TRADE_NO
     *
     * @return the value of umsmember..t_payinf.ORIGINAL_TRADE_NO
     *
     * @mbg.generated
     */
    public String getOriginalTradeNo() {
        return originalTradeNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_payinf.ORIGINAL_TRADE_NO
     *
     * @param originalTradeNo the value for umsmember..t_payinf.ORIGINAL_TRADE_NO
     *
     * @mbg.generated
     */
    public void setOriginalTradeNo(String originalTradeNo) {
        this.originalTradeNo = originalTradeNo == null ? null : originalTradeNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_payinf.PHONE_CODE
     *
     * @return the value of umsmember..t_payinf.PHONE_CODE
     *
     * @mbg.generated
     */
    public String getPhoneCode() {
        return phoneCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_payinf.PHONE_CODE
     *
     * @param phoneCode the value for umsmember..t_payinf.PHONE_CODE
     *
     * @mbg.generated
     */
    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode == null ? null : phoneCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_payinf.CENTER_NO
     *
     * @return the value of umsmember..t_payinf.CENTER_NO
     *
     * @mbg.generated
     */
    public String getCenterNo() {
        return centerNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_payinf.CENTER_NO
     *
     * @param centerNo the value for umsmember..t_payinf.CENTER_NO
     *
     * @mbg.generated
     */
    public void setCenterNo(String centerNo) {
        this.centerNo = centerNo == null ? null : centerNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_payinf.CREATE_TIME
     *
     * @return the value of umsmember..t_payinf.CREATE_TIME
     *
     * @mbg.generated
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_payinf.CREATE_TIME
     *
     * @param createTime the value for umsmember..t_payinf.CREATE_TIME
     *
     * @mbg.generated
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_payinf.PAY_TIME
     *
     * @return the value of umsmember..t_payinf.PAY_TIME
     *
     * @mbg.generated
     */
    public String getPayTime() {
        return payTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_payinf.PAY_TIME
     *
     * @param payTime the value for umsmember..t_payinf.PAY_TIME
     *
     * @mbg.generated
     */
    public void setPayTime(String payTime) {
        this.payTime = payTime == null ? null : payTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_payinf.AUTH_CODE
     *
     * @return the value of umsmember..t_payinf.AUTH_CODE
     *
     * @mbg.generated
     */
    public String getAuthCode() {
        return authCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_payinf.AUTH_CODE
     *
     * @param authCode the value for umsmember..t_payinf.AUTH_CODE
     *
     * @mbg.generated
     */
    public void setAuthCode(String authCode) {
        this.authCode = authCode == null ? null : authCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_payinf.BATCHNO
     *
     * @return the value of umsmember..t_payinf.BATCHNO
     *
     * @mbg.generated
     */
    public String getBatchno() {
        return batchno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_payinf.BATCHNO
     *
     * @param batchno the value for umsmember..t_payinf.BATCHNO
     *
     * @mbg.generated
     */
    public void setBatchno(String batchno) {
        this.batchno = batchno == null ? null : batchno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_payinf.TRACENO
     *
     * @return the value of umsmember..t_payinf.TRACENO
     *
     * @mbg.generated
     */
    public String getTraceno() {
        return traceno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_payinf.TRACENO
     *
     * @param traceno the value for umsmember..t_payinf.TRACENO
     *
     * @mbg.generated
     */
    public void setTraceno(String traceno) {
        this.traceno = traceno == null ? null : traceno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_payinf.REFERNCE_NO
     *
     * @return the value of umsmember..t_payinf.REFERNCE_NO
     *
     * @mbg.generated
     */
    public String getRefernceNo() {
        return refernceNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_payinf.REFERNCE_NO
     *
     * @param refernceNo the value for umsmember..t_payinf.REFERNCE_NO
     *
     * @mbg.generated
     */
    public void setRefernceNo(String refernceNo) {
        this.refernceNo = refernceNo == null ? null : refernceNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_payinf.OLD_INFO
     *
     * @return the value of umsmember..t_payinf.OLD_INFO
     *
     * @mbg.generated
     */
    public String getOldInfo() {
        return oldInfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_payinf.OLD_INFO
     *
     * @param oldInfo the value for umsmember..t_payinf.OLD_INFO
     *
     * @mbg.generated
     */
    public void setOldInfo(String oldInfo) {
        this.oldInfo = oldInfo == null ? null : oldInfo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_payinf.BANK_NAME
     *
     * @return the value of umsmember..t_payinf.BANK_NAME
     *
     * @mbg.generated
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_payinf.BANK_NAME
     *
     * @param bankName the value for umsmember..t_payinf.BANK_NAME
     *
     * @mbg.generated
     */
    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_payinf.ACQUIER_NAME
     *
     * @return the value of umsmember..t_payinf.ACQUIER_NAME
     *
     * @mbg.generated
     */
    public String getAcquierName() {
        return acquierName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_payinf.ACQUIER_NAME
     *
     * @param acquierName the value for umsmember..t_payinf.ACQUIER_NAME
     *
     * @mbg.generated
     */
    public void setAcquierName(String acquierName) {
        this.acquierName = acquierName == null ? null : acquierName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_payinf.STATE
     *
     * @return the value of umsmember..t_payinf.STATE
     *
     * @mbg.generated
     */
    public String getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_payinf.STATE
     *
     * @param state the value for umsmember..t_payinf.STATE
     *
     * @mbg.generated
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_payinf.STATE_DESC
     *
     * @return the value of umsmember..t_payinf.STATE_DESC
     *
     * @mbg.generated
     */
    public String getStateDesc() {
        return stateDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_payinf.STATE_DESC
     *
     * @param stateDesc the value for umsmember..t_payinf.STATE_DESC
     *
     * @mbg.generated
     */
    public void setStateDesc(String stateDesc) {
        this.stateDesc = stateDesc == null ? null : stateDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_payinf.CREATE_IP
     *
     * @return the value of umsmember..t_payinf.CREATE_IP
     *
     * @mbg.generated
     */
    public String getCreateIp() {
        return createIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_payinf.CREATE_IP
     *
     * @param createIp the value for umsmember..t_payinf.CREATE_IP
     *
     * @mbg.generated
     */
    public void setCreateIp(String createIp) {
        this.createIp = createIp == null ? null : createIp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_payinf.MACHINE
     *
     * @return the value of umsmember..t_payinf.MACHINE
     *
     * @mbg.generated
     */
    public String getMachine() {
        return machine;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_payinf.MACHINE
     *
     * @param machine the value for umsmember..t_payinf.MACHINE
     *
     * @mbg.generated
     */
    public void setMachine(String machine) {
        this.machine = machine == null ? null : machine.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_payinf.NOTE
     *
     * @return the value of umsmember..t_payinf.NOTE
     *
     * @mbg.generated
     */
    public String getNote() {
        return note;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_payinf.NOTE
     *
     * @param note the value for umsmember..t_payinf.NOTE
     *
     * @mbg.generated
     */
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_payinf.VERSION
     *
     * @return the value of umsmember..t_payinf.VERSION
     *
     * @mbg.generated
     */
    public String getVersion() {
        return version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_payinf.VERSION
     *
     * @param version the value for umsmember..t_payinf.VERSION
     *
     * @mbg.generated
     */
    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    private String orderType;
    private String customerId;
    private String factAmount;
    private String discountAmount;

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFactAmount() {
        return factAmount;
    }

    public void setFactAmount(String factAmount) {
        this.factAmount = factAmount;
    }

    public String getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }
}