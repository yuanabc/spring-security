package com.ybinsure.icar.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ybinsure.icar.user.annotation.WithoutAuthorization;
import com.ybinsure.icar.user.auth.AuthenticationHelper;
import com.ybinsure.icar.user.exception.AuthenticationException;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 身份认证
 *
 * @author HANHT
 * @version 2018/7/7 11:21
 */
public class AuthInfo {

    /** 登录用户认证令牌 */
    @NotBlank(groups = {WithoutAuthorization.class}, message = "认证信息不能为空")
    private String token;

    @JsonIgnore
    public String getAuth() {

        return AuthenticationHelper.getId().orElseThrow(AuthenticationException::unauthorized);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
