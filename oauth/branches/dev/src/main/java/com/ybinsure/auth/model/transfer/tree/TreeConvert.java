package com.ybinsure.auth.model.transfer.tree;

public interface TreeConvert {

    TreeNode convert();

    boolean isHead();

    String getKey();

    String getParentKey();

}
