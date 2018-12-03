package com.pos.service;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.dao.AbstractDaoImpl;
import com.pos.dao.CustomerDao;
import com.pos.dto.Customer;

import java.util.List;


public interface CustomerService {

	boolean addCustomer(Customer customer);
	boolean updateCustomer(Customer customer);
	boolean deleteCustomer(int id);
	List<Customer> getAllCustomer();
	Customer getCustomer(int id);
	
}
