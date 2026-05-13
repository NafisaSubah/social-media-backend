package com.example.social_media_backend.controller;

import com.example.social_media_backend.entity.Post;
import com.example.social_media_backend.payloadUser.PostRequestDto;
import com.example.social_media_backend.payloadUser.PostResponseDto;
import com.example.social_media_backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/posts")
@RestController
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping
    public PostResponseDto createPost(@RequestBody PostRequestDto postRequestDto){
        return  postService.createPost(postRequestDto);
    }
    @GetMapping
    public List<PostResponseDto> getAllPost(){
        return postService.getPost();
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable Long id) {
        return postService.deletePost(id);
    }

}
