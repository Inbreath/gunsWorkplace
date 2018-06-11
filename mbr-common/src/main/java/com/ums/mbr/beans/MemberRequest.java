package com.ums.mbr.beans;

import com.ums.mbr.utils.DateUtils;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 前端报文请求公共部分
 * @author jcouyang@chinaums.com
 * @date 2018-02-28
 */
public class MemberRequest implements Serializable {

    private static final long serialVersionUID = -6962796352188177678L;
    private String merchant_id;
    private String terminal_id;
    private String request_id;
    private String operator_id;
    private String device_id;
    private String timestamp;
    private String biz_type;
    private String biz_channel;
    private String biz_agency;
    private String biz_content;
    private String sign_type = "RSA";
    private String sign;
    private String version = "1.0.0";
    private String app_info;
    private String notify_url;
    private String sign_format;

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }

    public String getTerminal_id() {
        return terminal_id;
    }

    public void setTerminal_id(String terminal_id) {
        this.terminal_id = terminal_id;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public String getOperator_id() {
        return operator_id;
    }

    public void setOperator_id(String operator_id) {
        this.operator_id = operator_id;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getTimestamp() {
        return timestamp = timestamp == null ? DateUtils.formatNowTime() : timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getBiz_type() {
        return biz_type;
    }

    public void setBiz_type(String biz_type) {
        this.biz_type = biz_type;
    }

    public String getBiz_channel() {
        return biz_channel;
    }

    public void setBiz_channel(String biz_channel) {
        this.biz_channel = biz_channel;
    }

    public String getBiz_agency() {
        return biz_agency;
    }

    public void setBiz_agency(String biz_agency) {
        this.biz_agency = biz_agency;
    }

    public String getBiz_content() {
        return biz_content;
    }

    public void setBiz_content(String biz_content) {
        this.biz_content = biz_content;
    }

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getApp_info() {
        return app_info;
    }

    public void setApp_info(String app_info) {
        this.app_info = app_info;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getSign_format() {
        return sign_format;
    }

    public void setSign_format(String sign_format) {
        this.sign_format = sign_format;
    }
}
