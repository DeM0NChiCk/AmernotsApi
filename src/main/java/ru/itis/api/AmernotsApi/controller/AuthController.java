package ru.itis.api.AmernotsApi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.api.AmernotsApi.dto.request.SignUpDto;
import ru.itis.api.AmernotsApi.dto.request.SignInDto;
import ru.itis.api.AmernotsApi.dto.response.TokenDto;
import ru.itis.api.AmernotsApi.service.AuthService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/amernots_api/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/sign_up")
    public TokenDto singUp(@RequestBody SignUpDto form) {
        return authService.signUp(form);
    }

    @PostMapping("/sign_in")
    public TokenDto signIn(@RequestBody SignInDto form) {
        return authService.signIn(form);
    }
}
