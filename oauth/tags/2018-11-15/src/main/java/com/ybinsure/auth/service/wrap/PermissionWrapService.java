package com.ybinsure.auth.service.wrap;

import com.ybinsure.auth.model.data.PermissionDO;
import com.ybinsure.auth.model.transfer.tree.TreeNode;

import java.util.List;
import java.util.Optional;

public interface PermissionWrapService {

    Optional<List<PermissionDO>> queryByChannelCode(String channelCode);

    Optional<List<TreeNode>> queryByChannelCodeWithTree(String channelCode);
}
