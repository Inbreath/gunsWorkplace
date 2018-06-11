package com.ums.mbr.beans.request;

import java.io.Serializable;

/**
 * Author: jcouyang@chinaums.com
 * Date: 2018/4/4 10:34
 */
public class VerificationCancelRequestBody implements Serializable {

    private static final long serialVersionUID = -6290282228628303289L;
    private String out_trade_no;
    private String order_no;
    private String old_trade_no;
    private String old_order_no;

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getOld_trade_no() {
        return old_trade_no;
    }

    public void setOld_trade_no(String old_trade_no) {
        this.old_trade_no = old_trade_no;
    }

    public String getOld_order_no() {
        return old_order_no;
    }

    public void setOld_order_no(String old_order_no) {
        this.old_order_no = old_order_no;
    }
}
