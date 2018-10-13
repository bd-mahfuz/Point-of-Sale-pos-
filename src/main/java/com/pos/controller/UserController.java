package com.pos.controller;

import com.pos.dao.ProductItemDao;
import com.pos.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private ProductItemDao productItemDao;

	@RequestMapping(value={"/", "/home"})
	public String userHome(Model model) {
		model.addAttribute("userClickHome", true);
		return "index";
	}
	
	@RequestMapping(value="/setup")
	public String about(Model model, @RequestParam(name="message", required=false) String message) {
		model.addAttribute("userClickSetup", true);
		model.addAttribute("supplier", new Supplier());
		model.addAttribute("customer", new Customer());
		model.addAttribute("productItem", new ProductItem());
        model.addAttribute("itemModel", new ItemModel());
		model.addAttribute("itemModelPrice", new ItemModelPrice());
		model.addAttribute("message", message);
		return "index";
	}
}
