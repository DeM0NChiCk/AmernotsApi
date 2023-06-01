package ru.itis.api.AmernotsApi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.api.AmernotsApi.dto.response.NewsDto;
import ru.itis.api.AmernotsApi.model.News;
import ru.itis.api.AmernotsApi.repository.NewsRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NewsService {
    private final NewsRepository newsRepository;

    public NewsDto getNewsById(Long newsId) {
        Optional<News> optionalNews = newsRepository.findById(newsId);

        NewsDto news = NewsDto.builder().build();

        if (optionalNews.isPresent()) {
            news = NewsDto.builder()
                    .tittleSituation(optionalNews.get().getTittleSituation())
                    .description(optionalNews.get().getDescription())
                    .address(optionalNews.get().getAddress())
                    .roleNews(optionalNews.get().getRoleNews())
                    .urgencyCode(optionalNews.get().getUrgencyCode())
                    .photo(optionalNews.get().getPhoto())
                    .timeRelease(optionalNews.get().getTimeRelease())
                    .employeeId(optionalNews.get().getEmployeeId())
                    .build();
        }

        return news;
    }
}
