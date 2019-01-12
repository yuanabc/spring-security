package com.ybinsure.auth.mapper.custom;

import com.ybinsure.auth.model.data.CompanyDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomCompanyDOMapper {

    /**
     * 查询所有渠道的机构
     * 排除禁用和删除的渠道，以及删除的机构
     * @return 查询结果
     */
    List<CompanyDO> queryAll();

    CompanyDO queryLastSortedCompanyByParentId(@Param("parentId")String parentId);

    List<CompanyDO> queryAfterSortedCompanyById(@Param("id")String id);

    List<CompanyDO> queryBeforeSortedCompanyById(String id);
}
