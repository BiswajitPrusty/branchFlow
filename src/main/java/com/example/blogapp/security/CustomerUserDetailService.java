package com.example.blogapp.security;

import com.example.blogapp.exceptions.ResourceNotFoundException;
import com.example.blogapp.model.User;
import com.example.blogapp.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomerUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findByEmail(username).orElseThrow(() -> new ResourceNotFoundException("User", "email : " + username, 0));
    }
}
