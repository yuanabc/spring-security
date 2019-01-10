package com.ybinsure.icar.user.model.dto;

import com.ybinsure.icar.user.util.BeanUtil;

import java.util.Map;

/**
 * 用户认证接口信息
 *
 * @author HANHT
 * @version 2018/7/10 20:26
 */
public class UserAuthDTO {

    /** 客户端id */
    private String client_id;
    /** 客户端密码 */
    private String client_secret;
    /** 授权类型(见下说明) */
    private String grant_type;
    /** 用户名 */
    private String username;
    /** 用户密码 */
    private String password;

    public UserAuthDTO() {
        this.client_id = "yuebao-manager";
        this.client_secret = "c33367701511b4f6020ec61ded352059";
        this.grant_type = "password";
        this.password = "87aee03dc1b08b90cb22ee7993a04905";
    }

    public UserAuthDTO(String username) {
        this();
        this.username = username;
    }

    public static UserAuthDTO instance(String username, String channelCode) {

        return new UserAuthDTO(username + "---" + channelCode);
    }

    public Map<String, Object> assembleParam() {

        return BeanUtil.simpleObj2Map(this);
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
