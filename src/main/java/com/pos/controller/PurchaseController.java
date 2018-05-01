package com.pos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PurchaseController {

    @RequestMapping("/user/purchase")
    public String purchase(Model model) {
        model.addAttribute("userClickPurchase", true);
        return "index";
    }
}
