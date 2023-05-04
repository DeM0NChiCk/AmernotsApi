package ru.itis.api.AmernotsApi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.itis.api.AmernotsApi.dto.response.ProfileResponse;
import ru.itis.api.AmernotsApi.service.ProfileService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/amernots_api")
public class ProfileController {
    private final ProfileService profileService;

    @GetMapping("/profile")
    public ProfileResponse getProfile() {
        return profileService.getProfile();
    }

}
