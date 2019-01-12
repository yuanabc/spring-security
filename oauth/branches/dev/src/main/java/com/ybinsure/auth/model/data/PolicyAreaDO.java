package com.ybinsure.auth.model.data;

import com.ybinsure.auth.model.data.base.BasePolicyAreaDO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class PolicyAreaDO extends BasePolicyAreaDO implements Serializable {

    private String id;

    private String areaCode;

    private String areaName;

    private String districtCode;

    private Byte deleted;

    private static final long serialVersionUID = 1L;
}