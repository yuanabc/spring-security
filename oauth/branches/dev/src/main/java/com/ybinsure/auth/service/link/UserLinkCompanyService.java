package com.ybinsure.auth.service.link;

import com.ybinsure.auth.model.data.UserDO;
import com.ybinsure.auth.model.link.UserExtend;

import java.util.List;
import java.util.Optional;

public interface UserLinkCompanyService {

    Optional<UserExtend> queryById(String id);

    Optional<UserExtend> queryByAgentCode(String agentCode, String channelCode);

    Optional<List<UserDO>> queryUserByCompanyIdAndUserType(String companyId, List<String> userTypes);

    Optional<List<UserDO>> queryUserByCompanyIdsAndUserTypes(List<String> companyIds, List<String> userTypes);
}
