package com.ums.mbr.service.domain;

import java.io.Serializable;

public class TradeCoupon implements Serializable {
    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 系统跟踪流水
     * This field corresponds to the database table umsmember..t_trade_coupon
     *
     * @mbg.generated
     */
    private String retserial;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 会员系统定义的交易号
     * This field corresponds to the database table umsmember..t_trade_coupon
     *
     * @mbg.generated
     */
    private String tradeNo;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 订单号
     * This field corresponds to the database table umsmember..t_trade_coupon
     *
     * @mbg.generated
     */
    private String orderNo;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 券码号
     * This field corresponds to the database table umsmember..t_trade_coupon
     *
     * @mbg.generated
     */
    private String verifyNo;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 券码数量
     * This field corresponds to the database table umsmember..t_trade_coupon
     *
     * @mbg.generated
     */
    private Long verifyNum;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 券码类型：member或free
     * This field corresponds to the database table umsmember..t_trade_coupon
     *
     * @mbg.generated
     */
    private String verifyState;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_trade_coupon.RETSERIAL
     *
     * @return the value of umsmember..t_trade_coupon.RETSERIAL
     *
     * @mbg.generated
     */
    public String getRetserial() {
        return retserial;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_trade_coupon.RETSERIAL
     *
     * @param retserial the value for umsmember..t_trade_coupon.RETSERIAL
     *
     * @mbg.generated
     */
    public void setRetserial(String retserial) {
        this.retserial = retserial == null ? null : retserial.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_trade_coupon.TRADE_NO
     *
     * @return the value of umsmember..t_trade_coupon.TRADE_NO
     *
     * @mbg.generated
     */
    public String getTradeNo() {
        return tradeNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_trade_coupon.TRADE_NO
     *
     * @param tradeNo the value for umsmember..t_trade_coupon.TRADE_NO
     *
     * @mbg.generated
     */
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_trade_coupon.ORDER_NO
     *
     * @return the value of umsmember..t_trade_coupon.ORDER_NO
     *
     * @mbg.generated
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_trade_coupon.ORDER_NO
     *
     * @param orderNo the value for umsmember..t_trade_coupon.ORDER_NO
     *
     * @mbg.generated
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_trade_coupon.VERIFY_NO
     *
     * @return the value of umsmember..t_trade_coupon.VERIFY_NO
     *
     * @mbg.generated
     */
    public String getVerifyNo() {
        return verifyNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_trade_coupon.VERIFY_NO
     *
     * @param verifyNo the value for umsmember..t_trade_coupon.VERIFY_NO
     *
     * @mbg.generated
     */
    public void setVerifyNo(String verifyNo) {
        this.verifyNo = verifyNo == null ? null : verifyNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_trade_coupon.VERIFY_NUM
     *
     * @return the value of umsmember..t_trade_coupon.VERIFY_NUM
     *
     * @mbg.generated
     */
    public Long getVerifyNum() {
        return verifyNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_trade_coupon.VERIFY_NUM
     *
     * @param verifyNum the value for umsmember..t_trade_coupon.VERIFY_NUM
     *
     * @mbg.generated
     */
    public void setVerifyNum(Long verifyNum) {
        this.verifyNum = verifyNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_trade_coupon.VERIFY_STATE
     *
     * @return the value of umsmember..t_trade_coupon.VERIFY_STATE
     *
     * @mbg.generated
     */
    public String getVerifyState() {
        return verifyState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_trade_coupon.VERIFY_STATE
     *
     * @param verifyState the value for umsmember..t_trade_coupon.VERIFY_STATE
     *
     * @mbg.generated
     */
    public void setVerifyState(String verifyState) {
        this.verifyState = verifyState == null ? null : verifyState.trim();
    }
}