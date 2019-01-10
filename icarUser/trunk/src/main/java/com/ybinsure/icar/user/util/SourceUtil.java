package com.ybinsure.icar.user.util;

import com.ybinsure.icar.user.constant.SourceType;

/**
 * 渠道工具（临时用）
 *
 * @author HANHT
 * @version 2018/7/13 15:57
 */
public class SourceUtil {

    /**
     * 匹配渠道类型
     */
    public static int matchType(String source) {
        switch (source) {
            case "130":
            case "132":
                return SourceType.LIKE_CG;
            case "123":
            case "200":
                return SourceType.LIKE_CYH;
            default:
                return SourceType.LIKE_DT;
        }
    }

    /**
     * 是否需要签名
     */
    public static boolean matchSign(String source) {
        switch (source) {
            case "001":
                return true;
            default:
                return false;
        }
    }
}
