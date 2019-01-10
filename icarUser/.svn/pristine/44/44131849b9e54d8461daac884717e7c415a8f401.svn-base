package com.ybinsure.icar.user.controller.front;

import com.ybinsure.icar.user.constant.ApiPath;
import com.ybinsure.icar.user.model.ICarResult;
import com.ybinsure.icar.user.model.param.FrontParam;
import com.ybinsure.icar.user.service.data.FrontLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 前端页面操作接口
 *
 * @author HANHT
 * @version 2018/7/12 15:46
 */
@RestController
public class FrontController {

    private static final Logger logger = LoggerFactory.getLogger(FrontController.class);

    private final FrontLogService frontLogService;

    @Autowired
    public FrontController(FrontLogService frontLogService) {
        this.frontLogService = frontLogService;
    }

    /**
     * 前端页面上传错误日志
     */
    @PostMapping(ApiPath.FRONT_UPLOAD_ERROR_LOG)
    public ICarResult uploadErrorLog(@Validated FrontParam param) {

        frontLogService.saveErrorLog(param);

        return ICarResult.ok();
    }
}
