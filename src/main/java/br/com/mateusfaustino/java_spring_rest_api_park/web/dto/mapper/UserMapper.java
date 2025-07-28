package br.com.mateusfaustino.java_spring_rest_api_park.web.dto.mapper;

import br.com.mateusfaustino.java_spring_rest_api_park.entity.User;
import br.com.mateusfaustino.java_spring_rest_api_park.web.dto.UserCreateDto;
import br.com.mateusfaustino.java_spring_rest_api_park.web.dto.UserResponseDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.boot.context.properties.PropertyMapper;

public class UserMapper {
    public static User toUser(UserCreateDto userCreateDto){
        return new ModelMapper().map(userCreateDto, User.class);
    }

    public static UserResponseDto toDto(User user){
        String role = user.getRole().name().substring("ROLE_".length());
        PropertyMap<User, UserResponseDto> props = new PropertyMap<User, UserResponseDto>(){
            @Override
            protected void configure(){
                map().setRole(role);
            }
        };

        ModelMapper mapper = new ModelMapper();
        mapper.addMappings(props);
        return mapper.map(user, UserResponseDto.class);
    }
}
