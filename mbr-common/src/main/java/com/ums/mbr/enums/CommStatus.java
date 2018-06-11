package com.ums.mbr.enums;

public enum CommStatus {

    ON  ("on"  , "开启"),
    OFF ("off" , "关闭"),
    OTH ("oth" , "其他");

    private String stat;
    private String desc;

    CommStatus(String stat, String desc) {
        this.stat = stat;
        this.desc = desc;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
