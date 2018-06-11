package com.ums.mbr.packer.gda;

/**
 * Author: jcouyang@chinaums.com
 * Date: 2018/3/7 13:43
 */
public class GdaPosValidateResponseBody extends GdaResponseBody {

    private String t_id; //终端ID
    private String storeId; //商铺代码|传入值
    private String terminalNo; //终端号|传入值
    private String storeName; //商铺名称
    private String contNo;
    private String itemCode;
    private String mkt;

    public String getT_id() {
        return t_id;
    }

    public void setT_id(String t_id) {
        this.t_id = t_id;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getTerminalNo() {
        return terminalNo;
    }

    public void setTerminalNo(String terminalNo) {
        this.terminalNo = terminalNo;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getContNo() {
        return contNo;
    }

    public void setContNo(String contNo) {
        this.contNo = contNo;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getMkt() {
        return mkt;
    }

    public void setMkt(String mkt) {
        this.mkt = mkt;
    }
}
