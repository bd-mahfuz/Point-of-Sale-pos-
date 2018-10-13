package com.pos.controller;

import com.pos.dto.Customer;
import com.pos.dto.ItemModel;
import com.pos.dto.SalesInvoice;
import com.pos.service.CustomerService;
import com.pos.service.ItemModelPriceService;
import com.pos.service.ItemModelService;
import com.pos.service.SalesInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SalesInvoiceController {

    @Autowired
    ItemModelService itemModelService;

    @Autowired
    SalesInvoiceService salesInvoiceService;

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/user/sales-invoice")
    public String salesInvoice(Model model) {
        model.addAttribute("userClickSalesInvoice", true);
        model.addAttribute("title", "Sales Invoice");
        model.addAttribute("salesInvoice", new SalesInvoice());

        return "index";
    }

    @RequestMapping(value = "/user/confirm/sales-invoice", method = RequestMethod.POST)
    public String addSalesInvoice(@ModelAttribute("salesInvoice") SalesInvoice salesInvoice, Model model) {
        ItemModel itemModel = itemModelService.getItemModel(salesInvoice.getModel().getId());
        Customer customer = customerService.getCustomer(salesInvoice.getCustomer().getId());

        // if there are no customer or item model cause of null pointer exception
        if (customer == null) {
            customer = new Customer();
        }
        if ((itemModel == null)) {
            itemModel = new ItemModel();
        }
        salesInvoice.setModel(itemModel);
        salesInvoice.setCustomer(customer);
        model.addAttribute("userClickSalesInvoiceConfirm", true);
        model.addAttribute("title", "Confirm Sales Invoice");
        model.addAttribute("salesInvoice", salesInvoice);

        return "index";
    }

    @RequestMapping(value = "/user/sales-invoice", method = RequestMethod.POST)
    public String addSalesInvoice(@ModelAttribute("salesInvoice") SalesInvoice salesInvoice) {

        boolean isAdded = salesInvoiceService.addSalesInvoice(salesInvoice);
        String message = "";

        if (isAdded) {
            message = "Product Sale info added successfully";
        } else {
            message = "Product failed to sell"; }


        return "redirect:/user/sales-invoice?message="+message;
    }

    @RequestMapping(value = "/item-model/{id}/quantity")
    @ResponseBody
    public int getQuantity(@PathVariable("id") int modelId) {
        return itemModelService.getQuantity(modelId);
    }

    @RequestMapping(value = "/sell-price/{id}")
    @ResponseBody
    public double getSellPriceByModel(@PathVariable("id") int modelId) {
        return salesInvoiceService.getSellPriceByItemModel(modelId);
    }

    @RequestMapping(value = "/total-sell-price/{id}/{quantity}")
    @ResponseBody
    public double getTotalSellPriceByQty(@PathVariable("id") int modelId, @PathVariable("quantity") int quantity ) {
        return salesInvoiceService.getTotalSellByQty(modelId, quantity);
    }

    @RequestMapping(value = "/updated-invoice-no")
    @ResponseBody
    public int getUpdatedInvoiceNo() {
        try {
            return salesInvoiceService.getAllSalesInvoice().size() + 1;
        } catch (NullPointerException e) {
            //e.printStackTrace();
            System.out.println("Null pointer exception is handled");
            return 1;
        }
    }



}
