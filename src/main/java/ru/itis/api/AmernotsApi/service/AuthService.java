package ru.itis.api.AmernotsApi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.api.AmernotsApi.config.security.filter.JwtClaims;
import ru.itis.api.AmernotsApi.config.security.filter.JwtHelper;
import ru.itis.api.AmernotsApi.dto.request.SignUpDto;
import ru.itis.api.AmernotsApi.dto.request.SignInDto;
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

    public TokenDto signUp(SignUpDto form) {
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

    public TokenDto signIn(SignInDto form) {
        Optional<User> optionalUserLogin = userRepository.findByLogin(form.getLogin());

        TokenDto tokenDto = TokenDto.builder()
                .build();

        if (optionalUserLogin.isPresent() && passwordEncoder.matches(form.getPassword(), optionalUserLogin.get().getPassword())) {
            JwtClaims jwtClaims = JwtClaims.builder()
                    .id(optionalUserLogin.get().getUserId())
                    .password(optionalUserLogin.get().getPassword())
                    .build();
            tokenDto = TokenDto.builder()
                    .token(jwtHelper.generateToken(jwtClaims))
                    .build();
        }
        return tokenDto;

        // код статутс не изменяется
        // TODO: научится делать правильный Exception Handler
    }
}
