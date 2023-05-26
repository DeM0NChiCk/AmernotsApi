package ru.itis.api.AmernotsApi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.itis.api.AmernotsApi.dto.response.ProfileResponseDto;
import ru.itis.api.AmernotsApi.model.News;
import ru.itis.api.AmernotsApi.model.Role;
import ru.itis.api.AmernotsApi.model.User;
import ru.itis.api.AmernotsApi.repository.NewsRepository;
import ru.itis.api.AmernotsApi.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final UserRepository userRepository;
    private final NewsRepository newsRepository;

    public ProfileResponseDto getProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User profile = (User) authentication.getPrincipal();
        Optional<User> optionalUserLogin = userRepository.findByLogin(profile.getLogin());

        List<News> newslineUser = getNewsline(optionalUserLogin);

        return ProfileResponseDto.builder()
                .login(profile.getLogin())
                .username(profile.getUsername())
                .userStatus(profile.getUserStatus())
                .id(profile.getUserId())
                .newslineUser(newslineUser)
                .build();
    }

    private List<News> getNewsline(Optional<User> user) {
        List<News> newsline = newsRepository.findAll();
        List<News> newslineResult = new ArrayList<>();
        if (user.isPresent()) {
            for (News news : newsline) {
                if (news.getAuthorId().equals(user.get().getUserId()) && user.get().getUserStatus() == Role.ROLE_USER) {
                    newslineResult.add(news);
                } else if (news.getEmployeeId().equals(user.get().getUserId())){
                    newslineResult.add(news);
                }

            }
        }
        return newslineResult;
    }
}
