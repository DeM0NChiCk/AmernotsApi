package ru.itis.api.AmernotsApi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/amernots_api")
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "OK, I am test";
    }
}
