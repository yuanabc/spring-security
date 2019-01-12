package com.ybinsure.auth.service.data;

import com.ybinsure.auth.model.data.RoleDO;
import com.ybinsure.auth.model.transfer.page.PageParam;
import com.ybinsure.auth.model.transfer.page.PageResult;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    Optional<String> insert(RoleDO roleDO);

    boolean update(RoleDO roleDO);

    Optional<List<RoleDO>> queryByChannelCode(String channelCode);

    Optional<List<RoleDO>> queryByChannelCodes(List<String> channelCodes);

    Optional<PageResult<List<RoleDO>>> queryWithPage(PageParam<RoleDO> pageParam);

    Optional<List<RoleDO>> queryTemplateRole();

    boolean delete(String roleId);

    boolean exist(RoleDO roleDO);

    boolean exist(String id);
}
