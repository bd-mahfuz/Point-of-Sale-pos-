package com.pos;

import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import com.pos.dto.Test;
import com.pos.service.TestService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PosApplication.class)
public class TestForTest {
	
	Test test;

	@Autowired
	TestService testService;
	
	
	@org.junit.Test
	public void testAddCategory() {
		test = new Test();
		test.setId(3);
		test.setName("Hafiz");
		
		assertEquals("Not added successfully !", true, testService.add(test));
	}
	
	
}
