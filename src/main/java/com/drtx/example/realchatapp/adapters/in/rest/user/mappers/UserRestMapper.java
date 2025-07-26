package com.drtx.example.realchatapp.adapters.in.rest.user.mappers;

import com.drtx.example.realchatapp.adapters.in.rest.user.dto.UserRequest;
import com.drtx.example.realchatapp.adapters.in.rest.user.dto.UserResponse;
import com.drtx.example.realchatapp.core.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRestMapper {
    User toDomain(UserRequest userRequest);
    UserResponse toResponse(User user);
}
