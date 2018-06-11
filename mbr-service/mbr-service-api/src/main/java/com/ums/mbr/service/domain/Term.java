package com.ums.mbr.service.domain;

import java.io.Serializable;

public class Term extends TermKey implements Serializable {
    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 终端名称
     * This field corresponds to the database table umsmember..t_term
     *
     * @mbg.generated
     */
    private String termname;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 签名类型
     * This field corresponds to the database table umsmember..t_term
     *
     * @mbg.generated
     */
    private String signType;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 公钥
     * This field corresponds to the database table umsmember..t_term
     *
     * @mbg.generated
     */
    private String publicKey;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 私钥
     * This field corresponds to the database table umsmember..t_term
     *
     * @mbg.generated
     */
    private String privateKey;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * MD5校验值
     * This field corresponds to the database table umsmember..t_term
     *
     * @mbg.generated
     */
    private String md5key;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 是否允许隔日退货
     * This field corresponds to the database table umsmember..t_term
     *
     * @mbg.generated
     */
    private String refundFlag;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 创建时间
     * This field corresponds to the database table umsmember..t_term
     *
     * @mbg.generated
     */
    private String createTime;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 更新时间
     * This field corresponds to the database table umsmember..t_term
     *
     * @mbg.generated
     */
    private String refreshTime;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 八小时内已经OTA的次数
     * This field corresponds to the database table umsmember..t_term
     *
     * @mbg.generated
     */
    private Integer otaCount;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 八小时内允许OTA的次数
     * This field corresponds to the database table umsmember..t_term
     *
     * @mbg.generated
     */
    private Integer otaAdmit;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 八小时内最近一次OTA的时间
     * This field corresponds to the database table umsmember..t_term
     *
     * @mbg.generated
     */
    private String otaTime;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 终端状态
     * This field corresponds to the database table umsmember..t_term
     *
     * @mbg.generated
     */
    private String state;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 备注
     * This field corresponds to the database table umsmember..t_term
     *
     * @mbg.generated
     */
    private String note;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 综合体所属路由
     * This field corresponds to the database table umsmember..t_term
     *
     * @mbg.generated
     */
    private String routerId;

    public Term() {
    }

    public Term(String mchtno, String termno) {
        super(mchtno, termno);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_term.TERMNAME
     *
     * @return the value of umsmember..t_term.TERMNAME
     *
     * @mbg.generated
     */
    public String getTermname() {
        return termname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_term.TERMNAME
     *
     * @param termname the value for umsmember..t_term.TERMNAME
     *
     * @mbg.generated
     */
    public void setTermname(String termname) {
        this.termname = termname == null ? null : termname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_term.SIGN_TYPE
     *
     * @return the value of umsmember..t_term.SIGN_TYPE
     *
     * @mbg.generated
     */
    public String getSignType() {
        return signType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_term.SIGN_TYPE
     *
     * @param signType the value for umsmember..t_term.SIGN_TYPE
     *
     * @mbg.generated
     */
    public void setSignType(String signType) {
        this.signType = signType == null ? null : signType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_term.PUBLIC_KEY
     *
     * @return the value of umsmember..t_term.PUBLIC_KEY
     *
     * @mbg.generated
     */
    public String getPublicKey() {
        return publicKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_term.PUBLIC_KEY
     *
     * @param publicKey the value for umsmember..t_term.PUBLIC_KEY
     *
     * @mbg.generated
     */
    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey == null ? null : publicKey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_term.PRIVATE_KEY
     *
     * @return the value of umsmember..t_term.PRIVATE_KEY
     *
     * @mbg.generated
     */
    public String getPrivateKey() {
        return privateKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_term.PRIVATE_KEY
     *
     * @param privateKey the value for umsmember..t_term.PRIVATE_KEY
     *
     * @mbg.generated
     */
    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey == null ? null : privateKey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_term.MD5KEY
     *
     * @return the value of umsmember..t_term.MD5KEY
     *
     * @mbg.generated
     */
    public String getMd5key() {
        return md5key;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_term.MD5KEY
     *
     * @param md5key the value for umsmember..t_term.MD5KEY
     *
     * @mbg.generated
     */
    public void setMd5key(String md5key) {
        this.md5key = md5key == null ? null : md5key.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_term.REFUND_FLAG
     *
     * @return the value of umsmember..t_term.REFUND_FLAG
     *
     * @mbg.generated
     */
    public String getRefundFlag() {
        return refundFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_term.REFUND_FLAG
     *
     * @param refundFlag the value for umsmember..t_term.REFUND_FLAG
     *
     * @mbg.generated
     */
    public void setRefundFlag(String refundFlag) {
        this.refundFlag = refundFlag == null ? null : refundFlag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_term.CREATE_TIME
     *
     * @return the value of umsmember..t_term.CREATE_TIME
     *
     * @mbg.generated
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_term.CREATE_TIME
     *
     * @param createTime the value for umsmember..t_term.CREATE_TIME
     *
     * @mbg.generated
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_term.REFRESH_TIME
     *
     * @return the value of umsmember..t_term.REFRESH_TIME
     *
     * @mbg.generated
     */
    public String getRefreshTime() {
        return refreshTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_term.REFRESH_TIME
     *
     * @param refreshTime the value for umsmember..t_term.REFRESH_TIME
     *
     * @mbg.generated
     */
    public void setRefreshTime(String refreshTime) {
        this.refreshTime = refreshTime == null ? null : refreshTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_term.OTA_COUNT
     *
     * @return the value of umsmember..t_term.OTA_COUNT
     *
     * @mbg.generated
     */
    public Integer getOtaCount() {
        return otaCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_term.OTA_COUNT
     *
     * @param otaCount the value for umsmember..t_term.OTA_COUNT
     *
     * @mbg.generated
     */
    public void setOtaCount(Integer otaCount) {
        this.otaCount = otaCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_term.OTA_ADMIT
     *
     * @return the value of umsmember..t_term.OTA_ADMIT
     *
     * @mbg.generated
     */
    public Integer getOtaAdmit() {
        return otaAdmit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_term.OTA_ADMIT
     *
     * @param otaAdmit the value for umsmember..t_term.OTA_ADMIT
     *
     * @mbg.generated
     */
    public void setOtaAdmit(Integer otaAdmit) {
        this.otaAdmit = otaAdmit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_term.OTA_TIME
     *
     * @return the value of umsmember..t_term.OTA_TIME
     *
     * @mbg.generated
     */
    public String getOtaTime() {
        return otaTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_term.OTA_TIME
     *
     * @param otaTime the value for umsmember..t_term.OTA_TIME
     *
     * @mbg.generated
     */
    public void setOtaTime(String otaTime) {
        this.otaTime = otaTime == null ? null : otaTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_term.STATE
     *
     * @return the value of umsmember..t_term.STATE
     *
     * @mbg.generated
     */
    public String getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_term.STATE
     *
     * @param state the value for umsmember..t_term.STATE
     *
     * @mbg.generated
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_term.NOTE
     *
     * @return the value of umsmember..t_term.NOTE
     *
     * @mbg.generated
     */
    public String getNote() {
        return note;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_term.NOTE
     *
     * @param note the value for umsmember..t_term.NOTE
     *
     * @mbg.generated
     */
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_term.ROUTER_ID
     *
     * @return the value of umsmember..t_term.ROUTER_ID
     *
     * @mbg.generated
     */
    public String getRouterId() {
        return routerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_term.ROUTER_ID
     *
     * @param routerId the value for umsmember..t_term.ROUTER_ID
     *
     * @mbg.generated
     */
    public void setRouterId(String routerId) {
        this.routerId = routerId == null ? null : routerId.trim();
    }
}