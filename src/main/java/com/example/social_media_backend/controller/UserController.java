package com.example.social_media_backend.controller;

import com.example.social_media_backend.entity.User;
import com.example.social_media_backend.payloadUser.UserRequestDto;
import com.example.social_media_backend.payloadUser.UserResponseDto;
import com.example.social_media_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto) {
        return userService.createUser(userRequestDto);
    }

    @GetMapping ("/{id}")
    public UserResponseDto getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public UserResponseDto update(@PathVariable Long id, @RequestBody UserRequestDto userRequestDto){
        return userService.updateUser(id,userRequestDto);
    }


}
