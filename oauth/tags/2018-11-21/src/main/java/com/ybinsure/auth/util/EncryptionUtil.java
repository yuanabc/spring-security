package com.ybinsure.auth.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

public class EncryptionUtil {

    public static String base64(String data) {
        if (StringUtils.isBlank(data)) {
            return "";
        }
        return Base64.encodeBase64String(data.getBytes());
    }

    public static String md5(String data) {
        if (StringUtils.isBlank(data)) {
            return "";
        }
        return DigestUtils.md5Hex(data);
    }

    public static String sha256Hex(String data) {
        if (StringUtils.isBlank(data)) {
            return "";
        }
        return DigestUtils.sha256Hex(data);
    }

}
