package com.ybinsure.auth.mapper.link;

import com.ybinsure.auth.model.data.UserDO;
import com.ybinsure.auth.model.link.UserExtend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserLinkCompanyMapper {

    UserExtend queryById(@Param("param") UserDO param, @Param("linkType") String linkType);

    List<UserExtend> queryByAgentCode(@Param("param") UserDO param, @Param("linkType") String linkType);

    List<UserDO> queryUserByCompanyId(@Param("companyId") String companyId, @Param("userTypes")List<String> userTypes);

    List<UserDO> queryUserByCompanyIds(@Param("companyIds") List<String> companyIds, @Param("userTypes")List<String> userTypes);

}
