package com.pos.serviceImpl;

import com.pos.dao.ItemModelDao;
import com.pos.dao.ItemModelPriceDao;
import com.pos.dto.ItemModel;
import com.pos.dto.ItemModelPrice;
import com.pos.dto.MacList;
import com.pos.dto.ProductItem;
import com.pos.service.ItemModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemModelServiceImpl implements ItemModelService {

    @Autowired
    private ItemModelDao itemModelDao;

    @Autowired
    private ItemModelPriceDao itemModelPriceDao;


    @Override
    public boolean addItemModel(ItemModel itemModel) {

        boolean isAdded =  itemModelDao.add(itemModel);

        return  isAdded;
    }

    @Override
    public boolean updateItemModel(ItemModel itemModel) {
        //updating ItemModel
        boolean flag = itemModelDao.update(itemModel);

        // Updating ItemModelPrice for updating ItemModel
        ItemModelPrice itemModelPrice = itemModelPriceDao.getItemModelPriceByItemModel(itemModel);
        if (itemModelPrice != null) {
            itemModelPriceDao.update(itemModelPrice);
        }
        return flag;
    }

    @Override
    public boolean deleteItemModel(int itemModelId) {
        ItemModel itemModel = itemModelDao.get(itemModelId);
        // Deleting ItemModelPrice for deleting ItemModel
        ItemModelPrice itemModelPrice = itemModelPriceDao.getItemModelPriceByItemModel(itemModel);
        if (itemModelPrice != null) {
            itemModelPriceDao.delete(itemModelPrice.getId());
        }

        //Deleting ItemModel
        boolean flag = itemModelDao.delete(itemModel.getId());
        return flag;
    }

    @Override
    public List<ItemModel> getAllItemModels() {
        return itemModelDao.getAll();
    }

    @Override
    public ItemModel getItemModel(int itemModelId) {
        return itemModelDao.get(itemModelId);
    }

    @Override
    public List<ItemModel> getItemModelByProduct(ProductItem productItem) {
        return itemModelDao.getByProduct(productItem);
    }

    @Override
    public int getQuantity(int itemModelId) {
        return itemModelDao.getQuantity(itemModelId);
    }
}
