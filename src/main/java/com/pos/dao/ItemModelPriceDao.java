package com.pos.dao;


import com.pos.dto.ItemModel;
import com.pos.dto.ItemModelPrice;
import com.pos.dto.ProductItem;

import java.util.List;

public interface ItemModelPriceDao {
    public boolean add(ItemModelPrice itemModelPrice);
    public boolean update(ItemModelPrice itemModelPrice);
    public boolean delete(int id);

    public List<ItemModelPrice> getAll();
    public ItemModelPrice get(int id);

    List<ItemModelPrice> getItemModelPricesByProduct(ProductItem productItem);
    ItemModelPrice getItemModelPriceByItemModel(ItemModel itemModel);

    double getBuyPriceByModel(ItemModel itemModel);
    double getSellPriceByModel(ItemModel itemModel);
}
