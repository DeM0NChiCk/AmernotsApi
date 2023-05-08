package ru.itis.api.AmernotsApi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.api.AmernotsApi.config.security.filter.JwtClaims;
import ru.itis.api.AmernotsApi.config.security.filter.JwtHelper;
import ru.itis.api.AmernotsApi.dto.request.RegistrationDto;
import ru.itis.api.AmernotsApi.dto.request.SignInDto;
import ru.itis.api.AmernotsApi.dto.response.ErrorDto;
import ru.itis.api.AmernotsApi.dto.response.TokenDto;
import ru.itis.api.AmernotsApi.model.User;
import ru.itis.api.AmernotsApi.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtHelper jwtHelper;

    public TokenDto signUp(RegistrationDto form) {
        User newUser = User.builder()
                .login(form.getLogin())
                .password(passwordEncoder.encode(form.getPassword()))
                .username(form.getUsername())
                .userStatus(form.getUserStatus())
                .build();

        User createdUser = userRepository.save(newUser);
        JwtClaims jwtClaims = JwtClaims.builder()
                .id(createdUser.getUserId())
                .password(createdUser.getPassword())
                .build();


        return TokenDto.builder()
                .token(jwtHelper.generateToken(jwtClaims))
                .build();
    }

    public Object signIn(SignInDto form) {
        Optional<User> optionalUser = userRepository.findByLogin(form.getLogin());
        if (optionalUser.isPresent()){
            JwtClaims jwtClaims = JwtClaims.builder()
                    .id(optionalUser.get().getUserId())
                    .password(optionalUser.get().getPassword())
                    .build();
            return TokenDto.builder()
                    .token(jwtHelper.generateToken(jwtClaims))
                    .build();
        } else {
            return ErrorDto.builder()
                    .message("Пользователь не существует")
                    .build();
        }
    }
}
