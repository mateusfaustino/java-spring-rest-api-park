package br.com.mateusfaustino.java_spring_rest_api_park.service;

import br.com.mateusfaustino.java_spring_rest_api_park.entity.User;
import br.com.mateusfaustino.java_spring_rest_api_park.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public User save(User user) {
        return userRepository.save(user) ;
    }
}
