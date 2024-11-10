package com.example.prj1.dto;

import com.example.prj1.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * DTO for {@link com.example.prj1.entity.User}
 */
@Getter
@AllArgsConstructor
public class UserDto implements Serializable {
    private final UUID id;
    private final String username;
    private final String displayName;

    public static UserDto fromEntity(User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getDisplayName()
        );
    }

    public static List<UserDto> fromListEntity(List<User> users) {
        return users.stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }
}