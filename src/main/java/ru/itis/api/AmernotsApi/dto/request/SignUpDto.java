package ru.itis.api.AmernotsApi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.api.AmernotsApi.model.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpDto {
    private String login;
    private String password;
    private String username;
    private Role userStatus;
}
