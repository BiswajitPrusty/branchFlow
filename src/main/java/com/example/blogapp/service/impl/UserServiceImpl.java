package com.example.blogapp.service.impl;

import com.example.blogapp.dto.UserDto;
import com.example.blogapp.exceptions.ResourceNotFoundException;
import com.example.blogapp.model.User;
import com.example.blogapp.repository.UserRepository;
import com.example.blogapp.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = convertUserDtoToUser(userDto);
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        User save = userRepository.save(user);
        return convertUserToUserDto(save);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        User saved = userRepository.save(convertUserDtoToUser(userDto));
        return convertUserToUserDto(saved);
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        return convertUserToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(this::convertUserToUserDto).collect(Collectors.toList());
    }

    @Override
    public void deleteUserById(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

        userRepository.delete(user);
    }

    private User convertUserDtoToUser(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

    private UserDto convertUserToUserDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }
}
