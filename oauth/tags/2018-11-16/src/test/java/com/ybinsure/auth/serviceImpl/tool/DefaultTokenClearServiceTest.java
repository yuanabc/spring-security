package com.ybinsure.auth.serviceImpl.tool;

import com.ybinsure.auth.OauthApplicationTests;
import com.ybinsure.auth.service.tool.TokenClearService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

public class DefaultTokenClearServiceTest extends OauthApplicationTests {

    String tokens = "0517fb03-7f00-43ef-b7f9-9a8b284c2ac2 ";

    @Autowired
    private TokenClearService tokenClearService;

    @Test
    public void clearToken() {
        List<String> tokenList = Arrays.asList(tokens.split(" "));
        tokenClearService.clearToken(tokenList);
    }
}