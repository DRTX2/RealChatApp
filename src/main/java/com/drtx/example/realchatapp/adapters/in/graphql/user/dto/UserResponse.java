package com.drtx.example.realchatapp.adapters.in.graphql.user.dto;

public record UserResponse(
    String username,
    String userDescription,
    String userAvatar,
    String userEmail) {
}