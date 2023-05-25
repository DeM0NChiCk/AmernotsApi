package ru.itis.api.AmernotsApi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.api.AmernotsApi.model.News;
import ru.itis.api.AmernotsApi.model.Role;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileResponseDto {
    private Long id;
    private String username;
    private String login;
    private Role userStatus;
    private List<News> newslineUser;
}
