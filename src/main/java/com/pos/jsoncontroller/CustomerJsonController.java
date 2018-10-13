package com.pos.jsoncontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pos.dao.CustomerDao;
import com.pos.dto.Customer;

import java.util.List;

@RestController
@RequestMapping("/json/data")
public class CustomerJsonController {

    @Autowired
    CustomerDao customerDao;

    @RequestMapping("/allCustomer")
    public List<Customer> getAllCustomer() {
        return customerDao.getAll();
    }
}
