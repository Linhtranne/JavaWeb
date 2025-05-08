package com.ss3.ss3;

import com.ss3.ss3.User;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users = new ArrayList<>();
    private int nextId = 1;

    public void addUser(User user) {
        user.setId(nextId++);
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public void removeUser(int id) {
        users.removeIf(user -> user.getId() == id);
    }
}