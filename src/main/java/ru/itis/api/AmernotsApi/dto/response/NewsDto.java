package ru.itis.api.AmernotsApi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.api.AmernotsApi.model.Role;
import ru.itis.api.AmernotsApi.model.RoleNews;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewsDto {
    private Role userStatus;
    private String tittleSituation;
    private String description;
    private String address;
    private String timeRelease;
    private Integer urgencyCode;
    private RoleNews roleNews;
    private Long employeeId;
}
