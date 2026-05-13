package com.example.social_media_backend.service;

import com.example.social_media_backend.entity.User;
import com.example.social_media_backend.payloadUser.UserRequestDto;
import com.example.social_media_backend.payloadUser.UserResponseDto;
import com.example.social_media_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User convertToUser(UserRequestDto userRequestDto) {
        User user = new User();
        user.setFullName(userRequestDto.getFullName());
        user.setEmail(userRequestDto.getEmail());
        user.setBio(userRequestDto.getBio());
        return user;
    }

    public UserResponseDto convertToUserResponse(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setFullName(user.getFullName());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setBio(user.getBio());

        return userResponseDto;
    }

    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user = convertToUser(userRequestDto);
        userRepository.save(user);
        return convertToUserResponse(user);
    }

    public UserResponseDto getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if(user == null) {
            return null;
        }
        UserResponseDto userResponseDto=convertToUserResponse(user);
        return userResponseDto ;
    }

    public UserResponseDto updateUser(Long id, UserRequestDto userRequestDto) {
        User user = userRepository.findById(id).orElse(null);
        if(user == null) {
            return null;
        }

        user.setFullName(userRequestDto.getFullName());
        user.setEmail(userRequestDto.getEmail());
        user.setBio(userRequestDto.getBio());
        userRepository.save(user);
        return convertToUserResponse(user);
    }
}
