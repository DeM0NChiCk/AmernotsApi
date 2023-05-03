package ru.itis.api.AmernotsApi.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_USER,
    ROLE_SPEC_USER;

    @Override
    public String getAuthority() {
        return this.toString();
    }
}
