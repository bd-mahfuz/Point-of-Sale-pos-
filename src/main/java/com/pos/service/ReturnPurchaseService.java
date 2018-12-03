package com.pos.service;

import com.pos.dao.ReturnPurchaseDao;
import com.pos.dto.Purchase;

public interface ReturnPurchaseService extends ReturnPurchaseDao{

    boolean returnPurchase(Purchase purchase, int returnQty);




}
