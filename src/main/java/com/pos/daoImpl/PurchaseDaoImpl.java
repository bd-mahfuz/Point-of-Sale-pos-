package com.pos.daoImpl;

import com.pos.dao.PurchaseDao;
import com.pos.dto.ItemModel;
import com.pos.dto.Purchase;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("purchaseDao")
@Transactional
public class PurchaseDaoImpl implements PurchaseDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public boolean add(Purchase purchase) {
        try {
               sessionFactory.getCurrentSession().persist(purchase);
               return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Purchase purchase) {
        try {
            sessionFactory.getCurrentSession().update(purchase);
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
                    .createQuery("delete from Purchase where id=:id")
                    .setParameter("id", id)
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Purchase> getAll() {
        try {
            return sessionFactory.getCurrentSession()
                    .createQuery("from Purchase")
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Purchase get(int id) {
        try {
            return sessionFactory.getCurrentSession().get(Purchase.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
