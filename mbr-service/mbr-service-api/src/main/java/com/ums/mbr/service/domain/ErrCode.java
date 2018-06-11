package com.ums.mbr.service.domain;

import java.io.Serializable;

public class ErrCode implements Serializable {
    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 会员系统返回码编号
     * This field corresponds to the database table t_err_code
     *
     * @mbg.generated
     */
    private String id;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 会员系统返回码
     * This field corresponds to the database table t_err_code
     *
     * @mbg.generated
     */
    private String code;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 返回码的中文名称
     * This field corresponds to the database table t_err_code
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 返回码的说明
     * This field corresponds to the database table t_err_code
     *
     * @mbg.generated
     */
    private String msg;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 渠道方返回码编号
     * This field corresponds to the database table t_err_code
     *
     * @mbg.generated
     */
    private String cnCodeId;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 渠道方返回码
     * This field corresponds to the database table t_err_code
     *
     * @mbg.generated
     */
    private String cnCode;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 渠道方返回码的中文名称
     * This field corresponds to the database table t_err_code
     *
     * @mbg.generated
     */
    private String cnCodeName;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 渠道方返回码的说明
     * This field corresponds to the database table t_err_code
     *
     * @mbg.generated
     */
    private String cnCodeMsg;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 交易中心返回码编号
     * This field corresponds to the database table t_err_code
     *
     * @mbg.generated
     */
    private String ctCodeId;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 交易中心返回码
     * This field corresponds to the database table t_err_code
     *
     * @mbg.generated
     */
    private String ctCode;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 交易中心返回码的中文名称
     * This field corresponds to the database table t_err_code
     *
     * @mbg.generated
     */
    private String ctCodeName;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 交易中心返回码的说明
     * This field corresponds to the database table t_err_code
     *
     * @mbg.generated
     */
    private String ctCodeMsg;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 备注
     * This field corresponds to the database table t_err_code
     *
     * @mbg.generated
     */
    private String note;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_err_code.ID
     *
     * @return the value of t_err_code.ID
     *
     * @mbg.generated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_err_code.ID
     *
     * @param id the value for t_err_code.ID
     *
     * @mbg.generated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_err_code.CODE
     *
     * @return the value of t_err_code.CODE
     *
     * @mbg.generated
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_err_code.CODE
     *
     * @param code the value for t_err_code.CODE
     *
     * @mbg.generated
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_err_code.NAME
     *
     * @return the value of t_err_code.NAME
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_err_code.NAME
     *
     * @param name the value for t_err_code.NAME
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_err_code.MSG
     *
     * @return the value of t_err_code.MSG
     *
     * @mbg.generated
     */
    public String getMsg() {
        return msg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_err_code.MSG
     *
     * @param msg the value for t_err_code.MSG
     *
     * @mbg.generated
     */
    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_err_code.CN_CODE_ID
     *
     * @return the value of t_err_code.CN_CODE_ID
     *
     * @mbg.generated
     */
    public String getCnCodeId() {
        return cnCodeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_err_code.CN_CODE_ID
     *
     * @param cnCodeId the value for t_err_code.CN_CODE_ID
     *
     * @mbg.generated
     */
    public void setCnCodeId(String cnCodeId) {
        this.cnCodeId = cnCodeId == null ? null : cnCodeId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_err_code.CN_CODE
     *
     * @return the value of t_err_code.CN_CODE
     *
     * @mbg.generated
     */
    public String getCnCode() {
        return cnCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_err_code.CN_CODE
     *
     * @param cnCode the value for t_err_code.CN_CODE
     *
     * @mbg.generated
     */
    public void setCnCode(String cnCode) {
        this.cnCode = cnCode == null ? null : cnCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_err_code.CN_CODE _NAME
     *
     * @return the value of t_err_code.CN_CODE _NAME
     *
     * @mbg.generated
     */
    public String getCnCodeName() {
        return cnCodeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_err_code.CN_CODE _NAME
     *
     * @param cnCodeName the value for t_err_code.CN_CODE _NAME
     *
     * @mbg.generated
     */
    public void setCnCodeName(String cnCodeName) {
        this.cnCodeName = cnCodeName == null ? null : cnCodeName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_err_code.CN_CODE _MSG
     *
     * @return the value of t_err_code.CN_CODE _MSG
     *
     * @mbg.generated
     */
    public String getCnCodeMsg() {
        return cnCodeMsg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_err_code.CN_CODE _MSG
     *
     * @param cnCodeMsg the value for t_err_code.CN_CODE _MSG
     *
     * @mbg.generated
     */
    public void setCnCodeMsg(String cnCodeMsg) {
        this.cnCodeMsg = cnCodeMsg == null ? null : cnCodeMsg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_err_code.CT_CODE _ID
     *
     * @return the value of t_err_code.CT_CODE _ID
     *
     * @mbg.generated
     */
    public String getCtCodeId() {
        return ctCodeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_err_code.CT_CODE _ID
     *
     * @param ctCodeId the value for t_err_code.CT_CODE _ID
     *
     * @mbg.generated
     */
    public void setCtCodeId(String ctCodeId) {
        this.ctCodeId = ctCodeId == null ? null : ctCodeId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_err_code.CT_CODE
     *
     * @return the value of t_err_code.CT_CODE
     *
     * @mbg.generated
     */
    public String getCtCode() {
        return ctCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_err_code.CT_CODE
     *
     * @param ctCode the value for t_err_code.CT_CODE
     *
     * @mbg.generated
     */
    public void setCtCode(String ctCode) {
        this.ctCode = ctCode == null ? null : ctCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_err_code.CT_CODE _NAME
     *
     * @return the value of t_err_code.CT_CODE _NAME
     *
     * @mbg.generated
     */
    public String getCtCodeName() {
        return ctCodeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_err_code.CT_CODE _NAME
     *
     * @param ctCodeName the value for t_err_code.CT_CODE _NAME
     *
     * @mbg.generated
     */
    public void setCtCodeName(String ctCodeName) {
        this.ctCodeName = ctCodeName == null ? null : ctCodeName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_err_code.CT_CODE _MSG
     *
     * @return the value of t_err_code.CT_CODE _MSG
     *
     * @mbg.generated
     */
    public String getCtCodeMsg() {
        return ctCodeMsg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_err_code.CT_CODE _MSG
     *
     * @param ctCodeMsg the value for t_err_code.CT_CODE _MSG
     *
     * @mbg.generated
     */
    public void setCtCodeMsg(String ctCodeMsg) {
        this.ctCodeMsg = ctCodeMsg == null ? null : ctCodeMsg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_err_code.NOTE
     *
     * @return the value of t_err_code.NOTE
     *
     * @mbg.generated
     */
    public String getNote() {
        return note;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_err_code.NOTE
     *
     * @param note the value for t_err_code.NOTE
     *
     * @mbg.generated
     */
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}