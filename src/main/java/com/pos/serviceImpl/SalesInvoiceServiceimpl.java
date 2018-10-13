package com.pos.serviceImpl;

import com.pos.dao.SalesInvoiceDao;
import com.pos.dto.ItemModel;
import com.pos.dto.MacList;
import com.pos.dto.SalesInvoice;
import com.pos.service.ItemModelPriceService;
import com.pos.service.ItemModelService;
import com.pos.service.MacListService;
import com.pos.service.SalesInvoiceService;
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

    @Override
    public boolean addSalesInvoice(SalesInvoice salesInvoice) {
        // updating quantity of itemModel
        ItemModel itemModel = itemModelService.getItemModel(salesInvoice.getModel().getId());
        itemModel.setQuantity(itemModel.getQuantity()-salesInvoice.getQuantity());
        boolean isUpdated = itemModelService.updateItemModel(itemModel);

        int qty = salesInvoice.getQuantity();

        if (isUpdated) {
            boolean isAdded =  salesInvoiceDao.add(salesInvoice);

            if (isAdded) {
                List<MacList> macLists = macListService.getAllUnSoldMacByItemModel(itemModel);
                for (int i = 0; i < qty; i++) {
                    MacList macList = macLists.get(i);
                    macList.setSellStatus("Sold");
                    macList.setSalesInvoice(salesInvoice);

                    macListService.update(macList);
                }
            }
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
}
