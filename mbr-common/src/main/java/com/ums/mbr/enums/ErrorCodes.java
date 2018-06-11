package com.ums.mbr.enums;

public enum ErrorCodes {
    SYS_SUCCESS               ("0000", "SYS_SUCCESS"               , "交易成功"               ),
    SYS_SYSTEM_ERROR          ("0001", "SYS_SYSTEM_ERROR"          , "系统异常"               ),
    SYS_PARAMETER_INVALID     ("0002", "SYS_PARAMETER_INVALID"     , "参数无效"               ),
    SYS_DATABASE_ERROR        ("0003", "SYS_DATABASE_ERROR"        , "数据库异常"             ),
    SYS_SIGNATURE_ERROR       ("0004", "SYS_SIGNATURE_ERROR"       , "签名错误"               ),
    SYS_MCHT_NOT_EXIST        ("0005", "SYS_MCHT_NOT_EXIST"        , "商户不存在"             ),
    SYS_TERM_NOT_EXIST        ("0006", "SYS_TERM_NOT_EXIST"        , "终端不存在"             ),
    SYS_MCHT_NOT_SIGN_CHANNEL ("0007", "SYS_MCHT_NOT_SIGN_CHANNEL" , "商户未签约渠道"         ),
    SYS_TERM_NOT_SIGN_CHANNEL ("0008", "SYS_TERM_NOT_SIGN_CHANNEL" , "终端未签约渠道"         ),
    SYS_UNKNOWN_BIZ_TYPE      ("0009", "SYS_UNKNOWN_BIZ_TYPE"      , "未知交易类型"           ),
    SYS_BIZ_TYPE_STATUS_ERROR ("0010", "SYS_BIZ_TYPE_STATUS_ERROR" , "交易类型状态关闭"       ),
    SYS_OTA_COUNT_OVERFLOW    ("0011", "SYS_OTA_COUNT_OVERFLOW"    , "8小时内OTA次数超限"     ),
    SYS_AMOUNT_OVERFLOW       ("0012", "SYS_AMOUNT_OVERFLOW"       , "退款金额超限或交易已撤销"),
    SYS_TRANS_NOT_FOUND       ("0013", "SYS_TRANS_NOT_FOUND"       , "找不到交易订单"         ),
    SYS_FAILURE               ("0014", "SYS_FAILURE"               , "交易失败"              ),
    SYS_MCHT_STAT_ERROR       ("0015", "SYS_MCHT_STAT_ERROR"       , "商户状态异常"           ),
    SYS_TERM_STAT_ERROR       ("0016", "SYS_TERM_STAT_ERROR"       , "终端状态异常"           ),
    SYS_OTA_CHKVAL_ERROR      ("0017", "SYS_OTA_CHKVAL_ERROR"      , "OTA校验值错误"          ),
    SYS_MALL_NOT_EXIST        ("0018", "SYS_MALL_NOT_EXIST"        , "渠道方不存在"           ),
    SYS_UNKNOWN_PAY_CODE      ("0019", "SYS_UNKNOWN_PAY_CODE"      , "支付方式不存在"         ),
    SYS_MALL_STATUS_ERROR     ("0020", "SYS_MALL_STATUS_ERROR"     , "渠道方状态关闭"         ),
    SYS_PAY_CODE_STATUS_ERROR ("0021", "SYS_PAY_CODE_STATUS_ERROR" , "支付方式状态关闭"       ),
    SYS_OUT_TRADE_NO_REPEAT   ("0022", "SYS_OUT_TRADE_NO_REPEAT"   , "外部交易号重复"         ),
    SYS_ORDER_NO_REQUEST_ERROR("0023", "SYS_ORDER_NO_REQUEST_ERROR", "订单号请求出错"         ),
    SYS_UNKNOWN_BIZ_CHANNEL   ("0024", "SYS_UNKNOWN_BIZ_CHANNEL"   , "未知券码类型"           ),
    SYS_TRANS_ALREADY_CANCEL  ("0025", "SYS_TRANS_ALREADY_CANCEL"  , "交易已撤销"             ),
    SYS_INPUT_TYPE_ERROR      ("0026", "SYS_INPUT_TYPE_ERROR"      , "错误的券码输入方式"      ),
    SYS_AMUNT_OR_SCORE_ERROR  ("0027", "SYS_AMUNT_OR_SCORE_ERROR"  , "金额或者积分输入错误"    ),
    SYS_QUERY_TRANS_ERROR     ("0028", "SYS_QUERY_TRANS_ERROR"     , "核销交易查询出错"        ),
    SYS_ORDER_STATE_ERROR     ("0029", "SYS_ORDER_STATE_ERROR"     , "订单不存在或状态出错"    ),
    SYS_ORDER_AMOUNT_ERROR    ("0030", "SYS_ORDER_AMOUNT_ERROR"    , "订单金额没有上送或无效"   ),


    ;


    private String code;
    private String stat;
    private String message;

    ErrorCodes(String code, String stat, String message) {
        this.code = code;
        this.stat = stat;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
