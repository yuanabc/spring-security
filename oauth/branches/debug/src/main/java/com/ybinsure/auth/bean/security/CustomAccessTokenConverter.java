package com.ybinsure.auth.bean.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
@Slf4j
public class CustomAccessTokenConverter extends DefaultAccessTokenConverter {

    private final static String COMPANY = "company";

    @Override
    @SuppressWarnings("unchecked")
    public Map<String, ?> convertAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) {
        Map<String, Object> result = (Map<String, Object>) super.convertAccessToken(token, authentication);
        Object principal = authentication.getPrincipal();
        if (principal instanceof User) {
            User user = (User) principal;
            List<String> res = new ArrayList<>();
            // 提取机构权限
            result.put(COMPANY, res);
            if (user.getAuthorities() != null) {
                user.getAuthorities().stream()
                        .filter(grantedAuthority -> grantedAuthority.getAuthority().length() == 32)
                        .map(GrantedAuthority::getAuthority)
                        .forEach(res::add);
            }
        }
        return result;
    }


}
