package ru.itis.api.AmernotsApi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.itis.api.AmernotsApi.dto.request.ChangePasswordDto;
import ru.itis.api.AmernotsApi.dto.response.MessageDto;
import ru.itis.api.AmernotsApi.service.ChangeService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/amernots_api/change")
public class ChangeController {
    private final ChangeService changeService;

    @PatchMapping("/password")
    public MessageDto changePassword(@RequestBody ChangePasswordDto form) {
        return changeService.ChangePassword(form);
    }

    @PatchMapping("/news_status")
    public MessageDto changeNewsStatus(@RequestParam(name = "news_id") Long newsId) {
        return changeService.ChangeNewsStatus(newsId);
    }
}
