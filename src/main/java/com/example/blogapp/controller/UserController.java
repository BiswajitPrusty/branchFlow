package com.example.blogapp.controller;


import com.example.blogapp.dto.UserDto;
import com.example.blogapp.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody @Validated UserDto userDto) {
        return ResponseEntity.ok(userService.createUser(userDto));
    }
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser( @RequestBody @Validated UserDto userDto, @PathVariable Integer userId) {
        UserDto updatedUser = userService.updateUser(userDto, userId);
        return ResponseEntity.ok(updatedUser);
    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer userId) {
        userService.deleteUserById(userId);
        return new ResponseEntity<>(Map.of("message", "user has been deleted"), HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getAllUsers(@PathVariable Integer userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }
}
