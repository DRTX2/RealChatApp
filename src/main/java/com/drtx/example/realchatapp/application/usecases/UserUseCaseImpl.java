package com.drtx.example.realchatapp.application.usecases;

import com.drtx.example.realchatapp.core.models.User;
import com.drtx.example.realchatapp.core.ports.in.UserUseCasePort;
import com.drtx.example.realchatapp.core.ports.out.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserUseCaseImpl implements UserUseCasePort {
    private final UserRepositoryPort userRepositoryPort;

    @Override
    public User create(User user) {
        return userRepositoryPort.create(user);
    }

    @Override
    public User update(Long id, User user) {
        if(userRepositoryPort.findById(id).isEmpty())
        return userRepositoryPort.update(id, user);
    }

    @Override
    public void deleteById(Long id) {
        userRepositoryPort.deleteById(id);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepositoryPort.findById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepositoryPort.findByUsername(username);
    }

    @Override
    public List<User> findAll(){
        return userRepositoryPort.findAll();
    }
}
