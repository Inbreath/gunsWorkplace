package com.ums.mbr.beans.request;

import java.io.Serializable;

public class MixQueryRequestBody implements Serializable {

    private String query_order_no;
    private String query_trade_no;
    private String start_date;
    private String end_date;
    private String customer_id;
    private String customer_type;

    public String getCustomer_type() {
        return customer_type;
    }

    public void setCustomer_type(String customer_type) {
        this.customer_type = customer_type;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getQuery_order_no() {
        return query_order_no;
    }

    public void setQuery_order_no(String query_order_no) {
        this.query_order_no = query_order_no;
    }

    public String getQuery_trade_no() {
        return query_trade_no;
    }

    public void setQuery_trade_no(String query_trade_no) {
        this.query_trade_no = query_trade_no;
    }
}
