package com.ybinsure.auth.model.data;

import com.ybinsure.auth.model.data.base.BasePolicyAreaDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@ApiModel(description = "保监地编码数据")
@Setter
@Getter
public class PolicyAreaDO extends BasePolicyAreaDO implements Serializable {

    @ApiModelProperty(value = "数据主键")
    private String id;

    @ApiModelProperty(value = "保监地编码")
    private String areaCode;

    @ApiModelProperty(value = "保监地名称")
    private String areaName;

    @ApiModelProperty(value = "对应的行政区域编码")
    private String districtCode;

    @ApiModelProperty(value = "逻辑删除状态, 0-删除，1-没有删除")
    private Byte deleted;

    private static final long serialVersionUID = 1L;
}