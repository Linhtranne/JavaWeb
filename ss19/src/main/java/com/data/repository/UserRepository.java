package com.data.repository;

import com.data.entity.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll(int page, int size);

    void updateUserStatus(Long userId, boolean isActive);

    long countUsers();
}
