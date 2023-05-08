package ru.itis.api.AmernotsApi.model;

import lombok.*;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class ReceivedAlerts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long receivedAlertsId;
    private Long idUser;
    private Long idNewsline;
}
