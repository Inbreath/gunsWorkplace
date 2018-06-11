package com.ums.mbr.beans.response;

import java.io.Serializable;

/**
 * OTA交易返回业务数据部分
 *
 * @author jcouyang@chinaums.com
 * @date 2018-02-28
 */
public class OTAResponseBody implements Serializable {
    private static final long serialVersionUID = -8265365957709469530L;
    private String out_trade_no;
    private String private_key;
    private String public_key;

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getPrivate_key() {
        return private_key;
    }

    public void setPrivate_key(String private_key) {
        this.private_key = private_key;
    }

    public String getPublic_key() {
        return public_key;
    }

    public void setPublic_key(String public_key) {
        this.public_key = public_key;
    }
}
