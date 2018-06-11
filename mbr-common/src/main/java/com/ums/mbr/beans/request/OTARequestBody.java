package com.ums.mbr.beans.request;

import java.io.Serializable;

/**
 * OTA交易请求业务数据部分
 *
 * @author jcouyang@chinaums.com
 * @date 2018-02-28
 */
public class OTARequestBody implements Serializable {

    private static final long serialVersionUID = 6085938540913893473L;
    private String out_trade_no;
    private int idx;
    private String chkval;
    private String randval;

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getChkval() {
        return chkval;
    }

    public void setChkval(String chkval) {
        this.chkval = chkval;
    }

    public String getRandval() {
        return randval;
    }

    public void setRandval(String randval) {
        this.randval = randval;
    }
}
