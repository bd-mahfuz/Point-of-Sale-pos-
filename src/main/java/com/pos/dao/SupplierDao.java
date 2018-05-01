package com.pos.dao;

import java.util.List;

import com.pos.dto.Supplier;

public interface SupplierDao {
	
	public boolean add(Supplier supplier);
	public boolean update(Supplier supplier);
	public boolean delete(int id);
	
	public List<Supplier> getAll();
	public Supplier get(int id);
}
