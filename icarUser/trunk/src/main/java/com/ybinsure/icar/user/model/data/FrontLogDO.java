package com.ybinsure.icar.user.model.data;

import java.io.Serializable;
import java.util.Date;

/**
 * 前端页面日志
 *
 * @author HANHT
 * @version 2018/7/12 15:55
 */
public class FrontLogDO implements Serializable {
    private Long id;

    /** 错误请求地址 */
    private String error_url;

    /** 错误详情 */
    private String error_msg;

    /** 添加时间 */
    private Date gmt_create;

    /** 修改时间 */
    private Date gmt_modified;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getError_url() {
        return error_url;
    }

    public void setError_url(String error_url) {
        this.error_url = error_url == null ? null : error_url.trim();
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg == null ? null : error_msg.trim();
    }

    public Date getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Date gmt_create) {
        this.gmt_create = gmt_create;
    }

    public Date getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(Date gmt_modified) {
        this.gmt_modified = gmt_modified;
    }
}