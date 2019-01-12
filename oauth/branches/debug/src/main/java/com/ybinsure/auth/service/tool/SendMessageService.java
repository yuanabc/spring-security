package com.ybinsure.auth.service.tool;

import com.ybinsure.auth.model.tool.SendMessage;

/**
 * 发送短信服务
 */
public interface SendMessageService {

    /**
     * 发送短信
     * @param sendMessage 短信对象
     * @return 是否发送成功
     */
    boolean sendMessage(SendMessage sendMessage);
    
}
