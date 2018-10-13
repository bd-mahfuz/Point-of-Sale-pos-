package com.pos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReturnController {


    @RequestMapping(value = "/user/return")
    public String returnProduct(Model model) {
        model.addAttribute("userClickReturn", true);
        model.addAttribute("title", "Return");
        return "index";
    }



}
