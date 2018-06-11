package com.ums.mbr.service.core.service.impl;

import com.ums.mbr.service.core.example.CustomerExample;
import com.ums.mbr.service.core.mapper.CustomerMapper;
import com.ums.mbr.service.core.service.CustomerService;
import com.ums.mbr.service.domain.Customer;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerMapper customerMapper;

    @Override
    public Customer findByCstmerTypeAndCardNo(String customerType, String cardNo) {

        CustomerExample example = new CustomerExample();
        CustomerExample.Criteria criteria = example.createCriteria();
        criteria.andCustomerTypeEqualTo(customerType);
        criteria.andCardNoEqualTo(cardNo);

        List<Customer> lists = customerMapper.selectByExample(example);

        if (null == lists || lists.size() == 0) return null;

        return lists.get(0);

    }

    @Override
    public int insertSelective(Customer customer) {
        return customerMapper.insertSelective(customer);
    }

    @Override
    public int updateByPrimaryKeySelective(Customer customer) {
        return customerMapper.updateByPrimaryKeySelective(customer);
    }
}
