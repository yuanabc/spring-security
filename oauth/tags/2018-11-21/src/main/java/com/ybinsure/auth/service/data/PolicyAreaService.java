package com.ybinsure.auth.service.data;

import com.ybinsure.auth.model.data.PolicyAreaDO;

import java.util.List;
import java.util.Optional;

public interface PolicyAreaService {

    Optional<List<PolicyAreaDO>> queryAll();

    /**
     * 查询城市的保监地
     * @return 保监地编码
     */
    Optional<String> queryPolicyArea(String province, String city);
}
