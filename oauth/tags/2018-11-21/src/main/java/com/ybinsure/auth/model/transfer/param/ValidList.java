package com.ybinsure.auth.model.transfer.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Setter
@Getter
@ApiModel(description = "队列数据的包装对象，便于验证")
public class ValidList<E> {

    @Valid
    @NotNull(message = "wrap不能为空")
    @ApiModelProperty(value = "包装队列数据")
    private List<E> wrap;

}
