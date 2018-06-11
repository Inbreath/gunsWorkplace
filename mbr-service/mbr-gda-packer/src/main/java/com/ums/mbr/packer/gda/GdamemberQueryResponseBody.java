package com.ums.mbr.packer.gda;

import com.ums.mbr.beans.MemberCard;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: pwwug@chinaums.com
 * Date: 2018/3/15 9:20
 */
public class GdamemberQueryResponseBody<T> extends GdaResponseBody {

    private String name; //姓名
    private String memberId; //会员ID
    private String telephone; //手机号
    private String gender; //性别
    private String birthday; //生日
    private List<T> card ; //会员卡信息

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List<T> getCard() {
        return card;
    }

    public void setCard(List<T> card) {
        this.card = card;
    }

}
