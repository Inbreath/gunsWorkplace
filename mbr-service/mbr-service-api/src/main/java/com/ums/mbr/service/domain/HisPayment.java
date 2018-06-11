package com.ums.mbr.service.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class HisPayment implements Serializable {
    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 系统跟踪流水
     * This field corresponds to the database table t_hispayment
     *
     * @mbg.generated
     */
    private String retserial;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 银商商户号
     * This field corresponds to the database table t_hispayment
     *
     * @mbg.generated
     */
    private String mchtno;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 银商终端号
     * This field corresponds to the database table t_hispayment
     *
     * @mbg.generated
     */
    private String termno;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 渠道商户代码
     * This field corresponds to the database table t_hispayment
     *
     * @mbg.generated
     */
    private String exmchtno;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 渠道终端号
     * This field corresponds to the database table t_hispayment
     *
     * @mbg.generated
     */
    private String extermno;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 会员系统定义的交易号
     * This field corresponds to the database table t_hispayment
     *
     * @mbg.generated
     */
    private String tradeNo;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 商户系统定义的交易号
     * This field corresponds to the database table t_hispayment
     *
     * @mbg.generated
     */
    private String outTradeNo;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 订单号，由会员系统生成
     * This field corresponds to the database table t_hispayment
     *
     * @mbg.generated
     */
    private String orderNo;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 支付交易对应的业务订单号
     * This field corresponds to the database table t_hispayment
     *
     * @mbg.generated
     */
    private String paymentOrderNo;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 支付宝微信等中心的订单号
     * This field corresponds to the database table t_hispayment
     *
     * @mbg.generated
     */
    private String centerNo;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 交易状态
     * This field corresponds to the database table t_hispayment
     *
     * @mbg.generated
     */
    private String state;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 客户类型
     * This field corresponds to the database table t_hispayment
     *
     * @mbg.generated
     */
    private String customerType;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 交易币种
     * This field corresponds to the database table t_hispayment
     *
     * @mbg.generated
     */
    private String currency;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 支付金额
     * This field corresponds to the database table t_hispayment
     *
     * @mbg.generated
     */
    private BigDecimal realAmount;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 创建时间
     * This field corresponds to the database table t_hispayment
     *
     * @mbg.generated
     */
    private String createTime;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 支付时间
     * This field corresponds to the database table t_hispayment
     *
     * @mbg.generated
     */
    private String payTime;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 支付方式
     * This field corresponds to the database table t_hispayment
     *
     * @mbg.generated
     */
    private String payCode;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 批次号
     * This field corresponds to the database table t_hispayment
     *
     * @mbg.generated
     */
    private String batchno;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 流水号
     * This field corresponds to the database table t_hispayment
     *
     * @mbg.generated
     */
    private String traceno;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 交易参考号
     * This field corresponds to the database table t_hispayment
     *
     * @mbg.generated
     */
    private String refernceNo;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 返回码
     * This field corresponds to the database table t_hispayment
     *
     * @mbg.generated
     */
    private String retcode;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 返回信息
     * This field corresponds to the database table t_hispayment
     *
     * @mbg.generated
     */
    private String retmsg;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 产生交易的机器IP
     * This field corresponds to the database table t_hispayment
     *
     * @mbg.generated
     */
    private String createIp;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 异步通知地址
     * This field corresponds to the database table t_hispayment
     *
     * @mbg.generated
     */
    private String notifyUrl;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 交易来源：
     * This field corresponds to the database table t_hispayment
     *
     * @mbg.generated
     */
    private String source;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 交易主题
     * This field corresponds to the database table t_hispayment
     *
     * @mbg.generated
     */
    private String subject;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 商品详情，预留
     * This field corresponds to the database table t_hispayment
     *
     * @mbg.generated
     */
    private String goodsDetail;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 备注
     * This field corresponds to the database table t_hispayment
     *
     * @mbg.generated
     */
    private String note;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_hispayment.RETSERIAL
     *
     * @return the value of t_hispayment.RETSERIAL
     *
     * @mbg.generated
     */
    public String getRetserial() {
        return retserial;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_hispayment.RETSERIAL
     *
     * @param retserial the value for t_hispayment.RETSERIAL
     *
     * @mbg.generated
     */
    public void setRetserial(String retserial) {
        this.retserial = retserial == null ? null : retserial.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_hispayment.MCHTNO
     *
     * @return the value of t_hispayment.MCHTNO
     *
     * @mbg.generated
     */
    public String getMchtno() {
        return mchtno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_hispayment.MCHTNO
     *
     * @param mchtno the value for t_hispayment.MCHTNO
     *
     * @mbg.generated
     */
    public void setMchtno(String mchtno) {
        this.mchtno = mchtno == null ? null : mchtno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_hispayment.TERMNO
     *
     * @return the value of t_hispayment.TERMNO
     *
     * @mbg.generated
     */
    public String getTermno() {
        return termno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_hispayment.TERMNO
     *
     * @param termno the value for t_hispayment.TERMNO
     *
     * @mbg.generated
     */
    public void setTermno(String termno) {
        this.termno = termno == null ? null : termno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_hispayment.EXMCHTNO
     *
     * @return the value of t_hispayment.EXMCHTNO
     *
     * @mbg.generated
     */
    public String getExmchtno() {
        return exmchtno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_hispayment.EXMCHTNO
     *
     * @param exmchtno the value for t_hispayment.EXMCHTNO
     *
     * @mbg.generated
     */
    public void setExmchtno(String exmchtno) {
        this.exmchtno = exmchtno == null ? null : exmchtno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_hispayment.EXTERMNO
     *
     * @return the value of t_hispayment.EXTERMNO
     *
     * @mbg.generated
     */
    public String getExtermno() {
        return extermno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_hispayment.EXTERMNO
     *
     * @param extermno the value for t_hispayment.EXTERMNO
     *
     * @mbg.generated
     */
    public void setExtermno(String extermno) {
        this.extermno = extermno == null ? null : extermno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_hispayment.TRADE_NO
     *
     * @return the value of t_hispayment.TRADE_NO
     *
     * @mbg.generated
     */
    public String getTradeNo() {
        return tradeNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_hispayment.TRADE_NO
     *
     * @param tradeNo the value for t_hispayment.TRADE_NO
     *
     * @mbg.generated
     */
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_hispayment.OUT_TRADE_NO
     *
     * @return the value of t_hispayment.OUT_TRADE_NO
     *
     * @mbg.generated
     */
    public String getOutTradeNo() {
        return outTradeNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_hispayment.OUT_TRADE_NO
     *
     * @param outTradeNo the value for t_hispayment.OUT_TRADE_NO
     *
     * @mbg.generated
     */
    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo == null ? null : outTradeNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_hispayment.ORDER_NO
     *
     * @return the value of t_hispayment.ORDER_NO
     *
     * @mbg.generated
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_hispayment.ORDER_NO
     *
     * @param orderNo the value for t_hispayment.ORDER_NO
     *
     * @mbg.generated
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_hispayment.PAYMENT_ORDER_NO
     *
     * @return the value of t_hispayment.PAYMENT_ORDER_NO
     *
     * @mbg.generated
     */
    public String getPaymentOrderNo() {
        return paymentOrderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_hispayment.PAYMENT_ORDER_NO
     *
     * @param paymentOrderNo the value for t_hispayment.PAYMENT_ORDER_NO
     *
     * @mbg.generated
     */
    public void setPaymentOrderNo(String paymentOrderNo) {
        this.paymentOrderNo = paymentOrderNo == null ? null : paymentOrderNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_hispayment.CENTER_NO
     *
     * @return the value of t_hispayment.CENTER_NO
     *
     * @mbg.generated
     */
    public String getCenterNo() {
        return centerNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_hispayment.CENTER_NO
     *
     * @param centerNo the value for t_hispayment.CENTER_NO
     *
     * @mbg.generated
     */
    public void setCenterNo(String centerNo) {
        this.centerNo = centerNo == null ? null : centerNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_hispayment.STATE
     *
     * @return the value of t_hispayment.STATE
     *
     * @mbg.generated
     */
    public String getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_hispayment.STATE
     *
     * @param state the value for t_hispayment.STATE
     *
     * @mbg.generated
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_hispayment.CUSTOMER_TYPE
     *
     * @return the value of t_hispayment.CUSTOMER_TYPE
     *
     * @mbg.generated
     */
    public String getCustomerType() {
        return customerType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_hispayment.CUSTOMER_TYPE
     *
     * @param customerType the value for t_hispayment.CUSTOMER_TYPE
     *
     * @mbg.generated
     */
    public void setCustomerType(String customerType) {
        this.customerType = customerType == null ? null : customerType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_hispayment.CURRENCY
     *
     * @return the value of t_hispayment.CURRENCY
     *
     * @mbg.generated
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_hispayment.CURRENCY
     *
     * @param currency the value for t_hispayment.CURRENCY
     *
     * @mbg.generated
     */
    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_hispayment.REAL_AMOUNT
     *
     * @return the value of t_hispayment.REAL_AMOUNT
     *
     * @mbg.generated
     */
    public BigDecimal getRealAmount() {
        return realAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_hispayment.REAL_AMOUNT
     *
     * @param realAmount the value for t_hispayment.REAL_AMOUNT
     *
     * @mbg.generated
     */
    public void setRealAmount(BigDecimal realAmount) {
        this.realAmount = realAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_hispayment.CREATE_TIME
     *
     * @return the value of t_hispayment.CREATE_TIME
     *
     * @mbg.generated
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_hispayment.CREATE_TIME
     *
     * @param createTime the value for t_hispayment.CREATE_TIME
     *
     * @mbg.generated
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_hispayment.PAY_TIME
     *
     * @return the value of t_hispayment.PAY_TIME
     *
     * @mbg.generated
     */
    public String getPayTime() {
        return payTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_hispayment.PAY_TIME
     *
     * @param payTime the value for t_hispayment.PAY_TIME
     *
     * @mbg.generated
     */
    public void setPayTime(String payTime) {
        this.payTime = payTime == null ? null : payTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_hispayment.PAY_CODE
     *
     * @return the value of t_hispayment.PAY_CODE
     *
     * @mbg.generated
     */
    public String getPayCode() {
        return payCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_hispayment.PAY_CODE
     *
     * @param payCode the value for t_hispayment.PAY_CODE
     *
     * @mbg.generated
     */
    public void setPayCode(String payCode) {
        this.payCode = payCode == null ? null : payCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_hispayment.BATCHNO
     *
     * @return the value of t_hispayment.BATCHNO
     *
     * @mbg.generated
     */
    public String getBatchno() {
        return batchno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_hispayment.BATCHNO
     *
     * @param batchno the value for t_hispayment.BATCHNO
     *
     * @mbg.generated
     */
    public void setBatchno(String batchno) {
        this.batchno = batchno == null ? null : batchno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_hispayment.TRACENO
     *
     * @return the value of t_hispayment.TRACENO
     *
     * @mbg.generated
     */
    public String getTraceno() {
        return traceno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_hispayment.TRACENO
     *
     * @param traceno the value for t_hispayment.TRACENO
     *
     * @mbg.generated
     */
    public void setTraceno(String traceno) {
        this.traceno = traceno == null ? null : traceno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_hispayment.REFERNCE_NO
     *
     * @return the value of t_hispayment.REFERNCE_NO
     *
     * @mbg.generated
     */
    public String getRefernceNo() {
        return refernceNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_hispayment.REFERNCE_NO
     *
     * @param refernceNo the value for t_hispayment.REFERNCE_NO
     *
     * @mbg.generated
     */
    public void setRefernceNo(String refernceNo) {
        this.refernceNo = refernceNo == null ? null : refernceNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_hispayment.RETCODE
     *
     * @return the value of t_hispayment.RETCODE
     *
     * @mbg.generated
     */
    public String getRetcode() {
        return retcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_hispayment.RETCODE
     *
     * @param retcode the value for t_hispayment.RETCODE
     *
     * @mbg.generated
     */
    public void setRetcode(String retcode) {
        this.retcode = retcode == null ? null : retcode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_hispayment.RETMSG
     *
     * @return the value of t_hispayment.RETMSG
     *
     * @mbg.generated
     */
    public String getRetmsg() {
        return retmsg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_hispayment.RETMSG
     *
     * @param retmsg the value for t_hispayment.RETMSG
     *
     * @mbg.generated
     */
    public void setRetmsg(String retmsg) {
        this.retmsg = retmsg == null ? null : retmsg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_hispayment.CREATE_IP
     *
     * @return the value of t_hispayment.CREATE_IP
     *
     * @mbg.generated
     */
    public String getCreateIp() {
        return createIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_hispayment.CREATE_IP
     *
     * @param createIp the value for t_hispayment.CREATE_IP
     *
     * @mbg.generated
     */
    public void setCreateIp(String createIp) {
        this.createIp = createIp == null ? null : createIp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_hispayment.NOTIFY_URL
     *
     * @return the value of t_hispayment.NOTIFY_URL
     *
     * @mbg.generated
     */
    public String getNotifyUrl() {
        return notifyUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_hispayment.NOTIFY_URL
     *
     * @param notifyUrl the value for t_hispayment.NOTIFY_URL
     *
     * @mbg.generated
     */
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl == null ? null : notifyUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_hispayment.SOURCE
     *
     * @return the value of t_hispayment.SOURCE
     *
     * @mbg.generated
     */
    public String getSource() {
        return source;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_hispayment.SOURCE
     *
     * @param source the value for t_hispayment.SOURCE
     *
     * @mbg.generated
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_hispayment.SUBJECT
     *
     * @return the value of t_hispayment.SUBJECT
     *
     * @mbg.generated
     */
    public String getSubject() {
        return subject;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_hispayment.SUBJECT
     *
     * @param subject the value for t_hispayment.SUBJECT
     *
     * @mbg.generated
     */
    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_hispayment.GOODS_DETAIL
     *
     * @return the value of t_hispayment.GOODS_DETAIL
     *
     * @mbg.generated
     */
    public String getGoodsDetail() {
        return goodsDetail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_hispayment.GOODS_DETAIL
     *
     * @param goodsDetail the value for t_hispayment.GOODS_DETAIL
     *
     * @mbg.generated
     */
    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail == null ? null : goodsDetail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_hispayment.NOTE
     *
     * @return the value of t_hispayment.NOTE
     *
     * @mbg.generated
     */
    public String getNote() {
        return note;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_hispayment.NOTE
     *
     * @param note the value for t_hispayment.NOTE
     *
     * @mbg.generated
     */
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}