package com.ums.mbr.packer.gda.request;

/**
 * Author: jcouyang@chinaums.com
 * Date: 2018/4/13 15:35
 */
public class GdaGenerateParkingCouponRequestBody extends GdaBaseRequestBody {
    private String amount;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
