package com.ybinsure.auth.model.data;

import com.ybinsure.auth.annotation.validator.InsertAction;
import com.ybinsure.auth.annotation.validator.UpdateAction;
import com.ybinsure.auth.model.data.base.BasePropertyTypeDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

@ApiModel(description = "字典分类数据")
@Setter
@Getter
public class PropertyTypeDO extends BasePropertyTypeDO implements Serializable {

    @NotBlank(groups = {UpdateAction.class}, message = "PropertyType.id不能为空")
    @ApiModelProperty(value = "数据主键")
    private String id;

    @NotBlank(groups = {InsertAction.class}, message = "PropertyType.code不能为空")
    @ApiModelProperty(value = "字典分类编码")
    private String code;

    @NotBlank(groups = {InsertAction.class}, message = "PropertyType.value不能为空")
    @ApiModelProperty(value = "字典分类值")
    private String value;

    @NotBlank(groups = {InsertAction.class}, message = "PropertyType.sort不能为空")
    @ApiModelProperty(value = "排序值")
    private String sort;

    @ApiModelProperty(value = "禁用状态，0-可用，1-不可用")
    private Byte status;

    @ApiModelProperty(value = "创建时间")
    private Long createTime;

    @ApiModelProperty(value = "更新时间")
    private Long updateTime;

    private static final long serialVersionUID = 1L;
}