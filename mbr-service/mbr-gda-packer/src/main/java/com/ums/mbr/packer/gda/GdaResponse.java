package com.ums.mbr.packer.gda;

import java.util.Map;

/**
 * 国大的返回，公共部分
 * Author: jcouyang@chinaums.com
 * Date: 2018/3/7 10:53
 */
public class GdaResponse<T> {
    private int total;
    private String message;
    private T data;
    private String success;
    private String ajaxErrorCode;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getAjaxErrorCode() {
        return ajaxErrorCode;
    }

    public void setAjaxErrorCode(String ajaxErrorCode) {
        this.ajaxErrorCode = ajaxErrorCode;
    }
}
