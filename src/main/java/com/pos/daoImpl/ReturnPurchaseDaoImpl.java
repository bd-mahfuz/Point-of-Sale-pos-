package com.pos.daoImpl;

import com.pos.dao.ReturnPurchaseDao;
import com.pos.dto.ReturnPurchase;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("returnPurchaseDao")
@Transactional
public class ReturnPurchaseDaoImpl implements ReturnPurchaseDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean get(int id) {
        try {
            sessionFactory.getCurrentSession().get(ReturnPurchase.class, id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(ReturnPurchase returnPurchase) {
        try {
            sessionFactory.getCurrentSession().update(returnPurchase);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean add(ReturnPurchase returnPurchase) {
        try {
            sessionFactory.getCurrentSession().persist(returnPurchase);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            sessionFactory.getCurrentSession()
                .createQuery("delete from ReturnPurchase where id=:id")
                .setParameter("id", id)
                .executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ReturnPurchase> getAllReturnPurchase() {
        String hql = "from ReturnPurchase";
        try {
            return sessionFactory.getCurrentSession()
                    .createQuery(hql)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
