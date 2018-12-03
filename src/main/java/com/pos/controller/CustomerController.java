package com.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.pos.dao.CustomerDao;
import com.pos.dto.Customer;

@Controller
public class CustomerController {

    @Autowired
    CustomerDao customerDao;

    @RequestMapping(value ="/user/addCustomer", method= RequestMethod.POST)
    public String addCustomer(@ModelAttribute("customer") Customer customer, Model model) {
        // adding customer to database
        boolean flag = customerDao.add(customer);
        String message="";
        if(flag == true) {
            message = "Customer added Successfully";
        }
        else {
            message = "Customer is not Added";
        }

        return "redirect:/user/setup?message="+message;
    }

    @RequestMapping(value ="/user/edit/{id}/customer")
    public String editCustomer(@PathVariable("id") int id, Model model) {
        Customer customer = customerDao.get(id);
        model.addAttribute("customer", customer);
        model.addAttribute("userClickEditCustomer", true);
        return "index";
    }

    @RequestMapping(value="/user/updateCustomer", method= RequestMethod.POST)
    public String updateCustomer(@ModelAttribute("customer") Customer customer, Model model) {
        // add the new supplier into the database
        System.out.println("customer name:"+customer.getName());
        boolean flag = customerDao.update(customer);

        // send back message based on Customer is updated or not
        String updateMessage="";
        if(flag == true) {
            updateMessage = "Customer updated Successfully";
        }
        else {
            updateMessage = "Customer is not updated";
        }
        model.addAttribute("updateMessage", updateMessage);
        model.addAttribute("userClickEditCustomer", true);
        return "index";
    }

    //delete existing supplier info
    @RequestMapping(value="/user/delete/{id}/customer", method=RequestMethod.POST)
    @ResponseBody
    public String deleteSupplier(@PathVariable int id, Model model) {
        boolean isFlag = customerDao.delete(id);

        return (isFlag)? "You have successfully delete the customer with id:"+id
                : "Customer delete is not successfull with id"+id;
    }
}
