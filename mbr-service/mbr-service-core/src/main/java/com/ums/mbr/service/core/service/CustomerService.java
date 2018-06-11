package com.ums.mbr.service.core.service;

import com.ums.mbr.service.domain.Customer;

public interface CustomerService {

    /**
     * 根据客户类型和卡号进行查询
     * @param customerType 客户类型
     * @param cardNo  卡号
     * @return
     */
    Customer findByCstmerTypeAndCardNo(String customerType, String cardNo);

    /**
     * 插入客户信息
     * @param customer 客户信息
     * @return
     */
    int insertSelective(Customer customer);

    /**
     * 更新客户信息
     * @param customer 客户信息
     * @return
     */
    int updateByPrimaryKeySelective(Customer customer);
}
