package com.ybinsure.icar.user.controller.account;

import com.ybinsure.icar.user.annotation.ControllerLog;
import com.ybinsure.icar.user.constant.ApiPath;
import com.ybinsure.icar.user.model.ICarResult;
import com.ybinsure.icar.user.model.param.FeedbackParam;
import com.ybinsure.icar.user.model.vo.FeedbackVO;
import com.ybinsure.icar.user.service.data.FeedbackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 意见反馈接口
 *
 * @author HANHT
 * @version 2018/7/7 18:58
 */
@RestController
public class FeedbackController {

    private static final Logger logger = LoggerFactory.getLogger(FeedbackController.class);

    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @ControllerLog(description = "意见反馈")
    @PostMapping(ApiPath.ACCOUNT_FEEDBACK)
    public ICarResult<FeedbackVO> feedback(@Validated FeedbackParam param) {

        return feedbackService.addFeedback(param).map(ICarResult::ok).orElseGet(ICarResult::fail);
    }
}
