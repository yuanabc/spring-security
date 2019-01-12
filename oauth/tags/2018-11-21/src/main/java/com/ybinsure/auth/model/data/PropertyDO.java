package com.ybinsure.auth.model.data;

import com.ybinsure.auth.model.data.base.BasePropertyDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@ApiModel(description = "字典数据")
@Setter
@Getter
public class PropertyDO extends BasePropertyDO implements Serializable {

    @ApiModelProperty(value = "数据主键")
    private String id;

    @ApiModelProperty(value = "字典编码")
    private String code;

    @ApiModelProperty(value = "字典值1")
    private String value1;

    @ApiModelProperty(value = "字典值2")
    private String value2;

    @ApiModelProperty(value = "排序值")
    private String sort;

    @ApiModelProperty(value = "字典分类编码")
    private String typeCode;

    @ApiModelProperty(value = "描述文本")
    private String description;

    @ApiModelProperty(value = "禁用状态，0-可用，1-不可用")
    private Byte status;

    @ApiModelProperty(value = "创建时间")
    private Long createTime;

    @ApiModelProperty(value = "更新时间")
    private Long updateTime;

    private static final long serialVersionUID = 1L;
}