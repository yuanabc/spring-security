package com.ybinsure.auth.service.tool;

public interface TokenService {

    /**
     * 字符uuid
     */
    String suuid();

    /**
     * 数字id
     */
    long nuuid();

    /**
     * 随机验证码
     */
    int verificationCode();

    /**
     * 默认密码
     */
    String defaultPassword();

}
