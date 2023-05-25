package ru.itis.api.AmernotsApi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.itis.api.AmernotsApi.dto.request.ChangeNewsStatus;
import ru.itis.api.AmernotsApi.dto.response.MessageDto;
import ru.itis.api.AmernotsApi.model.News;
import ru.itis.api.AmernotsApi.model.User;
import ru.itis.api.AmernotsApi.repository.NewsRepository;
import ru.itis.api.AmernotsApi.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChangeService {
    private final UserRepository userRepository;
    private final NewsRepository newsRepository;

    public MessageDto ChangeNewsStatus(ChangeNewsStatus changeNewsStatus) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User profile = (User) authentication.getPrincipal();
        Optional<User> optionalUserLogin = userRepository.findByLogin(profile.getLogin());

        Optional<News> optionalNews = newsRepository.findById(changeNewsStatus.getNewsId());



        return MessageDto.builder()
                .message("Successfully")
                .build();
    }
}
