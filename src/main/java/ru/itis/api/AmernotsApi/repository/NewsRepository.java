package ru.itis.api.AmernotsApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.itis.api.AmernotsApi.model.News;

import java.util.Optional;

public interface NewsRepository extends JpaRepository<News, Long> {

}
