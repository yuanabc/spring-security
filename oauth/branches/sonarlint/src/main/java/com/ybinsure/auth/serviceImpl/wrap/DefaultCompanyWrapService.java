package com.ybinsure.auth.serviceImpl.wrap;

import com.ybinsure.auth.constant.CompanyTypeCode;
import com.ybinsure.auth.constant.UserTypeCode;
import com.ybinsure.auth.exception.FailResultException;
import com.ybinsure.auth.model.data.CompanyDO;
import com.ybinsure.auth.model.data.UserDO;
import com.ybinsure.auth.model.link.CompanyLinkWebConfig;
import com.ybinsure.auth.model.transfer.tree.TreeNode;
import com.ybinsure.auth.service.data.CompanyService;
import com.ybinsure.auth.service.data.UserService;
import com.ybinsure.auth.service.data.WebConfigService;
import com.ybinsure.auth.service.tool.TokenClearService;
import com.ybinsure.auth.service.tree.CompanyTreeService;
import com.ybinsure.auth.service.tree.TreeNodeService;
import com.ybinsure.auth.service.wrap.CompanyWrapService;
import com.ybinsure.auth.util.AuthenticationHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class DefaultCompanyWrapService implements CompanyWrapService {

    private final UserService userService;
    private final TokenClearService tokenClearService;
    private final CompanyService companyService;
    private final TreeNodeService treeNodeService;
    private final CompanyTreeService companyTreeService;
    private final WebConfigService webConfigService;

    @Override
    public boolean delete(String id) {
        boolean res = companyService.delete(id);
        if (res) {
            tokenClearService.clearByCompanyId(id);
        }
        return res;
    }

    @Override
    public boolean disable(String id) {
        boolean res = companyService.disable(id);
        if (res) {
            tokenClearService.clearByCompanyId(id);
        }
        return res;
    }

    @Override
    @Transactional
    public Optional<String> insertCompanyLinkWebConfig(CompanyLinkWebConfig param) {
        Optional<String> insertCompanyResult = companyService.insert(param.getCompanyDO());
        if (!insertCompanyResult.isPresent()) {
            return Optional.empty();
        }
        param.getWebConfigDOS().forEach(webConfigDo -> webConfigDo.setValue(insertCompanyResult.get()));
        webConfigService.deleteAndInsertList(param.getWebConfigDOS());
        return insertCompanyResult;
    }

    @Override
    @Transactional
    public boolean updateCompanyLinkWebConfig(CompanyLinkWebConfig param) {
        if (!companyService.update(param.getCompanyDO())) {
            return false;
        }
        param.getWebConfigDOS().forEach(webConfigDo -> webConfigDo.setValue(param.getCompanyDO().getId()));
        webConfigService.deleteAndInsertList(param.getWebConfigDOS());
        return true;
    }

    @Override
    public void resetCompanySort() {
        List<CompanyDO> allCompanyTree = companyService.queryCompanyTree().orElseGet(ArrayList::new);
        for (CompanyDO root : allCompanyTree) {
            loopCompanyAndUpdateCompanySort(root);
        }
    }

    private void loopCompanyAndUpdateCompanySort(CompanyDO parent) {
        if (parent.getChildren() == null || parent.getChildren().isEmpty()) {
            return;
        }
        updateCompanySort(parent.getChildren());
        for (CompanyDO children : parent.getChildren()) {
            loopCompanyAndUpdateCompanySort(children);
        }
    }

    private void updateCompanySort(List<CompanyDO> children) {
        children = Optional.ofNullable(children).orElseGet(ArrayList::new);
        children.sort(Comparator.comparingInt(CompanyDO::getSort));
        int defaultStartSort = 10000;
        for (CompanyDO item : children) {
            CompanyDO param = new CompanyDO();
            param.setId(item.getId());
            param.setSort(defaultStartSort++);
            if (!companyService.update(param)) {
                log.warn("更新排序失败, id-{}", param.getId());
            } else {
                log.warn("更新排序成功, id-{}", param.getId());
            }
        }
    }

    @Override
    // todo调整
    public Optional<List<CompanyDO>> queryChildrenByToken() {
        String userId = AuthenticationHelper.localContextHolderParser().getId().orElseThrow(FailResultException::userInfoError);
        UserDO userExtend = userService.queryUserLinkCompanyAndLinkRoleById(userId).orElseGet(UserDO::new);
        String lastBelongCompanyId = Optional.ofNullable(userExtend.getBelongCompanys()).orElseGet(ArrayList::new)
                .stream()
                .max(Comparator.comparingInt(CompanyDO::getLevel))
                .map(CompanyDO::getId)
                .orElseThrow(() -> new FailResultException("获取归属机构数据失败"));
        return companyService.queryChild(lastBelongCompanyId);
    }

    @Override
    public Optional<List<TreeNode>> queryAllTreeFilterByIds(List<String> ids) {
        Optional<List<TreeNode>> allTreeOptional = companyService.queryTree();
        if (!allTreeOptional.isPresent()) {
            return Optional.empty();
        }
        List<TreeNode> matchTreeNodes = treeNodeService.matchTreeNodes(ids, allTreeOptional.get());
        return Optional.ofNullable(matchTreeNodes);
    }

    @Override
    public Optional<List<TreeNode>> queryAllWithTreeFilterByIdAndOther(String id) {
        Optional<List<TreeNode>> filterTreeNodes = queryAllTreeFilterByIds(Collections.singletonList(id));
        List<TreeNode> result = new ArrayList<>();
        filterTreeNodes.ifPresent(treeNodes -> {
            treeNodes.forEach(treeNode -> {
                // 防止数据异常形成死循环
                int limit = 20;
                TreeNode currentTreeNode = treeNode;
                TreeNode tempTreeNode = new TreeNode();
                // 过滤同渠道同保监地的节点
                tempTreeNode.setAreaCode(currentTreeNode.getAreaCode());
                tempTreeNode.setChannelCode(currentTreeNode.getChannelCode());
                while (limit >= 0) {
                    limit--;
                    tempTreeNode.setKey(currentTreeNode.getKey());
                    TreeNode parent = currentTreeNode.getParent();
                    boolean notMatch = parent == null || !StringUtils.equals(parent.getAreaCode(), tempTreeNode.getAreaCode()) ||
                            !StringUtils.equals(parent.getChannelCode(), tempTreeNode.getChannelCode());
                    if (notMatch) {
                        result.add(currentTreeNode);
                        break;
                    }
                    currentTreeNode = parent;
                }
            });
        });
        return Optional.of(result);
    }

    @Override
    public Optional<List<CompanyDO>> queryCompanyTreeOfEffective() {
        List<String> companyIds = AuthenticationHelper.localContextHolderParser().getCompanyAuthority();
        return companyService.queryCompanyTree()
                .map(companyTrees -> companyTreeService.matchNodes(companyTrees, companyIds));
    }

    @Override
    public Optional<List<TreeNode>> queryAllWithTreeOfEffective() {
        return queryAllTreeFilterByIds(AuthenticationHelper.localContextHolderParser().getCompanyAuthority());
    }

    @Override
    public Optional<List<String>> queryChildWithTeam(String id) {
        if (StringUtils.isBlank(id)) {
            return Optional.empty();
        }
        // 后续可能需要调整为按机构权限
        Optional<TreeNode> matchTreeNode = treeNodeService.matchTreeNode(id, companyService.queryTree().orElseGet(ArrayList::new));
        if (matchTreeNode.isPresent()) {
            return treeNodeService.chooseTeamCompany(matchTreeNode.get());
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<String>> queryChildrenWithTeam(List<String> ids) {
        if (ids == null || ids.isEmpty()) {
            return Optional.empty();
        }
        List<TreeNode> matchTreeNodes = treeNodeService.matchTreeNodes(ids, companyService.queryTree().orElseGet(ArrayList::new));
        List<String> result = matchTreeNodes.stream()
                .flatMap(treeNode -> treeNodeService.chooseTeamCompany(treeNode).orElseGet(ArrayList::new).stream())
                .collect(Collectors.toList());
        return Optional.of(result);
    }

    @Override
    public Optional<List<TreeNode>> queryWithTreeByChannelCode(CompanyDO param) {
        if (StringUtils.isBlank(param.getChannelCode())) {
            return Optional.empty();
        }
        Optional<List<TreeNode>> result = treeNodeService.query(queryAllWithTreeOfEffective().orElseGet(ArrayList::new), param);
        if (param.isFilterTeamCompany()) {
            result.ifPresent(treeNodeService::filterTeamNodes);
        }
        return result;
    }

    @Override
    public Optional<List<TreeNode>> queryChildrenTreeFilterByIds(List<String> ids, boolean isFilterTeamCompany) {
        if (ids == null || ids.isEmpty()) {
            return Optional.empty();
        }
        return companyService.queryTree()
                .map(treeNodes -> treeNodeService.matchTreeNodes(ids, treeNodes))
                .map(treeNodes -> {
                    if (isFilterTeamCompany) {
                        treeNodeService.filterTeamNodes(treeNodes);
                    }
                    return treeNodes;
                });
    }


    @Override
    public Optional<List<TreeNode>> queryCompanyTypeChildrenTreeNode(List<String> ids) {
        return queryChildrenCompanyTreeNode(ids, CompanyTypeCode.COMPANY);
    }

    @Override
    public Optional<List<TreeNode>> queryChildrenTeamTypeTreeNode(List<String> ids) {
        return queryChildrenCompanyTreeNode(ids, CompanyTypeCode.TEAM);
    }

    @Override
    public Optional<List<TreeNode>> queryTeamTypeChildrenAndSalesTreeNode(List<String> ids) {
        Optional<List<TreeNode>> treeNodesOptional = queryChildrenTeamTypeTreeNode(ids);
        // todo 暂时单个机构的查询
        treeNodesOptional.ifPresent(treeNodes -> {
            treeNodes.forEach(treeNode -> {
                Optional.ofNullable(treeNode.getChildren()).orElseGet(ArrayList::new)
                        .forEach(children -> {
                            List<TreeNode> userTreeNode =
                                    userService.queryUserByCompanyIdsAndUserTypes(Collections.singletonList(children.getKey()), Collections.singletonList(UserTypeCode.SALE))
                                            .orElseGet(ArrayList::new).stream().map(UserDO::convertTreeNode).collect(Collectors.toList());
                            userTreeNode.forEach(depthChildren -> {
                                depthChildren.setChildren(null);
                                depthChildren.setLeaf(true);
                            });
                            if (!userTreeNode.isEmpty()) {
                                children.setChildren(userTreeNode);
                                children.setLeaf(false);
                            }
                        });
            });
        });
        return treeNodesOptional;
    }

    @Override
    public Optional<Map<String, List<CompanyDO>>> queryParent(List<String> ids) {
        if (ids == null || ids.isEmpty()) {
            return Optional.empty();
        }
        List<TreeNode> treeNodes = companyService.queryTree().orElseGet(ArrayList::new);
        return treeNodeService.queryParent(ids, treeNodes);
    }

    private Optional<List<TreeNode>> queryChildrenCompanyTreeNode(List<String> ids, String type) {
        if (ids == null || ids.isEmpty()) {
            return Optional.empty();
        }
        List<TreeNode> treeNodes = companyService.queryTree().orElseGet(ArrayList::new);
        List<TreeNode> matchTreeNodes = treeNodeService.matchTreeNodes(ids, treeNodes);
        matchTreeNodes.forEach(treeNode -> {
            List<TreeNode> filterChildren = Optional.ofNullable(treeNode.getChildren()).orElseGet(ArrayList::new)
                    .stream().filter(value -> StringUtils.equals(value.getCompanyType(), type)).collect(Collectors.toList());
            filterChildren.forEach(value -> value.setChildren(null));
            treeNode.setChildren(filterChildren);
        });
        treeNodeService.setLeaf(matchTreeNodes);
        return Optional.of(matchTreeNodes);
    }

}
