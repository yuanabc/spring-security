package com.ybinsure.auth.model.data;

import com.ybinsure.auth.annotation.validator.InsertAction;
import com.ybinsure.auth.annotation.validator.QueryAction;
import com.ybinsure.auth.annotation.validator.UpdateAction;
import com.ybinsure.auth.model.data.base.BaseWebConfigDO;
import com.ybinsure.auth.util.JsonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ApiModel(description = "前端配置")
@Setter
@Getter
public class WebConfigDO extends BaseWebConfigDO implements Serializable {

    //todo 易用性调整
    @ApiModelProperty(value = "数据主键")
    private String id;

    @NotBlank(groups = {InsertAction.class, UpdateAction.class, QueryAction.class}, message = "code不能为空")
    @ApiModelProperty(value = "编码")
    private String code;

    @NotBlank(groups = {InsertAction.class, UpdateAction.class, QueryAction.class}, message = "value不能为空")
    @ApiModelProperty(value = "关联数据，比如机构配置则为机构id,渠道配置则为渠道编码")
    private String value;

    @ApiModelProperty(value = "单选值数据")
    private Byte flag;

    @ApiModelProperty(value = "非单选值数据")
    private String data;

    @ApiModelProperty(value = "创建时间")
    private Long createTime;

    @ApiModelProperty(value = "更新时间")
    private Long updateTime;

    private static final long serialVersionUID = 1L;

    public List<String> convertValue() {
        if (StringUtils.isNotBlank(getData())) {
            return JsonUtil.toList(getData(), String.class).orElseGet(ArrayList::new);
        }
        return new ArrayList<>();
    }
}