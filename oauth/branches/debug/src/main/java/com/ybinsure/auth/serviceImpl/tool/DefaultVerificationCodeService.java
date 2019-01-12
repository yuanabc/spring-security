package com.ybinsure.auth.serviceImpl.tool;

import com.ybinsure.auth.model.tool.SendMessage;
import com.ybinsure.auth.service.tool.CacheService;
import com.ybinsure.auth.service.tool.SendMessageService;
import com.ybinsure.auth.service.tool.TokenService;
import com.ybinsure.auth.service.tool.VerificationCodeService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class DefaultVerificationCodeService implements VerificationCodeService {

    private static final String prefix = "auth_verification_code_";
    private static final String cdPrefix = "auth_verification_code_cd_";
    private final SendMessageService sendMessageService;
    private final CacheService cacheService;
    private final TokenService tokenService;

    @Override
    public Optional<Integer> sendVerificationCode(String phone, String channelCode) {
        if (StringUtils.isBlank(phone) || StringUtils.isBlank(channelCode)) {
            return Optional.empty();
        }
        int verificationCode = tokenService.verificationCode();
        SendMessage param = sendMessageInstance(phone, verificationCode);
        if (sendMessageService.sendMessage(param)) {
            cacheService.insert(prefix + phone + channelCode, verificationCode, 60 * 5, TimeUnit.SECONDS);
            addSendCount(phone, channelCode);
            return Optional.of(verificationCode);
        }
        return Optional.empty();
    }

    @Override
    public Optional<String> sendDefaultPassword(String phone, String channelCode, String password) {
        if (StringUtils.isBlank(phone) || StringUtils.isBlank(channelCode) || StringUtils.isBlank(password)) {
            return Optional.empty();
        }
        SendMessage param = new SendMessage();
        param.setMobile(phone);
        param.setText(defaultPasswordMessageText(password));
        if (sendMessageService.sendMessage(param)) {
            addSendCount(phone, channelCode);
            return Optional.of(password);
        }
        return Optional.empty();
    }

    private SendMessage sendMessageInstance(String phone, int verificationCode) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setMobile(phone);
        sendMessage.setText(verificationMessageText(verificationCode));
        return sendMessage;
    }

    private String verificationMessageText(int verificationCode) {
        String template = "【悦保科技】您的验证码是%s，5分钟内有效。如非本人操作，请忽略本短信";
        return String.format(template, verificationCode);
    }

    private String defaultPasswordMessageText(String password) {
        String template = "【悦保科技】您重置的密码是%s。如非本人操作，请忽略本短信";
        return String.format(template, password);
    }

    private void addSendCount(String phone, String channelCode) {
        byte count = cacheService.<Byte>query(cdPrefix + phone + channelCode).orElse((byte) 0);
        cacheService.insert(cdPrefix + phone + channelCode, ++count, 1, TimeUnit.HOURS);
    }

    @Override
    public boolean isExist(String phone, String channelCode) {
        if (StringUtils.isBlank(phone) || StringUtils.isBlank(channelCode)) {
            return false;
        }
        return cacheService.exists(prefix + phone + channelCode);
    }

    @Override
    public boolean isCd(String phone, String channelCode) {
        if (StringUtils.isBlank(phone) || StringUtils.isBlank(channelCode)) {
            return false;
        }
        return cacheService.<Byte>query(cdPrefix + phone + channelCode).orElse((byte) 0) >= 3;
    }

    @Override
    public boolean verification(String phone, String channelCode, String verificationCode) {
        if (StringUtils.isBlank(phone) || StringUtils.isBlank(channelCode) || StringUtils.isBlank(verificationCode)) {
            return false;
        }
        String cacheCode = String.valueOf(cacheService.query(prefix + phone + channelCode).orElse(""));
        // 验证后清除掉缓存的验证码
        if (verificationCode.equals(cacheCode)) {
            cacheService.remove(prefix + phone + channelCode);
        }
        return verificationCode.equals(cacheCode);
    }

}
