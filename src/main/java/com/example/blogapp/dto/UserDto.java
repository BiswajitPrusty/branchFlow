package com.example.blogapp.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@AllArgsConstructor
public class UserDto {
    private Integer id;
    @NotBlank
    @Size(min = 3, message = "Username must be min of 4 character!!")
    private String name;
    @Email(message = "Email is not valid")
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String about;
}
