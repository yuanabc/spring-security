package com.ybinsure.auth.util;

import org.apache.commons.lang3.RandomUtils;

import java.util.UUID;

public class TokenUtils {

    public static String suuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String verificationCode() {
        return String.valueOf(RandomUtils.nextInt(100000, 999999));
    }

}
