package com.ybinsure.auth.model.transfer.page;

import com.ybinsure.auth.annotation.validator.QueryPageAction;
import com.ybinsure.auth.util.SqlPatternUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 分页查询请求参数
 * Created by eric on 17-12-1
 */
@ApiModel(description = "分页查询请求参数")
@Setter
@Getter
public class PageParam<T> {

    @Min(groups = {QueryPageAction.class}, value = 0, message = "page不能小于0")
    @NotNull(groups = {QueryPageAction.class}, message = "page不能为空")
    @ApiModelProperty(value = "分页页码")
    private Integer page;

    @Min(groups = {QueryPageAction.class}, value = 0, message = "size不能小于0")
    @Max(groups = {QueryPageAction.class}, value = 60, message = "size不能大于60")
    @NotNull(groups = {QueryPageAction.class}, message = "size不能为空")
    @ApiModelProperty(value = "分页大小")
    private Integer size;

    @ApiModelProperty(value = "查询关键字")
    private String keyword;

    @Valid()
    @NotNull(groups = {QueryPageAction.class}, message = "model不能为空")
    @ApiModelProperty(value = "分页查询入参")
    private T model;

    public boolean blank() {
        return page == null || size == null;
    }

    // 设置模糊查询参数
    public void setKeywordPattern() {
        if (StringUtils.isNotBlank(getKeyword())) {
            setKeyword(SqlPatternUtil.getPattern(getKeyword()));
        }
    }

}
