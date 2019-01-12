package com.ybinsure.auth.model.transfer.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 分页数据
 * Created by eric on 17-12-1
 */
@Setter
@Getter
@ApiModel(description = "分页查询响应结果")
public class PageResult<T> {

    @ApiModelProperty(value = "符合条件的数据总量")
    private Long count;

    @ApiModelProperty(value = "响应的数据")
    private T model;

    public PageResult() {
    }

    public PageResult(Long count, T model) {
        this.count = count;
        this.model = model;
    }

    public static <T> PageResult<T> instance(Long count, T model) {
        return new PageResult<>(count, model);
    }

}
