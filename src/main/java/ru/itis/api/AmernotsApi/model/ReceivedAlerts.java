package ru.itis.api.AmernotsApi.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "received_alerts")
public class ReceivedAlerts extends AbstractEntity{
    private Long idUser;
    private Long[] idNewsline;
}
