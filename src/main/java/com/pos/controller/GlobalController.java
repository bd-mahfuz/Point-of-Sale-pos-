package com.pos.controller;

import com.pos.dao.CustomerDao;
import com.pos.dao.ProductItemDao;
import com.pos.dto.Customer;
import com.pos.dto.ItemModel;
import com.pos.dto.ProductItem;
import com.pos.dto.Supplier;
import com.pos.service.CustomerService;
import com.pos.service.ItemModelService;
import com.pos.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@ControllerAdvice
public class GlobalController {

    @Autowired
    ProductItemDao productItemDao;

    @Autowired
    SupplierService supplierService;

    @Autowired
    ItemModelService itemModelService;

    @Autowired
    CustomerService customerService;

    @ModelAttribute("productList")
    public List<ProductItem> getAllProducts() {
        return productItemDao.getAll();
    }

    @ModelAttribute("supplierList")
    public List<Supplier> getAllSupplier() {
        return supplierService.getAllSupplier();
    }

    @ModelAttribute("itemModelList")
    public List<ItemModel> getAllItemModel() {
        return itemModelService.getAllItemModels();
    }

    @ModelAttribute("customerList")
    public List<Customer> getAllCustomer() {
        return customerService.getAllCustomer();
    }
}
