package com.ums.mbr.enums;

public enum CustomerTypes {

    MEMBER   ("CUSTOMER_MEMBER"   , "会员"  ),
    EMPLOYEE ("CUSTOMER_EMPLOYEE" , "员工"  ),
    NONE     ("CUSTOMER_NONE"     , "未登录"),
    DEPOSIT  ("CUSTOMER_DEPOSIT"  , "储值卡");

    private String name;
    private String desc;

    CustomerTypes (String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}