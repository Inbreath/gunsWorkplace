package com.ums.mbr.beans.request;

import java.io.Serializable;

public class CouponBuiltRequestBody implements Serializable {

    private String out_trade_no;
    private String amount;

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
