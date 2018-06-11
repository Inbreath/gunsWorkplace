package com.ums.mbr.packer;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ums.mbr.ITransaction;
import com.ums.mbr.RequestBean;
import com.ums.mbr.TransResult;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import com.ums.mbr.enums.ErrorCodes;
import com.ums.mbr.packer.hding.request.HdingBaseRequestBody;
import com.ums.mbr.packer.hding.request.HdingMemberQueryRequestBody;
import com.ums.mbr.utils.CipherUtils;
import com.ums.mbr.utils.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
/**
 * Author: jcouyang@chinaums.com
 * Date: 2018/3/7 10:02
 */
@Service
public class HdingTransactionImpl implements ITransaction {

    private static final Logger logger = LoggerFactory.getLogger(HdingTransactionImpl.class);
    private static final String MESSAGE_TYPE = "json";
    private static final String CHAR_SET = "UTF-8";
    private static final int CONNET_TIMEOUT = 10000;
    private static final int READ_TIMEOUT = 60000;
    private static final String HDING_SUCCESS_CODE = "";
    private static final String HDING_SIGNERR_CODE1 = ""; // 签名错误
    private static final String HDING_SIGNERR_CODE2 = ""; // 签名超时

    private ObjectMapper objectMapper;

    public HdingTransactionImpl() {
        objectMapper = new ObjectMapper();
        // 忽略掉值为空或者空字符串的字段（但是对Map不生效）
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        // 忽略掉mapper中值为NULL的属性，但是不能忽略值为空的属性
        objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        // 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    //收发海鼎的会员查询交易
    public TransResult memberQuery(RequestBean bean) {
        TransResult transResult = new TransResult(ErrorCodes.SYS_SUCCESS.getCode(), ErrorCodes.SYS_SUCCESS.getMessage());
        try {
            HdingMemberQueryRequestBody body = new HdingMemberQueryRequestBody();
            body.setAppId(bean.getAppId());
            body.setTimestamp(bean.getTimestamp());
            body.setSign(bean.getSign());
            body.setOrgCode(bean.getOrgCode());
            body.setContent_Type(bean.getContentType());
            body.setAccountType(bean.getAccountType());
            body.setAccountValue(bean.getAccountValue());

            String request = objectMapper.writeValueAsString(body);
            String url = bean.getBaseUrl() + "/member";
            logger.info("POS验证的请求地址=[{}]", url);
            logger.info("POS验证的请求报文=[{}]", request);

            String response = wrapperPost(url, body, bean);
            logger.info("POS验证接收到后端返回数据=[{}]", response);

            GdaResponse<GdaPosValidateResponseBody> result = objectMapper.readValue(response, new TypeReference<GdaResponse<GdaPosValidateResponseBody>>() {});

            //国大验证交易失败（因为成功时已经默认为会员系统的成功代码做返回码），返回国大的返回码
            if (!GDA_SUCCESS_CODE.equals(result.getAjaxErrorCode())) {
                transResult.setCode(result.getAjaxErrorCode());
                transResult.setMessage(result.getMessage());
            }

            //当交易失败时，data是空
            transResult.setBody(result.getData());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("出现系统异常=[{}]", e.getMessage());
            transResult.setCode(ErrorCodes.SYS_SYSTEM_ERROR.getCode());
            transResult.setMessage("系统错误："+e.getMessage());
        }

        return transResult;
    }

    public String getAccessToken(String transUrl, String appId, String secureKey) throws Exception {
        return getAccessToken(transUrl, appId, secureKey, false);
    }

    /**
     * 获取AccessToken
     *
     * @param appId     国大分配
     * @param secureKey 国大分配
     * @param forceUpdate 强制更新
     * @return
     */
    public String getAccessToken(String transUrl, String appId, String secureKey, boolean forceUpdate) throws Exception {
        String fileName = "token.txt";
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
        map.put("appid", appId);
        map.put("timestamp", System.currentTimeMillis() + "");
        map.put("sign", getSign(appId, secureKey, map.get("timestamp")));

        String request = objectMapper.writeValueAsString(map);

        logger.info("获取accessToken的请求报文=[{}]", request);

        String url = transUrl + "/getAccessToken";
        String response = doPost(url, request);
        logger.info("获取accessToken接收到后端返回数据=[{}]", response);

        GdaResponse<GdaAccessTokenResponseBody> result = objectMapper.readValue(response, new TypeReference<GdaResponse<GdaAccessTokenResponseBody>>() {
        });

        String token = null;
        if (GDA_SUCCESS_CODE.equals(result.getAjaxErrorCode())) {
            GdaAccessTokenResponseBody body = result.getData();
            // 存储在文件当中
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fileName)));
            bw.write(body.getAccess_token() + "|" + body.getExpire_time() / 2);
            bw.close();

            token = body.getAccess_token();
        }

        return token;
    }

    /**
     * 对反会的数据进行一次检查，如果是签名错误的话强制更新token再次发起交易
     * @param url
     * @param body
     * @param bean
     * @return
     * @throws Exception
     */
    private String wrapperPost(String url, HdingBaseRequestBody body, RequestBean bean) throws Exception {
        String request = objectMapper.writeValueAsString(body);
        String response = doPost(url, request);

        HashMap<String, Object> result = objectMapper.readValue(response, new TypeReference<HashMap<String, Object>>() {});

        String code = result.get("ajaxErrorCode")+"";

        if (HDING_SIGNERR_CODE1.equals(code) || HDING_SIGNERR_CODE2.equals(code)) {
            logger.info("返回数据=[{}]", response);
            logger.info("后端返回签名错误护超时，需要强制更新accessToken");
            body.setAccessToken(getAccessToken(bean.getBaseUrl(), bean.getAppId(), bean.getSecureKey(), true));
            response = doPost(url, objectMapper.writeValueAsString(body));
        }

        return response;
    }

    private String getSign(String appId, String secureKey, String timestamp) {
        return CipherUtils.md5(appId + secureKey + timestamp + appId);
    }

    private String doPost(String url, String request) {
        try {
            return WebUtils.doPost(url, request, MESSAGE_TYPE, CHAR_SET, CONNET_TIMEOUT, READ_TIMEOUT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
