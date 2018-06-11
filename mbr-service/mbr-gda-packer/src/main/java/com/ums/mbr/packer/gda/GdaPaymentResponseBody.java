package com.ums.mbr.packer.gda;

import java.math.BigDecimal;

public class GdaPaymentResponseBody extends GdaResponseBody{

    private String transNo;
    private String cardNo;
    private String cardName;
    private BigDecimal remainCash;
    private BigDecimal remainAmount;


    public String getTransNo() {
        return transNo;
    }

    public void setTransNo(String transNo) {
        this.transNo = transNo;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public BigDecimal getRemainCash() {
        return remainCash;
    }

    public void setRemainCash(BigDecimal remainCash) {
        this.remainCash = remainCash;
    }

    public BigDecimal getRemainAmount() {
        return remainAmount;
    }

    public void setRemainAmount(BigDecimal remainAmount) {
        this.remainAmount = remainAmount;
    }
}
