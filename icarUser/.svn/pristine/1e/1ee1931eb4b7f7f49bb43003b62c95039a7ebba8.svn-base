package com.ybinsure.icar.user.constant;

/**
 * 用户认证服务接口地址
 *
 * @author HANHT
 * @version 2018/7/10 20:45
 */
public interface ApiPath {

    /** 登录接口地址 */
    String AUTH_TOKEN = "/token";
    /** 根据token查询用户信息 */
    String AUTH_QUEYR_BY_TOKEN = "/user-link-company/query-by-token";
    /** 根据ID查询用户信息 */
    String AUTH_QUERY_BY_ID = "/user-link-company/query";

    /** 用户认证 */
    String AUTH = "/auth";

    /** 账户接口 */
    String ACCOUNT = "/account";
    /** 查询用户业绩 */
    String ACCOUNT_PERFORMANCE = ACCOUNT + "/performance";

    /** 意见反馈 */
    String ACCOUNT_FEEDBACK = ACCOUNT + "/feedback";
    /** 消息通知 */
    String ACCOUNT_NOTIFY = ACCOUNT + "/listNotify";

    /** 森锐渠道 */
    String SR = "/sr";
    /** 森锐账户信息查询 */
    String SR_ACCOUNT = ACCOUNT + SR + "/queryAccount";
    /** 森锐账户奖金列表 */
    String SR_ACCOUNT_BONUS = ACCOUNT + SR + "/listBonus";

    /** 保单配送地址管理 */
    String ADDRESS = "/address";
    /** 保单配送地址查询 */
    String ADDRESS_LIST = AUTH + ADDRESS + "/listAddr";
    /** 添加保单配送地址 */
    String ADDRESS_ADD = AUTH + ADDRESS + "/addAddr";
    /** 修改保单配送地址 */
    String ADDRESS_UPDATE = AUTH + ADDRESS + "/updateAddr";
    /** 删除保单配送地址 */
    String ADDRESS_DELETE = AUTH + ADDRESS + "/deleteAddr";

    /** 客户 */
    String CUSTOMER = "/customer";
    /** 客户列表查询 */
    String CUSTOMER_LIST = AUTH + CUSTOMER + "/listCustomer";
    /** 查询客户信息 */
    String CUSTOMER_QUERY = AUTH + CUSTOMER + "/getCustomer";
    /** 添加客户信息 */
    String CUSTOMER_ADD = AUTH + CUSTOMER + "/addCustomer";
    /** 编辑客户信息 */
    String CUSTOMER_UPDATE = AUTH + CUSTOMER + "/updateCustomer";
    /** 删除客户信息 */
    String CUSTOMER_DELETE = AUTH + CUSTOMER + "/deleteCustomer";
    /** 上年投保信息 */
    String CUSTOMER_RENEWAL = AUTH + CUSTOMER + "/queryRenewal";

    /** 保单 */
    String POLICY = "/policy";
    /** 保单列表 */
    String POLICY_LIST = AUTH + POLICY + "/listPolicy";
    /** 查询订单详情 */
    String POLICY_QUERY = AUTH + POLICY + "/queryPolicy";
    /** 查询最近报价列表 */
    String POLICY_RECENT_QUOTE = AUTH + POLICY + "/recentQuote";
    /** 根据车架号查询最近报价列表 */
    String POLICY_RECENT_QUOTE_BY_FRAME_NO = AUTH + POLICY + "/recentQuoteByFrameNo";
    /** 查询保单车辆信息 */
    String POLICY_QUERY_VEHICLE = AUTH + POLICY + "/getVehicle";
    /** 删除保单 */
    String POLICY_DELETE = AUTH + POLICY + "/deletePolicy";
    /** 查询订单详情-分享查询免登录 */
    String POLICY_QUERY_AVOID_LOGIN = POLICY + "/queryPolicy";

    /** 续保查询 */
    String POLICY_QUERY_RENEWAL = AUTH + POLICY + "/queryRenewal";

    /** 云南平安订单列表 */
    String POLICY_PING_AN_ORDER = AUTH + POLICY + "/listOrder";

    /** 微信 */
    String WECHAT = "/wechat";
    /** 链接分享 */
    String WECHAT_SHARE_LINK = WECHAT + "/shareLink";

    /** 前端功能接口 */
    String FRONT = "/front";
    /** 上传错误日志 */
    String FRONT_UPLOAD_ERROR_LOG = FRONT + "/uploadErrorLog";
}
