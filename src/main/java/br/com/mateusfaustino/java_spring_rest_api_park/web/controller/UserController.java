package br.com.mateusfaustino.java_spring_rest_api_park.web.controller;

import br.com.mateusfaustino.java_spring_rest_api_park.entity.User;
import br.com.mateusfaustino.java_spring_rest_api_park.service.UserService;
import br.com.mateusfaustino.java_spring_rest_api_park.web.dto.UserCreateDto;
import br.com.mateusfaustino.java_spring_rest_api_park.web.dto.UserResponseDto;
import br.com.mateusfaustino.java_spring_rest_api_park.web.dto.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> create(@RequestBody UserCreateDto userCreateDto) {
        User newUser = userService.save(UserMapper.toUser(userCreateDto));

        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toDto(newUser));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        User newUser = userService.getById(id);

        return ResponseEntity.ok(newUser);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> updatePassword(@RequestBody User userBody, @PathVariable Long id) {
        User user = userService.updatePassword(id, userBody.getPassword());

        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity <List<User>> getAll() {
        List <User> users = userService.getAll();
        return ResponseEntity.ok(users);
    }
}
