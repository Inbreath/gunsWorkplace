package com.ums.mbr.enums;

public enum BizChannels {

    COUPON      ("umszj.paycode.coupon     ","优惠券      "),
    HANDMADE    ("umszj.paycode.handmade   ","手工券      "),
    SCORE       ("umszj.paycode.score      ","会员积分    "),
    DEPOSIT     ("umszj.paycode.deposit    ","储值卡      "),
    EMPLOYEE    ("umszj.paycode.emplyee    ","员工卡      "),
    GIFT        ("umszj.paycode.gift       ","礼品卡      "),
    PARKING     ("umszj.paycode.parking    ","停车券      "),
    BIRTHDAY    ("umszj.paycode.birthday   ","生日券      "),
    BANKCARD    ("umszj.paycode.bankcard   ","银行卡钱包  "),
    ALIPAY      ("umszj.paycode.alipay     ","支付宝钱包  "),
    WECHAT      ("umszj.paycode.wechat     ","微信钱包    "),
    UQRCODE     ("umszj.paycode.uqrcode    ","银联二维码  "),
    BESTPAY     ("umszj.paycode.bestpay    ","翼支付钱包  "),
    YIPAY       ("umszj.paycode.yipay      ","壹钱包      "),
    TONGPAY     ("umszj.paycode.tongpay    ","Pos通       "),
    KOUBEIPAY   ("umszj.paycode.koubeipay  ","口碑        "),
    CITIZENCARD ("umszj.paycode.citizencard","市民卡      "),
    ALLPAY      ("umszj.paycode.allpay     ","全民惠      "),
    CASHPAY     ("umszj.paycode.cashpay    ","现金支付    "),
    OTHERPAY    ("umszj.paycode.otherpay   ","其他支付方式");

    private String name;
    private String desc;

    BizChannels(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}