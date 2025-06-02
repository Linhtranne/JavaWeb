package com.data.repository;

import com.data.model.User;

public interface AuthRepository {
    boolean registerUser(User user);
    boolean login(String username, String password);
    boolean userExists(String username);
    User getUserByUsername(String username);
}
