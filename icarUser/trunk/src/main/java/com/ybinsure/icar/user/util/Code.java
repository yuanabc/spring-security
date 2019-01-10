package com.ybinsure.icar.user.util;

import com.ybinsure.icar.user.constant.DefaultConst;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;

/**
 * @author HANHT
 * @version 2018/6/13 16:33
 */
public final class Code {

    private static Cipher encryptCipher;
    private static Cipher decryptCipher;

    static {
        try {
            encryptCipher = Cipher.getInstance("AES");
            decryptCipher = Cipher.getInstance("AES");
            SecretKeySpec keySpec = new SecretKeySpec(MessageDigest.getInstance("MD5").digest(DefaultConst.AES_DIGEST.getBytes()), "AES");
            encryptCipher.init(Cipher.ENCRYPT_MODE, keySpec);
            decryptCipher.init(Cipher.DECRYPT_MODE, keySpec);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
