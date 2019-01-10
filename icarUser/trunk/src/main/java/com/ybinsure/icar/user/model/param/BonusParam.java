package com.ybinsure.icar.user.model.param;

import com.ybinsure.icar.user.model.PageInfo;
import org.hibernate.validator.constraints.Range;

/**
 * 查询奖金列表参数
 *
 * @author HANHT
 * @version 2018/6/28 11:52
 */
public class BonusParam extends PageInfo {

    /** 查下条件 0待发放 1已发放 */
    @Range(max = 1, min = 0, message = "查询条件有误")
    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
