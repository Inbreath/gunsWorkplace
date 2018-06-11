package com.ums.mbr.service.facade;

import com.ums.mbr.result.ServiceResult;
import com.ums.mbr.service.domain.OrderInf;
import com.ums.mbr.service.domain.TransLog;

/**
 * 系统的交易，不涉及到后端交互
 * Author: jcouyang@chinaums.com
 * Date: 2018/3/8 14:16
 */
public interface SystemTransFacade {

    ServiceResult ota(TransLog transLog, int idx, String chkval, String randval);

    /**
     * 订单请求接口，参见接口文档3.4
     * @param transLog 终端上送的请求报文
     * @return
     */
    ServiceResult orderRequest(TransLog transLog);
}
