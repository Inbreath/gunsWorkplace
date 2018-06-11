package com.ums.mbr.beans.request;

import java.io.Serializable;

/**
 * 终端绑定交易请求业务数据部分
 *
 * @author jcouyang@chinaums.com
 * @date 2018-03-01
 */
public class PosValidateRequestBody implements Serializable {
    private static final long serialVersionUID = -1118318503651533866L;

    private String out_trade_no;
    private String manager_id;

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getManager_id() {
        return manager_id;
    }

    public void setManager_id(String manager_id) {
        this.manager_id = manager_id;
    }

}
