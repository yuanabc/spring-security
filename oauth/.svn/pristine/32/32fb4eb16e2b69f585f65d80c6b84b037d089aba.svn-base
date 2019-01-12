package com.ybinsure.auth.model.transfer.tree;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class TreeOption implements Serializable {

    private String label;

    private String value;

    @JsonProperty("children")
    private List<? extends  TreeOption> treeOptions;

    @JsonProperty("isLeaf")
    private Boolean leaf;

    public TreeOption() {
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<? extends TreeOption> getTreeOptions() {
        return treeOptions;
    }

    public void setTreeOptions(List<? extends TreeOption> treeOptions) {
        this.treeOptions = treeOptions;
    }

    public Boolean getLeaf() {
        return leaf;
    }

    public void setLeaf(Boolean leaf) {
        this.leaf = leaf;
    }
}
