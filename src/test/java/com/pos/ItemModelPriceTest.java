package com.pos;

import com.pos.dao.ItemModelDao;
import com.pos.dao.ItemModelPriceDao;
import com.pos.dao.ProductItemDao;
import com.pos.dto.ItemModel;
import com.pos.dto.ItemModelPrice;
import com.pos.dto.ProductItem;
import com.pos.service.ItemModelPriceService;
import com.pos.service.ItemModelService;
import com.pos.service.ProductItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PosApplication.class)
public class ItemModelPriceTest {

    @Autowired
    private ItemModelPriceService itemModelPriceService;

    @Autowired
    private ProductItemService productItemService;

    @Autowired
    private ItemModelService itemModelService;


    private static final double DELTA = 1e-15;

    @Autowired
    ItemModelPriceDao itemModelPriceDao;

    @Autowired
    ItemModelDao itemModelDao;

    @Autowired
    ProductItemDao productItemDao;

    private ItemModel itemModel;
    private ItemModelPrice itemModelPrice;
    private ProductItem productItem;

    /*
            testing for addign item model price in database
     */
    @Test
    public void testAddItemModelPrice() {
        ProductItem productItem = productItemService.getProductItem(2);
        List<ItemModel> itemModelList  = itemModelService.getItemModelByProduct(productItem);

        itemModelPrice = new ItemModelPrice();
        itemModelPrice.setBuyPrice(3500);
        itemModelPrice.setSellPrice(4000);
        itemModelPrice.setProductItem(productItem);
        itemModelPrice.setItemModel(itemModelList.get(0));
        itemModelPrice.setNotes("notes");

        assertEquals("failed to add new itemModelPrice", true,
                itemModelPriceService.addItemModelPrice(itemModelPrice));
    }


        //getting a item model price from database
   @Test
    public void testGetItemModelPrice() {
       assertEquals( 4000,
               itemModelPriceService.getItemModelPrice(2).getSellPrice(), DELTA);
   }

    //update item Model price
    @Test
    public void testUpdateItemModelPrice() {
        itemModelPrice = itemModelPriceDao.get(1);
        itemModelPrice.setSellPrice(6000);
        assertEquals("failed to add new itemModelPrice", true,
                itemModelPriceDao.update(itemModelPrice));
    }

    //delete item Model price
    @Test
    public void testDeleteItemModelPrice() {
        assertEquals("failed to delete itemModelPrice", true,
                itemModelPriceService.deleteItemModelPrice(1));
    }

    /*
        Get all itemModelPrice
     */
    @Test
    public void testGetAllItemModelPrice() {
        assertEquals("failed to get itemModelPrice list", 1,
                itemModelPriceService.getAllItemModelPrice().size());
    }

    /*
        Get all itemModelPrice by productItem
     */
    @Test
    public void testGetAllItemModelPriceByProductItem() {
        ProductItem productItem = productItemService.getProductItem(2);
        assertEquals("failed to get itemModelPrice list by product", 1,
                itemModelPriceService.getItemModelPricesByProduct(productItem).size());
    }

    /*
        Get all itemModelPrice by ItemModel
     */
    @Test
    public void testGetAllItemModelPriceByItemModel() {
        ItemModel itemModel = itemModelService.getItemModel(1);
        assertEquals("failed to get itemModelPrice list by product", "Hp laptop",
                itemModelPriceService.getItemModelPriceByItemModel(itemModel).getProductItem().getProductItemName());
    }

    @Test
    public void testGetBuyPrice() {
        ItemModel itemModel = itemModelService.getItemModel(1);
        assertEquals("failed to get buy price by item model", "30000.0",
                itemModelPriceService.getBuyPriceByModel(itemModel)+"");

    }


}
