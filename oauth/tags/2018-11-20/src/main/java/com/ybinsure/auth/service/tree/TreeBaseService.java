package com.ybinsure.auth.service.tree;

import com.ybinsure.auth.model.transfer.tree.TreeNode;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public interface TreeBaseService<T> {

    /**
     * 判断节点是否是根节点
     * @param t 节点数据
     * @return 判断结果
     */
    boolean isRoot(T t);

    /**
     * 获取节点key
     * @param t 节点
     * @return key
     */
    String getKey(T t);

    /**
     * 获取节点的父节点key
     * @param t 节点
     * @return key
     */
    String getParentKey(T t);

    /**
     * 设置子节点
     * @param parent 父节点
     * @param list 子节点
     */
    void setChildren(T parent, List<T> list);

    /**
     * 获取子节点
     * @param parent 父节点
     * @return 子节点
     */
    List<T> getChildren(T parent);

    /**
     * 设置子节点数量
     * @param parent 父节点
     * @param size 子节点数量
     */
    default void setChildrenSize(T parent, int size) {}

    /**
     * 获取子节点数量
     * @param parent 父节点
     * @return 子节点数量
     */
    default int getChildrenSize(T parent) {return 0; }

    /**
     * 同层级比较器
     * @return 比较器
     */
    Comparator<T> comparator();

    /**
     * 转换成TreeNode的树型结构数据
     * @param list 源数据
     * @param convertFunction 转换函数
     * @return treeNode的树型结构数据
     */
    default List<TreeNode> convertTreeNode(List<T> list, Function<T, TreeNode> convertFunction) {
        return convertTreeNode(list, convertFunction, this::isRoot);
    }

    /**
     * 转换成TreeNode的树型结构数据
     * @param list 源数据
     * @param convertFunction 转换函数
     * @param isRoot 判断根节点函数
     * @return treeNode的树型结构数据
     */
    default List<TreeNode> convertTreeNode(List<T> list, Function<T, TreeNode> convertFunction, Predicate<T> isRoot) {
        List<T> source = Optional.ofNullable(list).orElseGet(ArrayList::new);
        source.sort(this.comparator());
        // 筛选根节点
        List<TreeNode> result = source.stream()
                .filter(isRoot)
                .map(convertFunction)
                .collect(Collectors.toList());
        result.forEach(root -> addConvertChildrenNode(root, source, convertFunction));
        return result;
    }

    /**
     * 设置子节点
     * @param parent 父节点
     * @param list 元数据
     */
    default void addConvertChildrenNode(TreeNode parent, List<T> list, Function<T, TreeNode> function) {
        List<TreeNode> childrenList = list.stream()
                .filter(children -> StringUtils.equals(parent.getKey(), getParentKey(children)))
                .map(function).collect(Collectors.toList());
        parent.setChildren(childrenList);
        parent.setLeaf(childrenList.isEmpty());
        childrenList.forEach(children -> addConvertChildrenNode(children, list, function));
    }

    /**
     * 转化成树型数据
     * @param list 源数据
     * @return 树型数据
     */
     default List<T> convertTree(List<T> list) {
        List<T> source = Optional.ofNullable(list).orElseGet(ArrayList::new);
        source.sort(this.comparator());
        // 筛选根节点
        List<T> result = source.stream()
                .filter(this::isRoot)
                .collect(Collectors.toList());
        result.forEach(root -> addChildrenNode(root, source));
        computeTreeSize(result);
        return result;
    }

    /**
     * 设置子节点
     * @param parent 父节点
     * @param list 元数据
     */
    default void addChildrenNode(T parent, List<T> list) {
        List<T> childrenList = list.stream()
                .filter(children -> StringUtils.equals(getKey(parent), getParentKey(children)))
                .collect(Collectors.toList());
        setChildren(parent, childrenList);
        childrenList.forEach(children -> addChildrenNode(children, list));
    }

    /**
     * 匹配多个节点
     * @param sources 源节点
     * @param keys 需要匹配的节点key
     * @return 匹配结果
     */
    default List<T> matchNodes(List<T> sources, List<String> keys) {
        List<T> result = new ArrayList<>();
        Optional.ofNullable(sources).orElseGet(ArrayList::new).forEach(source -> collectionMatchNodes(source, keys, result));
        return result;
    }

    /**
     * 递归匹配节点，收集匹配的节点
     * @param source 源节点
     * @param keys 需要匹配的条件
     * @param result 收集匹配结果
     */
    default void collectionMatchNodes(T source, List<String> keys, List<T> result) {
        boolean isMatch = Optional.ofNullable(keys).orElseGet(ArrayList::new)
                .stream().anyMatch(condition -> StringUtils.equals(condition, getKey(source)));
        if (isMatch) {
            result.add(source);
            return;
        }
        if (getChildren(source) != null && !getChildren(source).isEmpty()) {
            getChildren(source).forEach(item -> collectionMatchNodes(item, keys, result));
        }
    }

    /**
     * 设置各个节点的子节点数量
     * @param source 树型数据
     */
    default void computeTreeSize(List<T> source) {
        source.forEach(treeItem -> {
            if (getChildren(treeItem) != null && !getChildren(treeItem).isEmpty()) {
                getChildren(treeItem).forEach(item -> {
                    int itemChildrenSize = computeChildSize(item);
                    setChildrenSize(treeItem, getChildrenSize(treeItem) + itemChildrenSize);
                });
            }
        });
    }

    default int computeChildSize(T item) {
        if (getChildren(item) == null || getChildren(item).isEmpty()) {
            return 1;
        }
        getChildren(item).forEach(children -> {
            int itemChildrenSize = computeChildSize(children);
            setChildrenSize(item, getChildrenSize(item) + itemChildrenSize);
        });
        return getChildrenSize(item) + 1;
    }

}
