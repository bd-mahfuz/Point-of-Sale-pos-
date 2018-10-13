package com.pos;

import com.pos.dto.ItemModel;
import com.pos.dto.ProductItem;

import java.beans.PropertyEditorSupport;

public class ItemModelPropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Object  object = text;
        ProductItem productItem = (ProductItem) object;
        System.out.println(productItem);
        setValue(productItem);
    }
}
