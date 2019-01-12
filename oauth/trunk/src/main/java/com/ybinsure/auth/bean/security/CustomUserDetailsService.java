package com.ybinsure.auth.bean.security;

import com.ybinsure.auth.constant.ChannelCode;
import com.ybinsure.auth.constant.PermissionTypeCode;
import com.ybinsure.auth.exception.FailResultException;
import com.ybinsure.auth.model.data.CompanyDO;
import com.ybinsure.auth.model.data.PermissionDO;
import com.ybinsure.auth.model.data.UserDO;
import com.ybinsure.auth.model.transfer.tree.TreeNode;
import com.ybinsure.auth.service.data.ChannelService;
import com.ybinsure.auth.service.data.CompanyService;
import com.ybinsure.auth.service.data.PermissionService;
import com.ybinsure.auth.service.data.UserService;
import com.ybinsure.auth.service.tool.EmptyPasswordService;
import com.ybinsure.auth.service.tree.TreeNodeService;
import com.ybinsure.auth.util.SplitUserNameUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;
    private final CompanyService companyService;
    private final PermissionService permissionService;
    private final TreeNodeService treeNodeService;
    private final ChannelService channelService;
    private final EmptyPasswordService emptyPasswordService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDO> userInfoOption = queryUserInfo(username);
        if (!userInfoOption.isPresent() || hasDisableChannelOrCompany(userInfoOption.get())) {
            return new User(username, null, null);
        }
        UserDO userInfo = userInfoOption.get();
        setAdminPermission(userInfo);
        setDefaultPassword(userInfo);
        List<GrantedAuthority> companyAuthority = getCompanyAuthorities(userInfo)
                .stream()
                .map(companyDO -> new SimpleGrantedAuthority(companyDO.getId()))
                .collect(Collectors.toList());
        userInfo.setUserName(username);
        return userInfo.getUserDetails(companyAuthority);
    }

    private boolean hasDisableChannelOrCompany(UserDO userInfo) {
        boolean companyDisable = userService.hasDisableStatusCompany(userInfo.getId());
        if (companyDisable) {
            log.info("用户机构管理机构被禁用, username---{}", userInfo.getUserName());
        }
        boolean channelDisable = channelService.isDisable(userInfo.getChannelCode());
        if (channelDisable) {
            log.info("渠道被禁用, username---{}", userInfo.getUserName());
        }
        return companyDisable || channelDisable;
    }

    // 查询用户和权限信息
    private Optional<UserDO> queryUserInfo(String username) {
        String realUserName = SplitUserNameUtils.getRealUserName(username);
        String outChannelCode = SplitUserNameUtils.getRealChannelCode(username);
        if (StringUtils.isBlank(realUserName)) {
            return Optional.empty();
        }
        String realChannelCode = channelService.queryInnerCode(outChannelCode).orElse(outChannelCode);
        return userService.queryUserLinkCompanyAndLinkPermissionByUserNameAndChannelCode(realUserName , realChannelCode);
    }

    // 管理渠道设置自带权限
    private void setAdminPermission(UserDO userDO) {
        // 悦保超级管理员自动获取所有权限项
        if (ChannelCode.isRootAdminChannel(userDO.getChannelCode())) {
            userDO.setPermissionDOS(permissionService.queryByTypes(Arrays.asList(PermissionTypeCode.COMMON, PermissionTypeCode.ADMIN)).orElseGet(ArrayList::new));
        }
        // 悦保运维管理员附加管理员权限
        if (ChannelCode.isManagerAdminChannel(userDO.getChannelCode())) {
            List<PermissionDO> adminPermission = permissionService.queryByTypes(Collections.singletonList(PermissionTypeCode.ADMIN)).orElseGet(ArrayList::new);
            List<PermissionDO> permissionDOS = Optional.ofNullable(userDO.getPermissionDOS()).orElseGet(ArrayList::new);
            permissionDOS.addAll(adminPermission);
            userDO.setPermissionDOS(permissionDOS);
        }
    }

    // 没有密码登录，设置默认密码，模拟登录流程
    private void setDefaultPassword(UserDO userDO) {
        String defaultPassword = emptyPasswordService.getCryptDefaultPassword(userDO.getId()).orElse(userDO.getPassword());
        userDO.setPassword(defaultPassword);
    }

    // 计算机构权限
    private List<CompanyDO> getCompanyAuthorities(UserDO userDO) {
        CompanyDO lastLevelBelongCompany = Optional.ofNullable(userDO.getBelongCompanys()).orElseThrow(FailResultException::userInfoError)
                .stream()
                .max(Comparator.comparingInt(CompanyDO::getLevel))
                .orElseThrow(FailResultException::userInfoError);
        List<CompanyDO> managerCompaies = Optional.ofNullable(userDO.getManagerCompanys()).orElseGet(ArrayList::new);
        // 只有归属机构则直接使用归属机构最后一层
        if (managerCompaies.isEmpty()) {
            return Collections.singletonList(lastLevelBelongCompany);
        }
        // 归属和管辖机构均有，则计算
        List<TreeNode> companyTree = companyService.queryTree().orElseGet(ArrayList::new);
        return computePermissionCompany(lastLevelBelongCompany, managerCompaies, companyTree);
    }

    // 结合归属机构和管辖机构计算有效的权限机构
    private List<CompanyDO> computePermissionCompany(CompanyDO belongCompany, List<CompanyDO> managerCompany, List<TreeNode> treeNodes) {
        managerCompany = Optional.ofNullable(managerCompany).orElseGet(ArrayList::new);
        List<String> managerCompanyIds = managerCompany
                .stream()
                .map(CompanyDO::getId)
                .collect(Collectors.toList());
        List<TreeNode> managerCompanyTreeNode = treeNodeService.matchTreeNodes(managerCompanyIds, treeNodes);
        if (!isChildOrParent(belongCompany, managerCompanyTreeNode)) {
            managerCompany.add(belongCompany);
        }
        return managerCompany;
    }

    // 检查机构是否是treeItem元素的上下级
    private boolean isChildOrParent(CompanyDO companyDO, List<TreeNode> treeNodes) {
        return treeNodes.stream().anyMatch(treeItem -> isChildren(companyDO, treeItem) || isParent(companyDO, treeItem));
    }

    private boolean isChildren(CompanyDO companyDO, TreeNode treeNode) {
        if (companyDO.getId().equals(treeNode.getKey())) {
            return true;
        }
        if (treeNode.getChildren() == null || treeNode.getChildren().isEmpty()) {
            return false;
        }
        return treeNode.getChildren().stream().anyMatch(child -> isChildren(companyDO, child));
    }

    private boolean isParent(CompanyDO companyDO, TreeNode treeNode) {
        if (companyDO.getId().equals(treeNode.getKey())) {
            return true;
        }
        if (treeNode.getParent() == null) {
            return false;
        }
        return isParent(companyDO, treeNode.getParent());
    }

}
