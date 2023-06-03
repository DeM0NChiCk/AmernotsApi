package ru.itis.api.AmernotsApi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.api.AmernotsApi.dto.request.ChangePasswordDto;
import ru.itis.api.AmernotsApi.dto.response.MessageDto;
import ru.itis.api.AmernotsApi.model.News;
import ru.itis.api.AmernotsApi.model.User;
import ru.itis.api.AmernotsApi.repository.NewsRepository;
import ru.itis.api.AmernotsApi.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChangeService {
    private final UserRepository userRepository;
    private final NewsRepository newsRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public MessageDto ChangeNewsStatus(Long newsId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User profile = (User) authentication.getPrincipal();
        Optional<User> optionalUserLogin = userRepository.findByLogin(profile.getLogin());

        Optional<News> optionalNews = newsRepository.findById(newsId);

        if (optionalUserLogin.isPresent() && optionalNews.isPresent()) {
            if (optionalNews.get().getEmployeeId() == -1L) {
                newsRepository.updateEmployeeId(newsId, optionalUserLogin.get().getUserId());

                return MessageDto.builder()
                        .message("Successfully")
                        .build();
            }
            return MessageDto.builder()
                    .message("someone already answered the news")
                    .build();
        }
        return MessageDto.builder()
                .message("Failure")
                .build();


    }

    @Transactional
    public MessageDto ChangePassword(ChangePasswordDto form) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User profile = (User) authentication.getPrincipal();

        String loginUser = profile.getLogin();

        Optional<User> optionalUserLogin = userRepository.findByLogin(loginUser);

        if (optionalUserLogin.isPresent()) {
            if (passwordEncoder.matches(form.getOldPassword(), optionalUserLogin.get().getPassword())) {
                userRepository.updatePassword(optionalUserLogin.get().getUserId(), passwordEncoder.encode(form.getNewPassword()));

                Optional<User> optionalUserNewPass = userRepository.findByLogin(loginUser);
                if (optionalUserNewPass.isPresent()) {
                    return MessageDto.builder()
                            .message("Successfully")
                            .build();
                }
            }

            return MessageDto.builder()
                    .message("Failure")
                    .build();
        }
        return MessageDto.builder()
                .message("Failure")
                .build();


    }
}
