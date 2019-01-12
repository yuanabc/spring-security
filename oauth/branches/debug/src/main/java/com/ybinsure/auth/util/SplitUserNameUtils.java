package com.ybinsure.auth.util;

import org.apache.commons.lang3.StringUtils;

public class SplitUserNameUtils {

    private static String regex = "---";

    public static String join(String userName, String channelCode) {
        if (StringUtils.isNotBlank(userName) && StringUtils.isNotBlank(channelCode)) {
            return userName + regex + channelCode;
        }
        return userName;
    }

    public static String getRealChannelCode(String joinUserName) {
        String[] splitChars = splitUsername(joinUserName);
        if (splitChars.length >= 2) {
            return splitChars[1];
        }
        return null;
    }

    public static String getRealUserName(String username) {
        return splitUsername(username)[0];
    }

    public static String[] splitUsername(String username) {
        return username.split(regex, 3);
    }
}
