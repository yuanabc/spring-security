package com.ybinsure.auth.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.web.authentication.switchuser.SwitchUserGrantedAuthority;

import java.util.*;
import java.util.stream.Collectors;

public class AuthenticationHelper {

    public static final String customInfoRole = "UserDetail";
    public static final String id = "id";
    public static final String channelCode = "channelCode";
    public static final String nickName = "nickName";
    public static final String idName = "idName";
    public static final String phone = "phone";
    public static final String belongCompanyId = "belongCompanyId";

    public static AuthenticationParser localContextHolderParser() {
        return new AuthenticationParser(SecurityContextHolder.getContext().getAuthentication());
    }

    public static AuthenticationParser customParser(Authentication authentication) {
        return new AuthenticationParser(authentication);
    }

    public static class AuthenticationParser {

        private Authentication authentication;

        private AuthenticationParser(Authentication authentication) {
            this.authentication = authentication;
        }

        /**
         * 获取当前线程登陆用户的用户id
         */
        public Optional<String> getId() {
            return getCustomAuthenticationInfo().map(map -> map.get(id));
        }

        /**
         * 获取当前线程登陆用户渠道编码
         */
        public Optional<String> getChannelCode() {
            return getCustomAuthenticationInfo().map(map -> map.get(channelCode));
        }

        /**
         * 获取当前线程登陆用户昵称
         */
        @SuppressWarnings("unchecked")
        public Optional<String> getNickName() {
            return getCustomAuthenticationInfo().map(map -> map.get(nickName));
        }

        /**
         * 获取当前线程登陆证件名称
         */

        public Optional<String> getIdName() {
            return getCustomAuthenticationInfo().map(map -> map.get(idName));
        }

        /**
         * 获取用户手机号码
         */
        public Optional<String> getPhone() {
            return getCustomAuthenticationInfo().map(map -> map.get(phone));
        }

        /**
         * 获取当前线程登录用户的归属机构id
         * @return 归属机构id
         */
        public Optional<String> getBelongCompanyId() {
            return getCustomAuthenticationInfo().map(map -> map.get(belongCompanyId));
        }

        /**
         * 获取当前线程登陆用户的用户名
         */
        public Optional<String> getUserName() {
            return getUser().map(User::getUsername);
        }

        /**
         * 获取当前线程登陆用户登录使用的客户端信息
         */
        @SuppressWarnings("unchecked")
        public Optional<String> getClientId() {
            if (authentication instanceof OAuth2Authentication) {
                Object detail = Optional.of(authentication)
                        .map(instance -> (OAuth2Authentication)instance)
                        .map(OAuth2Authentication::getUserAuthentication)
                        .map(Authentication::getDetails).orElseGet(Object::new);
                if (detail instanceof HashMap) {
                    return Optional.ofNullable(((HashMap<String, String>)detail).get("client_id"));
                }
            }
            return Optional.empty();
        }

        /**
         * 否是包含某种权限
         */
        public boolean hasAuthority(String permissonCode) {
            return getUser()
                    .map(User::getAuthorities)
                    .orElseGet(ArrayList::new)
                    .stream()
                    .anyMatch(grantedAuthority -> StringUtils.equals(grantedAuthority.getAuthority(), permissonCode));
        }

        /**
         * 获取当前线程登陆用户的机构权限id
         */
        public List<String> getCompanyAuthority() {
            return getAuthority()
                    .orElseGet(ArrayList::new)
                    .stream()
                    .filter(authority -> authority.getAuthority().length() == 32)
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());
        }

        // 获取自定义信息
        @SuppressWarnings("unchecked")
        private Optional<Map<String, String>> getCustomAuthenticationInfo() {
            return getAuthority()
                    .orElseGet(ArrayList::new)
                    .stream()
                    .filter(grantedAuthority -> grantedAuthority instanceof SwitchUserGrantedAuthority)
                    .findAny()
                    .map(grantedAuthority -> ((SwitchUserGrantedAuthority) grantedAuthority).getSource())
                    .map(customAuthenticationInfo -> {
                        if (customAuthenticationInfo.getPrincipal() instanceof HashMap) {
                            return (Map<String, String>) customAuthenticationInfo.getPrincipal();
                        } else {
                            return new HashMap<>();
                        }
                    });
        }

        // 获取权限列表
        private Optional<Collection<GrantedAuthority>> getAuthority() {
            return getUser().map(User::getAuthorities);
        }

        // 获取当前登录用户的认证信息
        private Optional<User> getUser() {
            if (authentication.getPrincipal() != null && authentication.getPrincipal() instanceof User) {
                return Optional.of((User) authentication.getPrincipal());
            }
            return Optional.empty();
        }
    }

}
