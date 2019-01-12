package com.ybinsure.auth.model.transfer.page;

/**
 * 分页数据
 * Created by eric on 17-12-1
 */
public class PageResult<T> {

    private Long count;
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

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }
}
