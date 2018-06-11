package com.ums.mbr.utils;

public class RequestParametersHolder {
    private MemberHashMap protocalMustParams;
    private MemberHashMap protocalOptParams;
    private MemberHashMap applicationParams;

    public MemberHashMap getProtocalMustParams() {
        return protocalMustParams;
    }
    public void setProtocalMustParams(MemberHashMap protocalMustParams) {
        this.protocalMustParams = protocalMustParams;
    }
    public MemberHashMap getProtocalOptParams() {
        return protocalOptParams;
    }
    public void setProtocalOptParams(MemberHashMap protocalOptParams) {
        this.protocalOptParams = protocalOptParams;
    }
    public MemberHashMap getApplicationParams() {
        return applicationParams;
    }
    public void setApplicationParams(MemberHashMap applicationParams) {
        this.applicationParams = applicationParams;
    }
    
}
