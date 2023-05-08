package ru.itis.api.AmernotsApi.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.itis.api.AmernotsApi.dto.response.ProfileResponse;
import ru.itis.api.AmernotsApi.model.User;

@Service
public class ProfileService {

    public ProfileResponse getProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User profile = (User) authentication.getPrincipal();
        return ProfileResponse.builder()
                .login(profile.getLogin())
                .username(profile.getUsername())
                .userStatus(profile.getUserStatus())
                .id(profile.getUserId())
                .build();
    }
}
