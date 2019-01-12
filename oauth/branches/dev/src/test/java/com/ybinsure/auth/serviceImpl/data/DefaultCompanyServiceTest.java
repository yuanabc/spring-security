package com.ybinsure.auth.serviceImpl.data;

import com.ybinsure.auth.OauthApplicationTests;
import com.ybinsure.auth.service.data.CompanyService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class DefaultCompanyServiceTest extends OauthApplicationTests {

    @Autowired
    private CompanyService companyService;

    @Test
    public void updateCompanyCode() {
        this.companyService.updateCompanyCode();
    }
}