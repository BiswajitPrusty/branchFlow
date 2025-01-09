package com.example.blogapp.controller;

import com.example.blogapp.dto.ApiResponse;
import com.example.blogapp.dto.PostDto;
import com.example.blogapp.dto.PostResponse;
import com.example.blogapp.model.Post;
import com.example.blogapp.service.PostService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class PostController {

    private PostService postService;

    @PostMapping("/user/{userId}/category/{categoryId}")
    public ResponseEntity<PostDto> createPost(PostDto postDto, @PathVariable Integer userId, @PathVariable Integer categoryId) {
        return ResponseEntity.ok(postService.createPost(postDto, userId, categoryId));
    }

    @PostMapping("/posts/{postId}")
    public ResponseEntity<PostDto> updatePost(PostDto postDto, @PathVariable Integer postId) {
        return ResponseEntity.ok(postService.updatePost(postDto, postId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PostDto>> getPosts(@PathVariable Integer userId) {
        return ResponseEntity.ok(postService.getPostsByUser(userId));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId) {
        return ResponseEntity.ok(postService.getPostsByCategory(categoryId));
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPost(@PathVariable Integer postId) {
        return ResponseEntity.ok(postService.getPostById(postId));
    }

    @GetMapping("/posts")
    public ResponseEntity<PostResponse> getAllPosts(Pageable pageable) {
        return ResponseEntity.ok(postService.getAllPosts(pageable));
    }

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<ApiResponse> deletePosts(@PathVariable Integer postId) {
        postService.deletePost(postId);
        return new ResponseEntity<>(new ApiResponse("Post has been deleted", true), HttpStatus.OK);
    }

    @GetMapping("/posts/search/{keyword}")
    public ResponseEntity<List<PostDto>> searchPostByTitle(@PathVariable String keyword) {
        return ResponseEntity.ok(postService.searchPost(keyword));
    }


}
