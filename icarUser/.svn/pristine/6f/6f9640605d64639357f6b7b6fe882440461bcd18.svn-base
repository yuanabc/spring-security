package com.ybinsure.icar.user.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ybinsure.icar.user.util.JsonUtil;

/**
 * 用户机构信息
 *
 * @author HANHT
 * @version 2018/7/10 15:43
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrganizationDTO {

    /** 主键 */
    private String id;
    /** 机构名称 */
    private String name;
    /** 机构层级 */
    private Byte level;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return JsonUtil.toJson(this).orElse("");
    }
}
