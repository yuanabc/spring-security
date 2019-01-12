package com.ybinsure.auth.model.transfer.page;

import com.ybinsure.auth.annotation.QueryPageAction;

import javax.validation.constraints.NotNull;

/**
 * 包含时间参数的分页参数
 * Created by eric on 17-12-1
 */
public class TimePageParam<T> extends PageParam<T> {

    @NotNull(groups = {QueryPageAction.class}, message = "startTime不能为空")
    private Long startTime;

    @NotNull(groups = {QueryPageAction.class}, message = "endTime不能为空")
    private Long endTime;

    public TimePageParam() {
    }

    public boolean blank() {
        return super.blank() || startTime == null || endTime == null;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }
}
