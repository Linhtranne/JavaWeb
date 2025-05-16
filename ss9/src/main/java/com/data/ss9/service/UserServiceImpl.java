package com.data.ss9.service;

import com.data.ss9.dao.UserDAO;
import com.data.ss9.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User login(String username, String password) {
        return userDAO.findUserByUsernameAndPassword(username, password);
    }

    @Override
    public void register(User user) {
        userDAO.addUser(user);
    }
}
