package com.ybinsure.icar.user.model.data;

import java.io.Serializable;

public class FileDO implements Serializable {
    private Integer id;

    /** 父ID */
    private String pid;

    private String userid;

    /** 0为证件照片，1为验车照片,2  新车发票,3  上年保单, 4   双录,  5其他，6为反馈图片 */
    private Byte flag;

    /** 原文件 */
    private String files;

    /** 缩略图 */
    private String ico;

    /** 上传时间 */
    private Long times;

    /** 文件大小 */
    private Integer size;

    /** md5值 */
    private String fmd5;

    /** 文件名称 */
    private String named;

    private String field;

    /** 是否删除 */
    private Byte del;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Byte getFlag() {
        return flag;
    }

    public void setFlag(Byte flag) {
        this.flag = flag;
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files == null ? null : files.trim();
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico == null ? null : ico.trim();
    }

    public Long getTimes() {
        return times;
    }

    public void setTimes(Long times) {
        this.times = times;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getFmd5() {
        return fmd5;
    }

    public void setFmd5(String fmd5) {
        this.fmd5 = fmd5 == null ? null : fmd5.trim();
    }

    public String getNamed() {
        return named;
    }

    public void setNamed(String named) {
        this.named = named == null ? null : named.trim();
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field == null ? null : field.trim();
    }

    public Byte getDel() {
        return del;
    }

    public void setDel(Byte del) {
        this.del = del;
    }
}