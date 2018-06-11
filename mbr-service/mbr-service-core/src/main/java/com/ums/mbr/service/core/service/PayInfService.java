package com.ums.mbr.service.core.service;

import com.ums.mbr.service.domain.Payinf;

public interface PayInfService {

    int insertSelective(Payinf payinf);

    int updateByPrimaryKeySelective(Payinf payinf);

    int updateByOutTradeNoSelective(Payinf payinf);

    Payinf findPayInfByOutTradeNo(String outTradeNo, String transType);
}
