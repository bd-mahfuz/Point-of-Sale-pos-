package com.pos.service;

import com.pos.dto.ItemModel;
import com.pos.dto.ProductItem;

import java.util.List;

public interface ItemModelService {
    boolean addItemModel(ItemModel itemModel);
    boolean updateItemModel(ItemModel itemModel);
    boolean deleteItemModel(int itemModelId);

    List<ItemModel> getAllItemModels();
    ItemModel getItemModel(int itemModelId);
    List<ItemModel> getItemModelByProduct(ProductItem productItem);

    int getQuantity(int itemModelId);
}
