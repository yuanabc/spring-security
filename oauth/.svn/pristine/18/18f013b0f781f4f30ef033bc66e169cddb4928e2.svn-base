package com.ybinsure.auth.serviceImpl.link;

import com.ybinsure.auth.constant.CompanyLinkTypeCode;
import com.ybinsure.auth.constant.StatusCode;
import com.ybinsure.auth.mapper.link.UserLinkCompanyMapper;
import com.ybinsure.auth.model.data.ChannelDO;
import com.ybinsure.auth.model.data.UserDO;
import com.ybinsure.auth.model.link.UserExtend;
import com.ybinsure.auth.service.data.ChannelService;
import com.ybinsure.auth.service.link.UserLinkCompanyService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultUserLinkCompanyService implements UserLinkCompanyService {

    private final UserLinkCompanyMapper userLinkCompanyMapper;
    private final ChannelService channelService;

    @Override
    public Optional<UserExtend> queryById(String id) {
        if (StringUtils.isBlank(id)) {
            return Optional.empty();
        }
        UserDO param = new UserDO();
        param.setId(id);
        param.setDeleted(StatusCode.DISABLE);
        UserExtend result = userLinkCompanyMapper.queryById(param, CompanyLinkTypeCode.BELONG);
        if (result == null) {
            return Optional.empty();
        }
        result.setBelongCompanys(result.getCompanyDOS());
        result.setCompanyDOS(null);
        UserExtend managerUserExtend = userLinkCompanyMapper.queryById(param, CompanyLinkTypeCode.MANAGER);
        if (managerUserExtend != null) {
            result.setManagerCompanys(managerUserExtend.getCompanyDOS());
        }
        String channelType = channelService.queryByChannelCode(result.getChannelCode()).map(ChannelDO::getType).orElse(null);
        result.setChannelType(channelType);
        return Optional.of(result);
    }

    @Override
    public Optional<UserExtend> queryByAgentCode(String agentCode, String channelCode) {
        if (StringUtils.isBlank(agentCode) || StringUtils.isBlank(channelCode)) {
            return Optional.empty();
        }
        UserDO param = new UserDO();
        param.setAgentCode(agentCode);
        param.setChannelCode(channelCode);
        param.setDeleted(StatusCode.DISABLE);
        List<UserExtend> result = userLinkCompanyMapper.queryByAgentCode(param, CompanyLinkTypeCode.BELONG);
        if (result == null || result.isEmpty()) {
            return Optional.empty();
        }
        result.get(0).setBelongCompanys(result.get(0).getCompanyDOS());
        result.get(0).setCompanyDOS(null);
        return Optional.ofNullable(result.get(0));
    }

    @Override
    public Optional<List<UserDO>> queryUserByCompanyIdAndUserType(String companyId, List<String> userTypes) {
        if (StringUtils.isBlank(companyId) || userTypes == null || userTypes.isEmpty()) {
            return Optional.empty();
        }
        List<UserDO> result = userLinkCompanyMapper.queryUserByCompanyId(companyId, userTypes);
        return Optional.ofNullable(result);
    }

    @Override
    public Optional<List<UserDO>> queryUserByCompanyIdsAndUserTypes(List<String> companyIds, List<String> userTypes) {
        if (companyIds == null || companyIds.isEmpty() || userTypes == null || userTypes.isEmpty()) {
            return Optional.empty();
        }
        List<UserDO> result = userLinkCompanyMapper.queryUserByCompanyIds(companyIds, userTypes);
        return Optional.ofNullable(result);
    }


}
