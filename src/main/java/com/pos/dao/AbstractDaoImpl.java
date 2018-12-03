package com.pos.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

@Transactional
public class AbstractDaoImpl<T> extends HibernateDaoSupport implements AbstractDao<T>{

	private Class<T> entityClass;
	
	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public AbstractDaoImpl() {
        
		entityClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }
	
	
	@Override
	public List<T> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(T obj) {
		return false;
	}

	@Override
	public boolean update(T obj) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean delete(T obj) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public T get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
