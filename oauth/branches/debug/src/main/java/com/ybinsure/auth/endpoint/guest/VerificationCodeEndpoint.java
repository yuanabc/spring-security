package com.ybinsure.auth.endpoint.guest;

import com.ybinsure.auth.constant.ApiPath;
import com.ybinsure.auth.constant.ChannelCode;
import com.ybinsure.auth.constant.PermissionCode;
import com.ybinsure.auth.model.data.UserDO;
import com.ybinsure.auth.model.tool.CaptchaUser;
import com.ybinsure.auth.model.transfer.Result;
import com.ybinsure.auth.service.data.ChannelService;
import com.ybinsure.auth.service.data.UserService;
import com.ybinsure.auth.service.tool.VerificationCodeService;
import com.ybinsure.auth.util.RegUtils;
import com.ybinsure.auth.util.ValidatedResultUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class VerificationCodeEndpoint {

    private final UserService userService;
    private final VerificationCodeService verificationCodeService;
    private final ChannelService channelService;

    /**
     * 后台账号发送验证码
     */
    @GetMapping(ApiPath.GUEST_VERIFICATION_CODE_SEND_WITH_USERNAME)
    public Result<Void> verificationCodeSendWithUserName(@PathVariable("userName") String userName) {
        if (RegUtils.isPhoneNum(userName)) {
            return Result.nonError("用户名不能是手机号码");
        }
        return verificationCodeSend(userService.queryByUserName(userName));
    }

    /**
     * 前端账号发送验证码
     * 对外是phone，其实是userName
     */
    @PostMapping(ApiPath.GUEST_VERIFICATION_CODE_SEND_WITH_PHONE)
    public Result<Void> verificationCodeSendWithPhone(@RequestParam("phone") String username, @RequestParam("channelCode") String channelCode) {
        if (!RegUtils.isPhoneNum(username)) {
            return Result.nonError("请输入正确的手机号码");
        }
        channelCode = this.channelService.queryInnerCode(channelCode).orElse(channelCode);
        return verificationCodeSend(userService.queryByUserName(username, channelCode));
    }

    /**
     * 发送验证码
     */
    private Result<Void> verificationCodeSend(Optional<UserDO> existUserOptional) {
        if (!existUserOptional.isPresent()) {
            return Result.nonError("该用户不存在");
        }
        if (StringUtils.isBlank(existUserOptional.get().getPhone())) {
            return Result.nonError("该用户没有绑定手机号码");
        }
        if (verificationCodeService.isExist(existUserOptional.get().getPhone(), existUserOptional.get().getChannelCode())) {
            return Result.nonError("该手机号码已经发送了验证码");
        }
        if (verificationCodeService.isCd(existUserOptional.get().getPhone(), existUserOptional.get().getChannelCode())) {
            return Result.nonError("该手机号码发送短信频繁");
        }
        if (!verificationCodeService.sendVerificationCode(existUserOptional.get().getPhone(), existUserOptional.get().getChannelCode()).isPresent()) {
            return Result.nonError("发送验证码失败");
        }
        return Result.success();
    }

    /**
     * 前端账号发送注册验证码
     * 对外是phone，其实是userName
     */
    @PostMapping(ApiPath.GUEST_VERIFICATION_CODE_SEND)
    public Result<Void> verificationCodeSendWithPhone(@PathVariable("phone") String phone) {
        if (!RegUtils.isPhoneNum(phone)) {
            return Result.nonError("请输入正确的手机号码");
        }
        if (verificationCodeService.isExist(phone, ChannelCode.EMPTY)) {
            return Result.nonError("该手机号码已经发送了验证码，5分钟内有效!");
        }
        if (verificationCodeService.isCd(phone, ChannelCode.EMPTY)) {
            return Result.nonError("该手机号码发送短信频繁");
        }
        if (!verificationCodeService.sendVerificationCode(phone, ChannelCode.EMPTY).isPresent()) {
            return Result.nonError("发送验证码失败");
        }
        return Result.success();
    }

    @PostMapping(ApiPath.VERIFICATION_CODE_VERIFY)
    @PreAuthorize("hasAuthority('"+ PermissionCode.admin +"')")
    public Result<Void> verify(
            @Validated(CaptchaUser.Verify.class) @RequestBody() CaptchaUser param, BindingResult bindingResult
    ) {
        ValidatedResultUtil.checkFieldThrow(bindingResult);
        if (!verificationCodeService.verification(param.getPhone(), param.getChannelCode(), param.getCaptcha())) {
            return Result.nonError("验证码错误");
        }
        return Result.success();
    }


    @PostMapping(ApiPath.GUEST_VERIFICATION_CODE_CHANGE_PASSWORD_WITH_USERNAME)
    public Result<Boolean> changePasswordWithUserName(
            @Validated(CaptchaUser.VerifyCaptchaWithUserName.class) @RequestBody()CaptchaUser param, BindingResult bindingResult
    ) {
        ValidatedResultUtil.checkFieldThrow(bindingResult);
        if (RegUtils.isPhoneNum(param.getUserName())) {
            return Result.nonError("用户名不能是手机号码");
        }
        return changePassword(userService.queryByUserName(param.getUserName()), param);
    }

    @PostMapping(ApiPath.GUEST_VERIFICATION_CODE_CHANGE_PASSWORD_WITH_PHONE)
    public Result<Boolean> changePasswordWithPhone(
        @Validated(CaptchaUser.VerifyCaptchaWithPhone.class) @RequestBody() CaptchaUser param, BindingResult bindingResult
    ) {
        ValidatedResultUtil.checkFieldThrow(bindingResult);
        if (!RegUtils.isPhoneNum(param.getPhone())) {
            return Result.nonError("请输入正确的手机号码");
        }
        param.setChannelCode(channelService.queryInnerCode(param.getChannelCode()).orElse(param.getChannelCode()));
        return changePassword(userService.queryByUserName(param.getPhone(), param.getChannelCode()), param);
    }

    private Result<Boolean> changePassword(Optional<UserDO> existUser, CaptchaUser param) {
        if (!existUser.isPresent()) {
            return Result.nonError("该用户不存在");
        }
        // 前后端账号共用手机号码，验证码会混用
        if (!verificationCodeService.verification(existUser.get().getPhone(), existUser.get().getChannelCode(), param.getCaptcha())) {
            return Result.nonError("验证码错误");
        }
        if (userService.updatePassword(existUser.get().getId(), param.getPassword())) {
            return Result.success();
        }
        return Result.nonError("更新密码失败");
    }

}
