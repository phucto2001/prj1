package com.example.prj1.controller;

import com.example.prj1.common.response.ApiResponse;
import com.example.prj1.dto.UserDto;
import com.example.prj1.request.CreateUserRequest;
import com.example.prj1.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ApiResponse<List<UserDto>> getUsers() {
        List<UserDto> userDtos = userService.getAllUsers();
        return ApiResponse.success(userDtos);
    }

    @PostMapping("/")
    @Operation(
            summary = "Create new user",
            description = "Creates a new user with the provided information"
    )
    public ApiResponse<UserDto> createUser(@Valid @RequestBody CreateUserRequest createUserRequest) {
        UserDto userDto = userService.createUser(createUserRequest);
        return ApiResponse.success(userDto);
    }
}
