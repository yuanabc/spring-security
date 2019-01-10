package com.ybinsure.icar.user.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * 时间计算工具类
 *
 * @author HANHT
 * @version 2018/7/7 11:41
 */
public final class DateUtil {

    private static final ZoneId ZONE = ZoneId.systemDefault();

    public static Date toDate(String date) {

        return toDate(getLocalDate(date));
    }

    public static String toChar(Date date) {

        return getLocalDate(date).toString();
    }

    /**
     * 获取今天的日期
     */
    public static String today() {

        return getLocalDate("").toString();
    }

    /**
     * 获取今天加上指定天数的日期
     *
     * @param amount 增加天数
     * @return 日期
     */
    public static String addDay(int amount) {

        return addDay("", amount);
    }

    /**
     * 获取指定日期加上制定天数的日期
     *
     * @param date   指定日期
     * @param amount 增加天数
     * @return 日期
     */
    public static String addDay(String date, int amount) {

        return getLocalDate(date).plusDays(amount).toString();
    }

    /**
     * 获取指定日期加上制定天数的日期
     *
     * @param date   指定日期
     * @param amount 增加天数
     * @return 日期
     */
    public static Date addDay(Date date, int amount) {

        return toDate(getLocalDate(date).plusDays(amount));
    }

    /**
     * 获取当天凌晨时间戳
     */
    public static long getZeroTime() {

        return getZeroTime("");
    }

    /**
     * 获取指定日期凌晨时间戳
     */
    public static long getZeroTime(String date) {
        ZoneId zoneId = ZoneId.systemDefault();
        return getLocalDate(date).atStartOfDay(zoneId).toInstant().toEpochMilli();
    }

    /**
     * 获取当前月的第一天
     */
    public static String getFirstDayOfMonth() {

        return getFirstDayOfMonth(getLocalDate(""));
    }

    /**
     * 获取指定日期的月份第一天
     */
    public static String getFirstDayOfMonth(String date) {

        return getFirstDayOfMonth(getLocalDate(date));
    }

    public static String timestampToChar(long timestamp) {

        return getLocalDateTime(timestamp).toLocalDate().toString();
    }

    private static LocalDateTime getLocalDateTime(long timestamp) {

        return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZONE);
    }

    /**
     * localDate转Date
     */
    private static Date toDate(LocalDate localDate) {
        ZonedDateTime zdt = localDate.atStartOfDay(ZONE);

        return Date.from(zdt.toInstant());
    }

    /**
     * 获取LocalDate
     *
     * @param date 日期字符串
     */
    private static LocalDate getLocalDate(String date) {
        if (StrUtil.isBlank(date)) {

            return LocalDate.now();
        }

        try {
            return LocalDate.parse(date);
        } catch (Exception e) {

            return LocalDate.now();
        }
    }

    /**
     * 获取LocalDate
     *
     * @param date 日期
     */
    private static LocalDate getLocalDate(Date date) {
        if (date == null) {

            return LocalDate.now();
        }

        try {
            Instant instant = date.toInstant();

            return instant.atZone(ZONE).toLocalDate();
        } catch (Exception e) {

            return LocalDate.now();
        }
    }

    /**
     * 根据LocalDate获取月份第一天
     */
    private static String getFirstDayOfMonth(LocalDate localDate) {

        return LocalDate.of(localDate.getYear(), localDate.getMonth(), 1).toString();
    }
}
