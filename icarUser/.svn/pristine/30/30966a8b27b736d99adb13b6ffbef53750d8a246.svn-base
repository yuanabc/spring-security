package com.ybinsure.icar.user.controller.account;

import com.ybinsure.icar.user.annotation.ControllerLog;
import com.ybinsure.icar.user.constant.ApiPath;
import com.ybinsure.icar.user.constant.RespInfo;
import com.ybinsure.icar.user.model.ICarResult;
import com.ybinsure.icar.user.model.PageInfo;
import com.ybinsure.icar.user.model.vo.MessageVO;
import com.ybinsure.icar.user.service.data.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消息通知服务接口
 *
 * @author HANHT
 * @version 2018/7/10 21:29
 */
@RestController
public class MessageController {

    private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    /**
     * 获取用户消息通知
     *
     * @param param 入参
     * @return 消息列表
     */
    @ControllerLog(description = "获取用户消息通知")
    @PostMapping(ApiPath.ACCOUNT_NOTIFY)
    public ICarResult<PageInfo<MessageVO>> listNotify(PageInfo param) {
        Assert.hasText(param.getAuth(), RespInfo.F530.msg);

        return ICarResult.ok(messageService.queryUserNotify(param).orElseGet(PageInfo::new));
    }
}
