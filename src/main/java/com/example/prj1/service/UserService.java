package com.example.prj1.service;

import com.example.prj1.dto.UserDto;
import com.example.prj1.entity.User;
import com.example.prj1.repository.UserRepository;
import com.example.prj1.request.CreateUserRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return UserDto.fromListEntity(users);
    }

    public UserDto createUser(CreateUserRequest createUserRequest) {
        User user = new User();
        user.setUsername(createUserRequest.getUsername());
        user.setPassword(passwordEncoder.encode(createUserRequest.getPassword()));
        user.setDisplayName(createUserRequest.getDisplayName());
        User savedUser = userRepository.save(user);
        return UserDto.fromEntity(savedUser);
    }
}
