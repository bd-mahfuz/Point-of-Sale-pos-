package com.pos.dao;

import com.pos.dto.Purchase;
import com.pos.dto.ReturnSell;

import java.util.List;

public interface ReturnSellDao {

    boolean add(ReturnSell returnSell);
    boolean update(ReturnSell returnSell);
    boolean delete(int id);

    List<ReturnSell> getAll();
    ReturnSell get(int id);

}
