package com.ybinsure.auth.bean.security;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncodeTest {

    @Test
    public void encode() {
        String code = "c33367701511b4f6020ec61ded352059";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode(code));
    }
}
