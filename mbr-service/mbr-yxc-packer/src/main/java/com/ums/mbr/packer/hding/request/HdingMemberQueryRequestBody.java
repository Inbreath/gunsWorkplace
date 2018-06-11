package com.ums.mbr.packer.hding.request;

public class HdingMemberQueryRequestBody extends HdingBaseRequestBody{
    private String accountType;             //  账户识别类型
    private String accountValue;            //  账户识别值

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountValue() {
        return accountValue;
    }

    public void setAccountValue(String accountValue) {
        this.accountValue = accountValue;
    }

}
