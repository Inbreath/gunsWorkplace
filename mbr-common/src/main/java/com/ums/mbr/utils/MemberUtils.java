package com.ums.mbr.utils;

import com.ums.mbr.beans.MemberRequest;
import com.ums.mbr.beans.MemberResponse;
import com.ums.mbr.enums.CustomerTypes;
import com.ums.mbr.enums.InputTypes;
import com.ums.mbr.enums.OrderStatus;
import com.ums.mbr.enums.TradeStatus;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.*;

/**
 * 该系统的一些大杂烩工具
 *
 * @author jcouyang@chinaums.com
 * @date 2018-02-28
 */
public class MemberUtils {

    /**
     * 请求报文和返回报文存在一些重合字段，有一些是原样直接返回的
     *
     * @param request 接受到的前端请求报文
     * @return
     */
    public static MemberResponse getMemberResponse(MemberRequest request) {

        MemberResponse response = new MemberResponse();

        response.setMerchant_id(request.getMerchant_id());
        response.setTerminal_id(request.getTerminal_id());
        response.setOperator_id(request.getOperator_id());
        response.setDevice_id(request.getDevice_id());
        response.setRequest_id(request.getRequest_id());
        response.setTimestamp(DateUtils.formatNowTime());
        response.setBiz_type(request.getBiz_type());
        response.setVersion(request.getVersion());
        response.setSign_type(request.getSign_type());
        response.setSign_format(request.getSign_format());

        return response;
    }

    private static String localIp;

    /**
     * 将一个Bean对象转化为一个Map 忽略掉为空的属性，默认不排序
     *
     * @param bean
     * @return
     * @throws Exception
     */
    public static Map<String, String> convertBean(Object bean) throws Exception {
        return convertBean(bean, true);
    }

    /**
     * @param bean
     * @param isOrder
     * @return
     * @throws Exception
     */
    public static Map<String, String> convertBean(Object bean, boolean isOrder) throws Exception {
        Map<String, String> returnMap;
        if (isOrder) {
            returnMap = new TreeMap<>();
        } else {
            returnMap = new HashMap<>();
        }

        BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
        //获取属性描述器
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

        for (PropertyDescriptor descriptor : propertyDescriptors) {
            String propertyName = descriptor.getName();

            if (!propertyName.equals("class")) {
                Method readMethod = descriptor.getReadMethod();
                String result = (String) readMethod.invoke(bean);

                if (StringUtils.isNotEmpty(result)) {
                    returnMap.put(propertyName, result);
                }
            }
        }

        return returnMap;
    }

    /**
     * 获取文件的真实后缀名。目前只支持JPG, GIF, PNG, BMP四种图片文件。
     *
     * @param bytes 文件字节流
     * @return JPG, GIF, PNG or null
     */
    public static String getFileSuffix(byte[] bytes) {
        if (bytes == null || bytes.length < 10) {
            return null;
        }

        if (bytes[0] == 'G' && bytes[1] == 'I' && bytes[2] == 'F') {
            return "GIF";
        } else if (bytes[1] == 'P' && bytes[2] == 'N' && bytes[3] == 'G') {
            return "PNG";
        } else if (bytes[6] == 'J' && bytes[7] == 'F' && bytes[8] == 'I' && bytes[9] == 'F') {
            return "JPG";
        } else if (bytes[0] == 'B' && bytes[1] == 'M') {
            return "BMP";
        } else {
            return null;
        }
    }

    /**
     * 获取文件的真实媒体类型。目前只支持JPG, GIF, PNG, BMP四种图片文件。
     *
     * @param bytes 文件字节流
     * @return 媒体类型(MEME-TYPE)
     */
    public static String getMimeType(byte[] bytes) {
        String suffix = getFileSuffix(bytes);
        String mimeType;

        if ("JPG".equals(suffix)) {
            mimeType = "image/jpeg";
        } else if ("GIF".equals(suffix)) {
            mimeType = "image/gif";
        } else if ("PNG".equals(suffix)) {
            mimeType = "image/png";
        } else if ("BMP".equals(suffix)) {
            mimeType = "image/bmp";
        } else {
            mimeType = "application/octet-stream";
        }

        return mimeType;
    }

    /**
     * 清除字典中值为空的项。
     *
     * @param <V> 泛型
     * @param map 待清除的字典
     * @return 清除后的字典
     */
    public static <V> Map<String, V> cleanupMap(Map<String, V> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }

        Map<String, V> result = new HashMap<String, V>(map.size());
        Set<Map.Entry<String, V>> entries = map.entrySet();

        for (Map.Entry<String, V> entry : entries) {
            if (entry.getValue() != null) {
                result.put(entry.getKey(), entry.getValue());
            }
        }

        return result;
    }

    /**
     * 获取本机的网络IP
     */
    public static String getLocalNetWorkIp() {
        if (localIp != null) {
            return localIp;
        }
        try {
            Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            while (netInterfaces.hasMoreElements()) {// 遍历所有的网卡
                NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();
                if (ni.isLoopback() || ni.isVirtual()) {// 如果是回环和虚拟网络地址的话继续
                    continue;
                }
                Enumeration<InetAddress> addresss = ni.getInetAddresses();
                while (addresss.hasMoreElements()) {
                    InetAddress address = addresss.nextElement();
                    if (address instanceof Inet4Address) {// 这里暂时只获取ipv4地址
                        ip = address;
                        break;
                    }
                }
                if (ip != null) {
                    break;
                }
            }
            if (ip != null) {
                localIp = ip.getHostAddress();
            } else {
                localIp = "127.0.0.1";
            }
        } catch (Exception e) {
            localIp = "127.0.0.1";
        }
        return localIp;
    }

    public static String getHostNameForLiunx() {
        try {
            return (InetAddress.getLocalHost()).getHostName();
        } catch (UnknownHostException uhe) {
            String host = uhe.getMessage(); // host = "hostname: hostname"
            if (host != null) {
                int colon = host.indexOf(':');
                if (colon > 0) {
                    return host.substring(0, colon);
                }
            }
            return "UnknownHost";
        }
    }

    /**
     * 验证签名
     * @param map
     * @param publicKey
     * @return
     */
    public static boolean verify(Map<String, String> map, String publicKey){
        String sign = (String) map.remove("sign");
        map.remove("sign_type");
        map.remove("sign_format");

        TreeMap<String, String> params = new TreeMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (StringUtils.isNotEmpty(entry.getValue())) {
                params.put(entry.getKey(), entry.getValue());
            }
        }

        String signStr = "";
        StringBuffer sbtr = new StringBuffer();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            sbtr.append(entry.getKey());
            sbtr.append("=");
            sbtr.append(entry.getValue());
            sbtr.append("&");
        }

        signStr = sbtr.toString().substring(0, sbtr.toString().length()-1);
        return CipherUtils.designRSA(signStr, Base64.decode(sign), publicKey);
    }

    /**
     * 获取终端签名
     * @param map 传入TreeMap，这里不进行排序
     * @param key
     * @return
     */
    public static String getTermSign(Map<String, String> map, String key) {
        map.remove("sign");
        String signFormat = map.remove("sign_format");
        String signType   = (String) map.remove("sign_type");

        StringBuffer sbtr = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sbtr.append(entry.getKey());
            sbtr.append("=");
            sbtr.append(entry.getValue());
            sbtr.append("&");
        }

        String signStr = sbtr.substring(0, sbtr.length() - 1);

        String signResult = null;
        if ("md5".equalsIgnoreCase(signType)) {
            signStr += "&key=" + key;

            signResult = CipherUtils.md5(signStr);

        } else {
            try {
                signResult = CipherUtils.sign(signStr, key, "UTF-8");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return signResult;
    }

    public static String generateRandom(int len) {
        return String.format("%0"+len+"d", (int) (Math.random() * Math.pow(10, len)));
    }

    public static Map<String, String> upcase2underLine(Map<String, String> map) {
        Map<String, String> retMap = new HashMap<>();
        for (String key : map.keySet()) {
            retMap.put(StringUtils.upperChar2UnderLine(key), map.get(key));
        }
        return retMap;
    }

    /**
     * 用于将外部的字段转换成会员系统的字段
     * @param termcase
     * @return
     */
    public static String termcase2memberCase(String termcase) {
        if (StringUtils.isNotEmpty(termcase)) {
            String memberCase;
            switch (termcase) {
                case "member":
                    memberCase = CustomerTypes.MEMBER.getName();
                    break;
                case "employee":
                    memberCase = CustomerTypes.EMPLOYEE.getName();
                    break;
                case "common":
                    memberCase = CustomerTypes.NONE.getName();
                case "none":
                    memberCase = CustomerTypes.NONE.getName();
                    break;
                case "deposit":
                    memberCase = CustomerTypes.DEPOSIT.getName();
                    break;
                case "scan":
                    memberCase = InputTypes.SCAN.getName();
                    break;
                case "card":
                    memberCase = InputTypes.CARD.getName();
                    break;
                case "coupon":
                    memberCase = InputTypes.COUPON.getName();
                    break;
                case "hand":
                    memberCase = InputTypes.HAND.getName();
                    break;
                case "order_comsume":
                    memberCase = OrderStatus.SUCCESS.getName();
                    break;
                case "order_refund":
                    memberCase = OrderStatus.CANCELED.getName();
                    break;
                case "trade_start":
                    memberCase = TradeStatus.START.getName();
                    break;
                case "trade_success":
                    memberCase = TradeStatus.SUCCESS.getName();
                    break;
                case "trade_fail":
                    memberCase = TradeStatus.FAILED.getName();
                    break;
                case "trade_consume":
                    memberCase = TradeStatus.SUCCESS.getName();
                    break;
                case "trade _fail":
                    memberCase = TradeStatus.FAILED.getName();
                    break;
                case "trade_refund":
                    memberCase = TradeStatus.CANCELED.getName();
                    break;
                default:
                    memberCase = termcase;
                    break;
            }
            return memberCase;
        }
        else
            return null;
    }

}
