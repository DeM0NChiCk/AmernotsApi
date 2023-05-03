package ru.itis.api.AmernotsApi.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "newslines")
public class Newsline extends AbstractEntity{
    private String tittleSituation;
    private String description;
    private String address;
    private String timePublic;
    private Boolean newslineStatus;
    private Integer urgencyCode;
    private String photo;
    private Boolean codeFireService;
    private Boolean codeAmbulance;
    private Boolean codePolice;

}
