package com.ums.mbr.service.core.facade;

import com.ums.mbr.enums.OrderStatus;
import com.ums.mbr.service.core.service.OrderInfService;
import com.ums.mbr.service.core.service.TransLogService;
import com.ums.mbr.service.domain.*;
import com.ums.mbr.utils.DateUtils;
import com.ums.mbr.utils.MemberUtils;

import java.util.Date;

/**
 * Author: jcouyang@chinaums.com
 * Date: 2018/3/12 10:02
 */
public class BaseFacade {

    protected static final String ERROR_RETSERIAL = "000000";

    /**
     * 交易前记库，并生成系统全局唯一的交易号
     * @param transLogService
     * @param transLog
     * @return
     */
    protected String createTransLog(TransLogService transLogService, TransLog transLog) {

        String retserial = ERROR_RETSERIAL;
        if (isOutTradeNoExists(transLogService, transLog.getMchtno(), transLog.getOutTradeNo())) {
            return retserial;
        }

        /**
         * T 交易号，即tradeNo
         * R 订单号，即orderNo
         * K 主键，对应retserial，部分可以添加自定义的前缀，如慧优为HYK，国大为GDK
         */

        // 第一步，记录transLog操作日志
        // 生成系统的订单号
        retserial = "K" +  DateUtils.formatNowId() + String.format("%06d", (int) (Math.random() * 1000000));
        transLog.setRetserial(retserial);
        // 平台订单号复用该字段
        transLog.setTradeNo(retserial.replace("K", "T"));

        transLog.setCreateIp(MemberUtils.getLocalNetWorkIp());
        transLog.setMachine(MemberUtils.getHostNameForLiunx());

        transLogService.insert(transLog);

        return retserial;
    }

    /**
     * 检查外部流水号，生成系统全局唯一的交易号
     * @param transLogService
     * @param transLog
     * @return
     */
    protected String createRetserial(TransLogService transLogService, TransLog transLog) {

        String retserial = ERROR_RETSERIAL;
        if (isOutTradeNoExists(transLogService, transLog.getMchtno(), transLog.getOutTradeNo())) {
            return retserial;
        }

        // 生成系统的订单号
        retserial = DateUtils.formatNowId() + String.format("%01d", (int) (Math.random() * 10));

        return retserial;
    }

    /**
     * 生成订单号
     * @param mchtId
     * @param termId
     * @param orderInfService
     * @return
     */
    protected String createOrerinf(String mchtId, String termId, OrderInfService orderInfService) {

        OrderInf orderInf = new OrderInf();

        String orderNo = "R" + DateUtils.formatNowId() + String.format("%06d", (int) (Math.random() * 1000000));

        orderInf.setRetserial(orderNo.replace("R", "K"));
        orderInf.setOrderNo(orderNo);
        orderInf.setMchtno(mchtId);
        orderInf.setTermno(termId);
        orderInf.setState(OrderStatus.PAYING.getName());
        orderInf.setCreateTime(DateUtils.formatNowTime());

        return orderInfService.insertSelective(orderInf) > 0 ? orderNo : null;
    }


    /**
     * 检查商户下的外部交易号是否重复
     * @param transLogService
     * @param mchtNo 商户号
     * @param outTradeNo 外部交易号
     * @return
     */
    protected boolean isOutTradeNoExists(TransLogService transLogService, String mchtNo, String outTradeNo) {
        return transLogService.countByOutTradeNo(mchtNo, outTradeNo) > 0;
    }
}
