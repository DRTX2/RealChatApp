package com.drtx.example.realchatapp.adapters.in.rest.user;

import com.drtx.example.realchatapp.adapters.in.rest.user.dto.UserRequest;
import com.drtx.example.realchatapp.adapters.in.rest.user.dto.UserResponse;
import com.drtx.example.realchatapp.adapters.in.rest.user.mappers.UserRestMapper;
import com.drtx.example.realchatapp.core.models.User;
import com.drtx.example.realchatapp.core.ports.in.UserUseCasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserUseCasePort userUseCasePort;
    private final UserRestMapper userRestMapper;

    @PostMapping
    public ResponseEntity<UserResponse> create(UserRequest userRequest) {
        User user = userRestMapper.toDomain(userRequest);
        UserResponse userResponse=userRestMapper.toResponse(userUseCasePort.create(user));
        return ResponseEntity.ok(userResponse );
    }

    @PatchMapping
    public ResponseEntity<UserResponse> update(UserRequest userRequest) {
        User user = userRestMapper.toDomain(userRequest);
        UserResponse userResponse=userRestMapper.toResponse(userUseCasePort.update(user));
        return ResponseEntity.ok(userResponse );
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteById(Long id) {
        userUseCasePort.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(Long id) {
        UserResponse userResponse=userRestMapper.toResponse(userUseCasePort.findById(id));
        return ResponseEntity.ok(userResponse );
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserResponse> findByUsername(String username) {
        UserResponse userResponse=userRestMapper.toResponse(userUseCasePort.findByUsername(username));
        return ResponseEntity.ok(userResponse );
    }
}
