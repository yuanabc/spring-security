package com.ybinsure.auth.model.data;

import com.ybinsure.auth.model.data.base.BaseDistrictDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@ApiModel(description = "行政区域数据")
@Setter
@Getter
public class DistrictDO extends BaseDistrictDO implements Serializable {

    @ApiModelProperty(value = "数据主键")
    private Short id;

    @ApiModelProperty(value = "区域名称")
    private String name;

    @ApiModelProperty(value = "父级区域id")
    private Short parentId;

    @ApiModelProperty(value = "首字拼音缩写")
    private String initial;

    @ApiModelProperty(value = "完整拼音缩写")
    private String initials;

    @ApiModelProperty(value = "完整拼音")
    private String pinyin;

    @ApiModelProperty(value = "后缀，比如市")
    private String suffix;

    @ApiModelProperty(value = "区域编码")
    private String code;

    @ApiModelProperty(value = "排序值")
    private Byte sort;

    @ApiModelProperty(value = "区域等级，1-省级，2-市级，3-区县级")
    private Byte level;

    @ApiModelProperty(value = "禁用状态,0-可用，1-不可用")
    private Byte status;

    private static final long serialVersionUID = 1L;
}