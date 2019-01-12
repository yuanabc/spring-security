package com.ybinsure.auth.model.data;

import com.ybinsure.auth.annotation.DeleteAction;
import com.ybinsure.auth.annotation.InsertAction;
import com.ybinsure.auth.annotation.UpdateAction;
import com.ybinsure.auth.model.data.base.BaseRoleDO;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Setter
@Getter
public class RoleDO extends BaseRoleDO implements Serializable {

    @NotBlank(groups = {UpdateAction.class, DeleteAction.class}, message = "id不能为空")
    private String id;

    private String code;

    @NotBlank(groups = {InsertAction.class}, message = "name不能为空")
    private String name;

    private String description;

    @NotBlank(groups = {InsertAction.class}, message = "channelCode不能为空")
    private String channelCode;

    @NotNull(groups = {InsertAction.class}, message = "template不能为空")
    private Byte template;

    private Byte deleted;

    @NotNull(groups = {InsertAction.class}, message = "status不能为空")
    private Byte status;

    private Long createTime;

    private Long updateTime;

    private static final long serialVersionUID = 1L;
}