package com.ums.mbr.packer.hyou;

/**
 * 国大的返回，公共部分
 * Author: jcouyang@chinaums.com
 * Date: 2018/3/7 10:53
 */
public class HyouResponse<T> {

    private String flag;
    private T result;
    private String code;
    private String msg;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}
