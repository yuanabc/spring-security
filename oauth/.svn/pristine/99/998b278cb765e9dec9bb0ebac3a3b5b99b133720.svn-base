package com.ybinsure.auth.model.data;

import com.ybinsure.auth.annotation.InsertAction;
import com.ybinsure.auth.annotation.QueryAction;
import com.ybinsure.auth.annotation.UpdateAction;
import com.ybinsure.auth.model.data.base.BaseWebConfigDO;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

@Setter
@Getter
public class WebConfigDO extends BaseWebConfigDO implements Serializable {

    private String id;

    @NotBlank(groups = {InsertAction.class, UpdateAction.class, QueryAction.class}, message = "code不能为空")
    private String code;

    @NotBlank(groups = {InsertAction.class, UpdateAction.class, QueryAction.class}, message = "value不能为空")
    private String value;

    private Byte flag;

    private String data;

    private Long createTime;

    private Long updateTime;

    private static final long serialVersionUID = 1L;
}