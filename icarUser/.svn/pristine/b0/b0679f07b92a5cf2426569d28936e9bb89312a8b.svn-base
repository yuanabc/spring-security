package com.ybinsure.icar.user.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.pagehelper.Page;
import com.ybinsure.icar.user.util.JsonUtil;
import com.ybinsure.icar.user.util.StrUtil;

import java.io.Serializable;
import java.util.List;

/**
 * @author HANHT
 * @version 2018/7/2 19:52
 */
@SuppressWarnings({"rawtypes", "unchecked"})
@JsonIgnoreProperties(ignoreUnknown = true, value = {"sortord"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PageInfo<T> extends AuthInfo implements Serializable {

    /** 页码 */
    private Integer pageNum;
    /** 每页记录数 */
    private Integer pageSize;
    /** 总记录数 */
    private Long total;
    /** 总页数 */
    private Integer pages;
    /** 结果集 */
    private List<T> list;
    /** 排序字段 */
    private String orderBy;
    /** 排序方式：0升序/1降序 */
    private Integer sortord;

    public PageInfo() {
        this.total = 0L;
        this.pages = 0;
    }

    public PageInfo(List<T> list) {
        if (list != null) {
            this.total = StrUtil.toLong(list.size(), 0);
            this.list = list;
        }
    }

    public PageInfo(Page page) {
        this.pageNum = page.getPageNum();
        this.pageSize = page.getPageSize();
        this.total = page.getTotal();
        this.pages = page.getPages();
    }

    public static <T> PageInfo<T> instance(Page<T> page) {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNum(page.getPageNum());
        pageInfo.setPageSize(page.getPageSize());
        pageInfo.setTotal(page.getTotal());
        pageInfo.setPages(page.getPages());
        pageInfo.setList(page);

        return pageInfo;
    }

    public String assembleSort() {
        if (StrUtil.isBlank(this.orderBy)) {

            return "";
        }

        return this.orderBy + (0 == this.sortord ? " asc" : " desc");
    }

    public Integer getPageNum() {
        if (pageNum == null || pageNum == 0) {
            pageNum = 1;
        }
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        if (pageSize == null || pageSize == 0) {
            pageSize = 20;
        }
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Integer getSortord() {
        return sortord;
    }

    public void setSortord(Integer sortord) {
        this.sortord = sortord;
    }

    @Override
    public String toString() {
        return JsonUtil.toJson(this).orElse("");
    }
}
