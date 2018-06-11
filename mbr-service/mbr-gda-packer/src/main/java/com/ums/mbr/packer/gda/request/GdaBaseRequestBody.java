package com.ums.mbr.packer.gda.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 因为jackson不能忽略mapper中值为空的属性，所以还是统一采取以Bean的方式进行数据发送
 * Author: jcouyang@chinaums.com
 * Date: 2018/4/13 15:05
 */
public class GdaBaseRequestBody {
    @JsonProperty("access_token")
    private String accessToken;
    private String storeId;
    private String terminalNo;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getTerminalNo() {
        return terminalNo;
    }

    public void setTerminalNo(String terminalNo) {
        this.terminalNo = terminalNo;
    }
}
