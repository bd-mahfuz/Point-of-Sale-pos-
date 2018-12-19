package com.pos.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pos.dao.ProductItemDao;
import com.pos.dto.ProductItem;

@Repository("productItemDao")
@Transactional
public class ProductItemDaoImp implements ProductItemDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean add(ProductItem productItem) {
		productItem.setSerialNo(getAll().size() + 1);
		try {
			sessionFactory.getCurrentSession().persist(productItem);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(ProductItem productItem) {
		try {
			sessionFactory.getCurrentSession().update(productItem);
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
				.createQuery("delete from ProductItem where id=:id")
				.setParameter("id", id)
				.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<ProductItem> getAll() {
		try {
			return sessionFactory.getCurrentSession()
				.createQuery("from ProductItem")
				.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ProductItem get(int id) {
		try {
			return sessionFactory.getCurrentSession().get(ProductItem.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
