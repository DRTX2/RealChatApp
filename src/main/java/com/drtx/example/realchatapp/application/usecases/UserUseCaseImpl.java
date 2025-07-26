package com.drtx.example.realchatapp.application.usecases;

import com.drtx.example.realchatapp.core.models.User;
import com.drtx.example.realchatapp.core.ports.in.UserUseCasePort;
import com.drtx.example.realchatapp.core.ports.out.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserUseCaseImpl implements UserUseCasePort {
    private final UserRepositoryPort userRepositoryPort;

    @Override
    public User create(User user) {
        return userRepositoryPort.create(user);
    }

    @Override
    public User update(User user) {
        return userRepositoryPort.update(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepositoryPort.deleteById(id);
    }

    @Override
    public User findById(Long id) {
        return userRepositoryPort.findById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepositoryPort.findByUsername(username);
    }
}
