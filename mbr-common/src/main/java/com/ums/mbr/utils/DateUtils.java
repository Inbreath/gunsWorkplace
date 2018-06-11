package com.ums.mbr.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils  {
    public final static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public final static String YYYY_MM_DD = "yyyy-MM-dd";
    public final static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public final static String YYYYMMDDHHMMSS_SSSS = "yyyyMMddHHmmssSSSS";
    public final static String MMDDHHMMSS = "MMddHHmmss";
    public final static String YYYY = "yyyy";

    public static String format(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }

    public static String formatNow(String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(new Date());
    }

    public static String formatNowId() {
        return formatNow(YYYYMMDDHHMMSS_SSSS);
    }

    public static String formatNowTime() {
        return formatNow(YYYY_MM_DD_HH_MM_SS);
    }
    /**
     * 字符串转换为 年月日 时分秒
     *
     * @param dateString
     * @return
     */
    public static Date toDateTime(String dateString) {
        return toDate(dateString, "yyyy-MM-dd HH:mm:ss");
    }

    public static Date toDate(String dateString, String format) {
        if (StringUtils.isEmpty(dateString)) {
            return null;
        }

        DateFormat df = new SimpleDateFormat(format);
        try {
            return df.parse(dateString);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String addMinitues(Date date, int min) {
        Date result = new Date(date.getTime() + min * 60 * 1000);
        return format(result, YYYY_MM_DD_HH_MM_SS);
    }

}
