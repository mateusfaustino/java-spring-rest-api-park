package br.com.mateusfaustino.java_spring_rest_api_park.web.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @ToString @AllArgsConstructor
public class UserCreateDto {
    private String username;
    private String password;
}
