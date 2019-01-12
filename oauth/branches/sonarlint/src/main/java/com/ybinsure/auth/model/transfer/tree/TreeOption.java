package com.ybinsure.auth.model.transfer.tree;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ApiModel(description = "级联数据")
public class TreeOption implements Serializable {

    @ApiModelProperty(value = "名称")
    private String label;

    @ApiModelProperty(value = "值")
    private String value;

    @JsonProperty("children")
    @ApiModelProperty(value = "子节点")
    private List<? extends  TreeOption> treeOptions;

    @JsonProperty("isLeaf")
    @ApiModelProperty(value = "是否还有子节点")
    private Boolean leaf;

}
