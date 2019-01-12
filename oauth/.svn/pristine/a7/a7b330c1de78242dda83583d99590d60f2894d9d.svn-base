package com.ybinsure.auth.model.data;

import com.ybinsure.auth.annotation.UpdateAction;
import com.ybinsure.auth.model.data.base.BaseUserRelateCompanyDO;
import com.ybinsure.auth.model.link.UserExtend;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

@Setter
@Getter
public class UserRelateCompanyDO extends BaseUserRelateCompanyDO implements Serializable {

    private String id;

    private String userId;

    @NotBlank(groups = {
            UserExtend.InsertAdminAction.class,
            UserExtend.InsertUserAction.class,
            UserExtend.InsertSaleAction.class,
            UpdateAction.class
    }, message = "companyId不能为空")
    private String companyId;

    @NotBlank(groups = {
            UserExtend.InsertAdminAction.class,
            UserExtend.InsertUserAction.class,
            UserExtend.InsertSaleAction.class,
            UpdateAction.class
    }, message = "linkType不能为空")
    private String linkType;

    private Byte companyLevel;

    private static final long serialVersionUID = 1L;

    public boolean valid() {
        return StringUtils.isNotBlank(getUserId()) &&
                StringUtils.isNotBlank(getCompanyId()) &&
                StringUtils.isNotBlank(getLinkType()) && getCompanyLevel() == null;
    }
}