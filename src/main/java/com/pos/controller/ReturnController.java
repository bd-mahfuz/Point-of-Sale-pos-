package com.pos.controller;

import com.pos.dto.*;
import com.pos.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.crypto.Mac;
import java.util.Date;

@Controller
public class ReturnController {

    @Autowired
    private SalesInvoiceService salesInvoiceService;
    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private ReturnPurchaseService returnPurchaseService;

    @Autowired
    private MacListService macListService;

    @Autowired
    private ReturnSellService returnSellService;



    @RequestMapping(value = "/user/return")
    public String returnProduct(Model model) {
        model.addAttribute("userClickReturn", true);
        model.addAttribute("title", "Return");
        model.addAttribute("returnSell", new ReturnSell());
        return "index";
    }

    @RequestMapping(value = "/invoice/{invoiceNo}/sell-info", method = RequestMethod.GET)
    @ResponseBody
    public SalesInvoice returnSellInfo(@PathVariable("invoiceNo") int invoiceNo) {

        SalesInvoice salesInvoice = salesInvoiceService.getSalesInvoiceByInvoiceNo(invoiceNo);

        return salesInvoice;
    }

    @RequestMapping(value = "/user/return-sell/{salesInvoiceId}/quantity/{quantity}")
    public String returnSell(@PathVariable("salesInvoiceId") int salesInvoiceId, @PathVariable("quantity") int quantity ) {

        SalesInvoice salesInvoice = salesInvoiceService.getSalesInvoice(salesInvoiceId);
        boolean isReturned = returnSellService.returnSell(salesInvoice, quantity);

        String message = "";
        if (isReturned) {
            message = "Item return successfully";
        } else {
            message = "Item return failed";
        }

        return "redirect:/user/return?message="+message;
    }

    @RequestMapping(value = "/invoice/{invoiceNo}/purchase-info")
    @ResponseBody
    public Purchase returnPurchaseInfo(@PathVariable("invoiceNo") int invoiceNo) {

        Purchase purchase= purchaseService.getPurchaseByInvoiceNo(invoiceNo);

        return purchase;
    }

    @RequestMapping(value = "/user/return-purchase/{purchaseId}/quantity/{quantity}")
    public String returnPurchase(@PathVariable("purchaseId") int purchaseId, @PathVariable("quantity") int quantity ) {

        Purchase purchase = purchaseService.getPurchase(purchaseId);

        // saving return info in returnPurchase table
        ReturnPurchase returnPurchase = new ReturnPurchase();
        returnPurchase.setAvailableQty(purchase.getAvailableQty());
        returnPurchase.setPurchase(purchase);
        returnPurchase.setReturnQty(quantity);
        returnPurchase.setDate(new Date());
        boolean isAdd = returnPurchaseService.add(returnPurchase);

        // updating purchase table
        boolean isReturned = returnPurchaseService.returnPurchase(purchase, quantity);
        String message = "";
        if (isAdd && isReturned) {
            message = "Item return successfully";
        } else {
            message = "Item return failed";
        }

        return "redirect:/user/return?message="+message;
    }


    @RequestMapping(value = "/user/macList/by/{macId}")
    @ResponseBody
    public MacList getMacListByMacId(@PathVariable("macId") String macId) {
        MacList macList = macListService.getByMacId(macId);
        return macList;
    }




}
