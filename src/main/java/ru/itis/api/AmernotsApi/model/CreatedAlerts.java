package ru.itis.api.AmernotsApi.model;

import lombok.*;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class CreatedAlerts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long createdAlertsId;
    private Long idAuthor;
    private Long idCreatedNewsline;
}
