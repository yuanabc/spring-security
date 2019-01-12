package com.ybinsure.auth.serviceImpl.link;

import com.ybinsure.auth.constant.StatusCode;
import com.ybinsure.auth.mapper.link.UserLinkPermissionMapper;
import com.ybinsure.auth.model.data.PermissionDO;
import com.ybinsure.auth.model.data.UserDO;
import com.ybinsure.auth.model.link.UserExtend;
import com.ybinsure.auth.model.transfer.tree.TreeNode;
import com.ybinsure.auth.service.data.UserService;
import com.ybinsure.auth.service.link.UserExtendService;
import com.ybinsure.auth.service.link.UserLinkPermissionService;
import com.ybinsure.auth.service.tool.TreeNodeService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultUserLinkPermissionService implements UserLinkPermissionService {

    private final UserLinkPermissionMapper userLinkPermissionMapper;
    private final UserService userService;
    private final UserExtendService userExtendService;
    private final TreeNodeService treeNodeService;

    @Override
    public Optional<UserExtend> queryByUserInfo(UserDO param) {
        if (StringUtils.isBlank(param.getUserName()) ||
                param.getStatus() == null) {
            return Optional.empty();
        }
        param.setDeleted(StatusCode.DISABLE);
        List<UserExtend> queryResult = userLinkPermissionMapper.queryByUserName(param);
        if (queryResult.size() == 0) {
            return Optional.empty();
        }
        UserExtend result = queryResult.get(0);
        if (!userExtendService.checkUserCompanyStatus(result.getId())) {
            return Optional.empty();
        }
        List<PermissionDO> permissionDOS = userLinkPermissionMapper.queryByUserId(result);
        result.setPermissionDOS(permissionDOS);
        return Optional.of(result);
    }

    @Override
    public Optional<List<PermissionDO>> queryByChannelCode(String channelCode) {
        if (StringUtils.isBlank(channelCode)) {
            return Optional.empty();
        }
        Optional<UserDO> adminOptional = userService.queryAdmin(channelCode);
        if (!adminOptional.isPresent()) {
            return Optional.empty();
        }
        UserDO admin = adminOptional.get();
        admin.setStatus(StatusCode.ENABLE);
        admin.setChannelStatus(StatusCode.ENABLE);
        Optional<UserExtend> userExtendOptional = queryByUserInfo(admin);
        if (!userExtendOptional.isPresent()) {
            return Optional.empty();
        }
        return Optional.ofNullable(userExtendOptional.get().getPermissionDOS());
    }

    @Override
    public Optional<List<TreeNode>> queryByChannelCodeWithTree(String channelCode) {
        Optional<List<PermissionDO>> permissionDOS = queryByChannelCode(channelCode);
        return permissionDOS.map(treeNodeService::convert);
    }

}
