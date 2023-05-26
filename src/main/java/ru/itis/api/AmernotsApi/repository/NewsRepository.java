package ru.itis.api.AmernotsApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.itis.api.AmernotsApi.model.News;

public interface NewsRepository extends JpaRepository<News, Long> {
    @Modifying
    @Query("UPDATE News SET employeeId = ?2 where newslineId = ?1")
    void updateEmployeeId(Long news_id, Long employeeId);
}
