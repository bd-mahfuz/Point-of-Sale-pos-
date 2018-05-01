package com.pos.jsoncontroller;

import com.pos.dao.ItemModelPriceDao;
import com.pos.dto.ItemModelPrice;
import com.pos.service.ItemModelPriceService;
import com.pos.service.ItemModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/json/data")
public class ItemModelPriceJsonController {

    @Autowired
    private ItemModelPriceService itemModelPriceService;

    // getting all ItemModelPrice in json format
    @RequestMapping(value="/item/modelPrices")
    public List<ItemModelPrice> getAllItemModelPrice() {
        return itemModelPriceService.getAllItemModelPrice();
    }
}
