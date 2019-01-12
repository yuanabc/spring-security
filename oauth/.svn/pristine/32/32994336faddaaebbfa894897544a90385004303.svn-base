package com.ybinsure.auth.endpoint.guest;

import com.ybinsure.auth.constant.ApiPath;
import com.ybinsure.auth.constant.ChannelCode;
import com.ybinsure.auth.model.data.UserDO;
import com.ybinsure.auth.service.data.UserService;
import com.ybinsure.auth.service.tool.*;
import com.ybinsure.auth.util.HttpRequestUtils;
import com.ybinsure.auth.util.SplitUserNameUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class LoginEndpoint {


    private final UserNameLoginService userNameLoginService;
    private final DatongRsaLoginService datongRsaLoginService;
    private final ChannelLoginService channelLoginService;
    private final RestTemplateRequestService restTemplateRequestService;
    private final EmptyPasswordService emptyPasswordService;
    private final UserService userService;

    /**
     * 渠道和en号登录
     */
    @PostMapping(ApiPath.GUEST_CHANNEL_TOKEN)
    public ResponseEntity<Object> channelCodeToken(@RequestParam("channelCode") String channelCode, @RequestParam("enNo") String enNo) {
        UserDO userDO = channelLoginService.getUserDo(channelCode, enNo).orElse(new UserDO());
        emptyPasswordService.setDefaultPassword(userDO);
        String joinUserName = SplitUserNameUtils.join(userDO.getPhone(), userDO.getChannelCode());
        return restTemplateRequestService.tokenWithFrontClient(joinUserName, userDO.getPassword());
    }

    /**
     * 东方懿安手机号码登录
     */
    @PostMapping(ApiPath.GUEST_YIAN_TOKEN)
    public ResponseEntity<Object> yiAnToken(@RequestParam("phone") String userName, @RequestParam("companyCode") String companyCode, @RequestParam("nickName") String nickName) {
        UserDO param = new UserDO();
        param.setUserName(userName);
        param.setChannelCode(ChannelCode.YI_AN);
        param.setNickName(nickName);
        UserDO userDO = userNameLoginService.queryOrInsert(param, companyCode).orElseGet(UserDO::new);
        emptyPasswordService.setDefaultPassword(userDO);
        String joinUserName = SplitUserNameUtils.join(userDO.getUserName(), userDO.getChannelCode());
        return restTemplateRequestService.tokenWithFrontClient(joinUserName, userDO.getPassword());
    }

    /**
     * 中石油登录
     */
    @GetMapping(ApiPath.GUEST_SHIYOU_TOKEN)
    public ResponseEntity<Object> shiYouToken(@PathVariable("id") String id) {
        UserDO param = userService.query(id)
                .filter(userDO -> StringUtils.equals(userDO.getChannelCode(), ChannelCode.SHI_YOU))
                .orElseGet(UserDO::new);
        emptyPasswordService.setDefaultPassword(param);
        String joinUserName = SplitUserNameUtils.join(param.getUserName(), param.getChannelCode());
        return restTemplateRequestService.tokenWithFrontClient(joinUserName, param.getPassword());
    }

    /**
     * 大童rsa登陆
     */
    @PostMapping(ApiPath.GUEST_RSA_TOKEN)
    public ResponseEntity<Object> rsaToken(HttpServletRequest httpServletRequest) {
        UserDO userDO = HttpRequestUtils.readBody(httpServletRequest)
                .flatMap(datongRsaLoginService::cryptChar)
                .flatMap(datongRsaLoginService::decrypt)
                .flatMap(datongRsaLoginService::convertUser).orElse(new UserDO());
        emptyPasswordService.setDefaultPassword(userDO);
        String joinUserName = SplitUserNameUtils.join(userDO.getUserName(), userDO.getChannelCode());
        return restTemplateRequestService.tokenWithFrontClient(joinUserName, userDO.getPassword());
    }


}
