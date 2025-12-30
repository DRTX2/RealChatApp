package com.drtx.example.realchatapp.adapters.out.persistence.user.mappers;

import com.drtx.example.realchatapp.adapters.out.persistence.user.UserEntity;
import com.drtx.example.realchatapp.core.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {
    @org.mapstruct.Mapping(target = "messages", ignore = true)
    User toDomain(UserEntity entity);

    @org.mapstruct.Mapping(target = "sentMessages", ignore = true)
    @org.mapstruct.Mapping(target = "receivedMessages", ignore = true)
    UserEntity toEntity(User user);
}
