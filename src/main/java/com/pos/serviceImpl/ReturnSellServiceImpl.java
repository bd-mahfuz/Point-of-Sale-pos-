package com.pos.serviceImpl;

import com.pos.dao.ReturnSellDao;
import com.pos.daoImpl.ReturnSellDaoImpl;
import com.pos.dto.ItemModel;
import com.pos.dto.MacList;
import com.pos.dto.SalesInvoice;
import com.pos.service.ItemModelService;
import com.pos.service.MacListService;
import com.pos.service.ReturnSellService;
import com.pos.service.SalesInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturnSellServiceImpl extends ReturnSellDaoImpl implements ReturnSellService {

    @Autowired
    private ItemModelService itemModelService;

    @Autowired
    private MacListService macListService;

    @Autowired
    private SalesInvoiceService salesInvoiceService;

    @Override
    public boolean returnSell(SalesInvoice salesInvoice, int returnQuantity) {

        int currentQty = salesInvoice.getAvailableQty();
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

        salesInvoice.setAvailableQty((currentQty - returnQuantity));
        salesInvoice.setMacLists(macLists);
        boolean isSellUpdate = salesInvoiceService.updateSalesInvoice(salesInvoice);

        if (isSellUpdate && isUpdated) {
            return true;
        }
        return false;
    }

}
