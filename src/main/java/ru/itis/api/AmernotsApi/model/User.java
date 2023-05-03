package ru.itis.api.AmernotsApi.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "users")
public class User extends AbstractEntity {
    private String username;
    @Column(unique = true)
    private String login;
    private String password;
    private Integer userStatus;
}
