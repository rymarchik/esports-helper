package com.capitazz.esportshelper.model.security;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    GUEST,
    USER,
    PREMIUM_USER,
    ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
