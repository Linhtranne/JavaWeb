package com.data.service;

import com.data.model.User;

public interface AuthService {
    boolean registerUser(User user);
    boolean login(String username, String password);
    boolean userExists(String username);
    User getUserByUsername(String username);

}
