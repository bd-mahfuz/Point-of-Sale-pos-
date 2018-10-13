package com.pos.service;

import com.pos.dto.ProductItem;

import java.util.List;

public interface ProductItemService {

    boolean addProductItem(ProductItem productItem);
    boolean updateProductItem(ProductItem productItem);
    boolean deleteProductItem(int productItemId);

    List<ProductItem> getAllProductItems();
    ProductItem getProductItem(int productItemId);
}
