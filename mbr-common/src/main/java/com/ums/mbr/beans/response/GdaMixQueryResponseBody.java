package com.ums.mbr.beans.response;

import java.util.List;

public class GdaMixQueryResponseBody {

    private GdaMixQueryResponseSubBody subBody;
    private List<GdaMixQueryResponseSubBody> subBodyList;
    private String code;
    private String message;

    public List<GdaMixQueryResponseSubBody> getSubBodyList() {
        return subBodyList;
    }

    public void setSubBodyList(List<GdaMixQueryResponseSubBody> subBodyList) {
        this.subBodyList = subBodyList;
    }

    public GdaMixQueryResponseBody (String code, String message) {
        this.code = code;
        this.message = message;
    }

    public GdaMixQueryResponseSubBody getSubBody() {
        return subBody;
    }

    public void setSubBody(GdaMixQueryResponseSubBody subBody) {
        this.subBody = subBody;
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
        this.message = message;
    }
}
