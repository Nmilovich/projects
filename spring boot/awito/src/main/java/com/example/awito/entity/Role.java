package com.example.awito.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, ADMIN;

    // name()
    @Override
    public String getAuthority() {
        return toString();
    }
}
