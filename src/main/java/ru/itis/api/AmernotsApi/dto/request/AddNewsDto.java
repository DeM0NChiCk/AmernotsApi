package ru.itis.api.AmernotsApi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.api.AmernotsApi.model.RoleNews;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddNewsDto {
    private String tittleSituation;
    private String description;
    private String address;
    private String timeRelease;
    private Integer urgencyCode;
    private RoleNews roleNews;
    private Long authorId;
}
