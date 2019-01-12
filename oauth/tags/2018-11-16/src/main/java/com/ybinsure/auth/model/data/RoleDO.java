package com.ybinsure.auth.model.data;

import com.ybinsure.auth.annotation.validator.DeleteAction;
import com.ybinsure.auth.annotation.validator.InsertAction;
import com.ybinsure.auth.annotation.validator.QueryPageAction;
import com.ybinsure.auth.annotation.validator.UpdateAction;
import com.ybinsure.auth.constant.StatusCode;
import com.ybinsure.auth.model.data.base.BaseRoleDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel(description = "角色数据")
@Setter
@Getter
public class RoleDO extends BaseRoleDO implements Serializable {

    public final static String ROLE_TYPE_ADMIN = "1";
    public final static String ROLE_TYPE_NORMAL = "2";
    public final static String ADMIN_ROLE_NAME = "管理员";

    @NotBlank(groups = {UpdateAction.class, DeleteAction.class}, message = "id不能为空")
    @ApiModelProperty(value = "数据主键")
    private String id;

    @ApiModelProperty(value = "角色编码")
    private String code;

    @NotBlank(groups = {InsertAction.class}, message = "name不能为空")
    @ApiModelProperty(value = "角色名称")
    private String name;

    @ApiModelProperty(value = "角色类型，1-管理员角色， 2-普通角色")
    private String type;

    @ApiModelProperty(value = "文本描述")
    private String description;

    @NotBlank(groups = {InsertAction.class, QueryPageAction.class}, message = "channelCode不能为空")
    @ApiModelProperty(value = "渠道编码")
    private String channelCode;

    @NotNull(groups = {InsertAction.class}, message = "template不能为空")
    @ApiModelProperty(value = "是否是模板角色")
    private Byte template;

    @ApiModelProperty(value = "逻辑删除状态")
    private Byte deleted;

    @NotNull(groups = {InsertAction.class}, message = "status不能为空")
    @ApiModelProperty(value = "禁用状态")
    private Byte status;

    @ApiModelProperty(value = "创建时间")
    private Long createTime;

    @ApiModelProperty(value = "更新时间")
    private Long updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 创建管理员角色
     * @param channelCode 渠道编码
     * @return 角色对象
     */
    public static RoleDO createAdminInstance(String channelCode) {
        RoleDO roleDO = new RoleDO();
        roleDO.setName(ADMIN_ROLE_NAME);
        roleDO.setChannelCode(channelCode);
        roleDO.setTemplate(StatusCode.DISABLE);
        roleDO.setDeleted(StatusCode.DISABLE);
        roleDO.setStatus(StatusCode.ENABLE);
        return roleDO;
    }
}