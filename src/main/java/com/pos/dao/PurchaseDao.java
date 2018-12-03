package com.pos.dao;

import com.pos.dto.ItemModel;
import com.pos.dto.Purchase;

import java.util.List;

public interface PurchaseDao {

    boolean add(Purchase purchase);
    boolean update(Purchase purchase);
    boolean delete(int id);

    List<Purchase> getAll();
    Purchase get(int id);

    Purchase getPurchaseByInvoiceNo(int invoiceNo);

    List<Purchase> getAllPurchaseByItemModel(ItemModel itemModel);



}
