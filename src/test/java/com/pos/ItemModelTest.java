package com.pos;

import static org.junit.Assert.*;

import com.pos.dao.ItemModelDao;
import com.pos.dao.ItemModelPriceDao;
import com.pos.dao.ProductItemDao;
import com.pos.dto.ItemModel;
import com.pos.dto.ItemModelPrice;
import com.pos.dto.MacList;
import com.pos.dto.ProductItem;
import com.pos.service.ItemModelService;
import com.pos.service.MacListService;
import com.pos.service.ProductItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PosApplication.class)
public class ItemModelTest {

    @Autowired
    private ItemModelService itemModelService;

    @Autowired
    private ProductItemService productItemService;

    @Autowired
    ItemModelDao itemModelDao;

    @Autowired
    ProductItemDao productItemDao;

    @Autowired
    ItemModelPriceDao itemModelPriceDao;

    @Autowired
    MacListService macListService;

    ItemModel itemModel;
    ProductItem productItem;
    ItemModelPrice itemModelPrice;

    /*
        testing adding the itemModel into database
     */
    @Test
    public void testAddItemModel() {
        itemModel = new ItemModel();
        productItem = productItemDao.get(2);

        itemModel.setModelCode("AD2323SS");
        itemModel.setModelType("NH4");
        itemModel.setNotes("notes");
        itemModel.setProductItem(productItem);
        assertEquals("failed to add item model", true,
                itemModelService.addItemModel(itemModel));
    }

   /*
        update itemModel
    */
    @Test
    public void testUpdateItemModel() {
        itemModel = itemModelDao.get(1);

        productItem = productItemDao.get(2);

        //updating ItemModel
        itemModel.setModelCode("4540s");
        itemModel.setModelType("Probook");
        assertEquals("failed to update the particular item model", true,
                itemModelService.updateItemModel(itemModel));
    }


    /*
        delete itemModel
    */
    @Test
    public void testDeleteItemModel() {
        assertEquals("failed to delete the item model", true,
                itemModelService.deleteItemModel(1));
    }


    /*
        get all itemModel
    */
    @Test
    public void testGetAllItemModel() {
        assertEquals("failed to get all item model", 1, itemModelService.getAllItemModels().size());
    }


   /*
        get all item model by product item id
    */
    @Test
    public void testGetItemModelByProduct() {
        ProductItem productItem = productItemService.getProductItem(2);
        assertEquals("failed to get all item model by ProductItem", 1,
                itemModelService.getItemModelByProduct(productItem).size());
    }


    @Test
    public void testGetQuantity() {
        assertEquals("failed to get quantity", 10,
                itemModelService.getQuantity(1));
    }


    @Test
    public void testGetAllMaclist() {
        itemModel = itemModelDao.get(2);
        assertEquals("failed to get quantity", 7,
                macListService.getAllMacByItemModel(itemModel).size());
    }



}
