package com.pos.service;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.dao.AbstractDaoImpl;
import com.pos.dao.CustomerDao;
import com.pos.dto.Customer;

@Service
@Transactional
public class CustomerService {
	
	@Autowired
	SessionFactory sessionFactory;
	
}
