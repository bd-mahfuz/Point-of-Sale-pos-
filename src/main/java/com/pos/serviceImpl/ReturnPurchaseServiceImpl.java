package com.pos.serviceImpl;

import com.pos.daoImpl.ReturnPurchaseDaoImpl;
import com.pos.dto.ItemModel;
import com.pos.dto.MacList;
import com.pos.dto.Purchase;
import com.pos.service.ItemModelService;
import com.pos.service.MacListService;
import com.pos.service.PurchaseService;
import com.pos.service.ReturnPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturnPurchaseServiceImpl extends ReturnPurchaseDaoImpl implements ReturnPurchaseService {

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private ItemModelService itemModelService;

    @Autowired
    private MacListService macListService;

    @Override
    public boolean returnPurchase(Purchase purchase, int returnQty) {
        ItemModel itemModel = itemModelService.getItemModel(purchase.getModel().getId());


        // updating item model
        itemModel.setQuantity(itemModel.getQuantity() - returnQty);
        boolean isUpdateItemModel = itemModelService.updateItemModel(itemModel);
        System.out.println(isUpdateItemModel);


        // updating purchase table with availableQty
        purchase.setAvailableQty(purchase.getAvailableQty() - returnQty);
        boolean isPurchaseUpdate = purchaseService.updatePurchase(purchase);


        // deleting macList with unsoldMac and purchase
        if (purchase.getModel().getModelType().equals("With MAC")) {

            List<MacList> macLists = macListService.getAllUnsoldMavByPurchase(purchase);

            for (int i = 0; i < returnQty; i++) {
                macListService.delete(macLists.get(i).getId());
            }
        }

        if (isPurchaseUpdate && isUpdateItemModel) {
            return true;
        }
        return false;
    }
}
