package com.ybinsure.auth.model.data;

import com.ybinsure.auth.annotation.InsertAction;
import com.ybinsure.auth.annotation.UpdateAction;
import com.ybinsure.auth.model.data.base.BasePropertyTypeDO;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

@Setter
@Getter
public class PropertyTypeDO extends BasePropertyTypeDO implements Serializable {

    @NotBlank(groups = {UpdateAction.class}, message = "PropertyType.id不能为空")
    private String id;

    @NotBlank(groups = {InsertAction.class}, message = "PropertyType.code不能为空")
    private String code;

    @NotBlank(groups = {InsertAction.class}, message = "PropertyType.value不能为空")
    private String value;

    @NotBlank(groups = {InsertAction.class}, message = "PropertyType.sort不能为空")
    private String sort;

    private Byte status;

    private Long createTime;

    private Long updateTime;

    private static final long serialVersionUID = 1L;
}