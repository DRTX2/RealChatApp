package com.drtx.example.realchatapp.adapters.in.rest.user.dto;

public record UserResponse(
    String username,
    String userDescription,
    String userAvatar,
    String userEmail) {
}