package com.ums.mbr.service.core.service.impl;

import com.ums.mbr.service.core.example.CardExample;
import com.ums.mbr.service.core.mapper.CardMapper;
import com.ums.mbr.service.core.service.CardService;
import com.ums.mbr.service.domain.Card;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Resource
    private CardMapper cardMapper;

    @Override
    public int insertSelective(Card card) {
        return cardMapper.insertSelective(card);
    }

    @Override
    public Card findByCstmerTypeAndCardNo(String customerType, String cardNo) {
        CardExample example = new CardExample();
        CardExample.Criteria criteria = example.createCriteria();
        criteria.andCustomerTypeEqualTo(customerType);
        criteria.andCardNoEqualTo(cardNo);

        List<Card> lists = cardMapper.selectByExample(example);

        if (null == lists || lists.size() == 0) return null;

        return lists.get(0);
    }

    @Override
    public int updateByPrimaryKeySelective(Card card) {

        return cardMapper.updateByPrimaryKeySelective(card);
    }
}
