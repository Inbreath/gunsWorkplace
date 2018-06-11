package com.ums.mbr;


/**
 * 外部参数传入全部放在这里，以便
 * Author: pwwu@chinaums.com
 * Date: 2018/6/11 15:35
 */
public class RequestBean {

    private String baseUrl = "http://cre.api.hd123.cn/yl/api/v1";                 //  请求头地址
    private String appId;                   //  调用者身份信息
    private String timestamp;               //  时间戳
    private String sign;                    //  签名字符串
    private String orgCode;                 //  广场代码
    private String ContentType;             //  如：application/json

    private String accountType;             //  账户识别类型
    private String accountValue;            //  账户识别值

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountValue() {
        return accountValue;
    }

    public void setAccountValue(String accountValue) {
        this.accountValue = accountValue;
    }

    public String getContentType() {
        return ContentType;
    }

    public void setContentType(String contentType) {
        ContentType = contentType;
    }
}
