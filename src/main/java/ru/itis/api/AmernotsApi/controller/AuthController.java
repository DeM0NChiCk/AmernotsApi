package ru.itis.api.AmernotsApi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.api.AmernotsApi.dto.request.RegistrationDto;
import ru.itis.api.AmernotsApi.dto.response.TokenDto;
import ru.itis.api.AmernotsApi.service.AuthService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/amernots_api/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/sing_up")
    public TokenDto singUp(@RequestBody RegistrationDto form) {
        return authService.singUp(form);
    }
}
