package com.ums.mbr.service.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Category implements Serializable {
    private String id;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 一级行业
     * This field corresponds to the database table t_category
     *
     * @mbg.generated
     */
    private String firstLevel;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 二级行业
     * This field corresponds to the database table t_category
     *
     * @mbg.generated
     */
    private String secondLevel;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 三级行业
     * This field corresponds to the database table t_category
     *
     * @mbg.generated
     */
    private String thirdLevel;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 扣率
     * This field corresponds to the database table t_category
     *
     * @mbg.generated
     */
    private BigDecimal rate;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 结算周期
     * This field corresponds to the database table t_category
     *
     * @mbg.generated
     */
    private String settInterval;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 状态
     * This field corresponds to the database table t_category
     *
     * @mbg.generated
     */
    private String state;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 备注
     * This field corresponds to the database table t_category
     *
     * @mbg.generated
     */
    private String note;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_category.ID
     *
     * @return the value of t_category.ID
     *
     * @mbg.generated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_category.ID
     *
     * @param id the value for t_category.ID
     *
     * @mbg.generated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_category.FIRST_LEVEL
     *
     * @return the value of t_category.FIRST_LEVEL
     *
     * @mbg.generated
     */
    public String getFirstLevel() {
        return firstLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_category.FIRST_LEVEL
     *
     * @param firstLevel the value for t_category.FIRST_LEVEL
     *
     * @mbg.generated
     */
    public void setFirstLevel(String firstLevel) {
        this.firstLevel = firstLevel == null ? null : firstLevel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_category.SECOND_LEVEL
     *
     * @return the value of t_category.SECOND_LEVEL
     *
     * @mbg.generated
     */
    public String getSecondLevel() {
        return secondLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_category.SECOND_LEVEL
     *
     * @param secondLevel the value for t_category.SECOND_LEVEL
     *
     * @mbg.generated
     */
    public void setSecondLevel(String secondLevel) {
        this.secondLevel = secondLevel == null ? null : secondLevel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_category.THIRD_LEVEL
     *
     * @return the value of t_category.THIRD_LEVEL
     *
     * @mbg.generated
     */
    public String getThirdLevel() {
        return thirdLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_category.THIRD_LEVEL
     *
     * @param thirdLevel the value for t_category.THIRD_LEVEL
     *
     * @mbg.generated
     */
    public void setThirdLevel(String thirdLevel) {
        this.thirdLevel = thirdLevel == null ? null : thirdLevel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_category.RATE
     *
     * @return the value of t_category.RATE
     *
     * @mbg.generated
     */
    public BigDecimal getRate() {
        return rate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_category.RATE
     *
     * @param rate the value for t_category.RATE
     *
     * @mbg.generated
     */
    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_category.SETT_INTERVAL
     *
     * @return the value of t_category.SETT_INTERVAL
     *
     * @mbg.generated
     */
    public String getSettInterval() {
        return settInterval;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_category.SETT_INTERVAL
     *
     * @param settInterval the value for t_category.SETT_INTERVAL
     *
     * @mbg.generated
     */
    public void setSettInterval(String settInterval) {
        this.settInterval = settInterval == null ? null : settInterval.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_category.STATE
     *
     * @return the value of t_category.STATE
     *
     * @mbg.generated
     */
    public String getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_category.STATE
     *
     * @param state the value for t_category.STATE
     *
     * @mbg.generated
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_category.NOTE
     *
     * @return the value of t_category.NOTE
     *
     * @mbg.generated
     */
    public String getNote() {
        return note;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_category.NOTE
     *
     * @param note the value for t_category.NOTE
     *
     * @mbg.generated
     */
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}