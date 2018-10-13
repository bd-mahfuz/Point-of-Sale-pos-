package com.pos.serviceImpl;

import com.pos.dao.MacListDao;
import com.pos.dao.PurchaseDao;
import com.pos.dto.ItemModel;
import com.pos.dto.MacList;
import com.pos.dto.Purchase;
import com.pos.service.ItemModelPriceService;
import com.pos.service.ItemModelService;
import com.pos.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseDao purchaseDao;

    @Autowired
    ItemModelService itemModelService;

    @Autowired
    MacListDao macListDao;

    @Autowired
    private ItemModelPriceService itemModelPriceService;

    @Override
    public boolean addPurchase(Purchase purchase) {
        // updating quantity of itemModel
        ItemModel itemModel = itemModelService.getItemModel(purchase.getModel().getId());
        itemModel.setQuantity(itemModel.getQuantity() + purchase.getQuantity());
        boolean isUpdated = itemModelService.updateItemModel(itemModel);


        if (isUpdated) {
            boolean isAdded = purchaseDao.add(purchase);

            if (isAdded) {
                // adding mac list for purchased item model
                int quantity = purchase.getQuantity();
                for (int i = 0; i< quantity; i++) {
                    String mac = "MAC" + UUID.randomUUID().toString().substring(12).toUpperCase();
                    MacList macList = new MacList();
                    macList.setMacId(mac);
                    macList.setItemModel(itemModel);
                    macList.setPurchase(purchase);
                    macListDao.add(macList);
                }
                return true;
            }
            return false;
        }

        return false;
    }

    @Override
    public boolean updatePurchase(Purchase purchase) {
        return purchaseDao.update(purchase);
    }

    @Override
    public boolean deletePurchase(int id) {
        return purchaseDao.delete(id);
    }

    @Override
    public List<Purchase> getAllPurchase() {
        return purchaseDao.getAll();
    }

    @Override
    public Purchase getPurchase(int id) {
        return purchaseDao.get(id);
    }

    @Override
    public double getBuyPriceByItemModel(int modelId) {
        ItemModel itemModel = itemModelService.getItemModel(modelId);
        return itemModelPriceService.getBuyPriceByModel(itemModel);
    }

    @Override
    public double getTotalPurchase(int modelId, int quantity) {
        double buyPrice = getBuyPriceByItemModel(modelId);
        System.out.println(buyPrice * quantity);
        return (buyPrice * quantity);
    }



}
