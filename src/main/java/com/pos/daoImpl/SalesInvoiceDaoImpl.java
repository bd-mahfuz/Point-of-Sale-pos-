package com.pos.daoImpl;

import com.pos.dao.SalesInvoiceDao;
import com.pos.dto.Purchase;
import com.pos.dto.SalesInvoice;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("salesInvoiceDao")
@Transactional
public class SalesInvoiceDaoImpl implements SalesInvoiceDao{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public boolean add(SalesInvoice salesInvoice) {
        try {
            sessionFactory.getCurrentSession().persist(salesInvoice);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(SalesInvoice salesInvoice) {
        try {
            sessionFactory.getCurrentSession().update(salesInvoice);
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
                    .createQuery("delete from SalesInvoice where id=:id")
                    .setParameter("id", id)
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<SalesInvoice> getAll() {
        try {
            return sessionFactory.getCurrentSession()
                    .createQuery("from SalesInvoice")
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public SalesInvoice get(int id) {
        try {
            return sessionFactory.getCurrentSession().get(SalesInvoice.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
