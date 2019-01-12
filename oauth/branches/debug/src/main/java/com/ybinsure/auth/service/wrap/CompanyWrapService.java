package com.ybinsure.auth.service.wrap;

import com.ybinsure.auth.model.data.CompanyDO;

import java.util.List;
import java.util.Optional;

public interface CompanyWrapService {

    boolean delete(String id);

    boolean disable(String id);

    /**
     * 查询当前登录用户归属机构下的子机构
     * @return 子机构数据
     */
    Optional<List<CompanyDO>> queryChildrenByToken();
}
