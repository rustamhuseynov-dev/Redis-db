package com.rustam.redis_db.service;

import com.rustam.redis_db.dto.UserDto;
import com.rustam.redis_db.dto.UserUpdateDto;
import com.rustam.redis_db.model.User;
import com.rustam.redis_db.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @CacheEvict(value = {"users","user_id"},allEntries = true)
    public User save(UserDto userDto) {
        return userRepository.save(userDto.toEntity(userDto));
    }

    @Cacheable(value = "users",key = "#root.methodName",unless = "#result==null")
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @Cacheable(value = "user_id",key = "#root.methodName + #id")
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not exist"));
    }

    @CacheEvict(value = {"users","user_id"},allEntries = true)
    public String delete(Long id) {
        userRepository.deleteById(id);
        return "user deleted";
    }

    public User update(UserUpdateDto userUpdateDto) {
        User user = findById(userUpdateDto.getId());
        user.setPassword(userUpdateDto.getPassword());
        return userRepository.save(user);
    }
}
