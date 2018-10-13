package com.pos.dao;

import java.util.List;

import com.pos.dto.ProductItem;



public interface ProductItemDao {

	public boolean add(ProductItem productItem);
	public boolean update(ProductItem productItem);
	public boolean delete(int id);
	
	public List<ProductItem> getAll();
	public ProductItem get(int id);
}
