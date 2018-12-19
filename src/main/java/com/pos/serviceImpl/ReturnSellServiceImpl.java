package com.pos.serviceImpl;

import com.pos.daoImpl.ReturnSellDaoImpl;
import com.pos.dto.*;
import com.pos.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReturnSellServiceImpl extends ReturnSellDaoImpl implements ReturnSellService {

    @Autowired
    private ItemModelService itemModelService;

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private MacListService macListService;

    @Autowired
    private SalesInvoiceService salesInvoiceService;

    @Override
    public boolean returnSell(SalesInvoice salesInvoice, int returnQuantity) {

        int currentQty = salesInvoice.getAvailableQty();
        salesInvoice.setAvailableQty((currentQty - returnQuantity));
        salesInvoice.setMacLists(null);
        boolean isSellUpdate = salesInvoiceService.updateSalesInvoice(salesInvoice);

        ItemModel itemModel = itemModelService.getItemModel(salesInvoice.getModel().getId());
        //returning the quantity
        itemModel.setQuantity(returnQuantity + itemModel.getQuantity());
        //updating itemModel with quantity
        boolean isUpdated = itemModelService.updateItemModel(itemModel);

        //updating macList table
        List<MacList> macLists = macListService.getAllMacBySalesInvoice(salesInvoice);
        if (itemModel.getModelType().equals("With MAC")) {

            if (macLists.size() > 0) {
                for (int i = 0; i < returnQuantity; i++) {
                    MacList macList = macLists.get(i);

                    // update purchase table also for update available_qty
                    Purchase purchase = macList.getPurchase();
                    purchase.setAvailableQty(purchase.getAvailableQty() + (i+1));
                    purchaseService.updatePurchase(purchase);

                    macList.setSellStatus("Unsold");
                    macList.setSalesInvoice(null);
                    macListService.update(macList);
                }
            }
        }

        // delete the sales invoice
        /*boolean isSellDelete = false;
        boolean isSellUpdate = false;
        if (currentQty == returnQuantity) {
            isSellDelete = deleteSalesInvoice(salesInvoice.getId());
        } else {
            salesInvoice.setQuantity((currentQty - returnQuantity));
            isSellUpdate = updateSalesInvoice(salesInvoice);
        }*/


        // add the return info into sellReturn table
        ReturnSell returnSell = new ReturnSell();
        returnSell.setReturnQty(returnQuantity);
        returnSell.setAvailableQty(currentQty);
        returnSell.setDate(new Date());
        returnSell.setSalesInvoice(salesInvoice);

        boolean isAdded = add(returnSell);



        if (isAdded && isSellUpdate && isUpdated) {
            return true;
        }
        return false;
    }

    @Override
    public boolean returnSell(String macId) {
        MacList macList = macListService.getByMacId(macId);

        // updating itemModel
        ItemModel itemModel = macList.getItemModel();
        itemModel.setQuantity(itemModel.getQuantity() + 1);
        boolean isUpdatedItemModel = itemModelService.updateItemModel(itemModel);

        // updating purchase
        Purchase purchase = macList.getPurchase();
        purchase.setAvailableQty(purchase.getAvailableQty() + 1);
        boolean isPurchaseUpdate = purchaseService.updatePurchase(purchase);


        SalesInvoice salesInvoice = macList.getSalesInvoice();

        // add the return info into sellReturn table
        ReturnSell returnSell = new ReturnSell();
        returnSell.setReturnQty(1);
        returnSell.setAvailableQty(salesInvoice.getAvailableQty());
        returnSell.setDate(new Date());
        returnSell.setSalesInvoice(salesInvoice);

        boolean isAdded = add(returnSell);

        // updating salesInvoice
        salesInvoice.setAvailableQty(salesInvoice.getAvailableQty() + 1);
        boolean isSellUpdate = salesInvoiceService.updateSalesInvoice(salesInvoice);


        macList.setSalesInvoice(null);
        macList.setSellStatus("Unsold");
        boolean isMacUpdate = macListService.update(macList);

        if (isUpdatedItemModel && isPurchaseUpdate && isAdded && isSellUpdate && isMacUpdate) {
            return true;
        }

        return false;

    }
}
