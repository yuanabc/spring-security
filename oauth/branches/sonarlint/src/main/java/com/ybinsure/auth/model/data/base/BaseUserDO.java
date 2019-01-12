package com.ybinsure.auth.model.data.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ybinsure.auth.model.data.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.util.List;

@ApiModel(description = "用户扩展数据")
@Setter
@Getter
public class BaseUserDO {

    @JsonProperty("roles")
    @ApiModelProperty(value = "角色信息")
    private List<RoleDO> roleDOS;

    @JsonProperty("userRelateRoles")
    @ApiModelProperty(value = "用户关联角色信息")
    private List<UserRelateRoleDO> userRelateRoleDOS;

    @JsonProperty("permissions")
    @ApiModelProperty(value = "权限信息")
    private List<PermissionDO> permissionDOS;

    @JsonProperty("roleRelatePermissions")
    @ApiModelProperty(value = "角色关联权限信息")
    private List<RoleRelatePermissionDO> roleRelatePermissionDOS;

    @JsonProperty("companies")
    @ApiModelProperty(value = "机构信息")
    private List<CompanyDO> companyDOS;

    @JsonProperty("userRelateCompanys")
    @Size(groups = {UserDO.InsertUserAction.class, UserDO.InsertSaleAction.class, UserDO.InsertChannelSalesAction.class}, min = 1, message = "关联机构不能为空")
    @ApiModelProperty(value = "用户关联角色信息")
    private List<UserRelateCompanyDO> userRelateCompanyDOS;

    @JsonProperty("belongCompanys")
    @ApiModelProperty(value = "归属机构")
    private List<CompanyDO> belongCompanys;

    @JsonProperty("managerCompanys")
    @ApiModelProperty(value = "管辖机构")
    private List<CompanyDO> managerCompanys;

    @ApiModelProperty(value = "分销渠道")
    private List<SalesChannelDO> salesChannels;

    @NotBlank(groups = {UserDO.InsertSalesWithWebAction.class, UserDO.VerifyCaptchaWithUserName.class, UserDO.VerifyCaptchaWithPhone.class, UserDO.Verify.class}, message = "captcha不能为空")
    @ApiModelProperty(value = "验证码")
    private String captcha;

    @ApiModelProperty(value = "渠道分类")
    private String channelType;

    @ApiModelProperty(value = "渠道名称")
    private String channelName;
}
