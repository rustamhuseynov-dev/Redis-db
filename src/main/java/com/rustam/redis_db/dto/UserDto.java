package com.rustam.redis_db.dto;

import com.rustam.redis_db.model.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private String username;

    private String password;


    public User toEntity(UserDto userDto){
        return User.builder()
                .username(userDto.username)
                .password(userDto.password)
                .build();
    }
}
