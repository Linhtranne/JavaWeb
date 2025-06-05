package com.data.service;

import com.data.entity.User;
import com.data.repository.UserRepository;

import java.util.List;

public interface UserService {

    List<User> getUsers(int page, int size);

    void changeUserStatus(Long userId, boolean isActive);

    long getTotalUsers();
}
