package com.ybinsure.auth.model.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ybinsure.auth.annotation.validator.InsertAction;
import com.ybinsure.auth.annotation.validator.UpdateAction;
import com.ybinsure.auth.constant.StatusCode;
import com.ybinsure.auth.model.data.base.BaseChannelDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel(description = "渠道数据")
@Setter
@Getter
public class ChannelDO extends BaseChannelDO implements Serializable {

    @NotBlank(groups = {UpdateAction.class}, message = "channel.id不能为空")
    @ApiModelProperty(value = "主键id")
    private String id;

    @ApiModelProperty(value = "对外展示code, 语义化的渠道编码")
    private String outCode;

    @NotBlank(groups = {InsertAction.class, UpdateAction.class}, message = "channel.code不能为空")
    @ApiModelProperty(value = "内部使用的code, 内部数据均关联该编码。(兼容老数据)")
    private String code;

    @NotBlank(groups = {InsertAction.class}, message = "channel.shortName不能为空")
    @ApiModelProperty(value = "简写名称")
    private String shortName;

    @NotBlank(groups = {InsertAction.class}, message = "channel.fullName不能为空")
    @ApiModelProperty(value = "完整名称")
    private String fullName;

    @ApiModelProperty(value = "渠道推送数据时校验使用的用户名")
    private String userName;

    @ApiModelProperty(value = "渠道推送数据时校验使用的密码")
    private String passWord;

    @ApiModelProperty(value = "邮箱地址")
    private String email;

    @ApiModelProperty(value = "联系人")
    private String contact;

    @ApiModelProperty(value = "联系地址")
    private String address;

    @ApiModelProperty(value = "有效期的起始时间")
    @NotNull(groups = {InsertAction.class}, message = "startTime不能为空")
    private Long startTime;

    @ApiModelProperty(value = "有效期的截至时间")
    @NotNull(groups = {InsertAction.class}, message = "expireTime不能为空")
    private Long expireTime;

    @ApiModelProperty(value = "备注信息")
    private String backUp;

    @NotNull(groups = {InsertAction.class}, message = "type不能为空")
    @ApiModelProperty(value = "渠道分类, 1-代理渠道, 2-分销渠道")
    private String type;

    @ApiModelProperty(value = "代理渠道编码，渠道分类为分销渠道时存在")
    private String proxyChannelCode;

    private Byte sourceType;

    @ApiModelProperty(value = "排序值")
    private Integer sort;

    @ApiModelProperty(value = "是否删除")
    private Byte deleted;

    @ApiModelProperty(value = "渠道创建时间")
    private Long updateTime;

    @ApiModelProperty(value = "渠道更新时间")
    private Long createTime;

    @NotNull(groups = {InsertAction.class}, message = "channel.status不能为空")
    @ApiModelProperty(value = "渠道状态, 0-有效，1-失效")
    private Byte status;

    private static final long serialVersionUID = 1L;

    public void clear() {
        this.userName = null;
        this.passWord = null;
    }

    public static ChannelDO createInstanceWithCode(String code) {
        ChannelDO channelDO = new ChannelDO();
        channelDO.setCode(code);
        return channelDO;
    }

}