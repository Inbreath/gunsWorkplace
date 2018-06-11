package com.ums.mbr.packer.hyou;

import com.ums.mbr.beans.response.HyouMemberQueryResponseSubBody;

import java.math.BigDecimal;
import java.util.List;

public class HyouMemberQueryResponseBody extends HyouResponseBody{

    private String memberPhone;
    private String entityCardId;
    private String balanceScore;
    private String groupBalance;
    private String memberDiscount;
    private List<HyouMemberQueryResponseSubBody> listMemberCoupon;


    public List<HyouMemberQueryResponseSubBody> getListMemberCoupon() {
        return listMemberCoupon;
    }

    public void setListMemberCoupon(List<HyouMemberQueryResponseSubBody> listMemberCoupon) {
        this.listMemberCoupon = listMemberCoupon;
    }

    public String getMemberDiscount() {
        return memberDiscount;
    }

    public void setMemberDiscount(String memberDiscount) {
        this.memberDiscount = memberDiscount;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public String getEntityCardId() {
        return entityCardId;
    }

    public void setEntityCardId(String entityCardId) {
        this.entityCardId = entityCardId;
    }

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


}
