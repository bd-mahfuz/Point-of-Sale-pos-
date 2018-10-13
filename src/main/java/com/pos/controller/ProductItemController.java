package com.pos.controller;

import com.pos.dao.ItemModelDao;
import com.pos.dao.ItemModelPriceDao;
import com.pos.dto.ItemModel;
import com.pos.dto.ItemModelPrice;
import com.pos.service.ProductItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pos.dao.ProductItemDao;
import com.pos.dto.ProductItem;

import java.util.List;

@Controller
public class ProductItemController {

	@Autowired
	private ProductItemService productItemService;


	@RequestMapping(value="/user/add/productItem")
	public String addProductItem(@ModelAttribute("productItem") ProductItem productItem, Model model) {
		boolean flag = productItemService.addProductItem(productItem);
		String message="";
        if(flag == true) {
            message = "New Product added Successfully";
        }
        else {
            message = "New Product is not Added";
        }

        return "redirect:/user/setup?message="+message; 
	}
	
	@RequestMapping(value="/user/delete/{id}/productItem", method=RequestMethod.POST)
	@ResponseBody
	public String deleteProductItem(@PathVariable("id") int id, Model model) {

		boolean flag = productItemService.deleteProductItem(id);

		return (flag)? "Successfully deleted product Item with id="+id
				: "Product item or related table is not deleted with id="+id+"!";
	}
	
	@RequestMapping("/user/edit/{id}/productItem")
	public String editProductItem(@PathVariable("id") int id, Model model) {
		ProductItem productItem = productItemService.getProductItem(id);
		model.addAttribute("userClickEditProductItem", true);
		model.addAttribute("productItem", productItem);
		return "index";
	}
	
	@RequestMapping(value="/user/update/productItem", method=RequestMethod.POST)
	public String updateProductItem(@ModelAttribute("productItem") ProductItem productItem, Model model) {

		boolean flag = productItemService.updateProductItem(productItem);
		String message="";
		if(flag == true) {
            message = "Product Item updated Successfully!";
        }
        else {
            message = "Product item is not updated!";
        }
		model.addAttribute("updateMessage", message);
		model.addAttribute("userClickEditProductItem", true);
		return "index";
	}


}
