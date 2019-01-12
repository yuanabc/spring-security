package com.ybinsure.auth.serviceImpl.tool;

import com.ybinsure.auth.model.transfer.tree.CompanyTreeNode;
import com.ybinsure.auth.service.tool.CompanyTreeService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DefaultCompanyTreeService implements CompanyTreeService {

    @Override
    public List<CompanyTreeNode> convert(List<CompanyTreeNode> companyTreeNodes) {
        List<CompanyTreeNode> result = Optional.ofNullable(companyTreeNodes).orElseGet(ArrayList::new)
                .stream()
                .filter(CompanyTreeNode::isRoot)
                .collect(Collectors.toList());
        result.forEach(item -> collectChildren(item, companyTreeNodes));
        return result;
    }

    private void collectChildren(CompanyTreeNode parent, List<CompanyTreeNode> companyTreeNodes) {
        Optional.ofNullable(companyTreeNodes).orElseGet(ArrayList::new).forEach(item -> {
            if (StringUtils.equals(parent.getId(), item.getParentId())) {
                parent.getChildren().add(item);
            }
        });
        for (CompanyTreeNode item : parent.getChildren()) {
            collectChildren(item, companyTreeNodes);
        }
        if (parent.getChildren().isEmpty()) {
            parent.setChildren(null);
        }
    }

    @Override
    public List<CompanyTreeNode> matchTreeNodes(List<String> matchKey, List<CompanyTreeNode> companyTreeNodes) {
        List<CompanyTreeNode> matchResult = new ArrayList<>();
        companyTreeNodes.forEach(treeItem -> chooseMatchNodes(matchKey, treeItem, matchResult));
        return matchResult;
    }

    private void chooseMatchNodes(List<String> matchKey, CompanyTreeNode treeNode, List<CompanyTreeNode> matchResult) {
        // 检查当前节点是否属于管辖机构，如果属于管辖机构则加入匹配结果，然后返回不继续检查自节点
        boolean isMatch = matchKey.stream().anyMatch(key -> StringUtils.equals(key, treeNode.getId()));
        if (isMatch) {
            matchResult.add(treeNode);
            return;
        }
        if (treeNode.getChildren() != null && !treeNode.getChildren().isEmpty()) {
            treeNode.getChildren().forEach(item -> chooseMatchNodes(matchKey, item, matchResult));
        }
    }

}
