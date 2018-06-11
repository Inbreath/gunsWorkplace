package com.ums.mbr.service.core.service;

import com.ums.mbr.service.domain.Card;

public interface CardService {

    /**
     * 插入card信息
     * @param card
     * @return
     */
    int insertSelective(Card card);

    /**
     * @param customerType
     * @param cardNo
     * @return
     */
    Card findByCstmerTypeAndCardNo(String customerType, String cardNo);

    /**
     * 更新card信息
     * @param card
     * @return
     */
    int updateByPrimaryKeySelective(Card card);

}
