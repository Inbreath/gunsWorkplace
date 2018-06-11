package com.ums.mbr.packer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ums.mbr.ITransaction;
import com.ums.mbr.RequestBean;
import com.ums.mbr.TransResult;
import com.ums.mbr.enums.ErrorCodes;
import com.ums.mbr.utils.CipherUtils;
import com.ums.mbr.utils.DateUtils;
import com.ums.mbr.utils.MemberUtils;
import com.ums.mbr.utils.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Service
public class WJLongTransactionImpl implements ITransaction {

    private static final Logger logger = LoggerFactory.getLogger(GdaTransactionImpl.class);
//    private static final String MESSAGE_TYPE = "json";
    private static final String CHAR_SET = "UTF-8";
    private static final int CONNET_TIMEOUT = 3000;
    private static final int READ_TIMEOUT = 60000;
    private static final String HYOU_SUCCESS_CODE = "0";
    private static final String HYOU_SIGNERR_CODE1 = "3001"; // 签名错误
    private static final String HYOU_SIGNERR_CODE2 = "3002"; // 签名超时

    private ObjectMapper objectMapper;

    public HyouTransactionImpl() {
        objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        // 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    //收发慧优的优惠券查询交易
    public TransResult memberQuery(RequestBean bean) {
        TransResult transResult = new TransResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());
        try {
            Map<String, String> map = new HashMap<>();
            String access_token = getAccessToken(bean.getBaseUrl(), bean.getAppId(), bean.getSecureKey());

            map.put("appId"        , bean.getAppId());
            map.put("shopNo"       , bean.getMchtId());
            map.put("storeNo"      , bean.getTermId());
            map.put("totalFee"     , bean.getOrderAmount());
            map.put("memberPhone"  , bean.getMemberPhone());
            map.put("entityCardId" , bean.getEntityCardId());

            String request = objectMapper.writeValueAsString(map);
            String url = bean.getBaseUrl() + "/gdpos/getScanCodeInfo.json?accessToken=" + access_token;
            logger.info("会员卡查询的请求地址=[{}]", url);
            logger.info("国大会员查询的请求报文=[{}]", request);
            String response = wrapperPost(url, map, bean);
            logger.info("国大会员查询接收到后端返回数据=[{}]", response);

            //result是国大返回信息体的data部分
            HyouResponse<HyouMemberQueryResponseBody> result = objectMapper.readValue(response, new TypeReference<HyouResponse<HyouMemberQueryResponseBody>>() {});

            //国大交易失败（因为成功时已经默认为会员系统的成功代码做返回码），返回国大的返回码
            if (!HYOU_SUCCESS_CODE.equals(result.getCode())) {
                transResult.setCode(result.getCode());
                transResult.setMessage(result.getMsg());
            }

            //当交易失败时，data是空
            transResult.setBodyHyou(result.getResult());

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("出现系统异常=[{}]", e.getMessage());
            transResult.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
            transResult.setMessage("系统错误：");
        }

        return transResult;
    }

    //收发慧优的核销交易
    public TransResult verification(RequestBean bean) {
        TransResult transResult = new TransResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());
        try {
            Map<String, String> map = new HashMap<>();
            String access_token = getAccessToken(bean.getBaseUrl(), bean.getAppId(), bean.getSecureKey());
            String memberCoupon = objectMapper.writeValueAsString(bean.getCouponGDDTOInf());

            map.put("appId"        , bean.getAppId());
            map.put("memberPhone"  , bean.getMemberPhone());
            map.put("entityCardId" , bean.getEntityCardId());
            map.put("shopNo"       , bean.getMchtId());
            map.put("storeNo"      , bean.getTermId());
            map.put("payOrder"     , bean.getTransNo());
            map.put("orderNo"      , bean.getOrderNo());
            map.put("score"        , bean.getScore());
            map.put("totalFee"     , bean.getAmount());
            map.put("memberCoupon" , memberCoupon);

            String request = objectMapper.writeValueAsString(map);
            logger.info("国大会员核销的请求报文=[{}]", request);

            String url = bean.getBaseUrl() + "/gdpos/verifyPos.json?accessToken=" + access_token;
            String response = wrapperPost(url, map, bean);
            logger.info("国大会员核销接收到后端返回数据=[{}]", response);

            //result是国大返回信息体的data部分
            HyouResponse<HyouVerificationResponseBody> result = objectMapper.readValue(response, new TypeReference<HyouResponse<HyouVerificationResponseBody>>() {});

            //国大交易失败（因为成功时已经默认为会员系统的成功代码做返回码），返回国大的返回码
            if (!HYOU_SUCCESS_CODE.equals(result.getCode())) {
                transResult.setCode(result.getCode());
                transResult.setMessage(result.getMsg());
            }

            //当交易失败时，data是空
            transResult.setBodyHyou(result.getResult());

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("出现系统异常=" + e.getMessage(), e);
            transResult.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
            transResult.setMessage("系统错误：" + e.getMessage());
        }

        return transResult;
    }

    //收发慧优的撤单交易
    public TransResult verificationCancel(RequestBean bean) {
        TransResult transResult = new TransResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());
        try {
            Map<String, String> map = new HashMap<>();
            String access_token = getAccessToken(bean.getBaseUrl(), bean.getAppId(), bean.getSecureKey());
//            String memberCoupon = new ObjectMapper().writeValueAsString(bean.getCouponGDDTOInf());

            map.put("appId"        , bean.getAppId());
            map.put("memberPhone"  , bean.getMemberPhone());
            map.put("entityCardId" , bean.getEntityCardId());
            map.put("shopNo"       , bean.getMchtId());
            map.put("storeNo"      , bean.getTermId());
            map.put("payOrder"     , bean.getTransNo()); // 原正向交易的交易号

            String request = objectMapper.writeValueAsString(map);
            logger.info("国大会员撤单的请求报文=[{}]", request);

            String url = bean.getBaseUrl() + "/gdpos/savePosRefund.json?accessToken=" + access_token;
            String response = wrapperPost(url, map, bean);
            logger.info("国大会员撤单接收到后端返回数据=[{}]", response);

            //result是国大返回信息体的data部分
            HyouResponse result = objectMapper.readValue(response, new TypeReference<HyouResponse>() {});


            //国大交易失败（因为成功时已经默认为会员系统的成功代码做返回码），返回国大的返回码
            if (!HYOU_SUCCESS_CODE.equals(result.getCode())) {
                transResult.setCode(result.getCode());
                transResult.setMessage(result.getMsg());
            }

            // 没有result结构部分
//            transResult.se(result.getResult());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("出现系统异常=[{}]", e.getMessage());
            transResult.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
            transResult.setMessage("系统错误：");
        }

        return transResult;
    }

    //收发慧优的核销查询交易
    public TransResult mixQuery(RequestBean bean) {
        TransResult transResult = new TransResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());
        try {
            Map<String, String> map = new HashMap<>();
            String access_token = getAccessToken(bean.getBaseUrl(), bean.getAppId(), bean.getSecureKey());

            map.put("appId"    , bean.getAppId());
            map.put("payOrder" , bean.getOldTradeNo());

            String request = objectMapper.writeValueAsString(map);
            logger.info("慧优核销查询的请求报文=[{}]", request);

            String url = bean.getBaseUrl() + "/gdpos/getVerifyInfo.json?accessToken=" + access_token;
            String response = wrapperPost(url, map, bean);
            logger.info("慧优核销查询接收到后端返回数据=[{}]", response);

            //result是国大返回信息体的data部分
            HyouResponse<HyouMixQueryResponseBody> result = objectMapper.readValue(response, new TypeReference<HyouResponse<HyouMixQueryResponseBody>>() {});

            //慧优交易失败（因为成功时已经默认为会员系统的成功代码做返回码）
            if (!HYOU_SUCCESS_CODE.equals(result.getCode())) {
                transResult.setCode(result.getCode());
                transResult.setMessage(result.getMsg());
            }

            //当交易失败时，data是空
            transResult.setBodyHyou(result.getResult());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("出现系统异常=[{}]", e.getMessage());
            transResult.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
            transResult.setMessage("系统错误：");
        }

        return transResult;
    }

    //收发慧优的保存交易
    public TransResult orderCommit(RequestBean bean) {
        TransResult transResult = new TransResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());
        try {
            Map<String, String> map = new HashMap<>();
            String access_token = getAccessToken(bean.getBaseUrl(), bean.getAppId(), bean.getSecureKey());
            String memberCoupon = objectMapper.writeValueAsString(bean.getCouponGDDTOInf());

            map.put("appId"        , bean.getAppId());
            map.put("entityCardId" , bean.getEntityCardId());
            map.put("memberPhone"  , bean.getMemberPhone());
            map.put("shopNo"       , bean.getMchtId());
            map.put("storeNo"      , bean.getTermId());
            map.put("orderNo"      , bean.getOrderNo());
            map.put("totalFee"     , bean.getTotalFee());
            map.put("payFee"       , bean.getPayFee());
            map.put("groupFee"     , bean.getGroupFee());

            String request = objectMapper.writeValueAsString(map);
            logger.info("国大会员交易保存的请求报文=[{}]", request);

            String url = bean.getBaseUrl() + "/gdpos/savePosPayInfo.json?accessToken=" + access_token;
            String response = wrapperPost(url, map, bean);
            logger.info("国大会员交易保存接收到后端返回数据=[{}]", response);

            //result是国大返回信息体的data部分
            HyouResponse result = objectMapper.readValue(response, new TypeReference<HyouResponse>() {});

            //交易失败（因为成功时已经默认为会员系统的成功代码做返回码），返回慧优的返回码
            if (!HYOU_SUCCESS_CODE.equals(result.getCode())) {
                transResult.setCode(result.getCode());
                transResult.setMessage(result.getMsg());
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("出现系统异常=" + e.getMessage(), e);
            transResult.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
            transResult.setMessage("系统错误：" + e.getMessage());
        }

        return transResult;
    }

    public String getAccessToken(String transUrl, String appId, String secureKey) throws Exception {
        return getAccessToken(transUrl, appId, secureKey, false);
    }

    /**
     * 获取慧优的AccessToken
     *
     * @param appId     慧优分配
     * @param secureKey 慧优分配
     * @param forceUpdate 强制更新
     * @return
     */
    public String getAccessToken(String transUrl, String appId, String secureKey, boolean forceUpdate) throws Exception {
        String fileName = "tokenHyou.txt";
        File file = new File(fileName);

        // 文件已经存在了，检查token是否过期
        if (!forceUpdate && file.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String ctx = br.readLine();
            String accessToken = ctx.split("\\|")[0];
            String timeExpire = ctx.split("\\|")[1];
            br.close();

            long tmp = file.lastModified() + Long.parseLong(timeExpire) * 1000;

            if (System.currentTimeMillis() - tmp < 0) {
                logger.info("已经获取到的AccessToken尚未过期，直接返回");
                return accessToken;
            }

            logger.info("现有的accessToken已经过期，重新获取");
        }

        Map<String, String> map = new HashMap<>();
        map.put("appId", appId);
        map.put("appSecret", secureKey);
        map.put("timestamp", DateUtils.formatNowTime());
        map.put("sign", getSign(appId, secureKey, map.get("timestamp")));

        //慧优测试的随机9位数，暂时取123456789
        map.put("nonStr", MemberUtils.generateRandom(9));


        logger.info("获取accessToken的请求报文=[{}]", map);

        String url = transUrl + "/auth/accessToken";
        logger.info("token的请求地址=[{}]", url);
        String response = WebUtils.doPost(url, map, CHAR_SET, CONNET_TIMEOUT, READ_TIMEOUT);
        logger.info("获取慧优accessToken接收到后端返回数据=[{}]", response);

        HyouResponse<HyouAccessTokenResponseBody> result = objectMapper.readValue(response, new TypeReference<HyouResponse<HyouAccessTokenResponseBody>>() {
        });

        String token = null;
        if (HYOU_SUCCESS_CODE.equals(result.getCode())) {
            HyouAccessTokenResponseBody body = result.getResult();
            // 存储在文件当中
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fileName)));
            logger.info("[{}],[{}]", body.getAccessToken(), body.getExpireIn());
            bw.write(body.getAccessToken() + "|" + body.getExpireIn() / 2);
            bw.close();

            token = body.getAccessToken();
        }

        return token;
    }

    /**
     * 对反会的数据进行一次检查，如果是签名错误的话强制更新token再次发起交易
     * @param url
     * @param map
     * @param bean
     * @return
     * @throws Exception
     */
    private String wrapperPost(String url, Map<String, String> map, RequestBean bean) throws Exception {
        String response = doPost(url, map);

        HashMap<String, Object> result = objectMapper.readValue(response, new TypeReference<HashMap<String, Object>>() {});

        String code = result.get("code")+"";

        if (HYOU_SIGNERR_CODE1.equals(code) || HYOU_SIGNERR_CODE2.equals(code)) {
            logger.info("返回数据=[{}]", response);
            logger.info("后端返回签名错误护超时，需要强制更新accessToken");
            map.put("access_token", getAccessToken(bean.getBaseUrl(), bean.getAppId(), bean.getSecureKey(), true));
            response = doPost(url, map);
        }

        return response;
    }

    private String getSign(String appId, String secureKey, String timestamp) {
        return CipherUtils.md5(secureKey + timestamp + appId + secureKey);
    }

    private String doPost(String url, Map<String, String> map) {
        try {
            return WebUtils.doPost(url, map, CHAR_SET, CONNET_TIMEOUT, READ_TIMEOUT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static void main(String[] args) throws Exception {
//        System.out.println(new HyouTransactionImpl().getAccessToken(
//                "http://ceshi.wmallcity.com/api", "wisuwebposweb201708",
//                "sMTjdfXA7jF4luK8cbqMkf"));
//    }
}
