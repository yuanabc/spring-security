package com.ybinsure.auth.model.data.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ybinsure.auth.annotation.validator.InsertAction;
import com.ybinsure.auth.annotation.validator.UpdateAction;
import com.ybinsure.auth.model.data.CompanyDO;
import com.ybinsure.auth.model.data.UserDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@ApiModel(description = "渠道扩展数据")
@Setter
@Getter
public class BaseChannelDO {

    @JsonProperty("admin")
    @NotNull(groups = {InsertAction.class, UpdateAction.class}, message = "admin不能为空")
    @ApiModelProperty(value = "关联的管理员数据")
    private UserDO admin;

    @ApiModelProperty(value = "总部机构")
    @NotNull(groups = {InsertAction.class, UpdateAction.class}, message = "headCompany不能为空")
    private CompanyDO headCompany;

    @ApiModelProperty(value = "渠道权限列表")
    @NotNull(groups = {InsertAction.class, UpdateAction.class}, message = "channelPermissions不能为空")
    private List<String> permissionIds;
}
