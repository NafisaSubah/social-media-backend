package com.example.social_media_backend.payloadUser;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PostRequestDto {
    private String authorName;

    @NotBlank(message = "Content cannot be empty")
    @Size(max = 280, message = "Content should not exceed 280 characters")
    private String content;
}
