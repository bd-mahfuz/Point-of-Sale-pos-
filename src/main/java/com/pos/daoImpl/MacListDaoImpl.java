package com.pos.daoImpl;

import com.pos.dao.MacListDao;
import com.pos.dto.ItemModel;
import com.pos.dto.ItemModelPrice;
import com.pos.dto.MacList;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("macListDao")
@Transactional
public class MacListDaoImpl implements MacListDao{

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public boolean add(MacList macList) {
        try {
            sessionFactory.getCurrentSession().persist(macList);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(MacList macList) {
        try {
            sessionFactory.getCurrentSession().update(macList);
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
                    .createQuery("delete from MacList where id=:id")
                    .setParameter("id", id)
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<MacList> getAll() {
        try {
            return sessionFactory.getCurrentSession()
                    .createQuery("from ItemModelPrice")
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public MacList get(int id) {
        try {
            return sessionFactory.getCurrentSession().get(MacList.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<MacList> getAllMacByItemModel(ItemModel itemModel) {
        try {
            return sessionFactory.getCurrentSession()
                    .createQuery("from MacList where itemModel = :itemModel")
                    .setParameter("itemModel", itemModel)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteByItemModel(ItemModel itemModel) {
        try {
            sessionFactory.getCurrentSession()
                    .createQuery("delete from MacList where itemModel=:itemModel")
                    .setParameter("itemModel", itemModel)
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<MacList> getAllUnSoldMacByItemModel(ItemModel itemModel) {
        try {
            return  sessionFactory.getCurrentSession()
                    .createQuery("from MacList where itemModel=:itemModel and sellStatus =:sellStatus")
                    .setParameter("itemModel", itemModel)
                    .setParameter("sellStatus", "Unsold")
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
