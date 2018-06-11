package com.ums.mbr.enums;

public enum InputTypes {

    SCAN    ("1","INPUT_SCAN"   , "扫码"     ),
    CARD    ("A","INPUT_CARD"   , "刷卡"     ),
    COUPON  ("C","INPUT_COUPON" , "优惠券"   ),
    HAND    ("0","INPUT_HAND"   , "手工输入" );

    private String code;
    private String name;
    private String desc;

    InputTypes(String code, String name, String desc) {
        this.code = code;
        this.name = name;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}