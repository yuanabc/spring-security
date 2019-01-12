package com.ybinsure.auth.serviceImpl.data;

import com.ybinsure.auth.mapper.data.UserRelateCompanyDOMapper;
import com.ybinsure.auth.mapper.extend.ExtendUserRelateCompanyDOMapper;
import com.ybinsure.auth.model.data.UserRelateCompanyDO;
import com.ybinsure.auth.model.data.UserRelateCompanyDOExample;
import com.ybinsure.auth.service.data.UserRelateCompanyService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultUserRelateCompanyService implements UserRelateCompanyService {

    private final UserRelateCompanyDOMapper userRelateCompanyDOMapper;
    private final ExtendUserRelateCompanyDOMapper extendUserRelateCompanyDOMapper;

    @Override
    public Optional<List<String>> queryUserIdByCompanyId(String companyId) {
        if (StringUtils.isBlank(companyId)) {
            return Optional.empty();
        }
        return Optional.ofNullable(extendUserRelateCompanyDOMapper.queryUserIdByCompanyId(companyId));
    }

    @Override
    public Optional<String> insert(UserRelateCompanyDO param) {
        if (!param.valid()) {
            return Optional.empty();
        }
        if (userRelateCompanyDOMapper.insert(param) > 0) {
            return Optional.of(param.getId());
        }
        return Optional.empty();
    }

    @Override
    public boolean insertList(List<UserRelateCompanyDO> params) {
        if (params == null || params.isEmpty()) {
            return true;
        }
        return extendUserRelateCompanyDOMapper.insertList(params) == params.size();
    }

    @Override
    public boolean deleteByUserId(String userId) {
        if (StringUtils.isBlank(userId)) {
            return false;
        }
        UserRelateCompanyDOExample example = new UserRelateCompanyDOExample();
        example.or().andUserIdEqualTo(userId);
        userRelateCompanyDOMapper.deleteByExample(example);
        return userRelateCompanyDOMapper.countByExample(example) == 0;
    }
}
