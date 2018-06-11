package com.ums.mbr.beans.response;

import java.io.Serializable;

/**
 * 终端绑定交易返回业务数据部分
 *
 * @author jcouyang@chinaums.com
 * @date 2018-03-01
 */
public class PosValidateResponseBody implements Serializable {
    private static final long serialVersionUID = 1927146900621597012L;

    private String out_trade_no;
    private String trade_no;
    private String store_name;

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }
}
