package com.ybinsure.icar.user.model.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ybinsure.icar.user.config.CustomDoubleSerialize;
import com.ybinsure.icar.user.util.JsonUtil;

/**
 * 我的业绩结果对象
 *
 * @author HANHT
 * @version 2018/7/7 11:45
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PerformanceVO {

    /** 今日业绩 */
    @JsonSerialize(using = CustomDoubleSerialize.class)
    private Double todayPremium;
    /** 本月业绩 */
    @JsonSerialize(using = CustomDoubleSerialize.class)
    private Double monthPremium;
    /** 累计业绩 */
    @JsonSerialize(using = CustomDoubleSerialize.class)
    private Double totalPremium;
    /** 本月单量 */
    private Long orderCount;
    /** 累计奖金 */
    @JsonSerialize(using = CustomDoubleSerialize.class)
    private Double totalBonus;

    public Double getTodayPremium() {
        return todayPremium;
    }

    public void setTodayPremium(Double todayPremium) {
        this.todayPremium = todayPremium;
    }

    public Double getMonthPremium() {
        return monthPremium;
    }

    public void setMonthPremium(Double monthPremium) {
        this.monthPremium = monthPremium;
    }

    public Double getTotalPremium() {
        return totalPremium;
    }

    public void setTotalPremium(Double totalPremium) {
        this.totalPremium = totalPremium;
    }

    public Long getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Long orderCount) {
        this.orderCount = orderCount;
    }

    public Double getTotalBonus() {
        return totalBonus;
    }

    public void setTotalBonus(Double totalBonus) {
        this.totalBonus = totalBonus;
    }

    @Override
    public String toString() {
        return JsonUtil.toJson(this).orElse("");
    }
}
