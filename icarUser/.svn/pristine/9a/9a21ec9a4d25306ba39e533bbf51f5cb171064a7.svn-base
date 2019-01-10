package com.ybinsure.icar.user.model.param;

import com.ybinsure.icar.user.util.JsonUtil;
import com.ybinsure.icar.user.util.RSAUtil;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 保单信息查询对象
 *
 * @author HANHT
 * @version 2018/7/8 20:32
 */
public class PolicyEncryptParam {

    @NotBlank(message = "订单编号不能为空")
    private String orderId;

    public String getOrderId() {

        return RSAUtil.decryptByPrivateKey(orderId);
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return JsonUtil.toJson(this).orElse("");
    }
}
