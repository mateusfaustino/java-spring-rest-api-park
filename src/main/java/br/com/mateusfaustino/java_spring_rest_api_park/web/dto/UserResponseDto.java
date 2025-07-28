package br.com.mateusfaustino.java_spring_rest_api_park.web.dto;

import lombok.*;

@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class UserResponseDto {
    private Long id;
    private String username;
    private String role;
}
