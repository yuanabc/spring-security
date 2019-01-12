package com.ybinsure.auth.endpoint.data;

import com.ybinsure.auth.annotation.QueryPageAction;
import com.ybinsure.auth.annotation.UpdateAction;
import com.ybinsure.auth.constant.ApiPath;
import com.ybinsure.auth.constant.ChannelCode;
import com.ybinsure.auth.model.data.ChannelDO;
import com.ybinsure.auth.model.data.UserDO;
import com.ybinsure.auth.model.link.UserExtend;
import com.ybinsure.auth.model.transfer.Result;
import com.ybinsure.auth.model.transfer.page.PageParam;
import com.ybinsure.auth.model.transfer.page.PageResult;
import com.ybinsure.auth.model.transfer.param.UserLinkedQueryWithPageParam;
import com.ybinsure.auth.service.data.ChannelService;
import com.ybinsure.auth.service.data.UserService;
import com.ybinsure.auth.service.link.UserExtendService;
import com.ybinsure.auth.service.tool.VerificationCodeService;
import com.ybinsure.auth.util.AuthenticationHelper;
import com.ybinsure.auth.util.ValidatedResultUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserLinkedEndpoint {

    private final UserExtendService userExtendService;
    private final UserService userService;
    private final ChannelService channelService;
    private final VerificationCodeService verificationCodeService;

    @PostMapping(ApiPath.USER_LINKED_INSERT_USER)
    public Result<String> insertUser(
            @Validated(UserExtend.InsertUserAction.class) @RequestBody() UserExtend param, BindingResult bindingResult
    ) {
        ValidatedResultUtil.checkFieldThrow(bindingResult);
        UserDO user = new UserDO();
        user.setUserName(param.getUserName());
        user.setChannelCode(param.getChannelCode());
        if (userService.isExistByUserName(param.getUserName())) {
            return Result.nonError("用户名已经存在, ");
        }
        if (!channelService.isExist(ChannelDO.createInstanceWithCode(param.getChannelCode()))) {
            return Result.nonError("渠道不存在,");
        }
        if (StringUtils.isBlank(param.getPassword())) {
            param.getMd5PasswordWithPhone().ifPresent(param::setPassword);
        }
        return userExtendService.insertUser(param).map(Result::success).orElseGet(Result::nonError);
    }

    @PostMapping(ApiPath.USER_LINKED_INSERT_SALES)
    public Result<String> insertSales(
            @Validated(UserExtend.InsertSaleAction.class) @RequestBody() UserExtend param, BindingResult bindingResult
    ) {
        ValidatedResultUtil.checkFieldThrow(bindingResult);
        return insertSalesOperate(param);
    }

    @PostMapping(ApiPath.USER_LINKED_INSERT_SALES_WITH_WEB)
    public Result<String> insertSalesWithWeb(
            @Validated({UserExtend.InsertSalesWithWebAction.class, UserExtend.InsertSaleAction.class}) @RequestBody() UserExtend param, BindingResult bindingResult
    ) {
        ValidatedResultUtil.checkFieldThrow(bindingResult);
        // 校验验证码
        if (!verificationCodeService.verification(param.getPhone(), ChannelCode.EMPTY, param.getCaptcha())) {
            return Result.nonError("验证码错误, ");
        }
        return insertSalesOperate(param);
    }

    private Result<String> insertSalesOperate(UserExtend param) {
        UserDO user = new UserDO();
        user.setUserName(param.getUserName());
        user.setChannelCode(param.getChannelCode());
        if (userService.isExistByUserNameAndChannelCode(param.getUserName(), param.getChannelCode())) {
            return Result.error("用户名已经存在");
        }
        if (!channelService.isExist(ChannelDO.createInstanceWithCode(param.getChannelCode()))) {
            return Result.error("渠道不存在");
        }
        if (StringUtils.isBlank(param.getPassword())) {
            param.getMd5PasswordWithPhone().ifPresent(param::setPassword);
        }
        return userExtendService.insertSale(param).map(Result::success).orElseGet(Result::nonError);
    }

    @PostMapping(ApiPath.USER_LINKED_INSERT_CHANNEL_SALES)
    public Result<String> insertChannelSales(
            @Validated(UserExtend.InsertChannelSalesAction.class) @RequestBody() UserExtend param, BindingResult bindingResult
    ) {
        ValidatedResultUtil.checkFieldThrow(bindingResult);
        UserDO user = new UserDO();
        user.setUserName(param.getUserName());
        user.setChannelCode(param.getChannelCode());
        if (userService.isExistByUserNameAndChannelCode(param.getUserName(), param.getChannelCode())) {
            return Result.error("用户名已经存在");
        }
        if (!channelService.isExist(ChannelDO.createInstanceWithCode(param.getChannelCode()))) {
            return Result.error("渠道不存在");
        }
        if (StringUtils.isBlank(param.getPassword())) {
            param.getMd5PasswordWithPhone().ifPresent(param::setPassword);
        }
        return userExtendService.insertChannelSale(param).map(Result::success).orElseGet(Result::nonError);
    }

    @PostMapping(ApiPath.USER_LINKED_UPDATE)
    public Result<Boolean> updateUser(
            @Validated(UpdateAction.class) @RequestBody() UserExtend param, BindingResult bindingResult
    ) {
        return update(param, bindingResult);
    }

    @PostMapping(ApiPath.SALES_LINKED_UPDATE)
    public Result<Boolean> updateSales(
            @Validated(UpdateAction.class) @RequestBody() UserExtend param, BindingResult bindingResult
    ) {
        return update(param, bindingResult);
    }

    @PostMapping(ApiPath.USER_LINKED_QUERY_WITH_PAGE)
    public Result<PageResult<List<UserExtend>>> queryUserWithPage(
            @Validated(QueryPageAction.class) @RequestBody() PageParam<UserLinkedQueryWithPageParam> pageParam, BindingResult bindingResult
    ) {
        ValidatedResultUtil.checkFieldThrow(bindingResult);
        if (pageParam.getModel() != null) {
            pageParam.getModel().setId(AuthenticationHelper.localContextHolderParser().getId().orElse(null));
        }
        return Result.success(userExtendService.queryUserWithPage(pageParam).orElseGet(PageResult::new));
    }

    @PostMapping(ApiPath.USER_LINKED_QUERY_PERSON_SALES_WITH_PAGE)
    public Result<PageResult<List<UserExtend>>> querySalesWithPage(
            @Validated(QueryPageAction.class) @RequestBody() PageParam<UserLinkedQueryWithPageParam> pageParam, BindingResult bindingResult
    ) {
        ValidatedResultUtil.checkFieldThrow(bindingResult);
        if (pageParam.getModel() != null) {
            pageParam.getModel().setId(AuthenticationHelper.localContextHolderParser().getId().orElse(null));
        }
        boolean isAnyAdminChannel = ChannelCode.isAnyAdminChannel(AuthenticationHelper.localContextHolderParser().getChannelCode().orElse(null));
        boolean isEmptyChannelWithParam = !Optional.ofNullable(pageParam.getModel()).map(UserLinkedQueryWithPageParam::getChannelCode).isPresent();
        if (isAnyAdminChannel && isEmptyChannelWithParam) {
            return Result.success(PageResult.instance(0L, new ArrayList<>()));
        }
        return Result.success(userExtendService.querySalesWithPage(pageParam).orElseGet(PageResult::new));
    }

    @PostMapping(ApiPath.USER_LINKED_QUERY_CHANNEL_SALES_WITH_PAGE)
    public Result<PageResult<List<UserExtend>>> queryChannelSalesWithPage(
            @Validated(QueryPageAction.class) @RequestBody() PageParam<UserLinkedQueryWithPageParam> pageParam, BindingResult bindingResult
    ) {
        ValidatedResultUtil.checkFieldThrow(bindingResult);
        if (pageParam.getModel() != null) {
            pageParam.getModel().setId(AuthenticationHelper.localContextHolderParser().getId().orElse(null));
        }
        return Result.success(userExtendService.queryChannelSalesWithPage(pageParam).orElseGet(PageResult::new));
    }

    @GetMapping(ApiPath.USER_LINKED_QUERY_VIRTUAL_SALES)
    public Result<List<UserExtend>> queryVirtualSales(@RequestParam("channelCode") String channelCode, @RequestParam("salesChannelCode") String salesChannelCode) {
        return Result.success(userExtendService.queryVirtualSales(channelCode, salesChannelCode).orElseGet(ArrayList::new));
    }

    private Result<Boolean> update(UserExtend param, BindingResult bindingResult) {
        Optional<String> checkResult = ValidatedResultUtil.checkField(bindingResult);
        if (checkResult.isPresent()) {
            return Result.error(checkResult.get());
        }
        UserDO user = new UserDO();
        user.setId(param.getId());
        if (!userService.isExistById(param.getId())) {
            return Result.error("用户不存在");
        }
        if (userExtendService.update(param)) {
            return Result.success();
        }
        return Result.nonError();
    }

}
