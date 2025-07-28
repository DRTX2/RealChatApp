package com.drtx.example.realchatapp.adapters.in.graphql.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequest(
        @NotBlank String username,
        String description,
        String avatar,
        @Email String email,
        @Size(min = 8,max = 30) String password
        ) {
}
