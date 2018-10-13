package com.pos.daoImpl;

import com.pos.dao.ItemModelDao;
import com.pos.dto.ItemModel;
import com.pos.dto.ProductItem;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("itemModelDao")
@Transactional
public class ItemModelDaoImpl implements ItemModelDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public boolean add(ItemModel itemModel) {
        try {
            sessionFactory.getCurrentSession().persist(itemModel);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(ItemModel itemModel) {
        try {
            sessionFactory.getCurrentSession().update(itemModel);
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
                .createQuery("delete from ItemModel where id=:id")
                .setParameter("id", id)
                .executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ItemModel> getAll() {
        try {
            return sessionFactory.getCurrentSession()
            .createQuery("from ItemModel")
            .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ItemModel get(int id) {
        try {
            return sessionFactory.getCurrentSession().get(ItemModel.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ItemModel> getByProduct(ProductItem productItem) {
        try {
            return sessionFactory.getCurrentSession()
                    .createQuery("from ItemModel where productItem=:productItem")
                    .setParameter("productItem", productItem)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int getQuantity(int itemModelId) {
        String sql = "select quantity from ItemModel where id=:id";
        try {
            return (int) sessionFactory.getCurrentSession()
                    .createQuery(sql)
                    .setParameter("id", itemModelId)
                    .list().get(0);
        }catch (Exception e) {
            e.printStackTrace();;
            return 0;
        }
    }
}
