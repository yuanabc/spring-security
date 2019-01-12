package com.ybinsure.auth.service.data;

import com.ybinsure.auth.model.data.RoleDO;
import com.ybinsure.auth.model.transfer.page.PageParam;
import com.ybinsure.auth.model.transfer.page.PageResult;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    Optional<String> insert(RoleDO roleDO);

    Optional<String> insertAdmin(RoleDO roleDO);

    boolean update(RoleDO roleDO);

    boolean delete(String roleId);

    boolean exist(String name, String channelCode);

    boolean exist(String id);

    Optional<RoleDO> queryById(String id);

    Optional<List<RoleDO>> queryByChannelCode(String channelCode);

    Optional<List<RoleDO>> queryByChannelCodes(List<String> channelCodes);

    Optional<PageResult<List<RoleDO>>> queryWithPage(PageParam<RoleDO> pageParam);

    Optional<List<RoleDO>> queryTemplateRole();

    Optional<RoleDO> queryAdminRole(String channelCode);

}
