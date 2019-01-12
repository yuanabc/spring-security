package com.ybinsure.auth.serviceImpl.tree;

import com.ybinsure.auth.constant.CompanyTypeCode;
import com.ybinsure.auth.model.data.CompanyDO;
import com.ybinsure.auth.model.transfer.tree.TreeNode;
import com.ybinsure.auth.service.tree.TreeNodeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class DefaultTreeNodeService implements TreeNodeService {


    @Override
    public void filterTeamNodes(List<TreeNode> treeNodes) {
        Optional.ofNullable(treeNodes).orElseGet(ArrayList::new).forEach(this::filterTeamNode);
    }

    private void filterTeamNode(TreeNode treeNode) {
        if (treeNode.getChildren() == null || treeNode.getChildren().isEmpty()) {
            return;
        }
        List<TreeNode> filterChildren = treeNode.getChildren().stream()
                .filter(item -> !StringUtils.equals(item.getCompanyType(), CompanyTypeCode.TEAM))
                .collect(Collectors.toList());
        treeNode.setChildren(filterChildren);
        treeNode.getChildren().forEach(this::filterTeamNode);
    }



    @Override
    public void setLeaf(List<TreeNode> param) {
        Optional.ofNullable(param).ifPresent(treeNodes -> treeNodes.forEach(this::setLeaf));
    }

    private void setLeaf(TreeNode treeNode) {
        if (treeNode.getChildren() == null || treeNode.getChildren().isEmpty()) {
            treeNode.setLeaf(true);
            return;
        }
        treeNode.getChildren().forEach(this::setLeaf);
    }

    @Override
    public List<TreeNode> matchTreeNodes(List<String> keys, List<TreeNode> sources) {
        List<TreeNode> matchResult = new ArrayList<>();
        sources.forEach(treeItem -> chooseMatchNodes(keys, treeItem, matchResult));
        return matchResult;
    }

    private void chooseMatchNodes(List<String> keys, TreeNode treeNode, List<TreeNode> matchResult) {
        // 检查当前节点是否属于管辖机构，如果属于管辖机构则加入匹配结果，然后返回不继续检查自节点
        boolean isMatch = keys.stream().anyMatch(key -> StringUtils.equals(key, treeNode.getKey()));
        if (isMatch) {
            matchResult.add(treeNode);
            return;
        }
        if (treeNode.getChildren() != null && !treeNode.getChildren().isEmpty()) {
            treeNode.getChildren().forEach(item -> chooseMatchNodes(keys, item, matchResult));
        }
    }


    @Override
    public Optional<TreeNode> matchTreeNode(String key, List<TreeNode> sources) {
        for(TreeNode treeNode : sources) {
            Optional<TreeNode> temp = chooseMatchTreeNode(key, treeNode);
            if (temp.isPresent()) {
                return temp;
            }
        }
        return Optional.empty();
    }

    /**
     * 检查key是否与treeNode以及其子节点匹配
     */
    private Optional<TreeNode> chooseMatchTreeNode(String key, TreeNode treeNode) {
        if (StringUtils.equals(treeNode.getKey(), key)) {
            return Optional.of(treeNode);
        }
        if (treeNode.getChildren() != null && !treeNode.getChildren().isEmpty()) {
            for(TreeNode children : treeNode.getChildren()) {
                Optional<TreeNode> temp = chooseMatchTreeNode(key, children);
                if (temp.isPresent()) {
                    return temp;
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<String>> chooseTeamCompany(TreeNode treeNode) {
        if (treeNode == null) {
            return Optional.empty();
        }
        List<String> res = new ArrayList<>();
        reduceTeamCompany(treeNode, res);
        return Optional.of(res);
    }

    /**
     * 收集节点以及子节点的团队性质节点
     */
    private void reduceTeamCompany(TreeNode treeNode, List<String> container) {
        if (CompanyTypeCode.TEAM.equals(treeNode.getCompanyType())) {
            container.add(treeNode.getKey());
        }
        if (treeNode.getChildren() != null) {
            treeNode.getChildren().forEach(children -> reduceTeamCompany(children, container));
        }
    }

    @Override
    public Optional<List<TreeNode>> query(List<TreeNode> treeNodes, CompanyDO param) {
        if (treeNodes == null || treeNodes.isEmpty() || StringUtils.isBlank(param.getChannelCode())) {
            return Optional.empty();
        }
        List<TreeNode> result = new ArrayList<>();
        treeNodes.forEach(item -> collectMatchNode(item, param, result));
        result.forEach(item -> filterChildrenTreeNode(item, param));
        return Optional.of(result);
    }

    /**
     * 匹配符合条件的父节点
     */
    private void collectMatchNode(TreeNode treeNode, CompanyDO param, List<TreeNode> result) {
        // areaCode和level匹配
        if (queryMatch(treeNode, param)) {
            result.add(treeNode);
            return;
        }
        if (treeNode.getChildren() != null && !treeNode.getChildren().isEmpty()) {
            treeNode.getChildren().forEach(children -> collectMatchNode(children, param, result));
        }
    }

    /**
     * 过滤符合条件的父节点的子节点
     */
    private void filterChildrenTreeNode(TreeNode treeNode, CompanyDO param) {
        List<TreeNode> children = Optional.ofNullable(treeNode.getChildren()).orElseGet(ArrayList::new)
                .stream().filter(childrenTreeNode -> queryMatch(childrenTreeNode, param)).collect(Collectors.toList());
        children.forEach(childrenTreeNode -> filterChildrenTreeNode(childrenTreeNode, param));
        treeNode.setChildren(children);
    }

    private boolean queryMatch(TreeNode treeNode, CompanyDO param) {
        boolean channelCodeMatch = StringUtils.equals(treeNode.getChannelCode(), param.getChannelCode());
        boolean areaCodeMatch = StringUtils.isBlank(param.getAreaCode()) || StringUtils.equals(treeNode.getAreaCode(), param.getAreaCode());
        boolean levelMatch = param.getLevel() == null || param.getLevel().equals(treeNode.getLevel());
        return channelCodeMatch && areaCodeMatch && levelMatch;
    }


    @Override
    public Optional<Map<String, List<CompanyDO>>> queryParent(List<String> ids, List<TreeNode> sources) {
        if (ids == null || ids.isEmpty() || sources == null || sources.isEmpty()) {
            return Optional.empty();
        }
        List<TreeNode> treeNodes = matchTreeNodes(ids, sources);
        Map<String, List<CompanyDO>> result = new HashMap<>();
        treeNodes.forEach(treeNode -> {
            result.put(treeNode.getKey(), getParent(treeNode));
        });
        return Optional.of(result);
    }

    private List<CompanyDO> getParent(TreeNode treeNode) {
        List<CompanyDO> result = new ArrayList<>();
        int count = 0;
        do {
            count++;
            result.add(convert(treeNode));
            treeNode = treeNode.getParent();
        } while (treeNode != null && count < 20);
        return result;
    }

    private CompanyDO convert(TreeNode treeNode) {
        CompanyDO item = new CompanyDO();
        item.setId(treeNode.getKey());
        item.setName(treeNode.getTitle());
        item.setLevel(treeNode.getLevel());
        item.setCompanyType(treeNode.getCompanyType());
        return item;
    }

}
