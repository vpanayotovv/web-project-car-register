package com.project.mobile.service;

import com.project.mobile.models.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void createUser(User user);

    User getUserById(long id);

    boolean authenticate(String username,String password);

    void loginUser(String username);

    void logoutUser();
}
