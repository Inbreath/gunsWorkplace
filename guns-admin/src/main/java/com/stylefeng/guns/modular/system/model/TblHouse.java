package com.stylefeng.guns.modular.system.model;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Allen123
 * @since 2018-05-14
 */
@TableName("tbl_house")
public class TblHouse extends Model<TblHouse> {

    private static final long serialVersionUID = 1L;

    private Integer id;
    @TableField("house_user")
    private String houseUser;
    @TableField("house_address")
    private String houseAddress;
    @TableField("house_date")
    private String houseDate;
    @TableField("house_desc")
    private String houseDesc;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHouseUser() {
        return houseUser;
    }

    public void setHouseUser(String houseUser) {
        this.houseUser = houseUser;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public String getHouseDate() {
        return houseDate;
    }

    public void setHouseDate(String houseDate) {
        this.houseDate = houseDate;
    }

    public String getHouseDesc() {
        return houseDesc;
    }

    public void setHouseDesc(String houseDesc) {
        this.houseDesc = houseDesc;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TblHouse{" +
        "id=" + id +
        ", houseUser=" + houseUser +
        ", houseAddress=" + houseAddress +
        ", houseDate=" + houseDate +
        ", houseDesc=" + houseDesc +
        "}";
    }
}
