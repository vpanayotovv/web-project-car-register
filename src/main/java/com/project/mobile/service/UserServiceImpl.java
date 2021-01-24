package com.project.mobile.service;

import com.project.mobile.models.entity.User;
import com.project.mobile.models.entity.enums.Role;
import com.project.mobile.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(User user) {
        userRepository.findByUsername(user.getUsername()).ifPresent(u -> {
            throw new IllegalArgumentException(String.format("User with username '%s' already exists.", user.getUsername()));
        });
        user.setCreated(LocalDateTime.now());
        user.setModified(LocalDateTime.now());
        if (user.getRoles() == null || user.getRoles().size() == 0) {
            user.setRoles(Set.of(Role.USER));
        }

        user.setActive(true);
        this.userRepository.saveAndFlush(user);
    }
}
