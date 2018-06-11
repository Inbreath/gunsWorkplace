package com.ums.mbr.beans.request;

import java.io.Serializable;

public class SubmitPaymentRequestBody implements Serializable {

    private String retserial;
    private String mchtNo;
    private String termNo;
    private String sub_out_trade_no; //
    private String sub_trade_no; //该交易所发生的交易标识号

    private String exmchtNo;
    private String extermNo;
    private String trade_state; //trans_type
    private String currency;
    private String sub_trade_amount;

    private String sub_fact_amount;
    private String sub_score;
    private String verify_no;
    private String pay_code; //
    private String customer_id;

    private String telephone;
    private String card_no;
    private String phone_code;
    private String create_time; //
    private String pay_time; //

    private String auth_code; //
    private String bank_name; //
    private String acquier_name; //
    private String version;
    private String create_ip;

    private String machine;
    private String batch_no; //
    private String trace_no;
    private String center_no;
    private String reference_no;


    private String note;
 ////////////////////////////////////////////////////////

    private String order_no;
    private String trade_amount;
    private String original_trade_no; //
    private String trade_desc;
    private String old_info;

    public String getRetserial() {
        return retserial;
    }

    public void setRetserial(String retserial) {
        this.retserial = retserial;
    }

    public String getMchtNo() {
        return mchtNo;
    }

    public void setMchtNo(String mchtNo) {
        this.mchtNo = mchtNo;
    }

    public String getTermNo() {
        return termNo;
    }

    public void setTermNo(String termNo) {
        this.termNo = termNo;
    }

    public String getSub_out_trade_no() {
        return sub_out_trade_no;
    }

    public void setSub_out_trade_no(String sub_out_trade_no) {
        this.sub_out_trade_no = sub_out_trade_no;
    }

    public String getSub_trade_no() {
        return sub_trade_no;
    }

    public void setSub_trade_no(String sub_trade_no) {
        this.sub_trade_no = sub_trade_no;
    }

    public String getExmchtNo() {
        return exmchtNo;
    }

    public void setExmchtNo(String exmchtNo) {
        this.exmchtNo = exmchtNo;
    }

    public String getExtermNo() {
        return extermNo;
    }

    public void setExtermNo(String extermNo) {
        this.extermNo = extermNo;
    }

    public String getTrade_state() {
        return trade_state;
    }

    public void setTrade_state(String trade_state) {
        this.trade_state = trade_state;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSub_trade_amount() {
        return sub_trade_amount;
    }

    public void setSub_trade_amount(String sub_trade_amount) {
        this.sub_trade_amount = sub_trade_amount;
    }

    public String getSub_fact_amount() {
        return sub_fact_amount;
    }

    public void setSub_fact_amount(String sub_fact_amount) {
        this.sub_fact_amount = sub_fact_amount;
    }

    public String getSub_score() {
        return sub_score;
    }

    public void setSub_score(String sub_score) {
        this.sub_score = sub_score;
    }

    public String getVerify_no() {
        return verify_no;
    }

    public void setVerify_no(String verify_no) {
        this.verify_no = verify_no;
    }

    public String getPay_code() {
        return pay_code;
    }

    public void setPay_code(String pay_code) {
        this.pay_code = pay_code;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }

    public String getPhone_code() {
        return phone_code;
    }

    public void setPhone_code(String phone_code) {
        this.phone_code = phone_code;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getPay_time() {
        return pay_time;
    }

    public void setPay_time(String pay_time) {
        this.pay_time = pay_time;
    }

    public String getAuth_code() {
        return auth_code;
    }

    public void setAuth_code(String auth_code) {
        this.auth_code = auth_code;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getAcquier_name() {
        return acquier_name;
    }

    public void setAcquier_name(String acquier_name) {
        this.acquier_name = acquier_name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCreate_ip() {
        return create_ip;
    }

    public void setCreate_ip(String create_ip) {
        this.create_ip = create_ip;
    }

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine;
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

    public String getCenter_no() {
        return center_no;
    }

    public void setCenter_no(String center_no) {
        this.center_no = center_no;
    }

    public String getOriginal_trade_no() {
        return original_trade_no;
    }

    public void setOriginal_trade_no(String original_trade_no) {
        this.original_trade_no = original_trade_no;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getReference_no() {
        return reference_no;
    }

    public void setReference_no(String reference_no) {
        this.reference_no = reference_no;
    }

    public String getOld_info() {
        return old_info;
    }

    public void setOld_info(String old_info) {
        this.old_info = old_info;
    }

    public String getTrade_desc() {
        return trade_desc;
    }

    public void setTrade_desc(String trade_desc) {
        this.trade_desc = trade_desc;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getTrade_amount() {
        return trade_amount;
    }

    public void setTrade_amount(String trade_amount) {
        this.trade_amount = trade_amount;
    }
}
