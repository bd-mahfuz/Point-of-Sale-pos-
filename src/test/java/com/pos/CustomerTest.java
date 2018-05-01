package com.pos;

import static org.junit.Assert.*;

import com.pos.dao.CustomerDao;
import com.pos.dto.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= PosApplication.class)
@WebAppConfiguration
public class CustomerTest {

	@Autowired
	CustomerDao customerDao;
	
	Customer customer;
	
	@Test
	public void testAddCustomer() {
		customer = new Customer();
		customer.setName("Horizon");
		customer.setCompanyName("Brack IT");
		
		//assertEquals("Failed to add new Customer", true, customerDao.save(customer));
	}
	
}






















