package com.ums.mbr;

import com.ums.mbr.packer.gda.GdaResponseBody;
import com.ums.mbr.packer.hyou.HyouResponseBody;

import java.util.List;

/**
 * Author: jcouyang@chinaums.com
 * Date: 2018/3/7 13:58
 */
public class TransResult {

    private String code;
    private String message;
    private GdaResponseBody body;
    private HyouResponseBody bodyHyou;
    private List<? extends GdaResponseBody> bodyList;

    public TransResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public List<? extends GdaResponseBody> getBodyList() {
        return bodyList;
    }

    public void setBodyList(List<? extends GdaResponseBody> bodyList) {
        this.bodyList = bodyList;
    }


    public HyouResponseBody getBodyHyou() {
        return bodyHyou;
    }

    public void setBodyHyou(HyouResponseBody bodyHyou) {
        this.bodyHyou = bodyHyou;
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
        if (message.length() <= 100) {
            this.message = message;
        }
        else {
            this.message = message.substring(0, 100);
        }
    }

    public GdaResponseBody getBody() {
        return body;
    }

    public void setBody(GdaResponseBody body) {
        this.body = body;
    }

}
