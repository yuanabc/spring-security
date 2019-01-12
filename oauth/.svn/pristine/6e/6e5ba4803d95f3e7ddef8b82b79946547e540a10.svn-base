package com.ybinsure.auth.serviceImpl.adapter;

import com.ybinsure.auth.constant.CompanyTypeCode;
import com.ybinsure.auth.constant.UserTypeCode;
import com.ybinsure.auth.model.data.CompanyDO;
import com.ybinsure.auth.model.data.UserDO;
import com.ybinsure.auth.model.transfer.tree.CompanyTreeNode;
import com.ybinsure.auth.model.transfer.tree.TreeNode;
import com.ybinsure.auth.service.adapter.CompanyAdapterService;
import com.ybinsure.auth.service.data.CompanyService;
import com.ybinsure.auth.service.link.UserLinkCompanyService;
import com.ybinsure.auth.service.tool.CompanyTreeService;
import com.ybinsure.auth.service.tool.TreeNodeService;
import com.ybinsure.auth.util.AuthenticationHelper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DefaultCompanyAdapterService implements CompanyAdapterService {

    private final TreeNodeService treeNodeService;
    private final CompanyTreeService companyTreeService;
    private final CompanyService companyService;
    private final UserLinkCompanyService userLinkCompanyService;

    @Override
    public Optional<List<TreeNode>> queryAllTreeFilterByIds(List<String> ids) {
        Optional<List<TreeNode>> allTreeOptional = companyService.queryTree();
        if (!allTreeOptional.isPresent()) {
            return Optional.empty();
        }
        List<CompanyDO> companyDOS = Optional.ofNullable(ids).orElseGet(ArrayList::new)
                .stream()
                .map(CompanyDO::createInstance)
                .collect(Collectors.toList());
        List<TreeNode> matchTreeNodes = treeNodeService.matchTreeNodes(companyDOS, allTreeOptional.get());
        return Optional.ofNullable(matchTreeNodes);
    }

    @Override
    public Optional<List<TreeNode>> queryAllWithTreeOfEffective() {
        return queryAllWithTreeOfEffectiveNotLimit().map(treeNodes -> {
            treeNodeService.limitTreeNodeSize(treeNodes, TreeNodeService.DEFAULT_MAX, null);
            return treeNodes;
        });
    }

    @Override
    public Optional<List<TreeNode>> queryAllWithTreeOfEffective(List<String> ids) {
        Optional<List<TreeNode>> effectiveTreeNodeOptional = queryAllWithTreeOfEffectiveNotLimit();
        effectiveTreeNodeOptional.ifPresent(effectiveTreeNode -> {
            if (!treeNodeService.greaterSize(effectiveTreeNode, TreeNodeService.DEFAULT_MAX)) {
                return;
            }
            List<CompanyDO> matchAllCompanies = Optional.ofNullable(ids).orElseGet(ArrayList::new).stream()
                    .map(id -> companyService.queryAllParentsWithSelf(id).orElseGet(ArrayList::new))
                    .reduce(
                            new ArrayList<>(),
                            (a, b) -> {
                                a.addAll(b);
                                return a;
                            });
            treeNodeService.limitTreeNodeSize(effectiveTreeNode, TreeNodeService.DEFAULT_MAX, matchAllCompanies);
        });
        return effectiveTreeNodeOptional;
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
    public Optional<List<CompanyTreeNode>> queryCompanyTreeOfEffective() {
        List<String> companyIds = AuthenticationHelper.localContextHolderParser().getCompanyAuthority();
        return companyService.queryCompanyTree()
                .map(companyTreeNodes -> companyTreeService.matchTreeNodes(companyIds, companyTreeNodes));
    }

    @Override
    public Optional<List<TreeNode>> queryAllWithTreeOfEffectiveNotLimit() {
        return queryAllTreeFilterByIds(AuthenticationHelper.localContextHolderParser().getCompanyAuthority());
    }

    @Override
    public Optional<List<String>> queryChildWithTeam(String id) {
        if (StringUtils.isBlank(id)) {
            return Optional.empty();
        }
        CompanyDO param = new CompanyDO();
        param.setId(id);
        // 后续可能需要调整为按机构权限
        Optional<TreeNode> matchTreeNode = treeNodeService.matchTreeNode(param, companyService.queryTree().orElseGet(ArrayList::new));
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
        List<CompanyDO> param = ids.stream().map(id -> {
            CompanyDO item = new CompanyDO();
            item.setId(id);
            return item;
        }).collect(Collectors.toList());
        List<TreeNode> matchTreeNodes = treeNodeService.matchTreeNodes(param, companyService.queryTree().orElseGet(ArrayList::new));
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
        Optional<List<TreeNode>> result = treeNodeService.query(queryAllWithTreeOfEffectiveNotLimit().orElseGet(ArrayList::new), param);
        if (param.isFilterTeamCompany()) {
            result.ifPresent(treeNodeService::filterTeamNodes);
        }
        return result;
    }


    @Override
    public Optional<List<TreeNode>> queryWithTree(List<String> ids) {
        if (ids == null || ids.isEmpty()) {
            return Optional.empty();
        }
        List<CompanyDO> matchConditions = ids.stream().map(id -> {
            CompanyDO item = new CompanyDO();
            item.setId(id);
            return item;
        }).collect(Collectors.toList());
        return companyService.queryTree().map(treeNodes -> treeNodeService.matchTreeNodes(matchConditions, treeNodes));
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
                                    userLinkCompanyService.queryUserByCompanyIdAndUserType(children.getKey(), Collections.singletonList(UserTypeCode.SALE))
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
        List<CompanyDO> matchItem = ids.stream().map(id -> {
            CompanyDO item = new CompanyDO();
            item.setId(id);
            return item;
        }).collect(Collectors.toList());
        List<TreeNode> treeNodes = companyService.queryTree().orElseGet(ArrayList::new);
        List<TreeNode> matchTreeNodes = treeNodeService.matchTreeNodes(matchItem, treeNodes);
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
