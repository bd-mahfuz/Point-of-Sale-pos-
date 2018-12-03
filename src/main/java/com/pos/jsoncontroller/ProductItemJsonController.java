package com.pos.jsoncontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pos.dao.ProductItemDao;
import com.pos.dto.ProductItem;

@RestController
@RequestMapping("/json/data")
public class ProductItemJsonController {

	@Autowired
	ProductItemDao productItemDao;
	
	@RequestMapping("/allProductItem")
	public List<ProductItem> getAllProduct() {
		List<ProductItem> list=productItemDao.getAll();
		return list;
	}
}
