package com.example.social_media_backend.service;

import com.example.social_media_backend.entity.Post;
import com.example.social_media_backend.payloadUser.PostRequestDto;
import com.example.social_media_backend.payloadUser.PostResponseDto;
import com.example.social_media_backend.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public Post convertToPost(PostRequestDto postRequestDto){
        Post post=new Post();
        post.setAuthorName(postRequestDto.getAuthorName());
        post.setContent(postRequestDto.getContent());
        post.setCreatedAt(LocalDateTime.now());
        return post;
    }

    public PostResponseDto convertToPostResponse(Post post){
        PostResponseDto postResponseDto=new PostResponseDto();
        postResponseDto.setId(post.getId());
        postResponseDto.setAuthorName(post.getAuthorName());
        postResponseDto.setContent(post.getContent());
        postResponseDto.setCreatedAt(post.getCreatedAt());
        return postResponseDto;
    }

    public PostResponseDto createPost(PostRequestDto postRequestDto){
        Post post=convertToPost(postRequestDto);
        postRepository.save(post);
        return convertToPostResponse(post);
    }
    public List<PostResponseDto> getPost(){
        List<Post> post=postRepository.findAll();
        return post.stream().map(this::convertToPostResponse).toList();
    }
    public String deletePost(Long id) {

        Post post = postRepository.findById(id).orElse(null);
        if (post == null) {
            return "Post not found";
        }
        postRepository.delete(post);
        return "Post deleted successfully";
    }

}
