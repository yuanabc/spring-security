package com.ybinsure.auth.endpoint.data;

import com.ybinsure.auth.annotation.QueryPageAction;
import com.ybinsure.auth.annotation.UpdateAction;
import com.ybinsure.auth.constant.ApiPath;
import com.ybinsure.auth.model.data.UserDO;
import com.ybinsure.auth.model.transfer.Result;
import com.ybinsure.auth.model.transfer.page.PageParam;
import com.ybinsure.auth.model.transfer.page.PageResult;
import com.ybinsure.auth.service.data.UserService;
import com.ybinsure.auth.service.tool.VerificationCodeService;
import com.ybinsure.auth.service.wrap.UserWrapService;
import com.ybinsure.auth.util.AuthenticationHelper;
import com.ybinsure.auth.util.ValidatedResultUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserEndpoint {

    private final UserService userService;
    private final UserWrapService userWrapService;
    private final VerificationCodeService verificationCodeService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping(ApiPath.USER_UPDATE)
    public Result<Boolean> update(
            @Validated(UpdateAction.class) @RequestBody() UserDO userDO, BindingResult bindingResult
    ) {
        ValidatedResultUtil.checkFieldThrow(bindingResult);
        if (userService.update(userDO)) {
            return Result.success();
        }
        return Result.nonError();
    }

    @DeleteMapping(ApiPath.USER_DELETE)
    public Result<Boolean> delete(@PathVariable("id") String id) {
        UserDO userDO = new UserDO();
        userDO.setId(id);
        if (!userService.isExistById(id)) {
            return Result.nonError("用户不存在, ");
        }
        if (userWrapService.delete(id)) {
            return Result.success();
        }
        return Result.nonError();
    }

    @DeleteMapping(ApiPath.USER_DISABLE)
    public Result<Boolean> disable(@PathVariable("id") String id) {
        UserDO userDO = new UserDO();
        userDO.setId(id);
        if (!userService.isExistById(id)) {
            return Result.nonError("用户不存在, ");
        }
        if (userWrapService.disable(id)) {
            return Result.success();
        }
        return Result.nonError();
    }

    @DeleteMapping(ApiPath.USER_RECOVERY)
    public Result<Boolean> recovery(@PathVariable("id") String id) {
        UserDO userDO = new UserDO();
        userDO.setId(id);
        if (!userService.isExistById(id)) {
            return Result.nonError("用户不存在, ");
        }
        if (userService.recovery(id)) {
            return Result.success();
        }
        return Result.nonError();
    }

    @PostMapping(ApiPath.USER_RESET_PASSWORD)
    public Result<String> resetPassword(@RequestParam("id") String id, @RequestParam("sendMessage") Boolean sendMessage) {
        Optional<UserDO> userDOOptional = userService.query(id);
        if (!userDOOptional.isPresent()) {
            return Result.nonError("用户不存在, ");
        }
        if (sendMessage && this.verificationCodeService.isCd(userDOOptional.get().getPhone(), userDOOptional.get().getChannelCode())) {
            return Result.nonError("短信发送频繁, ");
        }
        return this.userService.resetPassword(id, sendMessage).map(Result::success).orElseGet(Result::nonError);
    }

    @PostMapping(ApiPath.USER_CHANGE_PASSWORD)
    public Result<Boolean> changePassword(@RequestParam("sourcePassWord") String sourcePassword, @RequestParam("newPassword") String newPassword) {
        Optional<UserDO> userInfoOptional = AuthenticationHelper.localContextHolderParser().getId().flatMap(userService::queryAll);
        if (!userInfoOptional.isPresent()) {
            return Result.nonError("用户不存在");
        }

        if (!passwordEncoder.matches(sourcePassword, userInfoOptional.get().getPassword())) {
            return Result.nonError("密码不正确");
        }
        if (!userService.updatePassword(userInfoOptional.get().getId(), newPassword)) {
            return Result.nonError();
        }
        return Result.success();
    }

    @PostMapping(ApiPath.USER_QUERY_BY_CODES)
    public Result<List<UserDO>> queryByCode(@RequestBody() List<Long> codes) {
        return Result.success(userService.queryByCodes(codes).orElseGet(ArrayList::new));
    }

    @PostMapping(ApiPath.USER_QUERY_BY_AGENT_CODE)
    public Result<UserDO> queryByAgentCode(@RequestBody() UserDO param) {
        return userService.queryByAgentCode(param.getAgentCode(), param.getChannelCode()).map(Result::success).orElseGet(Result::nonError);
    }

    @PostMapping(ApiPath.USER_QUERYS)
    public Result<List<UserDO>> querys(@RequestBody() List<String> ids) {
        return Result.success(userService.querys(ids).orElseGet(ArrayList::new));
    }

    @PostMapping(ApiPath.SALES_QUERY_WITH_PAGE)
    public Result<PageResult<List<UserDO>>> queryWithPage(
            @Validated(QueryPageAction.class) @RequestBody() PageParam<UserDO> pageParam, BindingResult bindingResult
    ) {
        ValidatedResultUtil.checkFieldThrow(bindingResult);
        return Result.success(userService.queryAgentWithPage(pageParam).orElseGet(PageResult::new));
    }

    @GetMapping(ApiPath.USER_IS_EXIST_BY_ID)
    public Result<Boolean> isExistById(@PathVariable("id") String id) {
        return Result.success(userService.isExistById(id));
    }

    @GetMapping(ApiPath.USER_IS_EXIST_BY_USER_NAME)
    public Result<Boolean> isExistByUserName(@PathVariable("userName")String username) {
        return Result.success(userService.isExistByUserName(username));
    }

    @PostMapping(ApiPath.USER_IS_EXIST_BY_USER_NAME_AND_CHANNEL_CODE)
    public Result<Boolean> isExistByUserNameAndChannelCode(@RequestParam("userName") String userName, @RequestParam("channelCode") String channelCode) {
        return Result.success(userService.isExistByUserNameAndChannelCode(userName, channelCode));
    }

    @PostMapping(ApiPath.USER_IS_EXIST_BY_AGENT_CODE_AND_CHANNEL_CODE)
    public Result<Boolean> isExistByAgentCodeAndChannelCode(@RequestParam("agentCode") String agentCode, @RequestParam("channelCode") String channelCode) {
        return Result.success(userService.isExistByAgentCodeAndChannelCode(agentCode, channelCode));
    }

}
