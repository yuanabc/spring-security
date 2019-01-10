package com.ybinsure.icar.user.auth;

import org.apache.commons.codec.binary.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.switchuser.SwitchUserGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class AuthenticationHelper {

    private static final String role = "UserDetail";
    private static final String id = "id";
    private static final String channelCode = "channelCode";
    private static final String nickName = "nickName";
    private static final String idName = "idName";

    /**
     * 获取当前线程登陆用户的用户id
     */
    public static Optional<String> getId() {
        return getUserDetails().map(map -> map.get(id));
    }

    /**
     * 获取当前线程登陆用户的用户id
     */
    public static Optional<String> getId(User user) {
        return getUserDetails(getAuthority(Optional.of(user))).map(map -> map.get(id));
    }

    /**
     * 获取当前线程登陆用户渠道编码
     */
    public static Optional<String> getChannelCode() {
        return getUserDetails().map(map -> map.get(channelCode));
    }

    /**
     * 获取当前线程登陆用户昵称
     */
    public static Optional<String> getNickName() {
        return getUserDetails().map(map -> map.get(nickName));
    }

    /**
     * 获取当前线程登陆证件名称
     */
    public static Optional<String> getIdName() {
        return getUserDetails().map(map -> map.get(idName));
    }

    /**
     * 获取当前线程登陆用户的用户名
     */
    public static Optional<String> getUserName() {
        return AuthenticationHelper.getUser().map(User::getUsername);
    }

    /**
     * 否是包含某种权限
     */
    public static boolean hasAuthority(String permissonCode) {
        return getUser().map(User::getAuthorities).orElseGet(ArrayList::new).stream().anyMatch(grantedAuthority -> StringUtils.equals(grantedAuthority.getAuthority(), permissonCode));
    }

    /**
     * 获取当前线程登陆用户的机构权限id
     */
    public static List<String> getCompanyAuthority() {
        return getAuthority().orElseGet(ArrayList::new).stream().filter(authority -> authority.getAuthority().length() == 32).map(GrantedAuthority::getAuthority).collect(Collectors.toList());
    }

    /**
     * 获取用户列表
     */
    private static Optional<Map<String, String>> getUserDetails() {
        return getUserDetails(getAuthority());
    }

    /**
     * 获取用户列表
     */
    private static Optional<Map<String, String>> getUserDetails(Optional<Collection<GrantedAuthority>> grantedAuthorities) {
        return grantedAuthorities.orElseGet(ArrayList::new).stream().filter(grantedAuthority -> grantedAuthority instanceof SwitchUserGrantedAuthority).map(grantedAuthority -> ((SwitchUserGrantedAuthority) grantedAuthority).getSource()).findAny().map(authentication -> {
            if (authentication.getPrincipal() instanceof HashMap) {
                return (Map<String, String>) authentication.getPrincipal();
            } else {
                return new HashMap<>();
            }
        });
    }

    /**
     * 获取权限列表
     */
    public static Optional<Collection<GrantedAuthority>> getAuthority() {
        return getAuthority(getUser());
    }

    private static Optional<Collection<GrantedAuthority>> getAuthority(Optional<User> user) {
        return user.map(User::getAuthorities);
    }

    /**
     * 获取当前登录用户的认证信息
     */
    private static Optional<User> getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() != null && authentication.getPrincipal() instanceof User) {
            return Optional.of((User) authentication.getPrincipal());
        }
        return Optional.empty();
    }

}
