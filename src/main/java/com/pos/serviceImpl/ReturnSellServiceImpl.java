package com.pos.serviceImpl;

import com.pos.dao.ReturnSellDao;
import com.pos.dao.SalesInvoiceDao;
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
    private SalesInvoiceDao salesInvoiceDao;

    @Override
    public boolean returnSell(SalesInvoice salesInvoice, int returnQuantity) {

        int currentQty = salesInvoice.getAvailableQty();
        salesInvoice.setAvailableQty((currentQty - returnQuantity));
        salesInvoice.setMacLists(null);
        boolean isSellUpdate = salesInvoiceDao.update(salesInvoice);

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

}
