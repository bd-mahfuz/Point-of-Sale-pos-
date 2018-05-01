package com.pos.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.pos.dto.Customer;

import java.util.List;


public interface CustomerDao {

	boolean add(Customer customer);
	boolean update(Customer customer);
	boolean delete(int id);
	List<Customer> getAll();
	Customer get(int id);
	
}
