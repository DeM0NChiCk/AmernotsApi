package ru.itis.api.AmernotsApi.model;

import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long newslineId;
    private String tittleSituation;
    private String description;
    private String address;
    private String timeRelease;
    private Integer urgencyCode;
    @Enumerated(EnumType.STRING)
    private RoleNews roleNews;
    private Long authorId;
    private Long employeeId;
}
