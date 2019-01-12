package com.ybinsure.auth.serviceImpl.tool;

import com.ybinsure.auth.model.tool.SendMessage;
import com.ybinsure.auth.model.tool.SendMessageResult;
import com.ybinsure.auth.service.tool.HttpService;
import com.ybinsure.auth.service.tool.SendMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultSendMessageService implements SendMessageService {

    @Value("${send.message.url}")
    private String messageUrl;

    @Value("${send.message.key}")
    private String messageKey;

    private final HttpService httpService;

    @Override
    public boolean sendMessage(SendMessage sendMessage) {
        setApiInfo(sendMessage);
        Optional<SendMessageResult> sendMessageResult = httpService.postEncode(messageUrl, sendMessage.convertParam(), SendMessageResult.class);
        return sendMessageResult.isPresent() && SendMessageResult.SUCCESS_CODE.equals(sendMessageResult.get().getCode());
    }

    private void setApiInfo(SendMessage sendMessage) {
        sendMessage.setKey(messageKey);
    }

}
