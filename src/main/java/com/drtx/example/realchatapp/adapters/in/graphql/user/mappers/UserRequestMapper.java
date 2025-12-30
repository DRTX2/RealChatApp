package com.drtx.example.realchatapp.adapters.in.graphql.user.mappers;

import com.drtx.example.realchatapp.adapters.in.graphql.user.dto.UserRequest;
import com.drtx.example.realchatapp.adapters.in.graphql.user.dto.UserResponse;
import com.drtx.example.realchatapp.core.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRequestMapper {
    User toDomain(UserRequest userRequest);

    @org.mapstruct.Mapping(target = "userDescription", source = "description")
    @org.mapstruct.Mapping(target = "userAvatar", source = "avatar")
    @org.mapstruct.Mapping(target = "userEmail", source = "email")
    UserResponse toResponse(User user);
}
