package com.pos.daoImpl;

import com.pos.dao.ReturnSellDao;
import com.pos.dto.ReturnSell;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("returnSellDao")
@Transactional
public class ReturnSellDaoImpl implements ReturnSellDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean add(ReturnSell returnSell) {
        try{

            sessionFactory.getCurrentSession()
                    .save(returnSell);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(ReturnSell returnSell) {
        try{

            sessionFactory.getCurrentSession()
                    .update(returnSell);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String hql = "delete from ReturnSell where id = :id";
        try{

            sessionFactory.getCurrentSession()
                    .createQuery(hql)
                    .setParameter("id", id)
                    .executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ReturnSell> getAll() {
        String hql = "from ReturnSell";
        try{
            return sessionFactory.getCurrentSession()
                    .createQuery(hql)
                    .list();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ReturnSell get(int id) {
        String hql = "from ReturnSell where id = :id";
        try{
            List<ReturnSell> returnSells =  sessionFactory.getCurrentSession()
                    .createQuery(hql)
                    .list();

            if (returnSells.size() > 0){
                return returnSells.get(0);
            }
            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
