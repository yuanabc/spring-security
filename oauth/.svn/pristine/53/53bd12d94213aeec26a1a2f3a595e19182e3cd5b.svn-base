package com.ybinsure.auth.model.transfer.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@ApiModel(description = "业务员分页查询参数")
public class SalesQueryPageParamDTO extends BaseUserQueryPageParam {

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

    @ApiModelProperty(value = "时间排序，0-升序，1-降序")
    private Long createTime;

    @ApiModelProperty(value = "排序sql,后台处理")
    private String orderCase;


}
