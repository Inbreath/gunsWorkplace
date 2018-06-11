package com.ums.mbr.packer.gda;

/**
 * Author: jcouyang@chinaums.com
 * Date: 2018/3/7 10:55
 */
public class GdaAccessTokenResponseBody extends GdaResponseBody {
    private String access_token;
    private int expire_time;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpire_time() {
        return expire_time;
    }

    public void setExpire_time(int expire_time) {
        this.expire_time = expire_time;
    }
}
