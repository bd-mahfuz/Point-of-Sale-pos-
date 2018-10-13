package com.pos.daoImpl;

import com.pos.dao.ItemModelPriceDao;
import com.pos.dto.ItemModel;
import com.pos.dto.ItemModelPrice;
import com.pos.dto.ProductItem;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("itemModelPriceDao")
@Transactional
public class ItemModelPriceDaoImpl implements ItemModelPriceDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public boolean add(ItemModelPrice itemModelPrice) {
        try {
            sessionFactory.getCurrentSession().persist(itemModelPrice);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(ItemModelPrice itemModelPrice) {
        try {
            sessionFactory.getCurrentSession().update(itemModelPrice);
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
                .createQuery("delete from ItemModelPrice where id=:id")
                .setParameter("id", id)
                .executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ItemModelPrice> getAll() {
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
    public ItemModelPrice get(int id) {
        try {
            return sessionFactory.getCurrentSession().get(ItemModelPrice.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ItemModelPrice> getItemModelPricesByProduct(ProductItem productItem) {
        try {
            return  sessionFactory.getCurrentSession()
                    .createQuery("from ItemModelPrice where productItem=:productItem")
                    .setParameter("productItem", productItem)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ItemModelPrice getItemModelPriceByItemModel(ItemModel itemModel) {
        try {
            List<ItemModelPrice> itemModelPrices = sessionFactory.getCurrentSession()
                    .createQuery("from ItemModelPrice where itemModel=:itemModel")
                    .setParameter("itemModel", itemModel)
                    .list();

            if (itemModelPrices.size() > 0 ) {
                return itemModelPrices.get(0);
            }
            else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public double getBuyPriceByModel(ItemModel itemModel) {
        String sql = "from ItemModelPrice where itemModel =:itemModel";
        try {
            ItemModelPrice itemModelPrice = (ItemModelPrice) sessionFactory.getCurrentSession()
                    .createQuery(sql)
                    .setParameter("itemModel", itemModel)
                    .list().get(0);
            return itemModelPrice.getBuyPrice();
        }catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public double getSellPriceByModel(ItemModel itemModel) {
        String sql = "from ItemModelPrice where itemModel =:itemModel";
        try {
            ItemModelPrice itemModelPrice = (ItemModelPrice) sessionFactory.getCurrentSession()
                    .createQuery(sql)
                    .setParameter("itemModel", itemModel)
                    .list().get(0);
            return itemModelPrice.getSellPrice();
        }catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
