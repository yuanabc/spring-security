package com.ybinsure.auth.model.transfer.page;

import com.ybinsure.auth.annotation.QueryPageAction;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 分页查询请求参数
 * Created by eric on 17-12-1
 */
public class PageParam<T> {

    @Min(groups = {QueryPageAction.class}, value = 0, message = "page不能小于0")
    @NotNull(groups = {QueryPageAction.class}, message = "page不能为空")
    private Integer page;

    @Min(groups = {QueryPageAction.class}, value = 0, message = "size不能小于0")
    @Max(groups = {QueryPageAction.class}, value = 60, message = "size不能大于60")
    @NotNull(groups = {QueryPageAction.class}, message = "size不能为空")
    private Integer size;

    @Valid()
    @NotNull(groups = {QueryPageAction.class}, message = "model不能为空")
    private T model;

    public PageParam() {
    }

    public boolean blank() {
        return page == null || size == null;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }
}
