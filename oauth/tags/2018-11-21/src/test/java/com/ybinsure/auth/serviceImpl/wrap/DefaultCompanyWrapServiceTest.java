package com.ybinsure.auth.serviceImpl.wrap;

import com.ybinsure.auth.OauthApplicationTests;
import com.ybinsure.auth.service.wrap.CompanyWrapService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class DefaultCompanyWrapServiceTest extends OauthApplicationTests {

    @Autowired
    private CompanyWrapService companyWrapService;

    @Test
    public void resetCompanySort() {
        companyWrapService.resetCompanySort();
    }
}