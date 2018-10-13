package com.pos.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.pos.dao.SupplierDao;
import com.pos.dto.Supplier;

@Repository("supplierDao")
@Transactional
public class SupplierDaoImpl implements SupplierDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean add(Supplier supplier) {
		try{
			sessionFactory.getCurrentSession().persist(supplier);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Supplier supplier) {
		try{
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(int id) {
		try{
			//sessionFactory.getCurrentSession().delete(supplier);
			sessionFactory.getCurrentSession().createQuery("delete from Supplier where id=:id")
				.setParameter("id", id)
				.executeUpdate();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Supplier> getAll() {
		try {
			return sessionFactory.getCurrentSession().createQuery("From Supplier").list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Supplier get(int id) {
		try{
			return sessionFactory.getCurrentSession()
					.get(Supplier.class, id);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
