package com.ums.mbr.packer.hding.request;

public class HdingBaseRequestBody {
    private String appId;                   //  调用者身份信息
    private String timestamp;               //  时间戳
    private String sign;                    //  签名字符串
    private String orgCode;                 //  广场代码
    private String Content_Type = "application/json";

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

    public String getContent_Type() {
        return Content_Type;
    }

    public void setContent_Type(String content_Type) {
        Content_Type = content_Type;
    }

}
