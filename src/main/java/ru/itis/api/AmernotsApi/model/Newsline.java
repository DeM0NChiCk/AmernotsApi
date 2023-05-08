package ru.itis.api.AmernotsApi.model;

import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Newsline{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long newslineId;
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
