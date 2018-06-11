package com.ums.mbr.beans.request;

import java.io.Serializable;

/**
 * Author: jcouyang@chinaums.com
 * Date: 2018/4/4 10:34
 */
public class VerificationTradeRequestBody implements Serializable {

    private String out_trade_no;
    private String order_no;
    private String batch_no;
    private String trace_no;
    private String pay_code;
    private String customer_type;
    private String customer_id;
    private String card_no;
    private String telephone;
    private String trade_amount;
    private String sub_trade_amount;
    private String dis_amount;
    private String fact_amount;
    private String score;
    private String input_type;
    private String subject;
    private String goods_detail;
    private String coupon_list;

    public String getPay_code() {
        return pay_code;
    }

    public void setPay_code(String pay_code) {
        this.pay_code = pay_code;
    }

    public String getTrade_amount() {
        return trade_amount;
    }

    public void setTrade_amount(String trade_amount) {
        this.trade_amount = trade_amount;
    }

    public String getSub_trade_amount() {
        return sub_trade_amount;
    }

    public void setSub_trade_amount(String sub_trade_amount) {
        this.sub_trade_amount = sub_trade_amount;
    }

    public String getInput_type() {
        return input_type == null? "":input_type;
    }

    public void setInput_type(String input_type) {
        this.input_type = input_type;
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

    public String getBatch_no() {
        return batch_no;
    }

    public void setBatch_no(String batch_no) {
        this.batch_no = batch_no;
    }

    public String getTrace_no() {
        return trace_no;
    }

    public void setTrace_no(String trace_no) {
        this.trace_no = trace_no;
    }

    public String getCustomer_type() {
        return customer_type;
    }

    public void setCustomer_type(String customer_type) {
        this.customer_type = customer_type;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDis_amount() {
        return dis_amount;
    }

    public void setDis_amount(String dis_amount) {
        this.dis_amount = dis_amount;
    }

    public String getFact_amount() {
        return fact_amount;
    }

    public void setFact_amount(String fact_amount) {
        this.fact_amount = fact_amount;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getGoods_detail() {
        return goods_detail;
    }

    public void setGoods_detail(String goods_detail) {
        this.goods_detail = goods_detail;
    }

    public String getCoupon_list() {
        return coupon_list;
    }

    public void setCoupon_list(String coupon_list) {
        this.coupon_list = coupon_list;
    }
}
