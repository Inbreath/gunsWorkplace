package com.ums.mbr.beans.response;

public class GdaMixQueryResponseSubBody{

    private String sub_trade_no;
    private String sub_order_no;
    private String sub_trade_type;
    private String pay_time;
    private String pay_code;
    private String card_no;
    private String trade_amount;
    private String fact_amount;
    private String score;
    private String refund_amount;
    private String refund_score;

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

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getSub_trade_type() {
        return sub_trade_type;
    }

    public void setSub_trade_type(String sub_trade_type) {
        this.sub_trade_type = sub_trade_type;
    }

    public String getSub_trade_no() {
        return sub_trade_no;
    }

    public void setSub_trade_no(String sub_trade_no) {
        this.sub_trade_no = sub_trade_no;
    }

    public String getSub_order_no() {
        return sub_order_no;
    }

    public void setSub_order_no(String sub_order_no) {
        this.sub_order_no = sub_order_no;
    }

    public String getPay_time() {
        return pay_time;
    }

    public void setPay_time(String pay_time) {
        this.pay_time = pay_time;
    }

    public String getPay_code() {
        return pay_code;
    }

    public void setPay_code(String pay_code) {
        this.pay_code = pay_code;
    }

    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }

    public String getRefund_amount() {
        return refund_amount;
    }

    public void setRefund_amount(String refund_amount) {
        this.refund_amount = refund_amount;
    }

    public String getRefund_score() {
        return refund_score;
    }

    public void setRefund_score(String refund_score) {
        this.refund_score = refund_score;
    }
}
