package com.ybinsure.icar.user.service.impl;

import com.ybinsure.icar.user.constant.SwitchCode;
import com.ybinsure.icar.user.mapper.data.FeedbackDOMapper;
import com.ybinsure.icar.user.model.data.FeedbackDO;
import com.ybinsure.icar.user.model.param.FeedbackParam;
import com.ybinsure.icar.user.model.vo.FeedbackVO;
import com.ybinsure.icar.user.service.data.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

/**
 * 意见反馈服务
 *
 * @author HANHT
 * @version 2018/7/7 19:07
 */
@Service
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackDOMapper feedbackDOMapper;

    @Autowired
    public FeedbackServiceImpl(FeedbackDOMapper feedbackDOMapper) {
        this.feedbackDOMapper = feedbackDOMapper;
    }

    @Override
    public Optional<FeedbackVO> addFeedback(FeedbackParam param) {
        FeedbackDO feedbackDO = new FeedbackDO();
        feedbackDO.setuId(param.getAuth());
        feedbackDO.setContent(param.getContent());
        feedbackDO.setCreateTime(new Date());
        feedbackDO.setType(SwitchCode.DISABLE);

        return feedbackDOMapper.insertSelective(feedbackDO) > 0 ? Optional.of(new FeedbackVO(feedbackDO.getId())) : Optional.empty();
    }
}
