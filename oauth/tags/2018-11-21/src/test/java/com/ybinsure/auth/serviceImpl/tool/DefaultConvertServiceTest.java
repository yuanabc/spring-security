package com.ybinsure.auth.serviceImpl.tool;

import com.ybinsure.auth.OauthApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DefaultConvertServiceTest extends OauthApplicationTests {

    @Autowired(required = false)
    private DefaultConvertService defaultConvertService;

    @Test
    public void convertPassword() {
        defaultConvertService.convertPassword();
    }

    @Test
    public void convertCompany() {
        defaultConvertService.generateCompanyCode();
    }

    @Test
    public void generateUser() {
        for (int i = 0; i < 1000; i++) {
            defaultConvertService.generateUserCode(i ,1000);
        }
    }
}