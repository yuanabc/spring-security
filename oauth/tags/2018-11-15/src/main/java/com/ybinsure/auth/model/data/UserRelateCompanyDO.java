package com.ybinsure.auth.model.data;

import com.ybinsure.auth.annotation.validator.UpdateAction;
import com.ybinsure.auth.model.data.base.BaseUserRelateCompanyDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

@ApiModel(description = "用户关联机构数据")
@Setter
@Getter
public class UserRelateCompanyDO extends BaseUserRelateCompanyDO implements Serializable {

    @ApiModelProperty(value = "数据主键")
    private String id;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @NotBlank(groups = {UserDO.InsertAdminAction.class, UserDO.InsertUserAction.class, UserDO.InsertSaleAction.class, UpdateAction.class}, message = "companyId不能为空")
    @ApiModelProperty(value = "机构id")
    private String companyId;

    @NotBlank(groups = {UserDO.InsertAdminAction.class, UserDO.InsertUserAction.class, UserDO.InsertSaleAction.class, UpdateAction.class}, message = "linkType不能为空")
    @ApiModelProperty(value = "关联分类， 1-归属机构， 2-管辖机构")
    private String linkType;

    @ApiModelProperty(value = "机构层级")
    private Byte companyLevel;

    private static final long serialVersionUID = 1L;

    public boolean valid() {
        return StringUtils.isNotBlank(getUserId()) &&
                StringUtils.isNotBlank(getCompanyId()) &&
                StringUtils.isNotBlank(getLinkType()) && getCompanyLevel() == null;
    }
}