package com.ybinsure.auth.bean.security;

import com.ybinsure.auth.service.wrap.UserWrapService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CustomUserDetailsServiceTest {

    @Mock
    private UserWrapService userWrapService;

    @InjectMocks
    private CustomUserDetailsService customUserDetailsService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void loadUserByUsername() {
    }
}