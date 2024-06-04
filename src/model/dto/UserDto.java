package model.dto;

public record UserDto(
        Integer userId,
        String userName,
        String email
) { }
