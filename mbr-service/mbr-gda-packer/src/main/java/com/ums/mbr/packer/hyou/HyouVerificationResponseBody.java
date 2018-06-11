package com.ums.mbr.packer.hyou;

public class HyouVerificationResponseBody extends HyouResponseBody{

    private String entityCardId;
    private String memberPhone;
    private String totalFee;
    private String totDisCash;
    private String balanceScore;
    private String groupBalance;

    public String getBalanceScore() {
        return balanceScore;
    }

    public void setBalanceScore(String balanceScore) {
        this.balanceScore = balanceScore;
    }

    public String getGroupBalance() {
        return groupBalance;
    }

    public void setGroupBalance(String groupBalance) {
        this.groupBalance = groupBalance;
    }

    public String getEntityCardId() {
        return entityCardId;
    }

    public void setEntityCardId(String entityCardId) {
        this.entityCardId = entityCardId;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }

    public String getTotDisCash() {
        return totDisCash;
    }

    public void setTotDisCash(String totDisCash) {
        this.totDisCash = totDisCash;
    }




}
