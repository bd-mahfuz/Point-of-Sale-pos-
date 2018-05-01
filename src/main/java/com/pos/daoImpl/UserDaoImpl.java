package com.pos.daoImpl;

import com.pos.dao.UserDao;
import com.pos.dto.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    SessionFactory sessionFactory;



    @Override
    public boolean add(User user) {
        try {
            sessionFactory.getCurrentSession().save(user);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(User user) {
        try {
            sessionFactory.getCurrentSession().update(user);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            sessionFactory.getCurrentSession()
                    .createQuery("delete from User where Id=:id")
                    .setParameter("id", id)
                    .executeUpdate();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<User> getAll() {
        try {
            return sessionFactory.getCurrentSession()
            .createQuery("from User")
            .list();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User get(int id) {
        try {
            return sessionFactory.getCurrentSession().get(User.class, id);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
