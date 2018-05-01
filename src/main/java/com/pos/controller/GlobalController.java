package com.pos.controller;

import com.pos.dao.CustomerDao;
import com.pos.dao.ProductItemDao;
import com.pos.dto.ProductItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@ControllerAdvice
public class GlobalController {

    @Autowired
    ProductItemDao productItemDao;

    @ModelAttribute("productList")
    public List<ProductItem> getAllProducts() {
        return productItemDao.getAll();
    }
}
