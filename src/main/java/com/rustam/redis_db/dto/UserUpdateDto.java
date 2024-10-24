package com.rustam.redis_db.dto;

import com.rustam.redis_db.model.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserUpdateDto {

    private Long id;

    private String password;

    public User toEntity(UserUpdateDto userDto){
        return User.builder()
                .password(userDto.password)
                .build();
    }
}
