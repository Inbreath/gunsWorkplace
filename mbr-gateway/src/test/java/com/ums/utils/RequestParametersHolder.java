package com.ums.utils;

public class RequestParametersHolder {
    private UmisHashMap protocalMustParams;
    private UmisHashMap protocalOptParams;
    private UmisHashMap applicationParams;

    public UmisHashMap getProtocalMustParams() {
        return protocalMustParams;
    }
    public void setProtocalMustParams(UmisHashMap protocalMustParams) {
        this.protocalMustParams = protocalMustParams;
    }
    public UmisHashMap getProtocalOptParams() {
        return protocalOptParams;
    }
    public void setProtocalOptParams(UmisHashMap protocalOptParams) {
        this.protocalOptParams = protocalOptParams;
    }
    public UmisHashMap getApplicationParams() {
        return applicationParams;
    }
    public void setApplicationParams(UmisHashMap applicationParams) {
        this.applicationParams = applicationParams;
    }
    
}
