package com.ybinsure.auth.model.data;

import com.ybinsure.auth.annotation.UpdateAction;
import com.ybinsure.auth.model.data.base.BaseUserRelateRoleDO;
import com.ybinsure.auth.model.link.UserExtend;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

@Setter
@Getter
public class UserRelateRoleDO extends BaseUserRelateRoleDO implements Serializable {

    private String id;

    private String userId;

    @NotBlank(groups = {UserExtend.InsertAdminAction.class, UserExtend.InsertUserAction.class, UpdateAction.class}, message = "roleId不能为空")
    private String roleId;

    private static final long serialVersionUID = 1L;

}