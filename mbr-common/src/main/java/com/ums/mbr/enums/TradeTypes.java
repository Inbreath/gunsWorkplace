package com.ums.mbr.enums;

/**
 * Author: jcouyang@chinaums.com
 * Date: 2018/4/11 16:18
 */
public enum TradeTypes {

    SALE    ("TRADE_SALE"      , "消费"),
    VOID    ("TRADE_VOID"      , "撤销"),
    REFOUND ("TRADE_REFOUND"   , "退货"),
    ;

    private String name;
    private String message;

    TradeTypes(String name, String message) {
        this.name = name;
        this.message = message;
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
