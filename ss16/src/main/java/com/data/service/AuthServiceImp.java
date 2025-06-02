package com.data.service;

import com.data.repository.AuthRepository;
import com.data.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImp implements AuthService {
    @Autowired
    private AuthRepository authRepository;

    @Override
    public boolean registerUser(User user) {
        return authRepository.registerUser(user);
    }

    @Override
    public boolean login(String username, String password) {
        return authRepository.login(username, password);
    }

    @Override
    public boolean userExists(String username) {
        return authRepository.userExists(username);
    }

    @Override
    public User getUserByUsername(String username) {
        return authRepository.getUserByUsername(username);
    }
}
