package com.pos.controller;

import com.pos.dto.Customer;
import com.pos.dto.ItemModel;
import com.pos.dto.Purchase;
import com.pos.dto.Supplier;
import com.pos.service.ItemModelService;
import com.pos.service.PurchaseService;
import com.pos.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    SupplierService supplierService;

    @Autowired
    ItemModelService itemModelService;


    @RequestMapping("/user/purchase")
    public String purchase(Model model) {
        model.addAttribute("userClickPurchase", true);
        model.addAttribute("purchase", new Purchase());
        return "index";
    }

    @RequestMapping(value = "/user/purchaseConfirm", method = RequestMethod.POST)
    public String purchaseConfirm(Model model, @ModelAttribute("purchase") Purchase purchase) {
        ItemModel itemModel = itemModelService.getItemModel(purchase.getModel().getId());
        Supplier supplier = supplierService.getSupplier(purchase.getSupplier().getId());

        // if there are no supplier or item model
        if (supplier == null) {
            supplier = new Supplier();
        }
        if ((itemModel == null)) {
            itemModel = new ItemModel();
        }
        purchase.setModel(itemModel);
        purchase.setSupplier(supplier);
        model.addAttribute("userClickPurchaseConfirm", true);
        model.addAttribute("purchase", purchase);
        return "index";
    }

    @RequestMapping(value = "/user/purchase", method = RequestMethod.POST)
    public String purchase(@ModelAttribute("purchase") Purchase purchase) {
        boolean isPurchase = purchaseService.addPurchase(purchase);
        String message = "";
        if (isPurchase) {
            message = "Product purchased successfully.";
        }else {
            message = "Product purchased Failed.";
        }
        return "redirect:/user/purchase?message="+message;
    }

    @RequestMapping(value = "/user/getAllPurchase")
    @ResponseBody
    public int getAllPurchase() {
        return (purchaseService.getAllPurchase().size() + 1);
    }

    @RequestMapping(value = "/user/productBuyPrice/{id}")
    @ResponseBody
    public double getProductBuyPrice(@PathVariable("id") int id) {
        return purchaseService.getBuyPriceByItemModel(id);
    }

    @RequestMapping(value = "/user/totalPurchase/{id}/{qty}", method = RequestMethod.POST)
    @ResponseBody
    public double getTotalPurchase(@PathVariable("id") int id, @PathVariable("qty") int quantity) {
        return purchaseService.getTotalPurchase(id, quantity);
    }


}
