package br.com.mateusfaustino.java_spring_rest_api_park.web.controller;

import br.com.mateusfaustino.java_spring_rest_api_park.entity.User;
import br.com.mateusfaustino.java_spring_rest_api_park.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        User newUser = userService.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }
}
