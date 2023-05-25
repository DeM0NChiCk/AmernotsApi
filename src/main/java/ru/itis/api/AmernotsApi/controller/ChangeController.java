package ru.itis.api.AmernotsApi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/amernots_api/change")
public class ChangeController {

    @PatchMapping("/password")
    public String changePassword() {
        return "password changed";
    }

    @PatchMapping("/news_status")
    public String changeNewsStatus() {
        return "news accepted";
    }
}
