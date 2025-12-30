package com.drtx.example.realchatapp.adapters.out.persistence.user;

import com.drtx.example.realchatapp.adapters.out.persistence.user.mappers.UserEntityMapper;
import com.drtx.example.realchatapp.core.models.User;
import com.drtx.example.realchatapp.core.ports.out.UserRepositoryPort;
import com.drtx.example.realchatapp.adapters.out.persistence.user.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserRepositoryPort {
    private final UserRepository userRepository;
    private final UserEntityMapper mapper;

    @Override
    public List<User> findAll() {
        return userRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public User create(User user) {
        UserEntity savedEntity = userRepository.save(mapper.toEntity(user));
        return mapper.toDomain(savedEntity);
    }

    @Override
    public User update(Long id, User user) {
        UserEntity savedEntity = userRepository.save(mapper.toEntity(user));
        return mapper.toDomain(savedEntity);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(mapper::toDomain);
    }
}

