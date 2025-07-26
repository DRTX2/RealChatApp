package com.drtx.example.realchatapp.core.ports.out;

import com.drtx.example.realchatapp.core.models.User;

public interface UserRepositoryPort {
    User create(User user);
    User update(User user);
    void deleteById(Long id);
    User findById(Long id);
    User findByUsername(String username);
}
