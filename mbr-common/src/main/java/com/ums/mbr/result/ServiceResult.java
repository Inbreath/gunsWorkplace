package com.ums.mbr.result;

import java.io.Serializable;
import java.util.Map;

/**
 * Author: jcouyang@chinaums.com
 * Date: 2018/3/7 9:46
 */
public class ServiceResult implements Serializable {
    private static final long serialVersionUID = -486427714019016239L;

    private String code;
    private String message;
    private Map<String, String> retMap;
    private Object object;

    public ServiceResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        if (message.length() < 100) {
            this.message = message;
        } else {
            this.message = message.substring(0, 100);
        }
    }

    public Map<String, String> getRetMap() {
        return retMap;
    }

    public void setRetMap(Map<String, String> retMap) {
        this.retMap = retMap;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
