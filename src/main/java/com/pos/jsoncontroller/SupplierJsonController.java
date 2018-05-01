package com.pos.jsoncontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pos.dao.SupplierDao;
import com.pos.dto.Supplier;

@RestController
@RequestMapping("/json/data")
public class SupplierJsonController {
	
	@Autowired
	SupplierDao supplierDao;

	@RequestMapping("/allSupplier")
	public List<Supplier> getAllSupplier() {
		return supplierDao.getAll();
	}
}
