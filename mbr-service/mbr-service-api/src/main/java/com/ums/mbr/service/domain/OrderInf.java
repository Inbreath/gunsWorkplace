package com.ums.mbr.service.domain;

import java.io.Serializable;

public class OrderInf implements Serializable {
    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 系统跟踪流水
     * This field corresponds to the database table umsmember..t_orderinf
     *
     * @mbg.generated
     */
    private String retserial;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 订单号
     * This field corresponds to the database table umsmember..t_orderinf
     *
     * @mbg.generated
     */
    private String orderNo;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 商户代码
     * This field corresponds to the database table umsmember..t_orderinf
     *
     * @mbg.generated
     */
    private String mchtno;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 终端编号
     * This field corresponds to the database table umsmember..t_orderinf
     *
     * @mbg.generated
     */
    private String termno;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 订单状态
     * This field corresponds to the database table umsmember..t_orderinf
     *
     * @mbg.generated
     */
    private String state;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 备注
     * This field corresponds to the database table umsmember..t_orderinf
     *
     * @mbg.generated
     */
    private String note;

    private String createTime;

    private String refreshTime;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 有效时间
     * This field corresponds to the database table umsmember..t_orderinf
     *
     * @mbg.generated
     */
    private String effectiveTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_orderinf.RETSERIAL
     *
     * @return the value of umsmember..t_orderinf.RETSERIAL
     *
     * @mbg.generated
     */
    public String getRetserial() {
        return retserial;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_orderinf.RETSERIAL
     *
     * @param retserial the value for umsmember..t_orderinf.RETSERIAL
     *
     * @mbg.generated
     */
    public void setRetserial(String retserial) {
        this.retserial = retserial == null ? null : retserial.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_orderinf.ORDER_NO
     *
     * @return the value of umsmember..t_orderinf.ORDER_NO
     *
     * @mbg.generated
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_orderinf.ORDER_NO
     *
     * @param orderNo the value for umsmember..t_orderinf.ORDER_NO
     *
     * @mbg.generated
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_orderinf.MCHTNO
     *
     * @return the value of umsmember..t_orderinf.MCHTNO
     *
     * @mbg.generated
     */
    public String getMchtno() {
        return mchtno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_orderinf.MCHTNO
     *
     * @param mchtno the value for umsmember..t_orderinf.MCHTNO
     *
     * @mbg.generated
     */
    public void setMchtno(String mchtno) {
        this.mchtno = mchtno == null ? null : mchtno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_orderinf.TERMNO
     *
     * @return the value of umsmember..t_orderinf.TERMNO
     *
     * @mbg.generated
     */
    public String getTermno() {
        return termno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_orderinf.TERMNO
     *
     * @param termno the value for umsmember..t_orderinf.TERMNO
     *
     * @mbg.generated
     */
    public void setTermno(String termno) {
        this.termno = termno == null ? null : termno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_orderinf.STATE
     *
     * @return the value of umsmember..t_orderinf.STATE
     *
     * @mbg.generated
     */
    public String getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_orderinf.STATE
     *
     * @param state the value for umsmember..t_orderinf.STATE
     *
     * @mbg.generated
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_orderinf.NOTE
     *
     * @return the value of umsmember..t_orderinf.NOTE
     *
     * @mbg.generated
     */
    public String getNote() {
        return note;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_orderinf.NOTE
     *
     * @param note the value for umsmember..t_orderinf.NOTE
     *
     * @mbg.generated
     */
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_orderinf.CREATE_TIME
     *
     * @return the value of umsmember..t_orderinf.CREATE_TIME
     *
     * @mbg.generated
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_orderinf.CREATE_TIME
     *
     * @param createTime the value for umsmember..t_orderinf.CREATE_TIME
     *
     * @mbg.generated
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_orderinf.REFRESH_TIME
     *
     * @return the value of umsmember..t_orderinf.REFRESH_TIME
     *
     * @mbg.generated
     */
    public String getRefreshTime() {
        return refreshTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_orderinf.REFRESH_TIME
     *
     * @param refreshTime the value for umsmember..t_orderinf.REFRESH_TIME
     *
     * @mbg.generated
     */
    public void setRefreshTime(String refreshTime) {
        this.refreshTime = refreshTime == null ? null : refreshTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_orderinf.EFFECTIVE_TIME
     *
     * @return the value of umsmember..t_orderinf.EFFECTIVE_TIME
     *
     * @mbg.generated
     */
    public String getEffectiveTime() {
        return effectiveTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_orderinf.EFFECTIVE_TIME
     *
     * @param effectiveTime the value for umsmember..t_orderinf.EFFECTIVE_TIME
     *
     * @mbg.generated
     */
    public void setEffectiveTime(String effectiveTime) {
        this.effectiveTime = effectiveTime == null ? null : effectiveTime.trim();
    }
}