package com.pos.jsoncontroller;

import com.pos.dao.ItemModelDao;
import com.pos.dto.ItemModel;
import com.pos.dto.ProductItem;
import com.pos.service.ItemModelService;
import com.pos.service.ProductItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/json/data")
public class ItemModelJsonController {

    @Autowired
    private ItemModelService itemModelService;

    @Autowired
    private ProductItemService productItemService;


    @RequestMapping(value="/{id}/item/models")
    public List<ItemModel> getItemModelByProductId(@PathVariable("id") int productId) {
        ProductItem productItem = productItemService.getProductItem(productId);
        return itemModelService.getItemModelByProduct(productItem);
    }

    @RequestMapping(value="/item/models")
    public List<ItemModel> getAllItemModels() {
        return itemModelService.getAllItemModels();
    }
}
