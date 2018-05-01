package com.pos.controller;

import com.pos.dao.ItemModelDao;
import com.pos.dao.ItemModelPriceDao;
import com.pos.dao.ProductItemDao;
import com.pos.dto.ItemModel;
import com.pos.dto.ItemModelPrice;
import com.pos.dto.ProductItem;
import com.pos.service.ItemModelPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ItemModelPriceController {

    @Autowired
    private ItemModelPriceService itemModelPriceService;



    @RequestMapping(value="/user/add/itemModelPrice")
    public String addProductItem(@ModelAttribute("itemModelPrice") ItemModelPrice itemModelPrice) {

        boolean flag = itemModelPriceService.addItemModelPrice(itemModelPrice);
        String message="";
        if(flag == true) {
            message = "New Item Model Price added Successfully";
        }
        else {
            message = "Item Model Price is not Added";
        }

        return "redirect:/user/setup?message="+message;
    }


    @RequestMapping(value="/user/delete/{id}/itemModelPrice", method= RequestMethod.POST)
    @ResponseBody
    public String deleteSupplier(@PathVariable int id) {
        boolean isFlag = itemModelPriceService.deleteItemModelPrice(id);

        return (isFlag)? "You have successfully delete the Item Model Price Info with id:"+id
                : "Item Model Price is not delete successfully with id"+id;
    }

    @RequestMapping("/user/edit/{id}/itemModelPrice")
    public String editItemModelPrice(@PathVariable("id") int id, Model model) {
        ItemModelPrice itemModelPrice = itemModelPriceService.getItemModelPrice(id);
        model.addAttribute("itemModelPrice", itemModelPrice);
        model.addAttribute("userClickEditItemModelPrice", true);
        return "index";
    }

    @RequestMapping("/user/update/itemModelPrice")
    public String updateItemModelPrice(@ModelAttribute("itemModelPrice") ItemModelPrice itemModelPrice, Model model) {

        boolean flag = itemModelPriceService.updateItemModelPrice(itemModelPrice);
        String message = "";
        if(flag) {
            message = "Successfully updated Item Model Price info!";
        }
        else {
            message = "Item Model Price is not updated!";
        }

        model.addAttribute("updateMessage", message);
        model.addAttribute("userClickEditItemModelPrice", true);
        return "index";
    }
}
