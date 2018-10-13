package com.pos.dao;


import com.pos.dto.ItemModel;
import com.pos.dto.ProductItem;

import java.util.List;

public interface ItemModelDao {
    public boolean add(ItemModel itemModel);
    public boolean update(ItemModel itemModel);
    public boolean delete(int id);

    public List<ItemModel> getAll();
    public ItemModel get(int id);
    public List<ItemModel> getByProduct(ProductItem productItem);

    public int getQuantity(int itemModelId);
}
