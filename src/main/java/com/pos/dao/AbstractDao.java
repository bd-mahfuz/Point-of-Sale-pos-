package com.pos.dao;

import java.util.List;

public interface AbstractDao<T> {
	
    public List<T> getAll();
    
    public boolean save(T obj);
         
    public boolean update(T obj);
         
    public boolean delete(T obj);
     
    public T get(int id);
}
