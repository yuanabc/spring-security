package com.ybinsure.auth.model.tool;

import com.ybinsure.auth.model.data.UserDO;
import org.hibernate.validator.constraints.NotBlank;

public class CaptchaUser extends UserDO {

    @NotBlank(groups = {VerifyCaptchaWithUserName.class, VerifyCaptchaWithPhone.class, Verify.class}, message = "captcha不能为空")
    private String captcha;

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public interface VerifyCaptchaWithUserName {}
    public interface VerifyCaptchaWithPhone {}
    public interface Verify{}
}
