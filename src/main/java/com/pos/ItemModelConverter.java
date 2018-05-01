package com.pos;

import com.pos.dto.ItemModel;
import com.pos.service.ItemModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ItemModelConverter implements Converter<String, ItemModel> {

    @Override
    public ItemModel convert(String s) {
        try {
            Object obj = s;
            ItemModel itemModel = (ItemModel) obj;
            return itemModel;
        }
        catch (Exception e) {
            e.printStackTrace();
            return  null;
        }
    }
}
