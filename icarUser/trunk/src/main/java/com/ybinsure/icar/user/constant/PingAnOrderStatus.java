package com.ybinsure.icar.user.constant;

/**
 * 订单状态
 *
 * @author HANHT
 * @version 2018/7/8 19:41
 */
public interface PingAnOrderStatus {

    /** 核保失败 */
    Byte INSURE_FAILURE = 3;
    /** 核保成功，未缴费 */
    Byte INSURE_SUCCESS = 4;
    /** 承保成功 */
    Byte POLICY_FAILURE = 5;
    /** 承保失败 */
    Byte POLICY_SUCCESS = 6;
}
