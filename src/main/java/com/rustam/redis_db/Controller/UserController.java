package com.rustam.redis_db.Controller;

import com.rustam.redis_db.dto.UserDto;
import com.rustam.redis_db.dto.UserUpdateDto;
import com.rustam.redis_db.model.User;
import com.rustam.redis_db.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(path = "/save")
    public ResponseEntity<User> save(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.save(userDto));
    }

    @GetMapping(path = "/read-list")
    public ResponseEntity<List<User>> read(){
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<User> readById(@PathVariable Long id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @PutMapping(path = "/update")
    public ResponseEntity<User> update(@RequestBody UserUpdateDto userUpdateDto){
        return ResponseEntity.ok(userService.update(userUpdateDto));
    }

    @DeleteMapping(path = "/{id}")
    public String delete(@PathVariable Long id){
        return userService.delete(id);
    }
}
