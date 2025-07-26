package com.drtx.example.realchatapp.adapters.out.persistence.user.mappers;

import com.drtx.example.realchatapp.adapters.out.persistence.user.UserEntity;
import com.drtx.example.realchatapp.core.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {
    User toDomain(UserEntity entity);
    UserEntity toEntity(User user);
}
