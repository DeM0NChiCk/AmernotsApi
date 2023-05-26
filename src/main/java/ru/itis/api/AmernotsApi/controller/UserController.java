package ru.itis.api.AmernotsApi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.itis.api.AmernotsApi.dto.response.NewslineDto;
import ru.itis.api.AmernotsApi.dto.response.ProfileResponseDto;
import ru.itis.api.AmernotsApi.service.NewslineService;
import ru.itis.api.AmernotsApi.service.ProfileService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/amernots_api")
public class UserController {
    private final ProfileService profileService;
    private final NewslineService NewslineService;

    @GetMapping("/profile")
    public ProfileResponseDto getProfile() {
        return profileService.getProfile();
    }

    @GetMapping("/newsline")
    public NewslineDto getNewsline() {
        return NewslineService.getNewsline();
    }

}