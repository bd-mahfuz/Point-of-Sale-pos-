package com.pos.dao;

import com.pos.dto.ReturnPurchase;

import java.util.List;

public interface ReturnPurchaseDao {

    boolean get(int id);
    boolean update(ReturnPurchase returnPurchase);
    boolean add(ReturnPurchase returnPurchase);
    boolean delete(int id);

    List<ReturnPurchase> getAllReturnPurchase();


}
