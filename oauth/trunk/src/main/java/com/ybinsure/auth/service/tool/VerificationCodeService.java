package com.ybinsure.auth.service.tool;

import java.util.Optional;

public interface VerificationCodeService {

    /**
     * 发送验证码
     * @param phone 接受验证码手机号码
     * @param channelCode 渠道编码
     * @return 发送结果
     */
    Optional<String> sendVerificationCode(String phone, String channelCode);

    /**
     * 发送默认密码
     * @param phone 手机号码
     * @param channelCode 渠道编码
     * @param password 密码
     * @return 发送结果
     */
    Optional<String> sendDefaultPassword(String phone, String channelCode, String password);

    /**
     * 检查是否在存在验证码
     * @param phone 手机号码
     * @param channelCode 渠道编码
     * @return 检查结果
     */
    boolean isExist(String phone, String channelCode);

    /**
     * 检查是否进入冷却期
     * @param phone 手机号码
     * @param channelCode 渠道编码
     * @return 检查结果
     */
    boolean isCd(String phone, String channelCode);

    /**
     * 验证验证码是否正确
     * @param phone 手机号码
     * @param channelCode 渠道编码
     * @param verificationCode 验证码
     * @return 验证结果
     */
    boolean verification(String phone, String channelCode, String verificationCode);

}
