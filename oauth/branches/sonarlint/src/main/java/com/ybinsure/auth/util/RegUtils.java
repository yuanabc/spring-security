package com.ybinsure.auth.util;

import java.util.regex.Pattern;

public class RegUtils {

    private static final String phoneReg = "^[0-9]{11}";
    private static final Pattern pattern = Pattern.compile(phoneReg);

    public static boolean isPhoneNum(String str) {
        return pattern.matcher(str).matches();
    }

}
