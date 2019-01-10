package com.ybinsure.icar.user.model.dto;

import com.ybinsure.icar.user.util.JsonUtil;

/**
 * 用户业绩查询对象
 *
 * @author HANHT
 * @version 2018/7/7 15:09
 */
public class UserPerformanceDTO {

    /** 用户编号 */
    private String userId;
    /** 当前时间戳 */
    private Long nowTime;
    /** 当天凌晨时间戳 */
    private Long zeroTime;
    /** 当月1日凌晨时间戳 */
    private Long monthTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getNowTime() {
        return nowTime;
    }

    public void setNowTime(Long nowTime) {
        this.nowTime = nowTime;
    }

    public Long getZeroTime() {
        return zeroTime;
    }

    public void setZeroTime(Long zeroTime) {
        this.zeroTime = zeroTime;
    }

    public Long getMonthTime() {
        return monthTime;
    }

    public void setMonthTime(Long monthTime) {
        this.monthTime = monthTime;
    }

    @Override
    public String toString() {
        return JsonUtil.toJson(this).orElse("");
    }
}
