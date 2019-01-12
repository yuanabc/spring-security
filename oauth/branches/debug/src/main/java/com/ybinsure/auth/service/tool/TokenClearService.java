package com.ybinsure.auth.service.tool;

import java.util.List;

public interface TokenClearService {

    /**
     * 清除id内用户的token
     * @param userId 需要请求token的用户id
     */
    void clearByUserIds(List<String> userId);

    /**
     * 清除机构内用户的token
     * @param companyId 机构id
     */
    void clearByCompanyId(String companyId);

    /**
     * 清除渠道内用户的token
     * @param id 渠道id
     */
    void clearByChannelId(String id);
}
