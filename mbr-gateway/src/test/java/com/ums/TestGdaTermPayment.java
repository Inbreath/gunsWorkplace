package com.ums;

public class TestGdaTermPayment {

    private String sub_trade_no; //该交易所发生的交易标识号
    private String sub_out_trade_no; //该交易所发生的交易标识号
    private String trade_state;

    private String sub_trade_amount;
    private String sub_fact_amount;
    private String verify_no;
    private String card_no;
    private String pay_time; //
    private String pay_code; //


    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }

    public String getSub_out_trade_no() {
        return sub_out_trade_no;
    }

    public void setSub_out_trade_no(String sub_out_trade_no) {
        this.sub_out_trade_no = sub_out_trade_no;
    }

    public String getSub_trade_amount() {
        return sub_trade_amount;
    }

    public void setSub_trade_amount(String sub_trade_amount) {
        this.sub_trade_amount = sub_trade_amount;
    }

    public String getSub_trade_no() {
        return sub_trade_no;
    }

    public void setSub_trade_no(String sub_trade_no) {
        this.sub_trade_no = sub_trade_no;
    }

    public String getVerify_no() {
        return verify_no;
    }

    public void setVerify_no(String verify_no) {
        this.verify_no = verify_no;
    }

    public String getTrade_state() {
        return trade_state;
    }

    public void setTrade_state(String trade_state) {
        this.trade_state = trade_state;
    }

    public String getSub_fact_amount() {
        return sub_fact_amount;
    }

    public void setSub_fact_amount(String sub_fact_amount) {
        this.sub_fact_amount = sub_fact_amount;
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



}
