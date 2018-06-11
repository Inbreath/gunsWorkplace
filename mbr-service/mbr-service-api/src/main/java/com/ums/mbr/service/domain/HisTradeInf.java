package com.ums.mbr.service.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class HisTradeInf implements Serializable {
    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 系统跟踪流水
     * This field corresponds to the database table umsmember..t_histradeinf
     *
     * @mbg.generated
     */
    private String retserial;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 会员系统定义的交易号
     * This field corresponds to the database table umsmember..t_histradeinf
     *
     * @mbg.generated
     */
    private String tradeNo;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 商户系统定义的交易号
     * This field corresponds to the database table umsmember..t_histradeinf
     *
     * @mbg.generated
     */
    private String outTradeNo;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 订单号
     * This field corresponds to the database table umsmember..t_histradeinf
     *
     * @mbg.generated
     */
    private String orderNo;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 银商商户号
     * This field corresponds to the database table umsmember..t_histradeinf
     *
     * @mbg.generated
     */
    private String mchtno;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 银商终端号
     * This field corresponds to the database table umsmember..t_histradeinf
     *
     * @mbg.generated
     */
    private String termno;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 渠道商户代码
     * This field corresponds to the database table umsmember..t_histradeinf
     *
     * @mbg.generated
     */
    private String exmchtno;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 渠道终端号
     * This field corresponds to the database table umsmember..t_histradeinf
     *
     * @mbg.generated
     */
    private String extermno;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 交易类型
     * This field corresponds to the database table umsmember..t_histradeinf
     *
     * @mbg.generated
     */
    private String bizType;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 交易代码
     * This field corresponds to the database table umsmember..t_histradeinf
     *
     * @mbg.generated
     */
    private String payCode;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 提交交易的类型
     * This field corresponds to the database table umsmember..t_histradeinf
     *
     * @mbg.generated
     */
    private String transType;

    private String status;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 客户类型
     * This field corresponds to the database table umsmember..t_histradeinf
     *
     * @mbg.generated
     */
    private String customerType;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 输入方式
     * This field corresponds to the database table umsmember..t_histradeinf
     *
     * @mbg.generated
     */
    private String inputType;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 消费金额
     * This field corresponds to the database table umsmember..t_histradeinf
     *
     * @mbg.generated
     */
    private BigDecimal tradeAmount;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 抵扣金额
     * This field corresponds to the database table umsmember..t_histradeinf
     *
     * @mbg.generated
     */
    private BigDecimal disAmount;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 消费积分
     * This field corresponds to the database table umsmember..t_histradeinf
     *
     * @mbg.generated
     */
    private BigDecimal score;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 会员系统交易返回码
     * This field corresponds to the database table umsmember..t_histradeinf
     *
     * @mbg.generated
     */
    private String retCode;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 返回码中文说明
     * This field corresponds to the database table umsmember..t_histradeinf
     *
     * @mbg.generated
     */
    private String retMsg;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 返回时间
     * This field corresponds to the database table umsmember..t_histradeinf
     *
     * @mbg.generated
     */
    private String retTime;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 用户ID
     * This field corresponds to the database table umsmember..t_histradeinf
     *
     * @mbg.generated
     */
    private String memberId;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 用户卡号
     * This field corresponds to the database table umsmember..t_histradeinf
     *
     * @mbg.generated
     */
    private String cardNo;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 手机号
     * This field corresponds to the database table umsmember..t_histradeinf
     *
     * @mbg.generated
     */
    private String telephone;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 交易币种
     * This field corresponds to the database table umsmember..t_histradeinf
     *
     * @mbg.generated
     */
    private String currency;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 剩余金额
     * This field corresponds to the database table umsmember..t_histradeinf
     *
     * @mbg.generated
     */
    private BigDecimal remainAmount;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 剩余积分
     * This field corresponds to the database table umsmember..t_histradeinf
     *
     * @mbg.generated
     */
    private BigDecimal remainScore;

    private String traceno;

    private String batchno;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 创建时间
     * This field corresponds to the database table umsmember..t_histradeinf
     *
     * @mbg.generated
     */
    private String createTime;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 更新时间
     * This field corresponds to the database table umsmember..t_histradeinf
     *
     * @mbg.generated
     */
    private String refreshTime;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 撤单交易跟踪号
     * This field corresponds to the database table umsmember..t_histradeinf
     *
     * @mbg.generated
     */
    private String outRefundNo;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 需撤销的交易号
     * This field corresponds to the database table umsmember..t_histradeinf
     *
     * @mbg.generated
     */
    private String oldTradeNo;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 需撤销的订单号
     * This field corresponds to the database table umsmember..t_histradeinf
     *
     * @mbg.generated
     */
    private String oldOrderNo;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 撤销交易返回码
     * This field corresponds to the database table umsmember..t_histradeinf
     *
     * @mbg.generated
     */
    private String correctCode;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 撤销返回码解释
     * This field corresponds to the database table umsmember..t_histradeinf
     *
     * @mbg.generated
     */
    private String correctMsg;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 撤销交易返回时间
     * This field corresponds to the database table umsmember..t_histradeinf
     *
     * @mbg.generated
     */
    private String correctTime;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 券码类型：member或free
     * This field corresponds to the database table umsmember..t_histradeinf
     *
     * @mbg.generated
     */
    private String verifyState;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 交易主题
     * This field corresponds to the database table umsmember..t_histradeinf
     *
     * @mbg.generated
     */
    private String subject;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 商品详情，预留
     * This field corresponds to the database table umsmember..t_histradeinf
     *
     * @mbg.generated
     */
    private String goodsDetail;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 备注
     * This field corresponds to the database table umsmember..t_histradeinf
     *
     * @mbg.generated
     */
    private String note;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 产生交易的机器IP
     * This field corresponds to the database table umsmember..t_histradeinf
     *
     * @mbg.generated
     */
    private String createIp;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 后端交易查询标志
     * This field corresponds to the database table umsmember..t_histradeinf
     *
     * @mbg.generated
     */
    private String querySign;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.RETSERIAL
     *
     * @return the value of umsmember..t_histradeinf.RETSERIAL
     *
     * @mbg.generated
     */
    public String getRetserial() {
        return retserial;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.RETSERIAL
     *
     * @param retserial the value for umsmember..t_histradeinf.RETSERIAL
     *
     * @mbg.generated
     */
    public void setRetserial(String retserial) {
        this.retserial = retserial == null ? null : retserial.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.TRADE_NO
     *
     * @return the value of umsmember..t_histradeinf.TRADE_NO
     *
     * @mbg.generated
     */
    public String getTradeNo() {
        return tradeNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.TRADE_NO
     *
     * @param tradeNo the value for umsmember..t_histradeinf.TRADE_NO
     *
     * @mbg.generated
     */
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.OUT_TRADE_NO
     *
     * @return the value of umsmember..t_histradeinf.OUT_TRADE_NO
     *
     * @mbg.generated
     */
    public String getOutTradeNo() {
        return outTradeNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.OUT_TRADE_NO
     *
     * @param outTradeNo the value for umsmember..t_histradeinf.OUT_TRADE_NO
     *
     * @mbg.generated
     */
    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo == null ? null : outTradeNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.ORDER_NO
     *
     * @return the value of umsmember..t_histradeinf.ORDER_NO
     *
     * @mbg.generated
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.ORDER_NO
     *
     * @param orderNo the value for umsmember..t_histradeinf.ORDER_NO
     *
     * @mbg.generated
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.MCHTNO
     *
     * @return the value of umsmember..t_histradeinf.MCHTNO
     *
     * @mbg.generated
     */
    public String getMchtno() {
        return mchtno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.MCHTNO
     *
     * @param mchtno the value for umsmember..t_histradeinf.MCHTNO
     *
     * @mbg.generated
     */
    public void setMchtno(String mchtno) {
        this.mchtno = mchtno == null ? null : mchtno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.TERMNO
     *
     * @return the value of umsmember..t_histradeinf.TERMNO
     *
     * @mbg.generated
     */
    public String getTermno() {
        return termno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.TERMNO
     *
     * @param termno the value for umsmember..t_histradeinf.TERMNO
     *
     * @mbg.generated
     */
    public void setTermno(String termno) {
        this.termno = termno == null ? null : termno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.EXMCHTNO
     *
     * @return the value of umsmember..t_histradeinf.EXMCHTNO
     *
     * @mbg.generated
     */
    public String getExmchtno() {
        return exmchtno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.EXMCHTNO
     *
     * @param exmchtno the value for umsmember..t_histradeinf.EXMCHTNO
     *
     * @mbg.generated
     */
    public void setExmchtno(String exmchtno) {
        this.exmchtno = exmchtno == null ? null : exmchtno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.EXTERMNO
     *
     * @return the value of umsmember..t_histradeinf.EXTERMNO
     *
     * @mbg.generated
     */
    public String getExtermno() {
        return extermno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.EXTERMNO
     *
     * @param extermno the value for umsmember..t_histradeinf.EXTERMNO
     *
     * @mbg.generated
     */
    public void setExtermno(String extermno) {
        this.extermno = extermno == null ? null : extermno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.BIZ_TYPE
     *
     * @return the value of umsmember..t_histradeinf.BIZ_TYPE
     *
     * @mbg.generated
     */
    public String getBizType() {
        return bizType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.BIZ_TYPE
     *
     * @param bizType the value for umsmember..t_histradeinf.BIZ_TYPE
     *
     * @mbg.generated
     */
    public void setBizType(String bizType) {
        this.bizType = bizType == null ? null : bizType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.PAY_CODE
     *
     * @return the value of umsmember..t_histradeinf.PAY_CODE
     *
     * @mbg.generated
     */
    public String getPayCode() {
        return payCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.PAY_CODE
     *
     * @param payCode the value for umsmember..t_histradeinf.PAY_CODE
     *
     * @mbg.generated
     */
    public void setPayCode(String payCode) {
        this.payCode = payCode == null ? null : payCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.TRANS_TYPE
     *
     * @return the value of umsmember..t_histradeinf.TRANS_TYPE
     *
     * @mbg.generated
     */
    public String getTransType() {
        return transType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.TRANS_TYPE
     *
     * @param transType the value for umsmember..t_histradeinf.TRANS_TYPE
     *
     * @mbg.generated
     */
    public void setTransType(String transType) {
        this.transType = transType == null ? null : transType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.STATUS
     *
     * @return the value of umsmember..t_histradeinf.STATUS
     *
     * @mbg.generated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.STATUS
     *
     * @param status the value for umsmember..t_histradeinf.STATUS
     *
     * @mbg.generated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.CUSTOMER_TYPE
     *
     * @return the value of umsmember..t_histradeinf.CUSTOMER_TYPE
     *
     * @mbg.generated
     */
    public String getCustomerType() {
        return customerType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.CUSTOMER_TYPE
     *
     * @param customerType the value for umsmember..t_histradeinf.CUSTOMER_TYPE
     *
     * @mbg.generated
     */
    public void setCustomerType(String customerType) {
        this.customerType = customerType == null ? null : customerType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.INPUT_TYPE
     *
     * @return the value of umsmember..t_histradeinf.INPUT_TYPE
     *
     * @mbg.generated
     */
    public String getInputType() {
        return inputType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.INPUT_TYPE
     *
     * @param inputType the value for umsmember..t_histradeinf.INPUT_TYPE
     *
     * @mbg.generated
     */
    public void setInputType(String inputType) {
        this.inputType = inputType == null ? null : inputType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.TRADE_AMOUNT
     *
     * @return the value of umsmember..t_histradeinf.TRADE_AMOUNT
     *
     * @mbg.generated
     */
    public BigDecimal getTradeAmount() {
        return tradeAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.TRADE_AMOUNT
     *
     * @param tradeAmount the value for umsmember..t_histradeinf.TRADE_AMOUNT
     *
     * @mbg.generated
     */
    public void setTradeAmount(BigDecimal tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.DIS_AMOUNT
     *
     * @return the value of umsmember..t_histradeinf.DIS_AMOUNT
     *
     * @mbg.generated
     */
    public BigDecimal getDisAmount() {
        return disAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.DIS_AMOUNT
     *
     * @param disAmount the value for umsmember..t_histradeinf.DIS_AMOUNT
     *
     * @mbg.generated
     */
    public void setDisAmount(BigDecimal disAmount) {
        this.disAmount = disAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.SCORE
     *
     * @return the value of umsmember..t_histradeinf.SCORE
     *
     * @mbg.generated
     */
    public BigDecimal getScore() {
        return score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.SCORE
     *
     * @param score the value for umsmember..t_histradeinf.SCORE
     *
     * @mbg.generated
     */
    public void setScore(BigDecimal score) {
        this.score = score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.RET_CODE
     *
     * @return the value of umsmember..t_histradeinf.RET_CODE
     *
     * @mbg.generated
     */
    public String getRetCode() {
        return retCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.RET_CODE
     *
     * @param retCode the value for umsmember..t_histradeinf.RET_CODE
     *
     * @mbg.generated
     */
    public void setRetCode(String retCode) {
        this.retCode = retCode == null ? null : retCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.RET_MSG
     *
     * @return the value of umsmember..t_histradeinf.RET_MSG
     *
     * @mbg.generated
     */
    public String getRetMsg() {
        return retMsg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.RET_MSG
     *
     * @param retMsg the value for umsmember..t_histradeinf.RET_MSG
     *
     * @mbg.generated
     */
    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg == null ? null : retMsg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.RET_TIME
     *
     * @return the value of umsmember..t_histradeinf.RET_TIME
     *
     * @mbg.generated
     */
    public String getRetTime() {
        return retTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.RET_TIME
     *
     * @param retTime the value for umsmember..t_histradeinf.RET_TIME
     *
     * @mbg.generated
     */
    public void setRetTime(String retTime) {
        this.retTime = retTime == null ? null : retTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.MEMBER_ID
     *
     * @return the value of umsmember..t_histradeinf.MEMBER_ID
     *
     * @mbg.generated
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.MEMBER_ID
     *
     * @param memberId the value for umsmember..t_histradeinf.MEMBER_ID
     *
     * @mbg.generated
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.CARD_NO
     *
     * @return the value of umsmember..t_histradeinf.CARD_NO
     *
     * @mbg.generated
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.CARD_NO
     *
     * @param cardNo the value for umsmember..t_histradeinf.CARD_NO
     *
     * @mbg.generated
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.TELEPHONE
     *
     * @return the value of umsmember..t_histradeinf.TELEPHONE
     *
     * @mbg.generated
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.TELEPHONE
     *
     * @param telephone the value for umsmember..t_histradeinf.TELEPHONE
     *
     * @mbg.generated
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.CURRENCY
     *
     * @return the value of umsmember..t_histradeinf.CURRENCY
     *
     * @mbg.generated
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.CURRENCY
     *
     * @param currency the value for umsmember..t_histradeinf.CURRENCY
     *
     * @mbg.generated
     */
    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.REMAIN_AMOUNT
     *
     * @return the value of umsmember..t_histradeinf.REMAIN_AMOUNT
     *
     * @mbg.generated
     */
    public BigDecimal getRemainAmount() {
        return remainAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.REMAIN_AMOUNT
     *
     * @param remainAmount the value for umsmember..t_histradeinf.REMAIN_AMOUNT
     *
     * @mbg.generated
     */
    public void setRemainAmount(BigDecimal remainAmount) {
        this.remainAmount = remainAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.REMAIN_SCORE
     *
     * @return the value of umsmember..t_histradeinf.REMAIN_SCORE
     *
     * @mbg.generated
     */
    public BigDecimal getRemainScore() {
        return remainScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.REMAIN_SCORE
     *
     * @param remainScore the value for umsmember..t_histradeinf.REMAIN_SCORE
     *
     * @mbg.generated
     */
    public void setRemainScore(BigDecimal remainScore) {
        this.remainScore = remainScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.TRACENO
     *
     * @return the value of umsmember..t_histradeinf.TRACENO
     *
     * @mbg.generated
     */
    public String getTraceno() {
        return traceno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.TRACENO
     *
     * @param traceno the value for umsmember..t_histradeinf.TRACENO
     *
     * @mbg.generated
     */
    public void setTraceno(String traceno) {
        this.traceno = traceno == null ? null : traceno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.BATCHNO
     *
     * @return the value of umsmember..t_histradeinf.BATCHNO
     *
     * @mbg.generated
     */
    public String getBatchno() {
        return batchno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.BATCHNO
     *
     * @param batchno the value for umsmember..t_histradeinf.BATCHNO
     *
     * @mbg.generated
     */
    public void setBatchno(String batchno) {
        this.batchno = batchno == null ? null : batchno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.CREATE_TIME
     *
     * @return the value of umsmember..t_histradeinf.CREATE_TIME
     *
     * @mbg.generated
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.CREATE_TIME
     *
     * @param createTime the value for umsmember..t_histradeinf.CREATE_TIME
     *
     * @mbg.generated
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.REFRESH_TIME
     *
     * @return the value of umsmember..t_histradeinf.REFRESH_TIME
     *
     * @mbg.generated
     */
    public String getRefreshTime() {
        return refreshTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.REFRESH_TIME
     *
     * @param refreshTime the value for umsmember..t_histradeinf.REFRESH_TIME
     *
     * @mbg.generated
     */
    public void setRefreshTime(String refreshTime) {
        this.refreshTime = refreshTime == null ? null : refreshTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.OUT_REFUND_NO
     *
     * @return the value of umsmember..t_histradeinf.OUT_REFUND_NO
     *
     * @mbg.generated
     */
    public String getOutRefundNo() {
        return outRefundNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.OUT_REFUND_NO
     *
     * @param outRefundNo the value for umsmember..t_histradeinf.OUT_REFUND_NO
     *
     * @mbg.generated
     */
    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo == null ? null : outRefundNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.OLD_TRADE_NO
     *
     * @return the value of umsmember..t_histradeinf.OLD_TRADE_NO
     *
     * @mbg.generated
     */
    public String getOldTradeNo() {
        return oldTradeNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.OLD_TRADE_NO
     *
     * @param oldTradeNo the value for umsmember..t_histradeinf.OLD_TRADE_NO
     *
     * @mbg.generated
     */
    public void setOldTradeNo(String oldTradeNo) {
        this.oldTradeNo = oldTradeNo == null ? null : oldTradeNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.OLD_ORDER_NO
     *
     * @return the value of umsmember..t_histradeinf.OLD_ORDER_NO
     *
     * @mbg.generated
     */
    public String getOldOrderNo() {
        return oldOrderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.OLD_ORDER_NO
     *
     * @param oldOrderNo the value for umsmember..t_histradeinf.OLD_ORDER_NO
     *
     * @mbg.generated
     */
    public void setOldOrderNo(String oldOrderNo) {
        this.oldOrderNo = oldOrderNo == null ? null : oldOrderNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.CORRECT_CODE
     *
     * @return the value of umsmember..t_histradeinf.CORRECT_CODE
     *
     * @mbg.generated
     */
    public String getCorrectCode() {
        return correctCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.CORRECT_CODE
     *
     * @param correctCode the value for umsmember..t_histradeinf.CORRECT_CODE
     *
     * @mbg.generated
     */
    public void setCorrectCode(String correctCode) {
        this.correctCode = correctCode == null ? null : correctCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.CORRECT_MSG
     *
     * @return the value of umsmember..t_histradeinf.CORRECT_MSG
     *
     * @mbg.generated
     */
    public String getCorrectMsg() {
        return correctMsg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.CORRECT_MSG
     *
     * @param correctMsg the value for umsmember..t_histradeinf.CORRECT_MSG
     *
     * @mbg.generated
     */
    public void setCorrectMsg(String correctMsg) {
        this.correctMsg = correctMsg == null ? null : correctMsg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.CORRECT_TIME
     *
     * @return the value of umsmember..t_histradeinf.CORRECT_TIME
     *
     * @mbg.generated
     */
    public String getCorrectTime() {
        return correctTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.CORRECT_TIME
     *
     * @param correctTime the value for umsmember..t_histradeinf.CORRECT_TIME
     *
     * @mbg.generated
     */
    public void setCorrectTime(String correctTime) {
        this.correctTime = correctTime == null ? null : correctTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.VERIFY_STATE
     *
     * @return the value of umsmember..t_histradeinf.VERIFY_STATE
     *
     * @mbg.generated
     */
    public String getVerifyState() {
        return verifyState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.VERIFY_STATE
     *
     * @param verifyState the value for umsmember..t_histradeinf.VERIFY_STATE
     *
     * @mbg.generated
     */
    public void setVerifyState(String verifyState) {
        this.verifyState = verifyState == null ? null : verifyState.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.SUBJECT
     *
     * @return the value of umsmember..t_histradeinf.SUBJECT
     *
     * @mbg.generated
     */
    public String getSubject() {
        return subject;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.SUBJECT
     *
     * @param subject the value for umsmember..t_histradeinf.SUBJECT
     *
     * @mbg.generated
     */
    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.GOODS_DETAIL
     *
     * @return the value of umsmember..t_histradeinf.GOODS_DETAIL
     *
     * @mbg.generated
     */
    public String getGoodsDetail() {
        return goodsDetail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.GOODS_DETAIL
     *
     * @param goodsDetail the value for umsmember..t_histradeinf.GOODS_DETAIL
     *
     * @mbg.generated
     */
    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail == null ? null : goodsDetail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.NOTE
     *
     * @return the value of umsmember..t_histradeinf.NOTE
     *
     * @mbg.generated
     */
    public String getNote() {
        return note;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.NOTE
     *
     * @param note the value for umsmember..t_histradeinf.NOTE
     *
     * @mbg.generated
     */
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.CREATE_IP
     *
     * @return the value of umsmember..t_histradeinf.CREATE_IP
     *
     * @mbg.generated
     */
    public String getCreateIp() {
        return createIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.CREATE_IP
     *
     * @param createIp the value for umsmember..t_histradeinf.CREATE_IP
     *
     * @mbg.generated
     */
    public void setCreateIp(String createIp) {
        this.createIp = createIp == null ? null : createIp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histradeinf.QUERY_SIGN
     *
     * @return the value of umsmember..t_histradeinf.QUERY_SIGN
     *
     * @mbg.generated
     */
    public String getQuerySign() {
        return querySign;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histradeinf.QUERY_SIGN
     *
     * @param querySign the value for umsmember..t_histradeinf.QUERY_SIGN
     *
     * @mbg.generated
     */
    public void setQuerySign(String querySign) {
        this.querySign = querySign == null ? null : querySign.trim();
    }
}