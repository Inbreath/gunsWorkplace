package com.ums.mbr.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Author: jcouyang@chinaums.com
 * Date: 2018/3/7 10:17
 */
public abstract class CipherUtils {

    private static final Logger logger = LoggerFactory.getLogger(CipherUtils.class);
    private static final String ENCODING = "UTF-8";
    private static final String ALGORITHM_MD5 = "MD5";
    private static final String ALGORITHM_RSA = "RSA";
    private static final String ALGORITHM_SIGN_RSA256 = "SHA256withRSA";
    private static final String ALGORITHM_SIGN_RSA1 = "SHA1WithRSA";

    /**
     * @param src
     * @return
     */
    public static String md5(String src) {
        return md5(src, true);
    }

    /**
     * @param src
     * @param upcase 结果是否大写true大写，false小写
     * @return
     */
    public static String md5(String src, boolean upcase) {
        String ret = null;

        try {
            MessageDigest md5 = MessageDigest.getInstance(ALGORITHM_MD5);
            byte[] bytes = md5.digest(src.getBytes(ENCODING));

            ret = StringUtils.bytes2HexString(bytes, upcase);

        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return ret;
    }

    /**
     * 使用RSAWith256进行签名
     *
     * @param source        待签名的字符串
     * @param privateKeyStr 私钥
     * @param charset       字符编码
     * @return
     * @throws Exception
     */
    public static String sign(String source, String privateKeyStr, String charset) throws Exception {
        PrivateKey privateKey = getPrivateKey(privateKeyStr);

        final Signature signatureChecker = Signature.getInstance(ALGORITHM_SIGN_RSA256);
        signatureChecker.initSign(privateKey);
        signatureChecker.update(source.getBytes(charset));
        return Base64.encode(signatureChecker.sign());
    }

    public static boolean designRSA(String message, byte[] signature, String publicKey) {
        try {
            return designRSA(message, signature, (RSAPublicKey) getPublicKey(publicKey));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("验签出错=[{}]", e.getMessage());
            return false;
        }
    }

    public static boolean designRSA(String message, byte[] signature, RSAPublicKey publicKey) {
        return _designRSA(message, signature, publicKey, ALGORITHM_SIGN_RSA256);
    }

    private static boolean _designRSA(String message, byte[] signature, RSAPublicKey publicKey, String algorithm) {
        boolean flag = false;
        try {
            Signature sign = Signature.getInstance(algorithm);
            sign.initVerify(publicKey);
            sign.update(message.getBytes(ENCODING));
            flag = sign.verify(signature);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
        return flag;
    }

    /**
     * 通过String装载私钥
     *
     * @param keyData
     * @return
     * @throws Exception
     */
    public static PrivateKey getPrivateKey(final String keyData) throws Exception {
        byte[] encodedKey = Base64.decode(keyData);
        final PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encodedKey);
        final KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);
        return keyFactory.generatePrivate(keySpec);
    }

    public static PublicKey getPublicKey(final String keyData) throws Exception {
        byte[] publicBytes = Base64.decode(keyData);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    }
}
