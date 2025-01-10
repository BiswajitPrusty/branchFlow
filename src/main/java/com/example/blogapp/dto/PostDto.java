package com.example.blogapp.dto;


import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PostDto {
    private Integer id;
    private String title;
    private String content;
    private String imageName;
    private Date postDate;
    private CategoryDto category;
    private UserDto user;
    private List<CommentDto> comments;

}
