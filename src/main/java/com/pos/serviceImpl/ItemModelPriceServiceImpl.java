package com.pos.serviceImpl;

import com.pos.dao.ItemModelPriceDao;
import com.pos.dto.ItemModel;
import com.pos.dto.ItemModelPrice;
import com.pos.dto.ProductItem;
import com.pos.service.ItemModelPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemModelPriceServiceImpl implements ItemModelPriceService{

    @Autowired
    private ItemModelPriceDao itemModelPriceDao;

    @Override
    public boolean addItemModelPrice(ItemModelPrice itemModelPrice) {
        return itemModelPriceDao.add(itemModelPrice);
    }

    @Override
    public boolean updateItemModelPrice(ItemModelPrice itemModelPrice) {
        //set product item name for updating
        return itemModelPriceDao.update(itemModelPrice);
    }

    @Override
    public boolean deleteItemModelPrice(int itemModelPriceId) {
        return itemModelPriceDao.delete(itemModelPriceId);
    }

    @Override
    public List<ItemModelPrice> getAllItemModelPrice() {
        return itemModelPriceDao.getAll();
    }

    @Override
    public ItemModelPrice getItemModelPrice(int itemModelPriceId) {
        return itemModelPriceDao.get(itemModelPriceId);
    }

    @Override
    public List<ItemModelPrice> getItemModelPricesByProduct(ProductItem productItem) {
        return itemModelPriceDao.getItemModelPricesByProduct(productItem);
    }

    @Override
    public ItemModelPrice getItemModelPriceByItemModel(ItemModel itemModel) {
        return itemModelPriceDao.getItemModelPriceByItemModel(itemModel);
    }
}
