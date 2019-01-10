package com.ybinsure.icar.user.service.impl;

import com.ybinsure.icar.user.mapper.data.FrontLogDOMapper;
import com.ybinsure.icar.user.model.data.FrontLogDO;
import com.ybinsure.icar.user.model.param.FrontParam;
import com.ybinsure.icar.user.service.data.FrontLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * 前端页面功能服务
 *
 * @author HANHT
 * @version 2018/7/12 15:41
 */
@Service
public class FrontLogServiceImpl implements FrontLogService {

    private static final Logger logger = LoggerFactory.getLogger(FrontLogServiceImpl.class);

    private final FrontLogDOMapper frontLogDOMapper;

    @Autowired
    public FrontLogServiceImpl(FrontLogDOMapper frontLogDOMapper) {
        this.frontLogDOMapper = frontLogDOMapper;
    }

    @Override
    public void saveErrorLog(FrontParam param) {
        String url = param.getUrl();
        String message = param.getMessage();

        Assert.hasText(url, "必要参数为空");
        Assert.hasText(message, "必要参数为空");

        FrontLogDO log = new FrontLogDO();
        log.setError_url(url.length() > 50 ? url.substring(0, 50) : url);
        log.setError_msg(message.length() > 500 ? message.substring(0, 500) : message);

        try {
            frontLogDOMapper.insertSelective(log);
        } catch (Exception e) {
            logger.error("前端页面错误日志添加失败：{}", e.getMessage());
        }
    }
}
