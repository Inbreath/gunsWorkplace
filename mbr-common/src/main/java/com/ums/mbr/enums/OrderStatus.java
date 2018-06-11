package com.ums.mbr.enums;

public enum OrderStatus {
    PAYING      ("1", "ORDER_PAYING"        , "等待支付"),
    SUCCESS     ("2", "ORDER_SUCCESS"       , "订单成功"),
    FAILED      ("3", "ORDER_FAILED"        , "订单失败"),
    CANCELED    ("4", "ORDER_CANCELED"      , "订单撤销"),
    PART_REFUND ("5", "ORDER_PART_REFUND"   , "部分退货"),
    FULL_REFUND ("6", "ORDER_FULL_REFUND"   , "全部退货"),
    UNKNOWN     ("7", "ORDER_UNKNOWN"       , "状态未知"),

    ;

    private String code;
    private String name;
    private String message;

    OrderStatus(String code, String name, String message) {
        this.code = code;
        this.name = name;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
