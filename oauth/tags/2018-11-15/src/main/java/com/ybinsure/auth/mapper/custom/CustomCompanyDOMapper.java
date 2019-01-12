package com.ybinsure.auth.mapper.custom;

import com.ybinsure.auth.model.data.CompanyDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomCompanyDOMapper {

    /**
     * 根据用户名，渠道编码，以及机构类型查找机构信息
     */
    //todo 一次查出所有的关联机构
    List<CompanyDO> queryByUserName(@Param("userName")String userName, @Param("channelCode") String channelCode, @Param("linkType") String linkType);

    /**
     * 查询渠道内最大的编码
     * @param channelCode 渠道编码
     * @param min 编码
     * @return
     */
    Long queryMaxCode(@Param("channelCode") String channelCode, @Param("min") Long min);

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
