package com.ybinsure.auth.mapper.extend;

import com.ybinsure.auth.model.data.CompanyDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExtendCompanyDOMapper {

    /**
     * 根据用户名，渠道编码，以及机构类型查找机构信息
     */
    List<CompanyDO> queryByUserName(@Param("userName")String userName, @Param("channelCode") String channelCode, @Param("linkType") String linkType);

    Long queryMaxCode(@Param("channelCode") String channelCode, @Param("min") Long min);

    List<CompanyDO> queryAll(@Param("status") Byte status, @Param("deleted") Byte deleted);

    List<CompanyDO> querySimpleInfo(@Param("param") List<String> ids);

}
