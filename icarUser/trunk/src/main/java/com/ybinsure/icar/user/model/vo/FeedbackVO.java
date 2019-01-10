package com.ybinsure.icar.user.model.vo;

/**
 * 意见反馈结果对象
 *
 * @author HANHT
 * @version 2018/7/11 16:12
 */
public class FeedbackVO {

    private Integer fid;

    public FeedbackVO() {
    }

    public FeedbackVO(Integer fid) {
        this.fid = fid;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }
}
