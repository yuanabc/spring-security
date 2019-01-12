package com.ybinsure.auth.service.link;

import java.util.List;
import java.util.Optional;

public interface UserLinkUserRelateCompanyService {

    /**
     * 查询机构内用户未失效的token
     * @param companyId 机构id
     * @return 未失效的token
     */
    Optional<List<String>> queryLastTokenByTokenNonExpire(String companyId);

    /**
     * 检查机构下是否有用户
     */
    boolean isExistUser(String companyId);

}
