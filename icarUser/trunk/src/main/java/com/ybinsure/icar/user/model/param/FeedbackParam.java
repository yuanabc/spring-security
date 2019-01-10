package com.ybinsure.icar.user.model.param;

import com.ybinsure.icar.user.model.AuthInfo;
import com.ybinsure.icar.user.util.JsonUtil;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 意见反馈入参
 *
 * @author HANHT
 * @version 2018/7/7 19:00
 */
public class FeedbackParam extends AuthInfo {

    /** 反馈详情 */
    @NotBlank(message = "反馈问题详情不能为空")
    @Length(max = 1000, message = "反馈问题内容太长")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return JsonUtil.toJson(this).orElse("");
    }
}
