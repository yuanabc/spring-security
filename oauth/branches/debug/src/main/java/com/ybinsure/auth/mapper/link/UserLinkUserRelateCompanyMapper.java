package com.ybinsure.auth.mapper.link;

import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface UserLinkUserRelateCompanyMapper {

    /**
     * 统计机构下正常使用的用户数量
     */
    int countUser(@Param("companyId") String companyId, @Param("deletedStatus") Byte deletedStatus);

    /**
     * 查询机构内用户未失效的token
     * @param companyId 机构id
     * @param now 当前时间
     * @return 未失效的token
     */
    List<String> queryLastTokenByTokenNonExpire(@Param("companyId") String companyId, @Param("now") Date now);
}
