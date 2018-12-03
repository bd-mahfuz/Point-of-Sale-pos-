package com.pos.service;

import com.pos.dto.ItemModel;
import com.pos.dto.Purchase;

import java.util.List;

public interface PurchaseService {

    boolean addPurchase(Purchase purchase);
    boolean updatePurchase(Purchase purchase);
    boolean deletePurchase(int id);

    List<Purchase> getAllPurchase();
    Purchase getPurchase(int id);

    double getBuyPriceByItemModel(int modelId);
    double getTotalPurchase(int modelId, int quantity);

    //invoiceNo means salesInvoice
    Purchase getPurchaseByInvoiceNo(int invoiceNo);
    List<Purchase> getAllPurchaseByItemModel(ItemModel itemModel);
}
