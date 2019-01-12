package com.ybinsure.auth.endpoint.guest;

import com.ybinsure.auth.constant.ApiPath;
import com.ybinsure.auth.constant.ChannelCode;
import com.ybinsure.auth.constant.PermissionCode;
import com.ybinsure.auth.model.data.UserDO;
import com.ybinsure.auth.service.data.UserService;
import com.ybinsure.auth.service.tool.*;
import com.ybinsure.auth.util.SplitUserNameUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Api(tags = "特殊登录接口")
public class LoginEndpoint {

    private final UserNameLoginService userNameLoginService;
    private final DatongRsaLoginService datongRsaLoginService;
    private final RestTemplateRequestService restTemplateRequestService;
    private final EmptyPasswordService emptyPasswordService;
    private final UserService userService;

    /**
     * 渠道和en号登录
     */
    @PostMapping(ApiPath.GUEST_CHANNEL_TOKEN)
    @ApiOperation(value = "渠道en号登录")
    public ResponseEntity<Object> channelCodeToken(
            @ApiParam(value = "渠道编码", required = true)
            @RequestParam("channelCode") String channelCode,
            @ApiParam(value = "用户关联的en号", required = true)
            @RequestParam("enNo") String enNo
    ) {
        UserDO userDO = userService.getByEnNoAndChannelCodeOrChannelCode(channelCode, enNo).orElse(new UserDO());
        emptyPasswordService.setDefaultPassword(userDO);
        String joinUserName = SplitUserNameUtils.join(userDO.getPhone(), userDO.getChannelCode());
        return restTemplateRequestService.tokenWithFrontClient(joinUserName, userDO.getPassword());
    }

    @PostMapping(ApiPath.GUEST_YIAN_TOKEN)
    @ApiOperation(value = "东方懿安手机号码登录，如果用户还不存在则创建用户")
    public ResponseEntity<Object> yiAnToken(
            @ApiParam(value = "手机号码", required = true)
            @RequestParam("phone") String userName,
            @ApiParam(value = "机构编码", required = true)
            @RequestParam("companyCode") String companyCode,
            @ApiParam(value = "用户昵称")
            @RequestParam("nickName") String nickName) {
        UserDO param = new UserDO();
        param.setUserName(userName);
        param.setChannelCode(ChannelCode.YI_AN);
        param.setNickName(nickName);
        UserDO userDO = userNameLoginService.queryOrInsert(param, companyCode).orElseGet(UserDO::new);
        emptyPasswordService.setDefaultPassword(userDO);
        String joinUserName = SplitUserNameUtils.join(userDO.getUserName(), userDO.getChannelCode());
        return restTemplateRequestService.tokenWithFrontClient(joinUserName, userDO.getPassword());
    }

    @GetMapping(ApiPath.GUEST_SHIYOU_TOKEN)
    @Deprecated
    @ApiOperation(value = "中石油登录, 已废弃，转到模拟登录接口")
    public ResponseEntity<Object> shiYouToken(
            @ApiParam(value = "用户id", required = true)
            @PathVariable("id") String id
    ) {
        UserDO param = userService.query(id)
                .filter(userDO -> StringUtils.equals(userDO.getChannelCode(), ChannelCode.SHI_YOU))
                .orElseGet(UserDO::new);
        emptyPasswordService.setDefaultPassword(param);
        String joinUserName = SplitUserNameUtils.join(param.getUserName(), param.getChannelCode());
        return restTemplateRequestService.tokenWithFrontClient(joinUserName, param.getPassword());
    }

    /**
     * 免密的模拟登录接口
     * 需要管理员权限
     * @param id 模拟用户id
     * @return 登录结果
     */
    @GetMapping(ApiPath.MOCK_LOGIN)
    @PreAuthorize("hasAuthority(" + PermissionCode.admin + ")")
    @ApiOperation(value = "免密的模拟登录接口", notes = PermissionCode.tipPrefix + PermissionCode.admin)
    public ResponseEntity<Object> mockLogin(
            @ApiParam(value = "用户id", required = true)
            @PathVariable("id") String id
    ) {
        UserDO param = userService.query(id).orElseGet(UserDO::new);
        emptyPasswordService.setDefaultPassword(param);
        String joinUserName = SplitUserNameUtils.join(param.getUserName(), param.getChannelCode());
        return restTemplateRequestService.tokenWithFrontClient(joinUserName, param.getPassword());
    }

    /**
     * 大童rsa登陆
     */
    @PostMapping(ApiPath.GUEST_RSA_TOKEN)
    @ApiOperation(value = "大童rsa密文登录")
    public ResponseEntity<Object> rsaToken(
            @ApiParam(value = "rsa密文", required = true)
            @RequestBody() String rsaText
    ) {
        UserDO userDO = Optional.ofNullable(rsaText)
                .flatMap(datongRsaLoginService::cryptChar)
                .flatMap(datongRsaLoginService::decrypt)
                .flatMap(datongRsaLoginService::convertUser)
                .orElse(new UserDO());
        emptyPasswordService.setDefaultPassword(userDO);
        String joinUserName = SplitUserNameUtils.join(userDO.getUserName(), userDO.getChannelCode());
        return restTemplateRequestService.tokenWithFrontClient(joinUserName, userDO.getPassword());
    }


}
