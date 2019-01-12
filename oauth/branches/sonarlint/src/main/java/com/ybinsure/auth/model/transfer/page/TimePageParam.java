package com.ybinsure.auth.model.transfer.page;

import com.ybinsure.auth.annotation.validator.QueryPageAction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * 包含时间参数的分页参数
 * Created by eric on 17-12-1
 */
@ApiModel(description = "包含时间参数的分页参数")
@Setter
@Getter
public class TimePageParam<T> extends PageParam<T> {

    @NotNull(groups = {QueryPageAction.class}, message = "startTime不能为空")
    @ApiModelProperty(value = "开始时间戳")
    private Long startTime;

    @NotNull(groups = {QueryPageAction.class}, message = "endTime不能为空")
    @ApiModelProperty(value = "结束时间戳")
    private Long endTime;

    public boolean isBlankAboutPageParam() {
        return super.blank();
    }

    public boolean blank() {
        return super.blank() || startTime == null || endTime == null;
    }

}
