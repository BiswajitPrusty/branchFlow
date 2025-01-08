package com.example.blogapp.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserDto {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String about;
}
