package com.ums.mbr.packer.gda.request;

/**
 * Author: jcouyang@chinaums.com
 * Date: 2018/4/13 15:22
 */
public class GdaEmplyeeQueryRequestBody extends GdaBaseRequestBody {
    private String qrcode;

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }
}
