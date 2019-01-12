package com.ybinsure.auth.serviceImpl.adapter;

import com.ybinsure.auth.constant.ChannelCode;
import com.ybinsure.auth.model.data.ChannelDO;
import com.ybinsure.auth.model.data.CompanyDO;
import com.ybinsure.auth.service.adapter.ChannelAdapterService;
import com.ybinsure.auth.service.data.ChannelService;
import com.ybinsure.auth.service.data.CompanyService;
import com.ybinsure.auth.util.AuthenticationHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DefaultChannelAdapterService implements ChannelAdapterService {

    private final CompanyService companyService;
    private final ChannelService channelService;

    @Override
    public Optional<List<ChannelDO>> queryAllOfEffective() {
        List<String> companyIds = AuthenticationHelper.localContextHolderParser().getCompanyAuthority();
        Optional<List<CompanyDO>> optionalCompanyDOS = companyService.querys(companyIds);
        Optional<List<ChannelDO>> optionalChannelDOList = channelService.queryAll();
        if (!optionalChannelDOList.isPresent() || !optionalCompanyDOS.isPresent()) {
            return Optional.empty();
        }
        // 悦保总部默认查看所有渠道
        if (optionalCompanyDOS.get().stream().anyMatch(companyDO -> ChannelCode.YUEBAO.equals(companyDO.getChannelCode()))) {
            return optionalChannelDOList;
        }
        // 其余根据机构权限查看
        List<ChannelDO> res = optionalChannelDOList.get().stream()
                .filter(channelDO -> optionalCompanyDOS.get().stream().anyMatch(companyDO -> channelDO.getCode().equals(companyDO.getChannelCode())))
                .collect(Collectors.toList());
        return Optional.of(res);
    }
}
