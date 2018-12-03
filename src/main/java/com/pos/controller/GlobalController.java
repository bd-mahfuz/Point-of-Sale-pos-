package com.pos.controller;

import com.pos.dao.CustomerDao;
import com.pos.dao.ProductItemDao;
import com.pos.dto.*;
import com.pos.service.CustomerService;
import com.pos.service.ItemModelService;
import com.pos.service.MacListService;
import com.pos.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    MacListService macListService;

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
