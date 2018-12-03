package com.pos;

import com.pos.dto.ItemModel;
import com.pos.dto.Purchase;
import com.pos.service.ItemModelService;
import com.pos.service.MacListService;
import com.pos.service.PurchaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PosApplication.class)
public class MacListTest {

    @Autowired
    private ItemModelService itemModelService;

    @Autowired
    private MacListService macListService;
    @Autowired
    private PurchaseService  purchaseService;

    @Test
    public void testDeleteMacListByModel() {
        ItemModel itemModel = itemModelService.getItemModel(1);

        assertEquals("Failed to delete maclist using itemModel", true,
                macListService.deleteByItemModel(itemModel));
    }


    @Test
    public void testGetAllUnSoldMacByItemModel() {
        ItemModel itemModel = itemModelService.getItemModel(1);
        assertEquals("Failed to get maclists using itemModel", 2,
                macListService.getAllUnSoldMacByItemModel(itemModel).size());
    }

    @Test
    public void testGetAllUnSoldMacByPurchase() {
        Purchase purchase = purchaseService.getPurchase(1);
        assertEquals("Failed to get maclists using purchsase", 2,
                macListService.getAllUnsoldMavByPurchase(purchase).size());
    }

}
