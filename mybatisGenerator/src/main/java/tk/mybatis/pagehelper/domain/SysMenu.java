package tk.mybatis.pagehelper.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统菜单/页内权限相关按钮按钮
 *
 * @author yuant
 * @version 2018/8/2 19:59
 */
public class SysMenu implements Serializable {
    /** 菜单id */
    private String id;

    /** 父菜单ID，一级菜单为0 */
    private String parentId;

    /** 名称 */
    private String name;

    /** 图标的url */
    private String icon;

    /** 菜单授权标识（格式如sys:user:list,sys:user:save） */
    private String perm;

    /** 菜单类型（0：目录   1：菜单   2：按钮或其他可点击的元素） */
    private Integer type;

    /** 菜单排序 */
    private Integer orderNum;

    /** 是否删除(1:删除  0:未删除) */
    private String isDelete;

    /** 是否启用(1:启用  0:不启用) */
    private String isEnable;

    private Date createdTime;

    private Date updateTime;

    /** 是否隐藏菜单(1:隐藏 0:不隐藏) */
    private String hidden;

    /** 是否作为子菜单显示(1:是 0:否) */
    private String alwaysShow;

    /** 组件路径 */
    private String component;

    /** 是否重定向路径,默认'noredirect' */
    private String redirect;

    /** 创建者 */
    private String createUser;

    /** 菜单的显示名称 */
    private String title;

    /** 请求的method */
    private String method;

    /** 菜单path */
    private String path;

    /** 请求后端的URL */
    private String url;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getPerm() {
        return perm;
    }

    public void setPerm(String perm) {
        this.perm = perm == null ? null : perm.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    public String getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable == null ? null : isEnable.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getHidden() {
        return hidden;
    }

    public void setHidden(String hidden) {
        this.hidden = hidden == null ? null : hidden.trim();
    }

    public String getAlwaysShow() {
        return alwaysShow;
    }

    public void setAlwaysShow(String alwaysShow) {
        this.alwaysShow = alwaysShow == null ? null : alwaysShow.trim();
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component == null ? null : component.trim();
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect == null ? null : redirect.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}