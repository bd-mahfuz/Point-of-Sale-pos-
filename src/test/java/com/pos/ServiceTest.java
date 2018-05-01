package com.pos;

import static org.junit.Assert.assertEquals;

import java.util.List;

import com.pos.dao.SupplierDao;
import com.pos.dto.Supplier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=PosApplication.class)
@WebAppConfiguration
public class ServiceTest {

	@Autowired
	private SupplierDao supplierDao;
	
	private Supplier supplier;
	
	
	/*
	 * testing for add a supplier into database
	 */
	/*@Test
	public void testAddSupplier() {
		supplier = new Supplier();
		
		supplier.setName("Hakim");
		supplier.setCompanyName("BJIT");
		supplier.setAddress("Merul Badda, Dhaka");
		supplier.setPhone("817278992");
		supplier.setFax("fax");
		supplier.setMobile("01750539179");
		supplier.setEmail("bt.mahfuz@gmail.com");
		supplier.setWeb("wwww.anybd.com");
		supplier.setNotes("this is note");
		
		assertEquals("Supplier is not added", true, supplierDao.add(supplier));
		
		
	}*/
	
	/*
	 * testing for get a supplier info from database
	 */
	/*@Test
	public void testUpdateSupplier() {
		supplier = supplierDao.get(1);
		
		assertEquals("some problem to fetching the supplier", "Hakim", supplier.getName());
		
		
	}*/
	
	/*
	 * testing for update a supplier info 
	 */
	/*@Test
	public void testUpdateSupplier() {
		supplier = supplierDao.get(1);
		
		supplier.setName("Abdullah");
		supplier.setCompanyName("BJIT");
		supplier.setAddress("Merul Badda, Dhaka");
		supplier.setPhone("817278992");
		supplier.setFax("fax");
		supplier.setMobile("01750539179");
		supplier.setEmail("bt.mahfuz@gmail.com");
		supplier.setWeb("wwww.anybd.com");
		supplier.setNotes("this is note");
		
		assertEquals("some proble to update the supplier", true, supplierDao.update(supplier));
		
		
	}*/
	
	/*
	 * testing for delete a supplier info from database
	 */
	@Test
	public void testDeleteSupplier() {
		
		assertEquals("Supplier is not deleted", true, supplierDao.delete(4));
		
		
	}
	
	/*
	 * testing for delete a supplier info from database
	 */
	/*@Test
	public void testGetAllSupplier() {
		List<Supplier> supplierList= supplierDao.getAll();
		
		assertEquals("Supplier is not added", 5 , supplierList.size());
		
		
	}*/
}






















