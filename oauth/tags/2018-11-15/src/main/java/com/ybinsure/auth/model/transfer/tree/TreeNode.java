package com.ybinsure.auth.model.transfer.tree;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
public class TreeNode implements Serializable {

    private String key;

    private String title;

    @JsonProperty("isLeaf")
    private boolean leaf;

    private boolean checked;

    private boolean selected;

    private boolean disabled;

    private List<TreeNode> children;

    @JsonIgnore
    private TreeNode parent;

    @JsonIgnore
    private int childrenSize;

    private Byte level;

    @JsonIgnore
    private String areaCode;

    private String companyType;

    private String channelCode;

}
