package com.ums.mbr.enums;

public enum BizAgencys {

    GDA      ("umszj.agency.guoda" ,"国大"),
    HYOU     ("umszj.agency.huiyou","慧优");

    private String name;
    private String desc;

    BizAgencys(String name, String desc) {
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
