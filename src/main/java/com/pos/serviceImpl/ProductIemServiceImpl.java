package com.pos.serviceImpl;

import com.pos.dao.ItemModelDao;
import com.pos.dao.ItemModelPriceDao;
import com.pos.dao.ProductItemDao;
import com.pos.dto.ItemModel;
import com.pos.dto.ItemModelPrice;
import com.pos.dto.ProductItem;
import com.pos.service.ProductItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductIemServiceImpl implements ProductItemService {

    @Autowired
    private ProductItemDao productItemDao;

    @Autowired
    private ItemModelDao itemModelDao;

    @Autowired
    private ItemModelPriceDao itemModelPriceDao;

    @Override
    public boolean addProductItem(ProductItem productItem) {
        return productItemDao.add(productItem);
    }

    @Override
    public boolean updateProductItem(ProductItem productItem) {
        // Updating ProductItem
        boolean flag = productItemDao.update(productItem);

        //updating ItemModel
        List<ItemModel> itemModelList = itemModelDao.getByProduct(productItem);
        if (itemModelList.size() > 0) {
            for(ItemModel itemModel : itemModelList) {
                itemModelDao.update(itemModel);
            }
        }

        //updating ItemModelPrice
        List<ItemModelPrice> itemModelPriceList = itemModelPriceDao.getItemModelPricesByProduct(productItem);
        if (itemModelPriceList.size() > 0) {
            for(ItemModelPrice itemModelPrice : itemModelPriceList) {
                itemModelPriceDao.update(itemModelPrice);
            }
        }
        return flag;
    }

    @Override
    public boolean deleteProductItem(int productItemId) {
        ProductItem productItem = productItemDao.get(productItemId);

        // Deleting ItemModelPrice
        List<ItemModelPrice> itemModelPriceList = itemModelPriceDao.getItemModelPricesByProduct(productItem);
        if (itemModelPriceList.size() > 0) {
            for(ItemModelPrice itemModelPrice : itemModelPriceList) {
                itemModelPriceDao.delete(itemModelPrice.getId());
            }
        }

        // Deleting ItemModel
        List<ItemModel> itemModelList = itemModelDao.getByProduct(productItem);
        if (itemModelList.size() > 0) {
            for(ItemModel itemModel : itemModelList) {
                itemModelDao.delete(itemModel.getId());
            }
        }

        // Deleting ProductItem
        boolean flag = productItemDao.delete(productItemId);
        return flag;
    }

    @Override
    public List<ProductItem> getAllProductItems() {
        return productItemDao.getAll();
    }

    @Override
    public ProductItem getProductItem(int productItemId) {
        return productItemDao.get(productItemId);
    }
}
