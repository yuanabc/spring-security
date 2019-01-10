package com.ybinsure.icar.user.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ybinsure.icar.user.util.JsonUtil;

import java.util.Date;

/**
 * 消息通知结果对象
 *
 * @author HANHT
 * @version 2018/7/11 9:54
 */
public class MessageVO {

    /** 消息id */
    private Integer messageId;
    /** 消息状态 0为未读，1为已读 */
    private Byte status;
    /** 标题 */
    private String title;
    /** 内容 */
    private String msg;
    /** 创建时间 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /** 类型 0系统，1交易，2续保提醒 */
    private Byte type;

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return JsonUtil.toJson(this).orElse("");
    }
}
