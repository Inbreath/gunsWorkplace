package com.ums.mbr.service.core.utils;

import com.chinaums.security.UmsKeyOperator;
import com.chinaums.security.rsa.core.UmsKeyType;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: jcouyang@chinaums.com
 * Date:   2017/11/8 11:20
 */
public class RsaUtils {

    /**
     * 默认生成Java版本的RSA密钥，即PKCS8格式
     * @return
     */
    public static Map<String, String> generateKey() {
        return generateKey(UmsKeyType.ASN);
    }

    /**
     * 生成PEM格式的密钥，亲测C语言通过mbedtls轻量级封装库加载通过
     * @return
     */
    public static Map<String, String> generateKey(UmsKeyType keyType) {
        // 默认生成PEM的公私钥对
        Map<String,String> pair = UmsKeyOperator.getKeyPairs(keyType);

        String privateKey = pair.get("privateKey");
        String publicKey  = pair.get("publicKey");

        Map<String, String> map = new HashMap<>();
        map.put("private_key", privateKey);
        map.put("public_key", publicKey);
        return map;
    }
}
