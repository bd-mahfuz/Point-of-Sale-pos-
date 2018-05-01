package com.pos.service;

import com.pos.dto.User;

import java.util.List;

public interface UserService {
    boolean addUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(int userId);

    List<User> getAllUser();
    User getUser(int userId);
}
