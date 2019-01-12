package com.ybinsure.auth.model.data.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(description = "机构扩展数据")
@Setter
@Getter
public class BaseCompanyDO {

    @ApiModelProperty(value = "是否过滤团队机构")
    private boolean filterTeamCompany;

    @ApiModelProperty(value = "渠道分类")
    private String channelType;

}
