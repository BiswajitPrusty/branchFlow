 package com.example.blogapp.service;


 import com.example.blogapp.dto.CommentDto;

 public interface CommentService {

     CommentDto createComment(CommentDto commentDto , Integer postId);

     void deleteComment(Integer commentId);

 }
