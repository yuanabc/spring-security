package com.ybinsure.icar.user.model.vo;

import com.ybinsure.icar.user.util.JsonUtil;

/**
 * 影像资料结果对象
 *
 * @author HANHT
 * @version 2018/7/8 20:18
 */
public class FileVO {

    /** 文件地址 */
    private String url;
    /** 文件名称 */
    private String named;
    /** 文件类型 */
    private Byte flag;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNamed() {
        return named;
    }

    public void setNamed(String named) {
        this.named = named;
    }

    public Byte getFlag() {
        return flag;
    }

    public void setFlag(Byte flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return JsonUtil.toJson(this).orElse("");
    }
}
