package com.ybinsure.auth.model.transfer.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@ApiModel(description = "业务员分页查询参数")
public class SalesQueryPageParamDTO {

    @ApiModelProperty(value = "渠道编码")
    private String channelCode;

    @ApiModelProperty(value = "业务员类型")
    private List<String> salesType;

    @ApiModelProperty(value = "启用状态")
    private Byte status;

    @ApiModelProperty(value = "登录账号")
    private String phone;

    @ApiModelProperty(value = "姓名")
    private String idName;

    @ApiModelProperty(value = "业务员编号")
    private String agentCode;

    @ApiModelProperty(value = "机构id")
    private List<String> companyIds;

    @ApiModelProperty(value = "时间排序")
    private Long createTime;

    private String orderCase;

}
