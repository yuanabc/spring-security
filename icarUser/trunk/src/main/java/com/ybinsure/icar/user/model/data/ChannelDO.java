package com.ybinsure.icar.user.model.data;

import java.io.Serializable;

/**
 * 渠道
 *
 * @author HANHT
 * @version 2018/7/4 18:5
 */
public class ChannelDO implements Serializable {
    /** id */
    private String id;

    /** 用户分类编码 */
    private String outCode;

    /** 内部code,兼容老数据 */
    private String code;

    /** 渠道编号 生成业务主键用 */
    private Short orderCode;

    /** 渠道名称 */
    private String shortName;

    /** 渠道全称 */
    private String fullName;

    /** 同步账号 */
    private String userName;

    /** 同步密码 */
    private String passWord;

    /** 联系邮箱 */
    private String email;

    /** 生效时间 */
    private Long startTime;

    /** 失效时间 */
    private Long expireTime;

    /** 备注信息 */
    private String backUp;

    /** 渠道分类 */
    private String type;

    /** 关联渠道编码 */
    private String proxyChannelCode;

    private Byte sourceType;

    private Integer sort;

    /** 是否逻辑删除 */
    private Byte deleted;

    /** 更新时间 */
    private Long updateTime;

    /** 创建时间 */
    private Long createTime;

    /** 0 可用 1不可用 */
    private Byte status;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOutCode() {
        return outCode;
    }

    public void setOutCode(String outCode) {
        this.outCode = outCode == null ? null : outCode.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Short getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(Short orderCode) {
        this.orderCode = orderCode;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public String getBackUp() {
        return backUp;
    }

    public void setBackUp(String backUp) {
        this.backUp = backUp == null ? null : backUp.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getProxyChannelCode() {
        return proxyChannelCode;
    }

    public void setProxyChannelCode(String proxyChannelCode) {
        this.proxyChannelCode = proxyChannelCode == null ? null : proxyChannelCode.trim();
    }

    public Byte getSourceType() {
        return sourceType;
    }

    public void setSourceType(Byte sourceType) {
        this.sourceType = sourceType;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Byte getDeleted() {
        return deleted;
    }

    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}