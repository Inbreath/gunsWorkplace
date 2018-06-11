package com.ums.mbr.packer.hyou;

public class HyouMixQueryResponseBody extends HyouResponseBody{

    private String member_id;
    private String member_nick_name;
    private String score;
    private String pay_state;
    private String entity_card_id;
    private String pay_order;
    private String group_fee;
    private String total_fee;
    private String pay_fee;
    private String member_name;

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getMember_nick_name() {
        return member_nick_name;
    }

    public void setMember_nick_name(String member_nick_name) {
        this.member_nick_name = member_nick_name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getPay_state() {
        return pay_state;
    }

    public void setPay_state(String pay_state) {
        this.pay_state = pay_state;
    }

    public String getEntity_card_id() {
        return entity_card_id;
    }

    public void setEntity_card_id(String entity_card_id) {
        this.entity_card_id = entity_card_id;
    }

    public String getPay_order() {
        return pay_order;
    }

    public void setPay_order(String pay_order) {
        this.pay_order = pay_order;
    }

    public String getGroup_fee() {
        return group_fee;
    }

    public void setGroup_fee(String group_fee) {
        this.group_fee = group_fee;
    }

    public String getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }

    public String getPay_fee() {
        return pay_fee;
    }

    public void setPay_fee(String pay_fee) {
        this.pay_fee = pay_fee;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }
}
