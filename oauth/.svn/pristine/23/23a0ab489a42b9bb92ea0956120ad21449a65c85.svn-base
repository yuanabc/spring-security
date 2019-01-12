package com.ybinsure.auth.serviceImpl.tree;

import com.ybinsure.auth.constant.CompanyLevelCode;
import com.ybinsure.auth.model.data.CompanyDO;
import com.ybinsure.auth.model.transfer.tree.TreeNode;
import com.ybinsure.auth.service.tree.CompanyTreeService;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Component
public class DefaultCompanyTreeService implements CompanyTreeService {

    @Override
    public boolean isRoot(CompanyDO companyDO) {
        return CompanyLevelCode.ROOT.equals(companyDO.getLevel());
    }

    @Override
    public String getKey(CompanyDO t) {
        return t.getId();
    }

    @Override
    public String getParentKey(CompanyDO t) {
        return t.getParentId();
    }

    @Override
    public void setChildren(CompanyDO parent, List<CompanyDO> list) {
        if (parent != null) {
            parent.setChildren(list);
        }
    }

    @Override
    public List<CompanyDO> getChildren(CompanyDO parent) {
        return parent.getChildren();
    }

    @Override
    public void setChildrenSize(CompanyDO parent, int size) {
        parent.setChildrenSize(size);
    }

    @Override
    public int getChildrenSize(CompanyDO parent) {
        return Optional.ofNullable(parent.getChildrenSize()).orElse(0);
    }

    @Override
    public Comparator<CompanyDO> comparator() {
        return Comparator.comparingInt(CompanyDO::getSort);
    }

    @Override
    public List<TreeNode> convertTreeNode(List<CompanyDO> list) {
        return convertTreeNode(list, CompanyDO::convert);
    }

    @Override
    public List<TreeNode> convertTreeNode(List<CompanyDO> list, Predicate<CompanyDO> predicate) {
        return convertTreeNode(list, CompanyDO::convert, predicate);
    }
}
