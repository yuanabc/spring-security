package com.ybinsure.auth.model.data;

import com.ybinsure.auth.annotation.InsertAction;
import com.ybinsure.auth.annotation.UpdateAction;
import com.ybinsure.auth.model.data.base.BaseChannelDO;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Setter
@Getter
public class ChannelDO extends BaseChannelDO implements Serializable {

    @NotBlank(groups = {UpdateAction.class}, message = "channel.id不能为空")
    private String id;

    private String outCode;

    @NotBlank(groups = {InsertAction.class}, message = "channel.code不能为空")
    private String code;

    private Short orderCode;

    @NotBlank(groups = {InsertAction.class}, message = "channel.shortName不能为空")
    private String shortName;

    @NotBlank(groups = {InsertAction.class}, message = "channel.fullName不能为空")
    private String fullName;

    private String userName;

    private String passWord;

    private String email;

    @NotNull(groups = {InsertAction.class}, message = "startTime不能为空")
    private Long startTime;

    @NotNull(groups = {InsertAction.class}, message = "expireTime不能为空")
    private Long expireTime;

    private String backUp;

    @NotNull(groups = {InsertAction.class}, message = "type不能为空")
    private String type;

    private String proxyChannelCode;

    private Byte sourceType;

    private Integer sort;

    private Byte deleted;

    private Long updateTime;

    private Long createTime;

    @NotNull(groups = {InsertAction.class}, message = "channel.status不能为空")
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