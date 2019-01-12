package com.ybinsure.auth.util;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptionUtilTest {

    private String input = "input word";
    private String base64 = "aW5wdXQgd29yZA==";
    private String md5 = "e767d441517f0042c9df8c8f362d18ee";
    private String sha256 = "1600c40cd27819e9b7cf939321025bc3253966081c23e0e2c489a87731d1e545";

    @Test
    public void base64() {
        Assert.assertThat(EncryptionUtil.base64(input), CoreMatchers.equalTo(base64));
        Assert.assertThat(EncryptionUtil.base64(null), CoreMatchers.equalTo(""));
        Assert.assertThat(EncryptionUtil.base64(""), CoreMatchers.equalTo(""));
    }

    @Test
    public void md5() {
        Assert.assertThat(EncryptionUtil.md5(input), CoreMatchers.equalTo(md5));
        Assert.assertThat(EncryptionUtil.md5(null), CoreMatchers.equalTo(""));
        Assert.assertThat(EncryptionUtil.md5(""), CoreMatchers.equalTo(""));
    }

    @Test
    public void sha256Hex() {
        Assert.assertThat(EncryptionUtil.sha256Hex(input), CoreMatchers.equalTo(sha256));
        Assert.assertThat(EncryptionUtil.sha256Hex(null), CoreMatchers.equalTo(""));
        Assert.assertThat(EncryptionUtil.sha256Hex(""), CoreMatchers.equalTo(""));
    }

    @Test
    public void name1() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String res = passwordEncoder.encode(EncryptionUtil.md5("c33367"));
        System.out.println(res);
    }

    @Test
    public void name2() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String res = passwordEncoder.encode("db5ac6d62435c57f647a7b0a159a17fa");
        System.out.println(res);
    }

    @Test
    public void match1() {
        String source = "db5ac6d62435c57f647a7b0a159a17fa";
        String enCode = "$2a$10$Pi8HrUQjWYbxlOK4FS7wXe/ZTPxEyPKDRGZCop3M2r/I67lk2XY3K";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.matches(source, enCode));
    }

    @Test
    public void match2() {
        String source = "18649227";
        String enCode = "$2a$10$EAje8jCfNJH6zLb8q64mke2VcFA7o2Rl4ic7foSVUjC4qrC7b/6gq";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.matches(EncryptionUtil.md5(source), enCode));
    }
}