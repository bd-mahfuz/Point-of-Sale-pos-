package com.pos.dao;

import com.pos.dto.User;

import java.util.List;

public interface UserDao {
    boolean add(User user);
    boolean update(User user);
    boolean delete(int id);

    List<User> getAll();
    User get(int id);
}
