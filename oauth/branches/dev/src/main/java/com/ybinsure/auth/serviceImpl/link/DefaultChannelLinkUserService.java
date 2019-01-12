package com.ybinsure.auth.serviceImpl.link;

import com.ybinsure.auth.constant.CompanyLinkTypeCode;
import com.ybinsure.auth.constant.UserTypeCode;
import com.ybinsure.auth.exception.FailResultException;
import com.ybinsure.auth.mapper.link.ChannelLinkUserMapper;
import com.ybinsure.auth.model.data.ChannelDO;
import com.ybinsure.auth.model.data.CompanyDO;
import com.ybinsure.auth.model.data.UserRelateCompanyDO;
import com.ybinsure.auth.model.link.ChannelExtend;
import com.ybinsure.auth.model.link.UserExtend;
import com.ybinsure.auth.service.data.ChannelService;
import com.ybinsure.auth.service.data.CompanyService;
import com.ybinsure.auth.service.data.UserService;
import com.ybinsure.auth.service.link.ChannelLinkUserService;
import com.ybinsure.auth.service.link.UserExtendService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultChannelLinkUserService implements ChannelLinkUserService {

    private final ChannelService channelService;
    private final UserExtendService userExtendService;
    private final UserService userService;
    private final CompanyService companyService;
    private final ChannelLinkUserMapper channelLinkUserMapper;

    @Override
    public Optional<ChannelExtend> query(String id) {
        if (StringUtils.isBlank(id)) {
            return Optional.empty();
        }
        return Optional.ofNullable(channelLinkUserMapper.query(id, UserTypeCode.ADMIN));
    }

    @Override
    @Transactional
    public boolean update(ChannelExtend param) {
        if (StringUtils.isBlank(param.getId()) ||
                param.getAdmin() == null ||
                StringUtils.isBlank(param.getAdmin().getId())) {
            return false;
        }
        if (!channelService.update(param) || !userExtendService.update(param.getAdmin())) {
            throw FailResultException.nonError();
        }
        return true;
    }

    @Override
    @Transactional
    public Optional<String> insert(ChannelExtend param) {
        if (param == null) {
            throw FailResultException.nonError();
        }
        String channelId = insertChannel(param);
        CompanyDO head = CompanyDO.createHeadInstance("0000000001", param.getShortName() + "总部", param.getCode());
        String headId = insertHead(head);
        // 创建admin的归属机构
        UserRelateCompanyDO userRelateCompanyDO = new UserRelateCompanyDO();
        userRelateCompanyDO.setCompanyId(headId);
        userRelateCompanyDO.setLinkType(CompanyLinkTypeCode.BELONG);
        UserExtend admin = param.getAdmin();
        admin.setUserRelateCompanyDOS(new ArrayList<>());
        admin.getUserRelateCompanyDOS().add((userRelateCompanyDO));
        insertAdmin(admin);
        return Optional.of(channelId);
    }

    private String insertChannel(ChannelDO param) {
        if (channelService.isExist(ChannelDO.createInstanceWithCode(param.getCode()))) {
            throw FailResultException.nonError("渠道" + param.getCode() + "已经存在,");
        }
        Optional<String> insertOptional = channelService.insert(param);
        if (!insertOptional.isPresent()) {
            throw FailResultException.nonError();
        }
        return insertOptional.get();
    }

    private String insertHead(CompanyDO param) {
        CompanyDO temp = new CompanyDO();
        temp.setOldCode(param.getOldCode());
        temp.setChannelCode(param.getChannelCode());
        if (companyService.isExist(temp)) {
            throw FailResultException.nonError("机构" + param.getCode() + "已经存在,");
        }
        Optional<String> insertHeadOptional = companyService.insertHead(param);
        if (!insertHeadOptional.isPresent()) {
            throw FailResultException.nonError();
        }
        return insertHeadOptional.get();
    }

    private void insertAdmin(UserExtend param) {
        if (userService.isExistByUserName(param.getUserName())) {
            throw FailResultException.nonError("用户" + param.getUserName() + "已经存在");
        }
        if (StringUtils.isBlank(param.getPassword())) {
            param.getMd5PasswordWithPhone().ifPresent(param::setPassword);
        }
        Optional<String> insertAdminOptional = userExtendService.insertAdmin(param);
        if (!insertAdminOptional.isPresent()) {
            throw FailResultException.nonError();
        }
    }

}
