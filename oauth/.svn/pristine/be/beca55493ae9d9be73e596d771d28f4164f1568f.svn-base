package com.ybinsure.auth.endpoint.data;

import com.ybinsure.auth.annotation.validator.QueryPageAction;
import com.ybinsure.auth.annotation.validator.UpdateAction;
import com.ybinsure.auth.constant.*;
import com.ybinsure.auth.model.data.ChannelDO;
import com.ybinsure.auth.model.data.UserDO;
import com.ybinsure.auth.model.transfer.Result;
import com.ybinsure.auth.model.transfer.page.PageParam;
import com.ybinsure.auth.model.transfer.page.PageResult;
import com.ybinsure.auth.model.transfer.param.SalesQueryPageParamDTO;
import com.ybinsure.auth.model.transfer.param.UserQueryPageParamDTO;
import com.ybinsure.auth.model.transfer.result.UserRoleCountResult;
import com.ybinsure.auth.service.data.ChannelService;
import com.ybinsure.auth.service.data.UserService;
import com.ybinsure.auth.service.tool.VerificationCodeService;
import com.ybinsure.auth.service.wrap.UserWrapService;
import com.ybinsure.auth.util.AuthenticationHelper;
import com.ybinsure.auth.util.ValidatedResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Api(tags = "用户相关服务")
public class UserEndpoint {

    private final UserService userService;
    private final UserWrapService userWrapService;
    private final ChannelService channelService;
    private final VerificationCodeService verificationCodeService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping(ApiPath.USER_UPDATE)
    @ApiOperation(value = "用户更新")
    public Result<Boolean> update(
            @ApiParam(value = "请求数据，必要字段：id", required = true)
            @Validated(UpdateAction.class)
            @RequestBody() UserDO userDO, BindingResult bindingResult
    ) {
        ValidatedResultUtil.checkFieldThrow(bindingResult);
        if (userService.update(userDO)) {
            return Result.success();
        }
        return Result.nonError();
    }

    @DeleteMapping(ApiPath.USER_DELETE)
    @PreAuthorize("hasAnyAuthority(" + PermissionCode.personSalesDelete + "," + PermissionCode.channelSalesDelete + "," + PermissionCode.accountDelete + ")")
    @ApiOperation(value = "用户删除", notes = PermissionCode.tipPrefix + PermissionCode.personSalesDelete + "," + PermissionCode.channelSalesDelete + "," + PermissionCode.accountDelete)
    public Result<Boolean> delete(
            @ApiParam(value = "用户id", required = true)
            @PathVariable("id") String id
    ) {
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
    @PreAuthorize("hasAnyAuthority(" + PermissionCode.personSalesDisable + "," + PermissionCode.channelSalesDisable + "," + PermissionCode.accountDisable + ")")
    @ApiOperation(value = "用户禁用", notes = PermissionCode.tipPrefix + PermissionCode.personSalesDisable + "," + PermissionCode.channelSalesDisable + "," + PermissionCode.accountDisable)
    public Result<Boolean> disable(
            @ApiParam(value = "用户id", required = true)
            @PathVariable("id") String id
    ) {
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
    @PreAuthorize("hasAnyAuthority(" + PermissionCode.personSalesDisable + "," + PermissionCode.channelSalesDisable + "," + PermissionCode.accountDisable + ")")
    @ApiOperation(value = "用户恢复", notes = PermissionCode.tipPrefix + PermissionCode.personSalesDisable + "," + PermissionCode.channelSalesDisable + "," + PermissionCode.accountDisable)
    public Result<Boolean> recovery(
            @ApiParam(value = "用户id", required = true)
            @PathVariable("id") String id
    ) {
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
    @PreAuthorize("hasAnyAuthority(" + PermissionCode.personSalesReset + "," + PermissionCode.accountReset + ")")
    @ApiOperation(value = "用户重置密码", notes = PermissionCode.tipPrefix + PermissionCode.personSalesReset + "," + PermissionCode.accountReset)
    public Result<String> resetPassword(
            @ApiParam(value = "用户id", required = true)
            @RequestParam("id") String id,
            @ApiParam(value = "是否附带发送重置密码的短信", required = true)
            @RequestParam("sendMessage") Boolean sendMessage) {
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
    @ApiOperation(value = "修改密码")
    public Result<Boolean> changePassword(
            @ApiParam(value = "原密码, md5形式", required = true)
            @RequestParam("sourcePassWord") String sourcePassword,
            @ApiParam(value = "新密码，md5形式", required = true)
            @RequestParam("newPassword") String newPassword
    ) {
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

    @PostMapping(ApiPath.USER_LINKED_INSERT_USER)
    @PreAuthorize("hasAuthority(" + PermissionCode.accountInsert + ")")
    @ApiOperation(value = "添加内勤人员", notes = PermissionCode.tipPrefix + PermissionCode.accountInsert)
    public Result<String> insertUser(
            @ApiParam(value = "请求数据，必要字段")
            @Validated(UserDO.InsertUserAction.class)
            @RequestBody() UserDO param, BindingResult bindingResult
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
        return userWrapService.insertUser(param).map(Result::success).orElseGet(Result::nonError);
    }

    @PostMapping(ApiPath.USER_LINKED_INSERT_SALES)
    @PreAuthorize("hasAuthority(" + PermissionCode.personSalesInsert + ")")
    @ApiOperation(value = "添加业务员", notes = PermissionCode.tipPrefix + PermissionCode.personSalesInsert)
    public Result<String> insertSales(
            @Validated(UserDO.InsertSaleAction.class) @RequestBody() UserDO param, BindingResult bindingResult
    ) {
        ValidatedResultUtil.checkFieldThrow(bindingResult);
        return insertSalesOperate(param);
    }

    @PostMapping(ApiPath.USER_LINKED_INSERT_SALES_WITH_WEB)
    @ApiOperation(value = "前端添加业务员")
    public Result<String> insertSalesWithWeb(
            @ApiParam(value = "请求数据")
            @Validated({UserDO.InsertSalesWithWebAction.class, UserDO.InsertSaleAction.class})
            @RequestBody() UserDO param, BindingResult bindingResult
    ) {
        ValidatedResultUtil.checkFieldThrow(bindingResult);
        // 校验验证码
        if (!verificationCodeService.verification(param.getPhone(), ChannelCode.EMPTY, param.getCaptcha())) {
            return Result.nonError("验证码错误, ");
        }
        param.setSalesType(SaleTypeCode.PERSON);
        return insertSalesOperate(param);
    }

    private Result<String> insertSalesOperate(UserDO param) {
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
        return userWrapService.insertSale(param).map(Result::success).orElseGet(Result::nonError);
    }

    @PostMapping(ApiPath.USER_LINKED_UPDATE)
    @PreAuthorize("hasAnyAuthority(" + PermissionCode.personSalesEdit + "," + PermissionCode.accountEdit + "," + PermissionCode.channelSalesEdit + ")")
    @ApiOperation(value = "更新账号, 业务员，渠道业务员", notes = PermissionCode.tipPrefix + PermissionCode.personSalesEdit + "," + PermissionCode.accountEdit + "," + PermissionCode.channelSalesEdit)
    public Result<Boolean> updateUser(
            @Validated(UpdateAction.class) @RequestBody() UserDO param, BindingResult bindingResult
    ) {
        return updateUserLinkCompanyAndRole(param, bindingResult);
    }

    private Result<Boolean> updateUserLinkCompanyAndRole(UserDO param, BindingResult bindingResult) {
        Optional<String> checkResult = ValidatedResultUtil.checkField(bindingResult);
        if (checkResult.isPresent()) {
            return Result.error(checkResult.get());
        }
        UserDO user = new UserDO();
        user.setId(param.getId());
        if (!userService.isExistById(param.getId())) {
            return Result.error("用户不存在");
        }
        if (userWrapService.updateUserLinkCompanyAndLinkRole(param)) {
            return Result.success();
        }
        return Result.nonError();
    }


    @PostMapping(ApiPath.USER_QUERY_BY_CODES)
    @ApiOperation(value = "根据code查询用户信息")
    public Result<List<UserDO>> queryByCode(
            @ApiParam(value = "用户code")
            @RequestBody() List<Long> codes
    ) {
        return Result.success(userService.queryByCodes(codes).orElseGet(ArrayList::new));
    }

    @PostMapping(ApiPath.USER_QUERY_BY_AGENT_CODE)
    @ApiOperation(value = "根据agentCode查询用户，机构信息")
    public Result<UserDO> queryByAgentCode(
            @ApiParam(value = "请求数据，必要字段：agentCode，channelCode")
            @RequestBody() UserDO param
    ) {
        return userService.queryByAgentCode(param.getAgentCode(), param.getChannelCode()).map(Result::success).orElseGet(Result::nonError);
    }

    @PostMapping(ApiPath.USER_QUERYS)
    @ApiOperation(value = "查询多个用户信息")
    public Result<List<UserDO>> querys(
            @ApiParam(value = "用户Id", required = true)
            @RequestBody() List<String> ids
    ) {
        return Result.success(userService.querys(ids).orElseGet(ArrayList::new));
    }

    @GetMapping(ApiPath.USER_LINK_COMPANY_QUERY_BY_TOKEN)
    @ApiOperation(value = "根据access_token查询用户，机构信息")
    public Result<UserDO> queryUserLinkCompanyByToken() {
        String id = AuthenticationHelper.localContextHolderParser().getId().orElse(null);
        return userService.queryUserLinkCompanyAndLinkRoleById(id).map(Result::success).orElseGet(Result::nonError);
    }

    @GetMapping(ApiPath.USER_LINK_COMPANY_QUERY)
    @ApiOperation(value = "根据id查询用户，机构信息，角色，关联渠道")
    public Result<UserDO> queryUserLinkCompanyAndLinkRoleAndSalesChannelById(
            @ApiParam(value = "用户id", required = true)
            @PathVariable("id") String id
    ) {
        return userWrapService.queryUserLinkCompanyAndLinkRoleAndSalesChannelById(id).map(Result::success).orElseGet(Result::nonError);
    }

    @PostMapping(ApiPath.USER_LINK_COMPANY_QUERYS)
    @ApiOperation(value = "根据id查询多个用户，机构信息")
    public Result<List<UserDO>> queryUserLinkCompanyByIds(
            @ApiParam(value = "用户id", required = true)
            @RequestBody() List<String> ids
    ) {
        return userService.queryUserLinkCompanyByIds(ids).map(Result::success).orElseGet(Result::nonError);
    }

    @GetMapping(ApiPath.USER_LINK_COMPANY_QUERY_SALES_BY_COMPANY_ID)
    @ApiOperation(value = "查询机构下的业务员信息")
    public Result<List<UserDO>> querySalesLinkCompanyByCompanyId(
            @ApiParam(value = "机构id", required = true)
            @PathVariable("companyId") String companyId
    ) {
        return Result.success(userService.queryUserByCompanyIdsAndUserTypes(Collections.singletonList(companyId), Collections.singletonList(UserTypeCode.SALE)).orElseGet(ArrayList::new));
    }

    @PostMapping(ApiPath.USER_LINK_COMPANY_QUERY_BY_AGENT_CODE)
    @ApiOperation(value = "根据人员agentCode查询用户，机构信息")
    public Result<UserDO> queryUserLinkCompanyByAgentCode(
            @ApiParam(value = "请求数据，必要字段：agentCode, channelCode", required = true)
            @RequestBody() UserDO userDO
    ) {
        return userService.queryUserLinkCompanyByAgentCodeAndChannelCode(userDO.getAgentCode(), userDO.getChannelCode()).map(Result::success).orElseGet(Result::nonError);
    }

    @PostMapping(ApiPath.USER_LINKED_QUERY_WITH_PAGE)
    @ApiOperation(value = "分页查询账号")
    public Result<PageResult<List<UserDO>>> queryUserLinkCompanyAndRoleWithPage(
            @Validated(QueryPageAction.class)
            @RequestBody() PageParam<UserQueryPageParamDTO> pageParam, BindingResult bindingResult
    ) {
        ValidatedResultUtil.checkFieldThrow(bindingResult);
        return Result.success(userWrapService.queryUserLinkCompanyAndLinkRoleAndChannelNameWithPage(pageParam).orElseGet(PageResult::new));
    }

    @PostMapping(ApiPath.USER_LINKED_QUERY_SALES_WITH_PAGE)
    @ApiOperation(value = "分页查询业务员")
    public Result<PageResult<List<UserDO>>> querySalesLinkCompanyWithPage(
            @Validated(QueryPageAction.class)
            @RequestBody() PageParam<SalesQueryPageParamDTO> pageParam, BindingResult bindingResult
    ) {
        ValidatedResultUtil.checkFieldThrow(bindingResult);
        return Result.success(userWrapService.querySalesLinkCompanyAndChannelNameWithPage(pageParam).orElseGet(PageResult::new));
    }

    @GetMapping(ApiPath.USER_IS_EXIST_BY_ID)
    @ApiOperation(value = "根据id检查用户是否存在")
    public Result<Boolean> isExistById(
            @ApiParam(value = "用户id", required = true)
            @PathVariable("id") String id
    ) {
        return Result.success(userService.isExistById(id));
    }

    @GetMapping(ApiPath.USER_IS_EXIST_BY_USER_NAME)
    @ApiOperation(value = "根据UserName检查用户是否存在")
    public Result<Boolean> isExistByUserName(
            @ApiParam(value = "用户userName", required = true)
            @PathVariable("userName")String username
    ) {
        return Result.success(userService.isExistByUserName(username));
    }

    @PostMapping(ApiPath.USER_IS_EXIST_BY_USER_NAME_AND_CHANNEL_CODE)
    @ApiOperation(value = "根据UserName/channelCode检查用户是否存在")
    public Result<Boolean> isExistByUserNameAndChannelCode(
            @ApiParam(value = "用户userName", required = true)
            @RequestParam("userName") String userName,
            @ApiParam(value = "用户渠道编码", required = true)
            @RequestParam("channelCode") String channelCode
    ) {
        return Result.success(userService.isExistByUserNameAndChannelCode(userName, channelCode));
    }

    @PostMapping(ApiPath.USER_IS_EXIST_BY_AGENT_CODE_AND_CHANNEL_CODE)
    @ApiOperation(value = "根据AgentCode检查用户是否存在")
    public Result<Boolean> isExistByAgentCodeAndChannelCode(
            @ApiParam(value = "用户agentCode", required = true)
            @RequestParam("agentCode") String agentCode,
            @ApiParam(value = "用户渠道编码", required = true)
            @RequestParam("channelCode") String channelCode
    ) {
        return Result.success(userService.isExistByAgentCodeAndChannelCode(agentCode, channelCode));
    }

    @GetMapping(ApiPath.USER_LINK_USER_RELATE_COMPANY_EXIST_USER)
    @ApiOperation(value = "检查机构下是否存在用户")
    public Result<Boolean> existUser(
            @ApiParam(value = "机构id", required = true)
            @PathVariable("companyId") String companyId
    ) {
        if (userService.isExistUserByCompanyId(companyId)) {
            return Result.success(true);
        }
        return Result.success(false);
    }

    @PostMapping(ApiPath.USER_USER_ROLE_COUNT)
    @ApiOperation(value = "根据分页查询参数查询渠道下每种角色的人员数量")
    public Result<UserRoleCountResult> userRoleCount(
            @ApiParam(value = "请求参数", required = true)
            @RequestBody() UserQueryPageParamDTO param
    ) {
        return Result.success(userService.queryUserRoleCountByPageParam(param));
    }

    @GetMapping(ApiPath.USER_QUERY_TEAM_CHILDREN_SALES_BY_PARENT_COMPANY_ID)
    @ApiOperation(value = "查询子团队下的业务员")
    public Result<List<UserDO>> queryTeamChildrenSalesByParentCompanyId(
            @ApiParam(value = "父级机构id")
            @PathVariable("parentCompanyId") String parentCompanyId
    ) {
        return Result.success(userWrapService.queryTeamChildrenSalesByCompanyId(parentCompanyId).orElseGet(ArrayList::new));
    }

}
