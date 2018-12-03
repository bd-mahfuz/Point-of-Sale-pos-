package com.pos;

import com.pos.dto.ItemModel;
import com.pos.dto.Purchase;
import com.pos.dto.Supplier;
import com.pos.service.ItemModelService;
import com.pos.service.PurchaseService;
import com.pos.service.SupplierService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PosApplication.class)
public class PurchaseTest {

    @Autowired
    SupplierService supplierService;

    @Autowired
    ItemModelService itemModelService;

    @Autowired
    PurchaseService purchaseService;

    @Test
    public void testAddPurchase() {

        Supplier supplier = supplierService.getSupplier(1);

        ItemModel itemModel = itemModelService.getItemModel(1);

        Purchase purchase = new Purchase();
        purchase.setInvoiceNo(1);
        purchase.setBillNo(1);
        purchase.setSupplier(supplier);
        purchase.setModel(itemModel);

        assertEquals("failed to add purchase", true, purchaseService.addPurchase(purchase));

    }

    @Test
    public void testGetAllPurchaseByModel() {
        ItemModel itemModel = itemModelService.getItemModel(1);
        assertEquals("failed to get purchases", 3, purchaseService.getAllPurchaseByItemModel(itemModel).size());

    }

}
