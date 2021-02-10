package com.project.mobile.service;

import com.project.mobile.models.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    void createUser(User user);

    User getUserById(long id);

    boolean authenticate(String username,String password);

    void loginUser(String username);

    void logoutUser();

    User getUserByName(String username);
}
