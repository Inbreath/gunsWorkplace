package com.ums.mbr.beans.request;

import java.io.Serializable;

public class OrderCommitRequestBody implements Serializable {

    private String out_trade_no;
    private String order_no;
    private String order_type;
    private String customer_id;
    private String trade_amount;
    private String fact_amount;
    private String discount_amount;
    private String score;
    private String pay_info;
    private String old_order_no;

    public String getOld_order_no() {
        return old_order_no;
    }

    public void setOld_order_no(String old_order_no) {
        this.old_order_no = old_order_no;
    }

    public String getPay_info() {
        return pay_info;
    }

    public void setPay_info(String pay_info) {
        this.pay_info = pay_info;
    }

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

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getTrade_amount() {
        return trade_amount;
    }

    public void setTrade_amount(String trade_amount) {
        this.trade_amount = trade_amount;
    }

    public String getFact_amount() {
        return fact_amount;
    }

    public void setFact_amount(String fact_amount) {
        this.fact_amount = fact_amount;
    }

    public String getDiscount_amount() {
        return discount_amount;
    }

    public void setDiscount_amount(String discount_amount) {
        this.discount_amount = discount_amount;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
