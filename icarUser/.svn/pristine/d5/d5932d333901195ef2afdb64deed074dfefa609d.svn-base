package com.ybinsure.icar.user.util;

import java.util.UUID;

public class StrUtil {

    public static boolean isEmpty(Object str) {
        return (str == null || "".equals(str));
    }

    /**
     * 字段串是否为空
     */
    public static boolean isBlank(String str) {
        return isEmpty(str) || str.trim().isEmpty();
    }

    /**
     * 字符串非空
     */
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    /**
     * Object是否为空
     *
     * @param obj object对象
     */
    public static boolean isNull(Object obj) {
        return isEmpty(obj) || obj.toString().trim().isEmpty();
    }

    /**
     * Object非空
     */
    public static boolean isNotNull(Object obj) {
        return !isNull(obj);
    }

    /**
     * str为空或null或空串或"null"返回默认值
     */
    public static String defaultIfBlank(String str, String defaultValue) {

        return (isBlank(str) || "null".equals(str.trim())) ? defaultValue : str;
    }

    /**
     * obj为空或null或者空串返回默认值
     */
    public static String defaultIfNull(Object obj, String defaultValue) {
        return isNull(obj) ? defaultValue : obj.toString();
    }

    /**
     * str转int，转换异常返回默认值
     */
    public static int toInt(Object obj, int defaultValue) {
        if (isNull(obj)) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(obj.toString());
        } catch (NumberFormatException nfe) {
            return defaultValue;
        }
    }

    /**
     * str转double，转换异常返回默认值
     */
    public static double toDouble(Object obj, double defaultValue) {
        if (isNull(obj)) {
            return defaultValue;
        }
        try {
            return Double.parseDouble(obj.toString());
        } catch (NumberFormatException nfe) {
            return defaultValue;
        }
    }

    /**
     * 对象转long
     */
    public static long toLong(Object obj, long defaultValue) {
        if (isNull(obj)) {
            return defaultValue;
        }
        try {
            return Long.parseLong(obj.toString());
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * 对象转byte
     */
    public static byte toByte(Object obj, int defaultValue) {
        try {
            if (isNull(obj)) {
                obj = defaultValue;
            }
            return Byte.parseByte(obj.toString());
        } catch (NumberFormatException e) {
            return Byte.valueOf("0");
        }
    }

    /**
     * 获取uuid
     */
    public static String uuid() {

        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * trim
     */
    public static String trim(String value) {
        if (isBlank(value)) {
            return "";
        }

        return value.trim();
    }

    /**
     * 按长度截取字符串
     */
    public static String substring(String value, int length) {
        if (isBlank(value) || length < 1) {

            return value;
        }

        int len = value.length();
        if (length >= len) {

            return value;
        }

        return value.substring(0, length);
    }
}
