package com.pos.serviceImpl;

import com.pos.dao.UserDao;
import com.pos.dto.User;
import com.pos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean addUser(User user) {
        return userDao.add(user);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.update(user);
    }

    @Override
    public boolean deleteUser(int userId) {
        return userDao.delete(userId);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAll();
    }

    @Override
    public User getUser(int userId) {
        return userDao.get(userId);
    }
}
