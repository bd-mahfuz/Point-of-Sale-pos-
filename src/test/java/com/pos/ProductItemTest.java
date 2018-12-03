package com.pos;

import static org.junit.Assert.*;

import com.pos.dao.ItemModelDao;
import com.pos.dao.ItemModelPriceDao;
import com.pos.dao.ProductItemDao;
import com.pos.dto.ItemModel;
import com.pos.dto.ItemModelPrice;
import com.pos.dto.ProductItem;
import com.pos.service.ProductItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=PosApplication.class)
public class ProductItemTest {


	@Autowired
	private ProductItemService productItemService;

	/*
	 * Test add product item 
	 */
	@Test
	public void testAddProductItem() {
		ProductItem productItem = new ProductItem();
		productItem.setNotes("this is note for product Item");
		productItem.setProductItemName("Hp laptop");
		
		assertEquals("failed to add a product item into database", true,
				productItemService.addProductItem(productItem));
	}
	
	
	/*
	 * Test update product item 
	 */
	@Test
	public void testUpdateProductItem() {
		ProductItem productItem = productItemService.getProductItem(1);
		productItem.setProductItemName("Lenevo");
		assertEquals("failed to add a product item into database", true,
				productItemService.updateProductItem(productItem));
	}
	
	/*
	 * Test delete product item 
	 */
	@Test
	public void testDeleteProductItem() {
		
		assertEquals("failed to delete a product item from database", true,
				productItemService.deleteProductItem(1));
	}
	
	
	/*
	 * Test get all product item 
	 */
	@Test
	public void testGetAllProductItem() {
		//productItem = productItemDao.get(1);

		assertEquals("failed to get all product item from database", 1, productItemService.getAllProductItems().size());
	}
	
}
