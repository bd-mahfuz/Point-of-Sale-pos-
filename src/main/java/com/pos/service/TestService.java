package com.pos.service;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.dao.TestDao;
import com.pos.dto.Test;

@Service
@Transactional
public class TestService implements TestDao{

	@Autowired
	SessionFactory sessionfactory;

	
	@Override
	public boolean add(Test t) {
		try {
			sessionfactory.getCurrentSession().save(t);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
//	
	
}
