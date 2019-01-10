package com.ybinsure.icar.user.controller.wechat;

import com.ybinsure.icar.user.annotation.ControllerLog;
import com.ybinsure.icar.user.constant.ApiPath;
import com.ybinsure.icar.user.model.ICarResult;
import com.ybinsure.icar.user.service.func.WechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信服务
 *
 * @author HANHT
 * @version 2018/7/9 15:03
 */
@RestController
public class WechatController {

    private final WechatService wechatService;

    @Autowired
    public WechatController(WechatService wechatService) {
        this.wechatService = wechatService;
    }

    /**
     * 微信链接分享
     *
     * @param url 分享地址
     */
    @ControllerLog(description = "微信链接分享")
    @PostMapping(ApiPath.WECHAT_SHARE_LINK)
    public ICarResult wechatShare(String url) throws Exception {
        Assert.hasText(url, "分享地址不能为空");

        return ICarResult.ok(wechatService.getInfo(url));
    }
}
