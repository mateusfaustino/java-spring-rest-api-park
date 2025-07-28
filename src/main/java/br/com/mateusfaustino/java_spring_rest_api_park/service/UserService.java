package br.com.mateusfaustino.java_spring_rest_api_park.service;

import br.com.mateusfaustino.java_spring_rest_api_park.entity.User;
import br.com.mateusfaustino.java_spring_rest_api_park.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public User save(User user) {
        return userRepository.save(user) ;
    }

    @Transactional(readOnly = true)
    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id)); 
    }

    @Transactional
    public User updatePassword(Long id, String password) {
        User user = getById(id);
        user.setPassword(password);
        return user;
    }
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
