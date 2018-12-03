package com.pos.service;

import com.pos.dto.ItemModel;
import com.pos.dto.ItemModelPrice;
import com.pos.dto.ProductItem;

import java.util.List;

public interface ItemModelPriceService {

    boolean addItemModelPrice(ItemModelPrice itemModelPrice);
    boolean updateItemModelPrice(ItemModelPrice itemModelPrice);
    boolean deleteItemModelPrice(int itemModelPriceId);

    List<ItemModelPrice> getAllItemModelPrice();
    ItemModelPrice getItemModelPrice(int itemModelPriceId);
    List<ItemModelPrice> getItemModelPricesByProduct(ProductItem productItem);
    ItemModelPrice getItemModelPriceByItemModel(ItemModel itemModel);

    double getBuyPriceByModel(ItemModel itemModel);
    double getSellPriceByModel(ItemModel itemModel);
}
