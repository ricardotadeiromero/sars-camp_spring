package com.example.sarscamp_spring.dtos;

import com.example.sarscamp_spring.domain.role.Role;

public record RegisterUserDTO(String username, String password, Role role) {
}