package com.ybinsure.icar.user.auth;

/**
 * 用户认证服务常量
 *
 * @author HANHT
 * @version 2018/7/17 11:23
 */
public class AuthConst {

    /** token参数名 */
    public static final String PARAM = "token";

    /** 登录接口地址 */
    public static final String LOGIN = "/token";
    /** 根据token查询用户信息 */
    public static final String QUEYR_BY_TOKEN = "/user-link-company/query-by-token";
    /** 根据ID查询用户信息 */
    public static final String QUERY_BY_ID = "/user-link-company/query/";

    /** 认证头信息 */
    public static final String AUTH = "Authorization";

    /** 认证头信息Authorization值前缀 */
    public static final String PREFIX = "Bearer ";

    /** oauth服务用户名 */
    public static String USERNAME;
    /** oauth服务密码 */
    public static String PASSWORD;

    /** 服务token */
    public static String TOKEN;
}
