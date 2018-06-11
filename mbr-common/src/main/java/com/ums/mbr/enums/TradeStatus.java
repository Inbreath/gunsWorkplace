package com.ums.mbr.enums;

/**
 * Author: jcouyang@chinaums.com
 * Date: 2018/4/11 16:18
 */
public enum TradeStatus {

    START    ("1", "TRADE_START"   , "交易已创建"),
    SUCCESS  ("2", "TRADE_SUCCESS" , "交易成功"),
    FAILED   ("3", "TRADE_FAILED"  , "交易失败"),
    CANCELED ("4", "TRADE_CANCELED", "交易已撤销"),
    ;

    private String code;
    private String name;
    private String message;

    TradeStatus(String code, String name, String message) {
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
