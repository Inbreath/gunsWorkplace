package com.ums.mbr.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    public static boolean isEmpty(Object... objs) {
        for (Object obj : objs) {
            return null == obj || "".equals(obj);
        }
        return false;
    }

    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static boolean isNotEmpty(CharSequence cs) {
        return !isEmpty(cs);
    }

    /**
     * 驼峰转小写加下划线
     * @param param
     * @return
     */
    public static String upperChar2UnderLine(String param) {
        Pattern p = Pattern.compile("[A-Z]");
        if (param == null || param.equals("")) {
            return "";
        }
        StringBuilder builder = new StringBuilder(param);
        Matcher mc = p.matcher(param);
        int i = 0;
        while (mc.find()) {
            builder.replace(mc.start() + i, mc.end() + i, "_" + mc.group().toLowerCase());
            i++;
        }

        if ('_' == builder.charAt(0)) {
            builder.deleteCharAt(0);
        }
        return builder.toString();
    }

    /**
     * 字符串前补零
     * @param value
     * @param length 补齐后的长度
     * @return
     */
    public static String fillZeroFront(long value, int length) {
        return fillZeroFront(value + "", length);
    }

    /**
     * 字符串前补零
     * @param value
     * @param length 补齐后的长度
     * @return
     */
    public static String fillZeroFront(String value, int length) {
        value = value == null ? "" : value;
        while (value.length() < length) {
            value = "0" + value;
        }
        return value;
    }

    /**
     * 字符串：NULL转空
     * @param value
     * @return
     */
    public static String valueOf(String value) {
        return value == null ? "" : value;
    }

    /**
     * 对象转字符串：NULL转空
     * @param o
     * @return
     */
//	public static String valueOf(Object o) {
//		return o == null ? "" : o.toString();
//	}

    /**
     * 判断字符串是否包含中文
     * @param str
     * @return
     */
    public static boolean hasChinese(String str) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }

    /**
     * 首字符转小写
     * @param str
     * @return
     */
    public static String firstToLower(String str){
        char[] cc = str.toCharArray();
        cc[0] = (cc[0]+"").toLowerCase().toCharArray()[0];
        return new String(cc);
    }


    /**
     * 检查指定的字符串列表是否不为空。
     */
    public static boolean areNotEmpty(String... values) {
        boolean result = true;
        if (values == null || values.length == 0) {
            result = false;
        } else {
            for (String value : values) {
                result &= !isEmpty(value);
            }
        }
        return result;
    }

    public static String valueOf(Object obj) {
        return (obj == null) ? "" : obj.toString();
    }

    /**
     * byte[] 转 16进制字符串
     *
     * @param arr
     * @return
     */
    public static String bytes2HexString(byte[] arr) {
        return bytes2HexString(arr, true);
    }

    /**
     * byte[] 转 16进制字符串
     *
     * @param arr
     * @param upcase 是否大写
     * @return
     */
    public static String bytes2HexString(byte[] arr, boolean upcase) {
        StringBuilder sbd = new StringBuilder();
        for (byte b : arr) {
            String tmp = Integer.toHexString(0xFF & b);
            if (tmp.length() < 2)
                tmp = "0" + tmp;
            sbd.append(tmp);
        }

        if (upcase) {
            return sbd.toString().toUpperCase();
        }
        else {
            return sbd.toString();
        }
    }



    /**
     * 十六进制 转换 byte[]
     *
     * @param hexStr
     * @return
     */
    public static byte[] hexString2Bytes(String hexStr) {
        if (hexStr == null)
            return null;
        if (hexStr.length() % 2 != 0) {
            hexStr += "0";
        }
        byte[] data = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            char hc = hexStr.charAt(2 * i);
            char lc = hexStr.charAt(2 * i + 1);
            byte hb = hexChar2Byte(hc);
            byte lb = hexChar2Byte(lc);
            if (hb < 0 || lb < 0) {
                return null;
            }
            int n = hb << 4;
            data[i] = (byte) (n + lb);
        }
        return data;
    }

    public static byte hexChar2Byte(char c) {
        if (c >= '0' && c <= '9')
            return (byte) (c - '0');
        if (c >= 'a' && c <= 'f')
            return (byte) (c - 'a' + 10);
        if (c >= 'A' && c <= 'F')
            return (byte) (c - 'A' + 10);
        return -1;
    }
}
