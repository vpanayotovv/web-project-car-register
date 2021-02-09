package com.project.mobile.service.impl;

import com.project.mobile.models.entity.User;
import com.project.mobile.models.entity.enums.Role;
import com.project.mobile.repository.UserRepository;
import com.project.mobile.security.CurrentUser;
import com.project.mobile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }

    @Override
    public void createUser(User user) {
        userRepository.findByUsername(user.getUsername()).ifPresent(u -> {
            throw new IllegalArgumentException(String.format("User with username '%s' already exists.", user.getUsername()));
        });
        user.setCreated(LocalDateTime.now());
        user.setModified(LocalDateTime.now());
        if (user.getRoles() == null || user.getRoles().size() == 0) {
            user.setRoles(List.of(Role.USER));
        }

        user.setActive(true);
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        this.userRepository.saveAndFlush(user);
    }

    @Override
    public User getUserById(long id) {
        return this.userRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("User not found!"));
    }

    @Override
    public boolean authenticate(String username, String password) {

        Optional<User> user = this.userRepository.findByUsername(username);

        return user.filter(user1 -> passwordEncoder.matches(password, user1.getPassword())).isPresent();
    }

    @Override
    public void loginUser(String username) {
        User user = this.userRepository.findByUsername(username).orElseThrow(() -> new IllegalArgumentException("User not found!"));

        currentUser.setAnonymous(false);
        currentUser.setName(user.getUsername());
        currentUser.setUserRoles(user.getRoles());
    }

    @Override
    public void logoutUser() {
        currentUser.setAnonymous(true);
    }

}
