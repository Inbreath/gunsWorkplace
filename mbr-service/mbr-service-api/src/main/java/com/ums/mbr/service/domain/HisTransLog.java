package com.ums.mbr.service.domain;

import java.io.Serializable;

public class HisTransLog implements Serializable {
    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 系统跟踪流水
     * This field corresponds to the database table umsmember..t_histranslog
     *
     * @mbg.generated
     */
    private String retserial;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 银商商户号
     * This field corresponds to the database table umsmember..t_histranslog
     *
     * @mbg.generated
     */
    private String mchtno;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 银商终端号
     * This field corresponds to the database table umsmember..t_histranslog
     *
     * @mbg.generated
     */
    private String termno;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 渠道商户代码
     * This field corresponds to the database table umsmember..t_histranslog
     *
     * @mbg.generated
     */
    private String exmchtno;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 渠道终端号
     * This field corresponds to the database table umsmember..t_histranslog
     *
     * @mbg.generated
     */
    private String extermno;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 请求消息号
     * This field corresponds to the database table umsmember..t_histranslog
     *
     * @mbg.generated
     */
    private String requestId;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 会员系统定义的交易号
     * This field corresponds to the database table umsmember..t_histranslog
     *
     * @mbg.generated
     */
    private String tradeNo;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 商户系统定义的交易号
     * This field corresponds to the database table umsmember..t_histranslog
     *
     * @mbg.generated
     */
    private String outTradeNo;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 订单号，由会员系统生成
     * This field corresponds to the database table umsmember..t_histranslog
     *
     * @mbg.generated
     */
    private String orderNo;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 交易类型
     * This field corresponds to the database table umsmember..t_histranslog
     *
     * @mbg.generated
     */
    private String bizType;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 支付方式
     * This field corresponds to the database table umsmember..t_histranslog
     *
     * @mbg.generated
     */
    private String bizChannel;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 代理渠道
     * This field corresponds to the database table umsmember..t_histranslog
     *
     * @mbg.generated
     */
    private String bizAgency;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 签名类型
     * This field corresponds to the database table umsmember..t_histranslog
     *
     * @mbg.generated
     */
    private String signType;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * OTA交易默认上送1234
     * This field corresponds to the database table umsmember..t_histranslog
     *
     * @mbg.generated
     */
    private String sign;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 私钥格式
     * This field corresponds to the database table umsmember..t_histranslog
     *
     * @mbg.generated
     */
    private String signFormat;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 报文字符编码
     * This field corresponds to the database table umsmember..t_histranslog
     *
     * @mbg.generated
     */
    private String charset;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 版本号
     * This field corresponds to the database table umsmember..t_histranslog
     *
     * @mbg.generated
     */
    private String version;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 交易请求的发起的应用程序名称和版本
     * This field corresponds to the database table umsmember..t_histranslog
     *
     * @mbg.generated
     */
    private String appInfo;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 运行机器名称
     * This field corresponds to the database table umsmember..t_histranslog
     *
     * @mbg.generated
     */
    private String machine;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 设备款台号
     * This field corresponds to the database table umsmember..t_histranslog
     *
     * @mbg.generated
     */
    private String deviceId;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 创建IP
     * This field corresponds to the database table umsmember..t_histranslog
     *
     * @mbg.generated
     */
    private String createIp;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 服务器主动通知商户服务器里指定的页面http/https路径
     * This field corresponds to the database table umsmember..t_histranslog
     *
     * @mbg.generated
     */
    private String notifyUrl;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 创建时间
     * This field corresponds to the database table umsmember..t_histranslog
     *
     * @mbg.generated
     */
    private String requestTime;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 返回时间
     * This field corresponds to the database table umsmember..t_histranslog
     *
     * @mbg.generated
     */
    private String retTime;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 业务返回码
     * This field corresponds to the database table umsmember..t_histranslog
     *
     * @mbg.generated
     */
    private String subCode;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 业务返回码说明
     * This field corresponds to the database table umsmember..t_histranslog
     *
     * @mbg.generated
     */
    private String subMessage;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 网关返回码
     * This field corresponds to the database table umsmember..t_histranslog
     *
     * @mbg.generated
     */
    private String code;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 网关返回码说明
     * This field corresponds to the database table umsmember..t_histranslog
     *
     * @mbg.generated
     */
    private String message;

    /**
     * 通过MBG添加该条注释，域注释读取建表语句的Comment信息。
     * 预留
     * This field corresponds to the database table umsmember..t_histranslog
     *
     * @mbg.generated
     */
    private String reserve;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histranslog.RETSERIAL
     *
     * @return the value of umsmember..t_histranslog.RETSERIAL
     *
     * @mbg.generated
     */
    public String getRetserial() {
        return retserial;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histranslog.RETSERIAL
     *
     * @param retserial the value for umsmember..t_histranslog.RETSERIAL
     *
     * @mbg.generated
     */
    public void setRetserial(String retserial) {
        this.retserial = retserial == null ? null : retserial.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histranslog.MCHTNO
     *
     * @return the value of umsmember..t_histranslog.MCHTNO
     *
     * @mbg.generated
     */
    public String getMchtno() {
        return mchtno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histranslog.MCHTNO
     *
     * @param mchtno the value for umsmember..t_histranslog.MCHTNO
     *
     * @mbg.generated
     */
    public void setMchtno(String mchtno) {
        this.mchtno = mchtno == null ? null : mchtno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histranslog.TERMNO
     *
     * @return the value of umsmember..t_histranslog.TERMNO
     *
     * @mbg.generated
     */
    public String getTermno() {
        return termno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histranslog.TERMNO
     *
     * @param termno the value for umsmember..t_histranslog.TERMNO
     *
     * @mbg.generated
     */
    public void setTermno(String termno) {
        this.termno = termno == null ? null : termno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histranslog.EXMCHTNO
     *
     * @return the value of umsmember..t_histranslog.EXMCHTNO
     *
     * @mbg.generated
     */
    public String getExmchtno() {
        return exmchtno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histranslog.EXMCHTNO
     *
     * @param exmchtno the value for umsmember..t_histranslog.EXMCHTNO
     *
     * @mbg.generated
     */
    public void setExmchtno(String exmchtno) {
        this.exmchtno = exmchtno == null ? null : exmchtno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histranslog.EXTERMNO
     *
     * @return the value of umsmember..t_histranslog.EXTERMNO
     *
     * @mbg.generated
     */
    public String getExtermno() {
        return extermno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histranslog.EXTERMNO
     *
     * @param extermno the value for umsmember..t_histranslog.EXTERMNO
     *
     * @mbg.generated
     */
    public void setExtermno(String extermno) {
        this.extermno = extermno == null ? null : extermno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histranslog.REQUEST_ID
     *
     * @return the value of umsmember..t_histranslog.REQUEST_ID
     *
     * @mbg.generated
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histranslog.REQUEST_ID
     *
     * @param requestId the value for umsmember..t_histranslog.REQUEST_ID
     *
     * @mbg.generated
     */
    public void setRequestId(String requestId) {
        this.requestId = requestId == null ? null : requestId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histranslog.TRADE_NO
     *
     * @return the value of umsmember..t_histranslog.TRADE_NO
     *
     * @mbg.generated
     */
    public String getTradeNo() {
        return tradeNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histranslog.TRADE_NO
     *
     * @param tradeNo the value for umsmember..t_histranslog.TRADE_NO
     *
     * @mbg.generated
     */
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histranslog.OUT_TRADE_NO
     *
     * @return the value of umsmember..t_histranslog.OUT_TRADE_NO
     *
     * @mbg.generated
     */
    public String getOutTradeNo() {
        return outTradeNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histranslog.OUT_TRADE_NO
     *
     * @param outTradeNo the value for umsmember..t_histranslog.OUT_TRADE_NO
     *
     * @mbg.generated
     */
    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo == null ? null : outTradeNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histranslog.ORDER_NO
     *
     * @return the value of umsmember..t_histranslog.ORDER_NO
     *
     * @mbg.generated
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histranslog.ORDER_NO
     *
     * @param orderNo the value for umsmember..t_histranslog.ORDER_NO
     *
     * @mbg.generated
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histranslog.BIZ_TYPE
     *
     * @return the value of umsmember..t_histranslog.BIZ_TYPE
     *
     * @mbg.generated
     */
    public String getBizType() {
        return bizType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histranslog.BIZ_TYPE
     *
     * @param bizType the value for umsmember..t_histranslog.BIZ_TYPE
     *
     * @mbg.generated
     */
    public void setBizType(String bizType) {
        this.bizType = bizType == null ? null : bizType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histranslog.BIZ_CHANNEL
     *
     * @return the value of umsmember..t_histranslog.BIZ_CHANNEL
     *
     * @mbg.generated
     */
    public String getBizChannel() {
        return bizChannel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histranslog.BIZ_CHANNEL
     *
     * @param bizChannel the value for umsmember..t_histranslog.BIZ_CHANNEL
     *
     * @mbg.generated
     */
    public void setBizChannel(String bizChannel) {
        this.bizChannel = bizChannel == null ? null : bizChannel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histranslog.BIZ_AGENCY
     *
     * @return the value of umsmember..t_histranslog.BIZ_AGENCY
     *
     * @mbg.generated
     */
    public String getBizAgency() {
        return bizAgency;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histranslog.BIZ_AGENCY
     *
     * @param bizAgency the value for umsmember..t_histranslog.BIZ_AGENCY
     *
     * @mbg.generated
     */
    public void setBizAgency(String bizAgency) {
        this.bizAgency = bizAgency == null ? null : bizAgency.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histranslog.SIGN_TYPE
     *
     * @return the value of umsmember..t_histranslog.SIGN_TYPE
     *
     * @mbg.generated
     */
    public String getSignType() {
        return signType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histranslog.SIGN_TYPE
     *
     * @param signType the value for umsmember..t_histranslog.SIGN_TYPE
     *
     * @mbg.generated
     */
    public void setSignType(String signType) {
        this.signType = signType == null ? null : signType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histranslog.SIGN
     *
     * @return the value of umsmember..t_histranslog.SIGN
     *
     * @mbg.generated
     */
    public String getSign() {
        return sign;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histranslog.SIGN
     *
     * @param sign the value for umsmember..t_histranslog.SIGN
     *
     * @mbg.generated
     */
    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histranslog.SIGN_FORMAT
     *
     * @return the value of umsmember..t_histranslog.SIGN_FORMAT
     *
     * @mbg.generated
     */
    public String getSignFormat() {
        return signFormat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histranslog.SIGN_FORMAT
     *
     * @param signFormat the value for umsmember..t_histranslog.SIGN_FORMAT
     *
     * @mbg.generated
     */
    public void setSignFormat(String signFormat) {
        this.signFormat = signFormat == null ? null : signFormat.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histranslog.CHARSET
     *
     * @return the value of umsmember..t_histranslog.CHARSET
     *
     * @mbg.generated
     */
    public String getCharset() {
        return charset;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histranslog.CHARSET
     *
     * @param charset the value for umsmember..t_histranslog.CHARSET
     *
     * @mbg.generated
     */
    public void setCharset(String charset) {
        this.charset = charset == null ? null : charset.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histranslog.VERSION
     *
     * @return the value of umsmember..t_histranslog.VERSION
     *
     * @mbg.generated
     */
    public String getVersion() {
        return version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histranslog.VERSION
     *
     * @param version the value for umsmember..t_histranslog.VERSION
     *
     * @mbg.generated
     */
    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histranslog.APP_INFO
     *
     * @return the value of umsmember..t_histranslog.APP_INFO
     *
     * @mbg.generated
     */
    public String getAppInfo() {
        return appInfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histranslog.APP_INFO
     *
     * @param appInfo the value for umsmember..t_histranslog.APP_INFO
     *
     * @mbg.generated
     */
    public void setAppInfo(String appInfo) {
        this.appInfo = appInfo == null ? null : appInfo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histranslog.MACHINE
     *
     * @return the value of umsmember..t_histranslog.MACHINE
     *
     * @mbg.generated
     */
    public String getMachine() {
        return machine;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histranslog.MACHINE
     *
     * @param machine the value for umsmember..t_histranslog.MACHINE
     *
     * @mbg.generated
     */
    public void setMachine(String machine) {
        this.machine = machine == null ? null : machine.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histranslog.DEVICE_ID
     *
     * @return the value of umsmember..t_histranslog.DEVICE_ID
     *
     * @mbg.generated
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histranslog.DEVICE_ID
     *
     * @param deviceId the value for umsmember..t_histranslog.DEVICE_ID
     *
     * @mbg.generated
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histranslog.CREATE_IP
     *
     * @return the value of umsmember..t_histranslog.CREATE_IP
     *
     * @mbg.generated
     */
    public String getCreateIp() {
        return createIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histranslog.CREATE_IP
     *
     * @param createIp the value for umsmember..t_histranslog.CREATE_IP
     *
     * @mbg.generated
     */
    public void setCreateIp(String createIp) {
        this.createIp = createIp == null ? null : createIp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histranslog.NOTIFY_URL
     *
     * @return the value of umsmember..t_histranslog.NOTIFY_URL
     *
     * @mbg.generated
     */
    public String getNotifyUrl() {
        return notifyUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histranslog.NOTIFY_URL
     *
     * @param notifyUrl the value for umsmember..t_histranslog.NOTIFY_URL
     *
     * @mbg.generated
     */
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl == null ? null : notifyUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histranslog.REQUEST_TIME
     *
     * @return the value of umsmember..t_histranslog.REQUEST_TIME
     *
     * @mbg.generated
     */
    public String getRequestTime() {
        return requestTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histranslog.REQUEST_TIME
     *
     * @param requestTime the value for umsmember..t_histranslog.REQUEST_TIME
     *
     * @mbg.generated
     */
    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime == null ? null : requestTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histranslog.RET_TIME
     *
     * @return the value of umsmember..t_histranslog.RET_TIME
     *
     * @mbg.generated
     */
    public String getRetTime() {
        return retTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histranslog.RET_TIME
     *
     * @param retTime the value for umsmember..t_histranslog.RET_TIME
     *
     * @mbg.generated
     */
    public void setRetTime(String retTime) {
        this.retTime = retTime == null ? null : retTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histranslog.SUB_CODE
     *
     * @return the value of umsmember..t_histranslog.SUB_CODE
     *
     * @mbg.generated
     */
    public String getSubCode() {
        return subCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histranslog.SUB_CODE
     *
     * @param subCode the value for umsmember..t_histranslog.SUB_CODE
     *
     * @mbg.generated
     */
    public void setSubCode(String subCode) {
        this.subCode = subCode == null ? null : subCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histranslog.SUB_MESSAGE
     *
     * @return the value of umsmember..t_histranslog.SUB_MESSAGE
     *
     * @mbg.generated
     */
    public String getSubMessage() {
        return subMessage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histranslog.SUB_MESSAGE
     *
     * @param subMessage the value for umsmember..t_histranslog.SUB_MESSAGE
     *
     * @mbg.generated
     */
    public void setSubMessage(String subMessage) {
        this.subMessage = subMessage == null ? null : subMessage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histranslog.CODE
     *
     * @return the value of umsmember..t_histranslog.CODE
     *
     * @mbg.generated
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histranslog.CODE
     *
     * @param code the value for umsmember..t_histranslog.CODE
     *
     * @mbg.generated
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histranslog.MESSAGE
     *
     * @return the value of umsmember..t_histranslog.MESSAGE
     *
     * @mbg.generated
     */
    public String getMessage() {
        return message;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histranslog.MESSAGE
     *
     * @param message the value for umsmember..t_histranslog.MESSAGE
     *
     * @mbg.generated
     */
    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column umsmember..t_histranslog.RESERVE
     *
     * @return the value of umsmember..t_histranslog.RESERVE
     *
     * @mbg.generated
     */
    public String getReserve() {
        return reserve;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column umsmember..t_histranslog.RESERVE
     *
     * @param reserve the value for umsmember..t_histranslog.RESERVE
     *
     * @mbg.generated
     */
    public void setReserve(String reserve) {
        this.reserve = reserve == null ? null : reserve.trim();
    }
}