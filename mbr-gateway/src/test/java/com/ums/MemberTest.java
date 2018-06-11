package com.ums;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ums.mbr.utils.DateUtils;
import com.ums.utils.WebUtils;
import net.minidev.json.JSONObject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberTest {
    private static final Logger logger = LoggerFactory.getLogger(MemberTest.class);
//   private final String url = "http://172.17.180.155:9901/member/gateway";
    private final String url = "https://test.zjpay.cn/member/gateway";

    @Test
    public void testdepositQuery() throws Exception {

        Map<String, String> params = new HashMap<>();
        params.put("merchant_id", "898330172992626");
        params.put("terminal_id", "09783109");
        params.put("biz_type"   , "umszj.member.memberQuery");
        params.put("biz_channel" , "umszj.paycode.deposit");
        params.put("biz_agency" , "umszj.agency.guoda");
        params.put("request_id" , "000049");

        //业务部分
        JSONObject biz_content = new JSONObject();
        biz_content.put("out_trade_no", DateUtils.formatNowId());
        biz_content.put("customer_type", "deposit");
        biz_content.put("input_type", "card");
        biz_content.put("card_no", "010000001634979356=10=1565684636");

        params.put("biz_content",biz_content.toString());

        String response = WebUtils.doPost(url, params, 3000, 60000);
        logger.info(response);
    }
    @Test
    public void testcashCouponQuery() throws Exception {

        Map<String, String> params = new HashMap<>();
        params.put("merchant_id", "898330172992626");
        params.put("terminal_id", "09783109");
        params.put("biz_type"   , "umszj.member.memberQuery");
        params.put("biz_channel" , "umszj.paycode.deposit");
        params.put("biz_agency" , "umszj.agency.guoda");
        params.put("request_id" , "000049");

        //业务部分
        JSONObject biz_content = new JSONObject();
        biz_content.put("out_trade_no", DateUtils.formatNowId());
        biz_content.put("customer_type", "common");
        biz_content.put("input_type", "card");
        biz_content.put("card_no", "1523805724038511292");

        params.put("biz_content",biz_content.toString());

        String response = WebUtils.doPost(url, params, 3000, 60000);
        logger.info(response);
    }

    @Test
    public void testparkingQuery() throws Exception {

        Map<String, String> params = new HashMap<>();
        params.put("merchant_id", "898330172992626");
        params.put("terminal_id", "09783109");
        params.put("biz_type"   , "umszj.member.memberQuery");
        params.put("biz_channel" , "umszj.paycode.parking");
        params.put("biz_agency" , "umszj.agency.guoda");
        params.put("request_id" , "000049");

        //业务部分
        JSONObject biz_content = new JSONObject();
        biz_content.put("out_trade_no", DateUtils.formatNowId());
        biz_content.put("customer_type", "common");
        biz_content.put("page_size", "10");
        biz_content.put("page_no", "1");

        params.put("biz_content",biz_content.toString());

        String response = WebUtils.doPost(url, params, 3000, 60000);
        logger.info(response);
    }

    @Test
    public void testemployeeQuery() throws Exception {

        Map<String, String> params = new HashMap<>();
        params.put("merchant_id", "898330172992626");
        params.put("terminal_id", "09783109");
        params.put("biz_type"   , "umszj.member.memberQuery");
        params.put("biz_channel" , "umszj.paycode.emplyee");
        params.put("biz_agency" , "umszj.agency.guoda");
        params.put("request_id" , "000049");

        //业务部分
        JSONObject biz_content = new JSONObject();
        biz_content.put("out_trade_no", DateUtils.formatNowId());
        biz_content.put("customer_type", "employee");
        biz_content.put("customer_id", ":::==QTUVVeNRUT04keBdnTEFUNOp3b28kaFd3TUtWP:::");

        params.put("biz_content",biz_content.toString());

        String response = WebUtils.doPost(url, params, 3000, 60000);
        logger.info(response);
    }

    @Test
    public void testMemberQueryHyou() throws Exception {

        Map<String, String> params = new HashMap<>();
        params.put("merchant_id", "898330172992626");
        params.put("terminal_id", "09783109");
        params.put("biz_type"   , "umszj.member.memberQuery");
        params.put("biz_agency" , "umszj.agency.guoda");
        params.put("request_id" , "000049");

        //业务部分
        JSONObject biz_content = new JSONObject();
        biz_content.put("out_trade_no", DateUtils.formatNowId());
        biz_content.put("customer_type", "member");
//        biz_content.put("card_no", "XS01-01-9800020981782-20180428093522-00220128-60bd6fce7af8cea69c86add748233b46？");
        biz_content.put("telephone", "13666604787");
        biz_content.put("order_amount", "100000000000");

        params.put("biz_content",biz_content.toString());

        String response = WebUtils.doPost(url, params, 3000, 60000);
        logger.info(response);
    }

    @Test
    public void testEmplyeeVerification() throws Exception {

        Map<String, String> params = new HashMap<>();
        params.put("merchant_id", "898330172992626");
        params.put("terminal_id", "09783109");
        params.put("biz_type"   , "umszj.member.verificationTrade");
        params.put("biz_channel" , "umszj.paycode.emplyee");
        params.put("biz_agency" , "umszj.agency.guoda");
        params.put("request_id" , "000049");

        //业务部分
        JSONObject biz_content = new JSONObject();
        biz_content.put("out_trade_no", DateUtils.formatNowId());
        biz_content.put("customer_type", "employee");
        biz_content.put("customer_id", "1099"); //员工消费前需要先验证将":::==QTUVVeNRUT04keBdnTEFUNOp3b28kaFd3TUtWP:::"转为1099
        biz_content.put("order_no", "R201804251105320242631685");
        biz_content.put("dis_amount", "0.1");
        biz_content.put("trade_amount", "0.5");

        params.put("biz_content",biz_content.toString());

        String response = WebUtils.doPost(url, params, 3000, 60000);
        logger.info(response);
    }

    //支付交易
    @Test
    public void testDPCVerification() throws Exception {

        Map<String, String> params = new HashMap<>();
        params.put("merchant_id", "898330172992626");
        params.put("terminal_id", "09783109");
        params.put("biz_type"   , "umszj.member.verificationTrade");
        params.put("biz_channel" , "umszj.paycode.deposit");
        params.put("biz_agency" , "umszj.agency.guoda");
        params.put("request_id" , "000049");

        //业务部分
        JSONObject biz_content = new JSONObject();
        biz_content.put("out_trade_no", DateUtils.formatNowId());
//        biz_content.put("order_no", DateUtils.formatNowId() + "1111");
        biz_content.put("order_no", "R201805101546290921413535");
        biz_content.put("customer_type", "none");
        biz_content.put("input_type", "card");
        biz_content.put("card_no", "010000002145914818=10=6272688523");
        biz_content.put("trade_amount", "0.5");

        params.put("biz_content",biz_content.toString());

        String response = WebUtils.doPost(url, params, 3000, 60000);
        logger.info(response);
    }

    //支付交易
    @Test
    public void testVerificationByHyou() throws Exception {

        Map<String, String> params = new HashMap<>();
        params.put("merchant_id", "898330172992626");
        params.put("terminal_id", "09783109");
        params.put("biz_type"   , "umszj.member.verificationTrade");
        params.put("biz_channel" , "umszj.paycode.coupon");
        params.put("biz_agency" , "umszj.agency.guoda");
        params.put("request_id" , "000049");

        //业务部分
        JSONObject biz_content = new JSONObject();
        biz_content.put("out_trade_no", DateUtils.formatNowId());
        biz_content.put("customer_type", "member");
        biz_content.put("telephone", "15658068160");
//        biz_content.put("card_no", "9800020981766");
        biz_content.put("order_no", "R201805111358530816157490");
        biz_content.put("score", "0.1");
        biz_content.put("trade_amount", "0.2");

//        List<verifyCouponHyou> verifyCouponHyouInfo = new ArrayList<>();
//        verifyCouponHyou verifyCouponHyouTest = new verifyCouponHyou();
//
//        verifyCouponHyouTest.setVerify_no("374");
//        verifyCouponHyouTest.setVerify_state("FREE");
//        verifyCouponHyouTest.setVerify_type("umszj.paycode.coupon");
//        verifyCouponHyouTest.setVerify_num("1");
//        verifyCouponHyouTest.setInput_type("coupon");
//
//        verifyCouponHyouInfo.add(verifyCouponHyouTest);
//        verifyCouponHyouInfo.add(verifyCouponHyouTest);
//        biz_content.put("coupon_list",new ObjectMapper().writeValueAsString(verifyCouponHyouInfo));
//
       params.put("biz_content",biz_content.toString());

        String response = WebUtils.doPost(url, params, 3000, 60000);
        logger.info(response);
    }

    //国大订单提交交易
    @Test
    public void testOrderSubmit() throws Exception {

        Map<String, String> params = new HashMap<>();
        params.put("merchant_id", "898330160120021");
        params.put("terminal_id", "05315812");
        params.put("biz_type"   , "umszj.member.orderCommit");
//        params.put("biz_channel" , "umszj.paycode.coupon");
        params.put("biz_agency" , "umszj.agency.guoda");
        params.put("request_id" , "000049");

        //业务部分
        JSONObject biz_content = new JSONObject();
        biz_content.put("out_trade_no", String.format("%06d", (int) (Math.random() * 1000000)));
        biz_content.put("order_no", "R201805221032260296623246");
        biz_content.put("order_type", "order_consume");
        biz_content.put("trade_amount", "0.3");
        biz_content.put("fact_amount", "0.1");
        biz_content.put("discount_amount", "0.1");
//        biz_content.put("customer_id", "12345678");

        List<TestGdaTermPayment> gdaTermPaymentInfoTest = new ArrayList<>();
        TestGdaTermPayment gdaTermPaymentTest = new TestGdaTermPayment();

//        gdaTermPaymentTest.setSub_out_trade_no(DateUtils.formatNowId());
        gdaTermPaymentTest.setSub_out_trade_no("R201805221032260296623246");
        gdaTermPaymentTest.setSub_trade_no(DateUtils.formatNowId());
        gdaTermPaymentTest.setPay_code("umszj.paycode.alipay");
        gdaTermPaymentTest.setTrade_state("trade_consume");
        gdaTermPaymentTest.setSub_fact_amount("0.1");
        gdaTermPaymentTest.setCard_no("135*****7850");
        gdaTermPaymentTest.setPay_code("umszj.paycode.alipay");
        gdaTermPaymentTest.setPay_time(DateUtils.formatNowTime());

        gdaTermPaymentInfoTest.add(gdaTermPaymentTest);
        biz_content.put("pay_info",new ObjectMapper().writeValueAsString(gdaTermPaymentInfoTest));


        params.put("biz_content",biz_content.toString());

        String response = WebUtils.doPost(url, params, 3000, 60000);
        logger.info(response);
    }

    //国大订单提交交易
    @Test
    public void testOrderSubmitCancel() throws Exception {

        Map<String, String> params = new HashMap<>();
        params.put("merchant_id", "898330172992626");
        params.put("terminal_id", "09783109");
        params.put("biz_type"   , "umszj.member.orderCommit");
//        params.put("biz_channel" , "umszj.paycode.coupon");
        params.put("biz_agency" , "umszj.agency.guoda");
        params.put("request_id" , "000049");

        //业务部分
        JSONObject biz_content = new JSONObject();
        biz_content.put("out_trade_no", String.format("%06d", (int) (Math.random() * 1000000)));
        biz_content.put("order_no", "R201805101552430322426237");
        biz_content.put("old_order_no", "R201805031802070191472511");
        biz_content.put("order_type", "order_refund");
        biz_content.put("trade_amount", "0.3");
        biz_content.put("fact_amount", "0.1");
        biz_content.put("discount_amount", "0.1");

        List<TestGdaTermPayment> gdaTermPaymentInfoTest = new ArrayList<>();
        TestGdaTermPayment gdaTermPaymentTest = new TestGdaTermPayment();

//        gdaTermPaymentTest.setSub_out_trade_no(DateUtils.formatNowId());
        gdaTermPaymentTest.setSub_out_trade_no("R201805101453390558309452");
        gdaTermPaymentTest.setSub_trade_no(DateUtils.formatNowId());
        gdaTermPaymentTest.setPay_code("umszj.paycode.alipay");
        gdaTermPaymentTest.setTrade_state("trade_refund");
        gdaTermPaymentTest.setSub_fact_amount("0.1");
        gdaTermPaymentTest.setCard_no("135*****7850");
        gdaTermPaymentTest.setPay_code("umszj.paycode.alipay");
        gdaTermPaymentTest.setPay_time(DateUtils.formatNowTime());

        gdaTermPaymentInfoTest.add(gdaTermPaymentTest);
        biz_content.put("pay_info",new ObjectMapper().writeValueAsString(gdaTermPaymentInfoTest));


        params.put("biz_content",biz_content.toString());

        String response = WebUtils.doPost(url, params, 3000, 60000);
        logger.info(response);
    }

    //支付交易
    @Test
    public void testOrderRequest() throws Exception {

        Map<String, String> params = new HashMap<>();
        params.put("merchant_id", "898330172992626");
        params.put("terminal_id", "09783109");
        params.put("biz_type"   , "umszj.member.orderRequest");
//        params.put("biz_channel" , "umszj.paycode.coupon");
        params.put("biz_agency" , "umszj.agency.guoda");
        params.put("request_id" , "000049");

        //业务部分
        JSONObject biz_content = new JSONObject();
        biz_content.put("out_trade_no", DateUtils.formatNowId());

        params.put("biz_content",biz_content.toString());

        String response = WebUtils.doPost(url, params, 3000, 60000);
        logger.info(response);
    }
    @Test
    public void testOrderCanael() throws Exception {

        Map<String, String> params = new HashMap<>();
        params.put("merchant_id", "898330172992626");
        params.put("terminal_id", "09783109");
        params.put("biz_type"   , "umszj.member.verificationCancel");
//        params.put("biz_channel" , "umszj.paycode.coupon");
        params.put("biz_agency" , "umszj.agency.guoda");
        params.put("request_id" , "000049");

        //业务部分
        JSONObject biz_content = new JSONObject();
        biz_content.put("out_trade_no", DateUtils.formatNowId());
        biz_content.put("order_no", "R201805031802180251923947");
        biz_content.put("old_trade_no", "T201805031803360466127084");

        params.put("biz_content",biz_content.toString());

        String response = WebUtils.doPost(url, params, 3000, 60000);
        logger.info(response);
    }
    //员工消费撤销
    @Test
    public void testEmployeeCancel() throws Exception {

        Map<String, String> params = new HashMap<>();
        params.put("merchant_id", "898330172992626");
        params.put("terminal_id", "09783109");
        params.put("biz_type"   , "umszj.member.verificationCancel");
        params.put("biz_channel" , "umszj.paycode.employee");
        params.put("biz_agency" , "umszj.agency.guoda");
        params.put("request_id" , "000049");

        //业务部分
        JSONObject biz_content = new JSONObject();
        biz_content.put("out_trade_no", DateUtils.formatNowId());
//        biz_content.put("old_trade_no", "R201804251047150139963846");
        biz_content.put("old_order_no", "R201804271632230937382260");
        biz_content.put("customer_type", "employee");

        biz_content.put("customer_id", "1099");
        biz_content.put("cancel_trade_type", "consume");
        biz_content.put("total_amount", "0.1");
        biz_content.put("receipt_amount", "0.01");
        biz_content.put("discount_amount", "0.01");

        params.put("biz_content",biz_content.toString());

        String response = WebUtils.doPost(url, params, 3000, 60000);
        logger.info(response);
    }

    //会员消费撤销
    @Test
    public void testVerificationCancelByHyou() throws Exception {

        Map<String, String> params = new HashMap<>();
        params.put("merchant_id", "898330172992626");
        params.put("terminal_id", "09783109");
        params.put("biz_type"   , "umszj.member.verificationCancel");
        params.put("biz_channel" , "umszj.paycode.coupon");
        params.put("biz_agency" , "umszj.agency.guoda");
        params.put("request_id" , "000049");

        //业务部分
        JSONObject biz_content = new JSONObject();
        biz_content.put("out_trade_no", DateUtils.formatNowId());
        biz_content.put("order_no", "R201805031747030284631383");
        biz_content.put("old_order_no", "2018050317454503051111");
        biz_content.put("customer_type", "member");
        biz_content.put("telepnone", "13666604787");
        biz_content.put("card_no", "62416282");

        params.put("biz_content",biz_content.toString());

        String response = WebUtils.doPost(url, params, 3000, 60000);
        logger.info(response);
    }

    //券码核销撤销
    @Test
    public void testCouponCancel() throws Exception {

        Map<String, String> params = new HashMap<>();
        params.put("merchant_id", "898330172992626");
        params.put("terminal_id", "09783109");
        params.put("biz_type"   , "umszj.member.verificationCancel");
        params.put("biz_channel" , "umszj.paycode.coupon");
        params.put("biz_agency" , "umszj.agency.guoda");
        params.put("request_id" , "000049");

        //业务部分
        JSONObject biz_content = new JSONObject();
        biz_content.put("out_trade_no", DateUtils.formatNowId());
        biz_content.put("old_order_no", "R201804242349140742336003");
//        biz_content.put("old_trade_no", "trn2001800322001");
        biz_content.put("customer_type", "common");
        biz_content.put("order_amount", "0.1");

        params.put("biz_content",biz_content.toString());

        String response = WebUtils.doPost(url, params, 3000, 60000);
        logger.info(response);
    }

    //国大交易查询
    @Test
    public void mixQueryByGda() throws Exception {

        Map<String, String> params = new HashMap<>();
        params.put("merchant_id", "898330172992626");
        params.put("terminal_id", "09783109");
        params.put("biz_type"   , "umszj.member.mixQuery");
        params.put("biz_agency" , "umszj.agency.guoda");
        params.put("request_id" , "000049");

        //业务部分
        JSONObject biz_content = new JSONObject();
        biz_content.put("query_trade_no", "T201804181540590992748534");
//        biz_content.put("query_order_no", "R201804181539450310158146");
        biz_content.put("customer_type", "common");

        params.put("biz_content",biz_content.toString());

        String response = WebUtils.doPost(url, params, 3000, 60000);
        logger.info(response);
    }

    //慧优交易查询
    @Test
    public void mixQueryByHyou() throws Exception {

        Map<String, String> params = new HashMap<>();
        params.put("merchant_id", "898330172992626");
        params.put("terminal_id", "09783109");
        params.put("biz_type"   , "umszj.member.mixQuery");
        params.put("biz_agency" , "umszj.agency.guoda");
        params.put("request_id" , "000049");

        //业务部分
        JSONObject biz_content = new JSONObject();
        biz_content.put("out_trade_no", DateUtils.formatNowId());
        biz_content.put("old_trade_no", "101917952949966217216");
        biz_content.put("customer_type", "member");

        params.put("biz_content",biz_content.toString());

        String response = WebUtils.doPost(url, params, 3000, 60000);
        logger.info(response);
    }

    //国大员工餐卡交易查询
    @Test
    public void mixEmployeeQueryByGda() throws Exception {

        Map<String, String> params = new HashMap<>();
        params.put("merchant_id", "898330172992626");
        params.put("terminal_id", "09783109");
        params.put("biz_type"   , "umszj.member.mixQuery");
        params.put("biz_agency" , "umszj.agency.guoda");
        params.put("request_id" , "000049");

        //业务部分
        JSONObject biz_content = new JSONObject();
        biz_content.put("customer_id", "1099");
        biz_content.put("customer_type", "employee");
        biz_content.put("start_date", "2018-04-18");
        biz_content.put("end_date", "2018-04-19");
        params.put("biz_content",biz_content.toString());

        String response = WebUtils.doPost(url, params, 3000, 60000);
        logger.info(response);
    }




}
