package com.ybinsure.auth.service.link;

import com.ybinsure.auth.model.data.PermissionDO;
import com.ybinsure.auth.model.data.UserDO;
import com.ybinsure.auth.model.link.UserExtend;
import com.ybinsure.auth.model.transfer.tree.TreeNode;

import java.util.List;
import java.util.Optional;

public interface UserLinkPermissionService {

    Optional<UserExtend> queryByUserInfo(UserDO param);

    Optional<List<PermissionDO>> queryByChannelCode(String channelCode);

    Optional<List<TreeNode>> queryByChannelCodeWithTree(String channelCode);

}
