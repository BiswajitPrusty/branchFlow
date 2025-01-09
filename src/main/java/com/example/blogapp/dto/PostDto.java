package com.example.blogapp.dto;

import com.example.blogapp.model.Category;
import com.example.blogapp.model.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
public class PostDto {
    private Integer id;
    private String title;
    private String content;
    private String imageName;
    private Date postDate;
    private CategoryDto category;
    private UserDto user;
}
