package com.ybinsure.auth.model.transfer.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ApiModel(description = "渠道分页查询入参")
public class ChannelQueryPageParamDTO {

    @ApiModelProperty(value = "渠道类型,")
    private String type;

    @ApiModelProperty(value = "启用状态")
    private Byte status;

    @ApiModelProperty(value = "计费渠道")
    private Byte isBillChannel;

    @ApiModelProperty(value = "开始时间")
    private Long startTime;

    @ApiModelProperty(value = "截至时间")
    private Long endTime;

    @ApiModelProperty(value = "时间排序, 0-升序 1-降序, 默认使用降序")
    private String timeSort;

    @ApiModelProperty(value = "省份编码")
    private String province;

    @ApiModelProperty(value = "城市编码")
    private String city;

}
