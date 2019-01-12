package com.ybinsure.auth.serviceImpl.tool;

import com.ybinsure.auth.constant.CacheKey;
import com.ybinsure.auth.model.tool.SendMessage;
import com.ybinsure.auth.service.tool.SendMessageService;
import com.ybinsure.auth.service.tool.VerificationCodeService;
import com.ybinsure.auth.util.TokenUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class DefaultVerificationCodeService implements VerificationCodeService {


    private final SendMessageService sendMessageService;
    private final StringRedisTemplate stringRedisTemplate;

    @Override
    public Optional<String> sendVerificationCode(String phone, String channelCode) {
        if (StringUtils.isBlank(phone) || StringUtils.isBlank(channelCode)) {
            return Optional.empty();
        }
        String verificationCode = TokenUtils.verificationCode();
        SendMessage param = sendMessageInstance(phone, verificationCode);
        if (sendMessageService.sendMessage(param)) {
            stringRedisTemplate.opsForValue().set(CacheKey.verificationCode + phone + channelCode, verificationCode, 5, TimeUnit.MINUTES);
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

    private SendMessage sendMessageInstance(String phone, String verificationCode) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setMobile(phone);
        sendMessage.setText(verificationMessageText(verificationCode));
        return sendMessage;
    }

    private String verificationMessageText(String verificationCode) {
        String template = "【悦保科技】您的验证码是%s，5分钟内有效。如非本人操作，请忽略本短信";
        return String.format(template, verificationCode);
    }

    private String defaultPasswordMessageText(String password) {
        String template = "【悦保科技】您重置的密码是%s。如非本人操作，请忽略本短信";
        return String.format(template, password);
    }

    private void addSendCount(String phone, String channelCode) {
        String realKey = CacheKey.verificationCodeCD + phone + channelCode;
        if (stringRedisTemplate.hasKey(realKey)) {
            stringRedisTemplate.opsForValue().increment(realKey, 1);
            return;
        }
        stringRedisTemplate.opsForValue().set(realKey, "1", 1, TimeUnit.HOURS);
    }

    @Override
    public boolean isExist(String phone, String channelCode) {
        if (StringUtils.isBlank(phone) || StringUtils.isBlank(channelCode)) {
            return false;
        }
        return stringRedisTemplate.hasKey(CacheKey.verificationCode + phone + channelCode);
    }

    @Override
    public boolean isCd(String phone, String channelCode) {
        if (StringUtils.isBlank(phone) || StringUtils.isBlank(channelCode)) {
            return false;
        }
        String existValue = stringRedisTemplate.opsForValue().get(CacheKey.verificationCodeCD + phone + channelCode);
        return Optional.ofNullable(existValue).map(Integer::valueOf).orElse(0) >= 3;
    }

    @Override
    public boolean verification(String phone, String channelCode, String verificationCode) {
        if (StringUtils.isBlank(phone) || StringUtils.isBlank(channelCode) || StringUtils.isBlank(verificationCode)) {
            return false;
        }
        String cacheCode = stringRedisTemplate.opsForValue().get(CacheKey.verificationCode + phone + channelCode);
        // 验证后清除掉缓存的验证码
        if (StringUtils.equals(cacheCode, verificationCode)) {
            stringRedisTemplate.delete(CacheKey.verificationCode + phone + channelCode);
        }
        return verificationCode.equals(cacheCode);
    }

}
