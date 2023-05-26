package ru.itis.api.AmernotsApi.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_USER,
    ROLE_FIRE_DEPARTMENT,
    ROLE_AMBULANCE,
    ROLE_POLICE;


    @Override
    public String getAuthority() {
        return this.toString();
    }
}
