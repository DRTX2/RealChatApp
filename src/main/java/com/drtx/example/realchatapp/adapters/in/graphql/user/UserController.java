package com.drtx.example.realchatapp.adapters.in.graphql.user;

import com.drtx.example.realchatapp.adapters.in.graphql.user.dto.UserRequest;
import com.drtx.example.realchatapp.adapters.in.graphql.user.dto.UserResponse;
import com.drtx.example.realchatapp.adapters.in.graphql.user.mappers.UserRequestMapper;
import com.drtx.example.realchatapp.core.models.User;
import com.drtx.example.realchatapp.core.ports.in.UserUseCasePort;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserUseCasePort userUseCasePort;
    private final UserRequestMapper userRequestMapper;

    @MutationMapping
    public UserResponse createUser(@Argument("input") @Valid UserRequest userRequest) {
        User user = userRequestMapper.toDomain(userRequest);
        return userRequestMapper.toResponse(userUseCasePort.create(user));
    }

    @MutationMapping
    public UserResponse updateUser(@Argument Long id, @Argument("input") @Valid UserRequest userRequest) {
        User user = userRequestMapper.toDomain(userRequest);
        return userRequestMapper.toResponse(userUseCasePort.update(id, user));
    }

    @MutationMapping
    public Boolean deleteUser(@Argument Long id) {
        userUseCasePort.deleteById(id);
        return true;
    }

    @QueryMapping
    public UserResponse findUserById(@Argument Long id) {
        User user = userUseCasePort.findById(id)
                .orElseThrow(()->new EntityNotFoundException("User not found with id: " + id));
        return userRequestMapper.toResponse(user);
    }

    @QueryMapping
    public UserResponse findUserByUsername(@Argument String username) {
        User user = userUseCasePort.findByUsername(username)
                .orElseThrow(()->new EntityNotFoundException("User not found with username: " + username));
        return userRequestMapper.toResponse(user);
    }

    @QueryMapping
    public List<UserResponse> findAllUsers() {
        return userUseCasePort.findAll()
                .stream()
                .map(userRequestMapper::toResponse)
                .toList();
    }
}