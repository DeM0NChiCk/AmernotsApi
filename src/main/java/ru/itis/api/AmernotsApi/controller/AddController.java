package ru.itis.api.AmernotsApi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.api.AmernotsApi.dto.request.AddNewsDto;
import ru.itis.api.AmernotsApi.dto.response.MessageDto;
import ru.itis.api.AmernotsApi.service.NewslineService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/amernots_api/add")
public class AddController {
    private final NewslineService addNewsService;

    @PostMapping("/news")
    public MessageDto addNews(@RequestBody AddNewsDto form) {
        return addNewsService.addNews(form);
    }
}
