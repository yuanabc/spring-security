package com.ybinsure.auth.model.transfer.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@ApiModel(description = "人员分页查询")
public class UserQueryPageParamDTO {

    @ApiModelProperty(value = "渠道编码")
    private String channelCode;

    @ApiModelProperty(value = "账号状态")
    private Byte status;

    @ApiModelProperty(value = "登录账号")
    private String userName;

    @ApiModelProperty(value = "姓名")
    private String nickName;

    @ApiModelProperty(value = "机构id")
    private List<String> companyIds;

    @ApiModelProperty(value = "时间排序")
    private Long createTime;

    @ApiModelProperty(value = "角色id, 全部则不传")
    private String roleId;

    private String orderCase;
}
