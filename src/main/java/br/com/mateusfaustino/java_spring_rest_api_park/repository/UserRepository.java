package br.com.mateusfaustino.java_spring_rest_api_park.repository;

import br.com.mateusfaustino.java_spring_rest_api_park.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}