package com.example.prj1.controller;

import com.example.prj1.common.response.ApiResponse;
import com.example.prj1.entity.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/protected")
    public ApiResponse<Map<String, Object>> protectedRoute(@AuthenticationPrincipal User user) {
        Map<String, Object> data = new HashMap<>();
        data.put("message", "This is protected data!");
        data.put("username", user.getUsername());
        data.put("displayName", user.getDisplayName());
        data.put("timestamp", System.currentTimeMillis());
        return ApiResponse.success(data);
    }

    @GetMapping("/public")
    public ApiResponse<String> publicRoute() {
        return ApiResponse.success("This is public data!");
    }
}