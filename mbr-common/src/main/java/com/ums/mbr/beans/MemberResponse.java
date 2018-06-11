package com.ums.mbr.beans;

import java.io.Serializable;

/**
 * 前端报文返回公共部分
 *
 * @author jcouyang@chinaums.com
 * @date 2018-02-28
 */
public class MemberResponse implements Serializable {

    private static final long serialVersionUID = -2428845105080906865L;
    private String merchant_id;
    private String terminal_id;
    private String exmerchant_id;
    private String exterminal_id;
    private String operator_id;
    private String device_id;
    private String request_id;
    private String timestamp;
    private String biz_channel;
    private String biz_type;
    private String biz_agency;
    private String biz_content;
    private String code;
    private String message;
    private String sub_code;
    private String sub_message;
    private String version;
    private String sign;
    private String sign_type;
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

    public String getExmerchant_id() {
        return exmerchant_id;
    }

    public void setExmerchant_id(String exmerchant_id) {
        this.exmerchant_id = exmerchant_id;
    }

    public String getExterminal_id() {
        return exterminal_id;
    }

    public void setExterminal_id(String exterminal_id) {
        this.exterminal_id = exterminal_id;
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

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getBiz_channel() {
        return biz_channel;
    }

    public void setBiz_channel(String biz_channel) {
        this.biz_channel = biz_channel;
    }

    public String getBiz_type() {
        return biz_type;
    }

    public void setBiz_type(String biz_type) {
        this.biz_type = biz_type;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSub_code() {
        return sub_code;
    }

    public void setSub_code(String sub_code) {
        this.sub_code = sub_code;
    }

    public String getSub_message() {
        return sub_message;
    }

    public void setSub_message(String sub_message) {
        this.sub_message = sub_message;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getSign_format() {
        return sign_format;
    }

    public void setSign_format(String sign_format) {
        this.sign_format = sign_format;
    }
}
