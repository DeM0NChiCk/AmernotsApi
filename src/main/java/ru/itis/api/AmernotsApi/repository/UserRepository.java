package ru.itis.api.AmernotsApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.itis.api.AmernotsApi.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);

    @Modifying
    @Query("UPDATE User SET password = ?2 where userId = ?1")
    void updatePassword(Long news_id, String password);
}
