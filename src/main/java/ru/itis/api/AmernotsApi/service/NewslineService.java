package ru.itis.api.AmernotsApi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.itis.api.AmernotsApi.dto.request.AddNewsDto;
import ru.itis.api.AmernotsApi.dto.response.MessageDto;
import ru.itis.api.AmernotsApi.dto.response.NewslineDto;
import ru.itis.api.AmernotsApi.model.News;
import ru.itis.api.AmernotsApi.model.Role;
import ru.itis.api.AmernotsApi.model.RoleNews;
import ru.itis.api.AmernotsApi.model.User;
import ru.itis.api.AmernotsApi.repository.NewsRepository;
import ru.itis.api.AmernotsApi.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NewslineService {
    private final UserRepository userRepository;
    private final NewsRepository newsRepository;

    public NewslineDto getNewsline() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User profile = (User) authentication.getPrincipal();
        Optional<User> optionalUserLogin = userRepository.findByLogin(profile.getLogin());
        List<News> newslineUser = newsRepository.findAll();
        List<News> newslineFDepartment = new ArrayList<>();
        List<News> newslinePolice = new ArrayList<>();
        List<News> newslineAmbulance = new ArrayList<>();

        for (News news : newslineUser) {
            if (news.getRoleNews() == RoleNews.ROLE_FIRE_DEPARTMENT) {
                newslineFDepartment.add(news);
            }
            if (news.getRoleNews() == RoleNews.ROLE_POLICE) {
                newslinePolice.add(news);
            }
            if (news.getRoleNews() == RoleNews.ROLE_AMBULANCE) {
                newslineAmbulance.add(news);
            }
        }

        NewslineDto result = new NewslineDto();

        if (optionalUserLogin.isPresent()) {
            if (optionalUserLogin.get().getUserStatus() == Role.ROLE_USER) {
                result = NewslineDto.builder()
                        .userStatus(profile.getUserStatus())
                        .newsline(newslineUser)
                        .build();
            } else if (optionalUserLogin.get().getUserStatus() == Role.ROLE_FIRE_DEPARTMENT) {
                result =  NewslineDto.builder()
                        .userStatus(profile.getUserStatus())
                        .newsline(newslineFDepartment)
                        .build();
            } else if (optionalUserLogin.get().getUserStatus() == Role.ROLE_AMBULANCE) {
                result = NewslineDto.builder()
                        .userStatus(profile.getUserStatus())
                        .newsline(newslineAmbulance)
                        .build();
            } else if (optionalUserLogin.get().getUserStatus() == Role.ROLE_POLICE) {
                result =  NewslineDto.builder()
                        .userStatus(profile.getUserStatus())
                        .newsline(newslinePolice)
                        .build();
            }
        }

        return result;
    }

    public MessageDto addNews(AddNewsDto form) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User profile = (User) authentication.getPrincipal();

        Long valueEmployeeId = -1L;


        News newNews = News.builder()
                .tittleSituation(form.getTittleSituation())
                .description(form.getDescription())
                .address(form.getAddress())
                .timeRelease(form.getTimeRelease())
                .urgencyCode(form.getUrgencyCode())
                .photo(form.getPhoto())
                .roleNews(form.getRoleNews())
                .authorId(profile.getUserId())
                .employeeId(valueEmployeeId)
                .build();

        News createdNews = newsRepository.save(newNews);

        return MessageDto.builder()
                .message("Successfully")
                .build();
    }
}
