package com.ums.mbr.service.domain;

import java.io.Serializable;

public class Mcht implements Serializable {
    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 银商商户号
     * This field corresponds to the database table umsmember..t_mcht
     *
     * @mbg.generated
     */
    private String mchtno;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 商户名称
     * This field corresponds to the database table umsmember..t_mcht
     *
     * @mbg.generated
     */
    private String mchtname;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 商户简称
     * This field corresponds to the database table umsmember..t_mcht
     *
     * @mbg.generated
     */
    private String briefname;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 商户状态
     * This field corresponds to the database table umsmember..t_mcht
     *
     * @mbg.generated
     */
    private String state;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 签名类型
     * This field corresponds to the database table umsmember..t_mcht
     *
     * @mbg.generated
     */
    private String signType;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 公钥
     * This field corresponds to the database table umsmember..t_mcht
     *
     * @mbg.generated
     */
    private String publicKey;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 私钥，预留字段
     * This field corresponds to the database table umsmember..t_mcht
     *
     * @mbg.generated
     */
    private String privateKey;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * MD5校验值
     * This field corresponds to the database table umsmember..t_mcht
     *
     * @mbg.generated
     */
    private String md5key;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 是否允许隔日退货
     * This field corresponds to the database table umsmember..t_mcht
     *
     * @mbg.generated
     */
    private String refundFlag;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 创建时间
     * This field corresponds to the database table umsmember..t_mcht
     *
     * @mbg.generated
     */
    private String createTime;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 更新时间
     * This field corresponds to the database table umsmember..t_mcht
     *
     * @mbg.generated
     */
    private String refreshTime;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 商户类别，详见类目表
     * This field corresponds to the database table umsmember..t_mcht
     *
     * @mbg.generated
     */
    private String categoryid;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 所属综合体,取值为T_MALL的CODE
     * This field corresponds to the database table umsmember..t_mcht
     *
     * @mbg.generated
     */
    private String mallCode;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 备注
     * This field corresponds to the database table umsmember..t_mcht
     *
     * @mbg.generated
     */
    private String note;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_mcht.MCHTNO
     *
     * @return the value of umsmember..t_mcht.MCHTNO
     *
     * @mbg.generated
     */
    public String getMchtno() {
        return mchtno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_mcht.MCHTNO
     *
     * @param mchtno the value for umsmember..t_mcht.MCHTNO
     *
     * @mbg.generated
     */
    public void setMchtno(String mchtno) {
        this.mchtno = mchtno == null ? null : mchtno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_mcht.MCHTNAME
     *
     * @return the value of umsmember..t_mcht.MCHTNAME
     *
     * @mbg.generated
     */
    public String getMchtname() {
        return mchtname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_mcht.MCHTNAME
     *
     * @param mchtname the value for umsmember..t_mcht.MCHTNAME
     *
     * @mbg.generated
     */
    public void setMchtname(String mchtname) {
        this.mchtname = mchtname == null ? null : mchtname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_mcht.BRIEFNAME
     *
     * @return the value of umsmember..t_mcht.BRIEFNAME
     *
     * @mbg.generated
     */
    public String getBriefname() {
        return briefname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_mcht.BRIEFNAME
     *
     * @param briefname the value for umsmember..t_mcht.BRIEFNAME
     *
     * @mbg.generated
     */
    public void setBriefname(String briefname) {
        this.briefname = briefname == null ? null : briefname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_mcht.STATE
     *
     * @return the value of umsmember..t_mcht.STATE
     *
     * @mbg.generated
     */
    public String getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_mcht.STATE
     *
     * @param state the value for umsmember..t_mcht.STATE
     *
     * @mbg.generated
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_mcht.SIGN_TYPE
     *
     * @return the value of umsmember..t_mcht.SIGN_TYPE
     *
     * @mbg.generated
     */
    public String getSignType() {
        return signType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_mcht.SIGN_TYPE
     *
     * @param signType the value for umsmember..t_mcht.SIGN_TYPE
     *
     * @mbg.generated
     */
    public void setSignType(String signType) {
        this.signType = signType == null ? null : signType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_mcht.PUBLIC_KEY
     *
     * @return the value of umsmember..t_mcht.PUBLIC_KEY
     *
     * @mbg.generated
     */
    public String getPublicKey() {
        return publicKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_mcht.PUBLIC_KEY
     *
     * @param publicKey the value for umsmember..t_mcht.PUBLIC_KEY
     *
     * @mbg.generated
     */
    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey == null ? null : publicKey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_mcht.PRIVATE_KEY
     *
     * @return the value of umsmember..t_mcht.PRIVATE_KEY
     *
     * @mbg.generated
     */
    public String getPrivateKey() {
        return privateKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_mcht.PRIVATE_KEY
     *
     * @param privateKey the value for umsmember..t_mcht.PRIVATE_KEY
     *
     * @mbg.generated
     */
    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey == null ? null : privateKey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_mcht.MD5KEY
     *
     * @return the value of umsmember..t_mcht.MD5KEY
     *
     * @mbg.generated
     */
    public String getMd5key() {
        return md5key;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_mcht.MD5KEY
     *
     * @param md5key the value for umsmember..t_mcht.MD5KEY
     *
     * @mbg.generated
     */
    public void setMd5key(String md5key) {
        this.md5key = md5key == null ? null : md5key.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_mcht.REFUND_FLAG
     *
     * @return the value of umsmember..t_mcht.REFUND_FLAG
     *
     * @mbg.generated
     */
    public String getRefundFlag() {
        return refundFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_mcht.REFUND_FLAG
     *
     * @param refundFlag the value for umsmember..t_mcht.REFUND_FLAG
     *
     * @mbg.generated
     */
    public void setRefundFlag(String refundFlag) {
        this.refundFlag = refundFlag == null ? null : refundFlag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_mcht.CREATE_TIME
     *
     * @return the value of umsmember..t_mcht.CREATE_TIME
     *
     * @mbg.generated
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_mcht.CREATE_TIME
     *
     * @param createTime the value for umsmember..t_mcht.CREATE_TIME
     *
     * @mbg.generated
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_mcht.REFRESH_TIME
     *
     * @return the value of umsmember..t_mcht.REFRESH_TIME
     *
     * @mbg.generated
     */
    public String getRefreshTime() {
        return refreshTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_mcht.REFRESH_TIME
     *
     * @param refreshTime the value for umsmember..t_mcht.REFRESH_TIME
     *
     * @mbg.generated
     */
    public void setRefreshTime(String refreshTime) {
        this.refreshTime = refreshTime == null ? null : refreshTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_mcht.CATEGORYID
     *
     * @return the value of umsmember..t_mcht.CATEGORYID
     *
     * @mbg.generated
     */
    public String getCategoryid() {
        return categoryid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_mcht.CATEGORYID
     *
     * @param categoryid the value for umsmember..t_mcht.CATEGORYID
     *
     * @mbg.generated
     */
    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid == null ? null : categoryid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_mcht.MALL_CODE
     *
     * @return the value of umsmember..t_mcht.MALL_CODE
     *
     * @mbg.generated
     */
    public String getMallCode() {
        return mallCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_mcht.MALL_CODE
     *
     * @param mallCode the value for umsmember..t_mcht.MALL_CODE
     *
     * @mbg.generated
     */
    public void setMallCode(String mallCode) {
        this.mallCode = mallCode == null ? null : mallCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_mcht.NOTE
     *
     * @return the value of umsmember..t_mcht.NOTE
     *
     * @mbg.generated
     */
    public String getNote() {
        return note;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_mcht.NOTE
     *
     * @param note the value for umsmember..t_mcht.NOTE
     *
     * @mbg.generated
     */
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}