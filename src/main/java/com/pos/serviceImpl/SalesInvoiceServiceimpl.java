package com.pos.serviceImpl;

import com.pos.dao.SalesInvoiceDao;
import com.pos.dto.ItemModel;
import com.pos.dto.MacList;
import com.pos.dto.Purchase;
import com.pos.dto.SalesInvoice;
import com.pos.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesInvoiceServiceimpl implements SalesInvoiceService {

    @Autowired
    ItemModelService itemModelService;

    @Autowired
    private SalesInvoiceDao salesInvoiceDao;

    @Autowired
    private ItemModelPriceService itemModelPriceService;

    @Autowired
    private MacListService macListService;

    @Autowired
    private PurchaseService purchaseService;

    @Override
    public boolean addSalesInvoice(SalesInvoice salesInvoice) {
        // updating quantity of itemModel
        ItemModel itemModel = itemModelService.getItemModel(salesInvoice.getModel().getId());
        itemModel.setQuantity(itemModel.getQuantity()-salesInvoice.getQuantity());
        boolean isUpdated = itemModelService.updateItemModel(itemModel);

        //System.out.println("sales invoice:"+ salesInvoice.getMacLists().get(0).getMacId());

        int qty = salesInvoice.getQuantity();

        if (isUpdated) {
            boolean isAdded =  salesInvoiceDao.add(salesInvoice);

            if (isAdded&& (!itemModel.getModelType().equals("Non MAC"))) {
                List<MacList> macLists = macListService.getAllUnSoldMacByItemModel(itemModel);
                for (int i = 0; i < qty; i++) {
                    MacList macList = macLists.get(i);
                    macList.setSellStatus("Sold");
                    macList.setSalesInvoice(salesInvoice);
                    macListService.update(macList);

                    // also update purchase table for availableQty
                    Purchase purchase = purchaseService.getPurchase(macList.getPurchase().getId());
                    purchase.setAvailableQty(purchase.getAvailableQty() - (i+1));
                    purchaseService.updatePurchase(purchase);
                }
            }
            return isAdded;
        }

        return false;
    }

    @Override
    public boolean addSalesInvoice(SalesInvoice salesInvoice, List<String> macIds) {
        // updating quantity of itemModel
        ItemModel itemModel = itemModelService.getItemModel(salesInvoice.getModel().getId());
        itemModel.setQuantity(itemModel.getQuantity()-salesInvoice.getQuantity());
        boolean isUpdated = itemModelService.updateItemModel(itemModel);

        //System.out.println("sales invoice:"+ salesInvoice.getMacLists().get(0).getMacId());

        //int qty = salesInvoice.getQuantity();

        if (isUpdated) {
            boolean isAdded =  salesInvoiceDao.add(salesInvoice);

            if (isAdded&& (!itemModel.getModelType().equals("Non MAC"))) {
                for (int i = 0; i < macIds.size(); i++) {

                    MacList macList = macListService.getByMacId(macIds.get(i));
                    macList.setSellStatus("Sold");
                    macList.setSalesInvoice(salesInvoice);
                    macListService.update(macList);
                }
            }
            return isAdded;
        }

        return false;
    }

    @Override
    public boolean updateSalesInvoice(SalesInvoice salesInvoice) {
        return salesInvoiceDao.update(salesInvoice);
    }

    @Override
    public boolean deleteSalesInvoice(int id) {
        return salesInvoiceDao.delete(id);
    }

    @Override
    public List<SalesInvoice> getAllSalesInvoice() {
        return salesInvoiceDao.getAll();
    }

    @Override
    public SalesInvoice getSalesInvoice(int id) {
        return salesInvoiceDao.get(id);
    }

    @Override
    public double getSellPriceByItemModel(int modelId) {
        ItemModel itemModel = itemModelService.getItemModel(modelId);
        return itemModelPriceService.getBuyPriceByModel(itemModel);
    }

    @Override
    public double getTotalSellByQty(int modelId, int quantity) {
        double buyPrice = getSellPriceByItemModel(modelId);
        System.out.println(buyPrice * quantity);
        return (buyPrice * quantity);
    }

    @Override
    public SalesInvoice getSalesInvoiceByInvoiceNo(int sellInvoiceNo) {
        return salesInvoiceDao.getSalesInvoiceByInvoiceNo(sellInvoiceNo);
    }

}
