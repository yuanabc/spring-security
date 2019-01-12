package com.ybinsure.auth.service.data;

import com.ybinsure.auth.model.data.UserRelateCompanyDO;

import java.util.List;
import java.util.Optional;

public interface UserRelateCompanyService {

    Optional<String> insert(UserRelateCompanyDO param);

    boolean insertList(List<UserRelateCompanyDO> params);

    boolean deleteByUserId(String userId);
}
