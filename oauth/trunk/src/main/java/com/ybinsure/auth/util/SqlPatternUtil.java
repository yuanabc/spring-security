package com.ybinsure.auth.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @author liu yucheng
 * @date 2018/11/9
 */
public class SqlPatternUtil {

    private static final String escapeChar = "\\\\";
    private static final String wildcard = "%";

    public static String getPattern(String source) {
        if (StringUtils.isBlank(source)) {
            return source;
        }
        source = replaceKeyWord(source);
        return wildcard + source.trim() + wildcard;
    }

    private static String replaceKeyWord(String source) {
        if (StringUtils.isBlank(source)) {
            return source;
        }
        return source
                .replaceAll("\\\\", escapeChar + escapeChar)
                .replaceAll("'", escapeChar + "'")
                .replaceAll("%", escapeChar + "%")
                .replaceAll("_", escapeChar + "_");
    }
}
