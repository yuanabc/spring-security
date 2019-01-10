package com.ybinsure.icar.user.auth;

import com.ybinsure.icar.user.util.StrUtil;

public class SplitUserNameUtils {

    private static String regex = "---";

    public static String join(String userName, String password, String id) {
        if (StrUtil.isNotBlank(userName) && StrUtil.isNotBlank(password)) {
            return userName + regex + password + regex + id;
        }
        return userName;
    }

    public static String getRealChannelCode(String joinUserName) {
        String[] splitChars = splitUsername(joinUserName);
        if (splitChars.length >= 2) {
            return splitChars[1];
        }
        return "";
    }

    public static String getRealId(String join) {
        String[] splitChars = splitUsername(join);
        if (splitChars.length >= 3) {
            return splitChars[2];
        }
        return "";
    }

    public static String getRealUserName(String username) {
        return splitUsername(username)[0];
    }

    public static String[] splitUsername(String username) {
        return username.split(regex, 3);
    }
}
