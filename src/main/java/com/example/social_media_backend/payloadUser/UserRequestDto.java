package com.example.social_media_backend.payloadUser;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserRequestDto {
    private String fullName;
    @Column(unique = true)
    private String email;
    private String bio;
}
