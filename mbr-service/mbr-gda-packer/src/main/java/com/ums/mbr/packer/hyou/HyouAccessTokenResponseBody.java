package com.ums.mbr.packer.hyou;

/**
 * Author: ppwu@chinaums.com
 * Date: 2018/3/22 19:17
 */
public class HyouAccessTokenResponseBody extends HyouResponseBody {

    private String accessToken;
    private String time;
    private int expireIn;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }

}
