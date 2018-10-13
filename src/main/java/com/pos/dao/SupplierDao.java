package com.pos.dao;

import java.util.List;

import com.pos.dto.Supplier;

public interface SupplierDao {
	
	boolean add(Supplier supplier);
	boolean update(Supplier supplier);
	boolean delete(int id);
	
	List<Supplier> getAll();
	Supplier get(int id);
}
