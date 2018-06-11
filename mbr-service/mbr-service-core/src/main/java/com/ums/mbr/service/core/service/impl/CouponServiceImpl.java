package com.ums.mbr.service.core.service.impl;

import com.ums.mbr.enums.CustomerTypes;
import com.ums.mbr.service.core.example.CouponExample;
import com.ums.mbr.service.core.example.CustomerExample;
import com.ums.mbr.service.core.mapper.CouponMapper;
import com.ums.mbr.service.core.service.CouponService;
import com.ums.mbr.service.domain.Coupon;
import com.ums.mbr.utils.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {

    @Resource
    private CouponMapper couponMapper;

    @Override
    public Coupon findByMVPD(String customerType, String verifyNo, String payCode, String customerId) {

        CouponExample example = new CouponExample();
        CouponExample.Criteria criteria = example.createCriteria();

        if (CustomerTypes.MEMBER.getName().equals(customerType)) {
            criteria.andCustomerTypeEqualTo(CustomerTypes.MEMBER.getName());
        }

        criteria.andCouponNoEqualTo(verifyNo);
        criteria.andPayCodeEqualTo(payCode);

        if (StringUtils.isNotEmpty(customerId)) {
            criteria.andCustomerIdEqualTo(customerId);
        }

        List<Coupon> lists = couponMapper.selectByExample(example);

        if (null == lists || lists.size() == 0) return null;

        return lists.get(0);

    }

    @Override
    public int insertSelective(Coupon coupon) {
        return couponMapper.insertSelective(coupon);
    }

    @Override
    public int updateByPrimaryKeySelective(Coupon coupon) {
        return couponMapper.updateByPrimaryKeySelective(coupon);
    }

//    @Override
//    public int updateByPrimaryKey(Customer customer) {
//        return customerMapper.updateByPrimaryKeySelective(customer);
//    }
}
