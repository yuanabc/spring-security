package com.ybinsure.icar.user.constant;

import java.util.Arrays;

/**
 * 返回信息
 *
 * @author HANHT
 * @version 2018/4/8 10:12
 */
public enum RespInfo {

    /** status msg */
    SUCCESS(200, "成功"),

    /** 400 Bad Request */
    ERROR(400, "请求参数有误"),
    /** 401 Unauthorized */
    F401(401, "登录失效"),
    /** 404 Not Found */
    F404(404, "请求失败"),
    /** 405 Method Not Allowed */
    F405(405, "Method Not Allowed"),
    /** 406 Not Acceptable */
    F406(406, "Not Acceptable"),

    /** 未知的服务异常 */
    FAIL(500, "服务异常，请稍后再试！"),

    /** 501-510保留 */
    F501(501, "数据异常"),
    F502(502, "数据异常"),
    F503(503, "数据异常"),
    F504(504, "数据异常"),

    ABNORMAL_DATA(507, "接口数据异常"),
    EXIST_DATA(508, "数据已存在"),
    NO_DATA(509, "数据不存在"),

    /** 入参错误或数据错误 */
    F511(511, "必要参数为空"),
    F512(512, "未找到该车型"),
    F513(513, "订单数据不存在"),
    F514(514, "上传订单号不存在"),

    F515(515, "用户信息获取失败"),
    F516(516, "用户机构信息获取失败"),

    /** 接口异常 */
    F520(520, "服务连接失败，请稍后再试！"),
    F521(521, "车型查询异常，请稍后再试！"),
    F522(522, "保费计算异常，请稍后再试！"),
    F523(523, "核保下单异常，请稍后再试！"),
    F524(524, "支付申请异常，请稍后再试！"),
    F525(525, "资料上传异常，请稍后再试！"),

    /** 认证服务 */
    F530(530, "用户认证失败，请稍后再试！"),

    /** 模拟异常 */
    F801(801, "模拟账号异常"),

    /** 接口特殊返回 */
    F900(900, "接口特殊返回"),
    F901(901, "江苏交管车辆验证码"),
    F902(902, "转保车验证码"),
    F903(903, "重复投保错误信息"),
    F904(904, "撤单"),
    F905(905, "北京电子保单身份采集验证码"),
    F906(906, "核保失败，再次核保"),
    F907(907, "紫金核保后需要上传图片"),
    ;

    public int code;
    public String msg;

    RespInfo(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 根据code匹配得到msg
     */
    public static String matchMsg(int code) {
        // 根据code查找RespInfo
        RespInfo respInfo = Arrays.stream(RespInfo.values()).filter(info -> code == info.code).findFirst().orElse(RespInfo.FAIL);

        return respInfo.msg;
    }
}
