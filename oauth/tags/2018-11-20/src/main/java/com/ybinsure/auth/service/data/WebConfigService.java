package com.ybinsure.auth.service.data;

import com.ybinsure.auth.model.data.WebConfigDO;

import java.util.List;
import java.util.Optional;

/**
 * 前端配置服务
 */
public interface WebConfigService {

    boolean insertList(List<WebConfigDO> param);

    boolean delete(List<String> values);

    boolean deleteAndInsertList(List<WebConfigDO> param);

    Optional<List<WebConfigDO>> queryByValue(String value);

    Optional<WebConfigDO> queryByCode(String code, String value);

}
