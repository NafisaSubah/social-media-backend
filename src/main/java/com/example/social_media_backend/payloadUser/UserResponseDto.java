package com.example.social_media_backend.payloadUser;

import lombok.Data;

@Data
public class UserResponseDto {
    Long id;
    String fullName;
    String email;
    String bio;
}
