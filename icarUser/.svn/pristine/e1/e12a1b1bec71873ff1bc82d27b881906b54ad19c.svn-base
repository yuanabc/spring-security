package com.ybinsure.icar.user.constant;

import com.ybinsure.icar.user.exception.FailResultException;

import java.util.Arrays;
import java.util.Objects;

/**
 * 险别信息
 *
 * @author HANHT
 * @version 2018/7/9 20:37
 */
public enum RiskInfo {

    A0("a0", "车损险"),
    A1("a1", "盗抢险"),
    A2("a2", "三者险"),
    A3("a3", "司机险"),
    A4("a4", "乘客险"),
    A5("a5", "划痕险"),
    A6("a6", "破碎险"),
    A7("a7", "修理险"),
    A8("a8", "自燃险"),
    A9("a9", "涉水险"),
    A10("a10", "特约险"),
    ;

    public String code;
    public String name;

    RiskInfo(String code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 根据code匹配得到name
     */
    public static String matchName(String code) {
        // 根据code查找RespInfo
        RiskInfo riskInfo = Arrays.stream(RiskInfo.values()).filter(info -> Objects.equals(code, info.code)).findFirst().orElseThrow(FailResultException::dataNoExistException);

        return riskInfo.name;
    }

    /**
     * 根据index匹配得到name
     *
     * @param codeIndex code索引
     * @return name
     */
    public static String matchName(int codeIndex) {

        return matchName("a" + codeIndex);
    }
}
