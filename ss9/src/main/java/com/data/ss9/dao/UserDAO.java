package com.data.ss9.dao;

import com.data.ss9.model.User;

public interface UserDAO {
    User findUserByUsernameAndPassword(String username, String password);
    void addUser(User user);
}
