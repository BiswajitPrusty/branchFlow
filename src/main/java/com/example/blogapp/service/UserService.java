package com.example.blogapp.service;

import com.example.blogapp.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {

    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto, Integer userId);
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUsers();
    void deleteUserById(Integer userId);
}
