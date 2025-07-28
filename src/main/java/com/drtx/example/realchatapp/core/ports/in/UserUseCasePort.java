package com.drtx.example.realchatapp.core.ports.in;

import com.drtx.example.realchatapp.core.models.User;

import java.util.List;
import java.util.Optional;

public interface UserUseCasePort {
    List<User> findAll();
    User create(User user);
    User update(Long id, User user);
    void deleteById(Long id);
    Optional<User> findById(Long id);
    Optional<User> findByUsername(String username);
}
