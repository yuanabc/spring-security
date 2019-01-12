package com.ybinsure.auth.serviceImpl.tool;

import com.ybinsure.auth.constant.StatusCode;
import com.ybinsure.auth.model.data.CompanyDO;
import com.ybinsure.auth.model.data.UserDO;
import com.ybinsure.auth.model.data.UserRelateCompanyDO;
import com.ybinsure.auth.service.data.CompanyService;
import com.ybinsure.auth.service.data.UserService;
import com.ybinsure.auth.service.tool.UserNameLoginService;
import com.ybinsure.auth.service.wrap.UserWrapService;
import com.ybinsure.auth.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultUserNameLoginService implements UserNameLoginService {

    private final static Logger logger = LoggerFactory.getLogger(DefaultUserNameLoginService.class);

    private final UserService userService;
    private final UserWrapService userWrapService;
    private final CompanyService companyService;

    @Override
    public Optional<UserDO> queryOrInsert(UserDO userDO, String companyCode) {
        if (StringUtils.isBlank(userDO.getUserName()) || StringUtils.isBlank(userDO.getChannelCode()) || StringUtils.isBlank(companyCode)) {
            return Optional.empty();
        }
        Optional<UserDO> existUserOptional = userService.queryByUserName(userDO.getUserName(), userDO.getChannelCode());
        if (existUserOptional.isPresent()) {
            return existUserOptional;
        }
        Optional<CompanyDO> teamCompanyOptional = companyService.query(companyCode, userDO.getChannelCode());
        if (!teamCompanyOptional.isPresent()) {
            logger.warn("手机号码登陆，无法匹配团队机构---{}-{}", companyCode, userDO.getChannelCode());
            return Optional.empty();
        }
        UserRelateCompanyDO teamCompany = teamCompanyOptional.map(CompanyDO::convertUserRelateCompanyDo).get();
        List<UserRelateCompanyDO> companys = new ArrayList<>();
        companys.add(teamCompany);
        UserDO param = new UserDO();
        param.setUserName(userDO.getUserName());
        param.setNickName(StringUtils.isNotBlank(userDO.getNickName()) ? userDO.getNickName() : userDO.getUserName());
        param.setPhone(userDO.getUserName());
        param.setChannelCode(userDO.getChannelCode());
        param.setStatus(StatusCode.ENABLE);
        param.setDeleted(StatusCode.DISABLE);
        param.setUserRelateCompanyDOS(companys);
        logger.warn("rsa: 新增手机登陆用户信息---{}", JsonUtil.toJson(param));
        if (!userWrapService.insertSale(param).isPresent()) {
            return Optional.empty();
        }
        return Optional.of(param);
    }
}
