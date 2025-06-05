package com.data.service;

import com.data.entity.User;
import com.data.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public List<User> getUsers(int page, int size) {
        return userRepository.findAll(page, size);
    }
    @Override
    public void changeUserStatus(Long userId, boolean isActive) {
        userRepository.updateUserStatus(userId, isActive);
    }
    @Override
    public long getTotalUsers() {
        return userRepository.countUsers();
    }
}