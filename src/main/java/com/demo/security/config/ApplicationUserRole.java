package com.demo.security.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;
import java.util.stream.Collectors;

public enum ApplicationUserRole {
    STUDENT(new ArrayList<>()),
    ADMIN(Arrays.asList(ApplicationUserPermission.STUDENT_READ, ApplicationUserPermission.STUDENT_WRITE)),
    ADMINTRAINEE(Arrays.asList(ApplicationUserPermission.STUDENT_READ));

    private final List<ApplicationUserPermission> listPermission;

    ApplicationUserRole(List<ApplicationUserPermission> listPermission) {
        this.listPermission = listPermission;
    }

    public List<ApplicationUserPermission> getListPermission() {
        return listPermission;
    }

    public List<SimpleGrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> listAuthorities = getListPermission().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        listAuthorities.add(new SimpleGrantedAuthority("ROLE_" + name()));
        return listAuthorities;
    }
}
