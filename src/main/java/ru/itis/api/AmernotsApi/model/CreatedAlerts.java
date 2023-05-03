package ru.itis.api.AmernotsApi.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "created_alerts")
public class CreatedAlerts extends AbstractEntity{
    private Long idAuthor;
    private Long[] idCreatedNewsline;
}
