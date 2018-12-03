package com.pos.controller;

import com.pos.ItemModelPropertyEditor;
import com.pos.dao.ItemModelDao;
import com.pos.dao.ItemModelPriceDao;
import com.pos.dao.ProductItemDao;
import com.pos.dto.ItemModel;
import com.pos.dto.ItemModelPrice;
import com.pos.dto.ProductItem;
import com.pos.service.ItemModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class ItemModelController {

    @Autowired
    private ItemModelService itemModelService;

    @RequestMapping(value="/user/add/itemModel", method= RequestMethod.POST)
    public String addNewItemModel(@ModelAttribute("itemModel") ItemModel itemModel) {
        // set the mac code if item is 'with mac'
        /*String mac = "MAC" + UUID.randomUUID().toString().substring(12).toUpperCase();
        if (itemModel.getModelType().equals("With MAC")) {
            itemModel.setModelType(mac);
        }*/

        boolean flag = itemModelService.addItemModel(itemModel);

        // send back message based on itemModel is added or not
        String message="";
        if(flag == true) {
            message = "New Item Model added Successfully";
        }
        else {
            message = "Item Model is not Added";
        }

        return "redirect:/user/setup?message="+message;
    }


    @RequestMapping(value="/user/delete/{id}/itemModel", method=RequestMethod.POST)
    @ResponseBody
    public String deleteItemModel(@PathVariable int id) {

        boolean flag1 = itemModelService.deleteItemModel(id);
        return (flag1)? "You have successfully delete the Item Model with id:"+id
                : "Item Model or related table is not delete successfully with id"+id;
    }

    @RequestMapping(value = "/user/edit/{itemModelId}/itemModel")
    public String editItemModel(@PathVariable("itemModelId") int itemModelId, Model model ) {
        ItemModel itemModel = itemModelService.getItemModel(itemModelId);
        model.addAttribute("itemModel", itemModel);
        model.addAttribute("userClickEditItemModel", true);
        return "index";
    }

    @RequestMapping(value = "/user/update/itemModel", method = RequestMethod.POST)
    public String updateItemModel(@ModelAttribute("itemModel") ItemModel itemModel, Model model ) {

        boolean flag = itemModelService.updateItemModel(itemModel);
        String updateMessage = "";
        if (flag == true) {
            updateMessage = "Successfully updated Item Model!";
        }
        else {
            updateMessage = "Item Model is not updated!";
        }

        model.addAttribute("updateMessage", updateMessage);
        model.addAttribute("userClickEditItemModel", true);
        return "index";
    }
}
