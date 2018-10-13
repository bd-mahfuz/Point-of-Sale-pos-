package com.pos.daoImpl;

import com.pos.dao.CustomerDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.pos.dto.Customer;

import javax.transaction.Transactional;
import java.util.List;

@Repository("customerDao")
@Transactional
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public boolean add(Customer customer) {
        try{
            sessionFactory.getCurrentSession().persist(customer);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Customer customer) {
        try{
            sessionFactory.getCurrentSession().update(customer);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try{
            sessionFactory.getCurrentSession()
                            .createQuery("delete from Customer where id=:id")
                                .setParameter("id", id)
                                    .executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Customer> getAll() {
        try{
            return sessionFactory.getCurrentSession()
                    .createQuery("From Customer").list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Customer get(int id) {
        try{
            return sessionFactory.getCurrentSession().get(Customer.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
