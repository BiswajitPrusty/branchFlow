package com.example.blogapp.service;

import com.example.blogapp.dto.PostDto;
import com.example.blogapp.dto.PostResponse;
import com.example.blogapp.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
    PostDto updatePost(PostDto postDto, Integer postId);
    void deletePost(Integer id);
    PostResponse getAllPosts(Pageable pageable);
    PostDto getPostById(Integer id);
    List<PostDto> getPostsByCategory(Integer id);
    List<PostDto> getPostsByUser(Integer id);
    List<PostDto> searchPost(String keyword);

}
