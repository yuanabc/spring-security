package com.ybinsure.auth.service.tool;

import com.ybinsure.auth.model.transfer.tree.CompanyTreeNode;

import java.util.List;

public interface CompanyTreeService {

    List<CompanyTreeNode> convert(List<CompanyTreeNode> companyTreeNodes);

    /**
     * 匹配树形数据
     */
    List<CompanyTreeNode> matchTreeNodes(List<String> matchKey, List<CompanyTreeNode> companyTreeNodes);
}
