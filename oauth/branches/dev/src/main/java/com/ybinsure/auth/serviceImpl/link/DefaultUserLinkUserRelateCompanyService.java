package com.ybinsure.auth.serviceImpl.link;

import com.ybinsure.auth.constant.StatusCode;
import com.ybinsure.auth.mapper.link.UserLinkUserRelateCompanyMapper;
import com.ybinsure.auth.service.link.UserLinkUserRelateCompanyService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultUserLinkUserRelateCompanyService implements UserLinkUserRelateCompanyService {

    private final UserLinkUserRelateCompanyMapper userLinkUserRelateCompanyMapper;

    @Override
    public Optional<List<String>> queryLastTokenByTokenNonExpire(String companyId) {
        if (StringUtils.isBlank(companyId)) {
            return Optional.empty();
        }
        return Optional.of(userLinkUserRelateCompanyMapper.queryLastTokenByTokenNonExpire(companyId, new Date()));
    }

    @Override
    public boolean isExistUser(String companyId) {
        if (StringUtils.isBlank(companyId)) {
            return false;
        }
        return userLinkUserRelateCompanyMapper.countUser(companyId, StatusCode.DISABLE) > 0;
    }
}
