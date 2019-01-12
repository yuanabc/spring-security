package com.ybinsure.auth.bean.security;

import com.ybinsure.auth.constant.ChannelCode;
import com.ybinsure.auth.constant.CompanyLinkTypeCode;
import com.ybinsure.auth.constant.PermissionTypeCode;
import com.ybinsure.auth.constant.StatusCode;
import com.ybinsure.auth.model.data.CompanyDO;
import com.ybinsure.auth.model.data.PermissionDO;
import com.ybinsure.auth.model.data.UserDO;
import com.ybinsure.auth.model.link.UserExtend;
import com.ybinsure.auth.model.transfer.tree.TreeNode;
import com.ybinsure.auth.service.data.ChannelService;
import com.ybinsure.auth.service.data.CompanyService;
import com.ybinsure.auth.service.data.PermissionService;
import com.ybinsure.auth.service.link.UserLinkPermissionService;
import com.ybinsure.auth.service.tool.EmptyPasswordService;
import com.ybinsure.auth.service.tool.TreeNodeService;
import com.ybinsure.auth.util.SplitUserNameUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserLinkPermissionService userLinkPermissionService;
    private final CompanyService companyService;
    private final PermissionService permissionService;
    private final TreeNodeService treeNodeService;
    private final ChannelService channelService;
    private final EmptyPasswordService emptyPasswordService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userName = SplitUserNameUtils.getRealUserName(username);
        String outChannelCode = SplitUserNameUtils.getRealChannelCode(username);
        if (StringUtils.isBlank(userName)) {
            return new User(userName, null, null);
        }
        String innerChannelCode = channelService.queryInnerCode(outChannelCode).orElse(outChannelCode);
        UserDO param = new UserDO();
        param.setUserName(userName);
        param.setChannelCode(innerChannelCode);
        param.setStatus(StatusCode.ENABLE);
        Optional<UserExtend> optionalLinkedDO = userLinkPermissionService.queryByUserInfo(param);
        if (!optionalLinkedDO.isPresent()) {
            return new User(userName, null, null);
        }
        UserExtend userExtend = optionalLinkedDO.get();
        // 悦保超级管理员自动获取所有权限项
        if (ChannelCode.isRootAdminChannel(optionalLinkedDO.get().getChannelCode())) {
            userExtend.setPermissionDOS(permissionService.queryByTypes(Arrays.asList(PermissionTypeCode.COMMON, PermissionTypeCode.ADMIN)).orElseGet(ArrayList::new));
        }
        // 悦保运维管理员附加管理员权限
        if (ChannelCode.isManagerAdminChannel(optionalLinkedDO.get().getChannelCode())) {
            List<PermissionDO> adminPermission = permissionService.queryByTypes(Collections.singletonList(PermissionTypeCode.ADMIN)).orElseGet(ArrayList::new);
            List<PermissionDO> permissionDOS = Optional.ofNullable(userExtend.getPermissionDOS()).orElseGet(ArrayList::new);
            permissionDOS.addAll(adminPermission);
            userExtend.setPermissionDOS(permissionDOS);
        }
        String defaultPassword = emptyPasswordService.getCryptDefaultPassword(userExtend.getId()).orElse(userExtend.getPassword());
        userExtend.setPassword(defaultPassword);
        List<GrantedAuthority> companyAuthority = getCompanyAuthority(userName, userExtend.getChannelCode());
        return setCompanyAuthority(userExtend.getUserDetails(), companyAuthority);
    }

    private User setCompanyAuthority(User user, List<GrantedAuthority> grantedAuthorities) {
        grantedAuthorities.addAll(user.getAuthorities());
        return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }

    /**
     * 设置有权限的机构
     */
    private List<GrantedAuthority> getCompanyAuthority(String userName, String channelCode) {
        List<CompanyDO> companyDOS = getCompanyDO(userName, channelCode);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        companyDOS.forEach(companyDO -> grantedAuthorities.add(new SimpleGrantedAuthority(companyDO.getId())));
        return grantedAuthorities;
    }

    private List<CompanyDO> getCompanyDO(String userName, String channelCode) {
        // 只有归属机构则直接使用归属机构最后一层
        Optional<CompanyDO> belongCompany = realBelongCompany(userName, channelCode);
        Optional<List<CompanyDO>> managerCompany = companyService.queryByUserName(userName, channelCode, CompanyLinkTypeCode.MANAGER);
        if (!managerCompany.isPresent() || managerCompany.get().isEmpty()) {
            return belongCompany.map(Collections::singletonList).orElseGet(ArrayList::new);
        }
        // 悦保渠道如果有管理机构则直接返回管理机构
        if (ChannelCode.YUEBAO.equals(channelCode)) {
            return managerCompany.get();
        }
        // 归属和管辖机构均有，则计算
        List<TreeNode> companyTree = companyService.queryTree().orElseGet(ArrayList::new);
        return computePermissionCompany(belongCompany.orElse(null), managerCompany.get(), companyTree);
    }

    /**
     * 获取归属机构
     */
    private Optional<CompanyDO> realBelongCompany(String userName, String channelCode) {
        Optional<List<CompanyDO>> belongCompanyOptional = companyService.queryByUserName(userName, channelCode, CompanyLinkTypeCode.BELONG);
        if (!belongCompanyOptional.isPresent()) {
            return Optional.empty();
        }
        List<CompanyDO> companyDOS = belongCompanyOptional.get();
        return companyDOS.stream().max(Comparator.comparingInt(CompanyDO::getLevel));
    }

    // 结合归属机构和管辖机构计算有效的权限机构
    private List<CompanyDO> computePermissionCompany(CompanyDO belongCompany, List<CompanyDO> managerCompany, List<TreeNode> treeNodes) {
        List<TreeNode> managerCompanyTreeNode = treeNodeService.matchTreeNodes(managerCompany, treeNodes);
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
