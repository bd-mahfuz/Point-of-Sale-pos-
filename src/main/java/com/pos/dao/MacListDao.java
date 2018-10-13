package com.pos.dao;

import com.pos.dto.ItemModel;
import com.pos.dto.MacList;

import java.util.List;

public interface MacListDao {

    boolean add(MacList macList);
    boolean update(MacList macList);
    boolean delete(int id);

    List<MacList> getAll();
    MacList get(int id);

    List<MacList> getAllMacByItemModel(ItemModel itemModel);
    boolean deleteByItemModel(ItemModel itemModel);
    List<MacList> getAllUnSoldMacByItemModel(ItemModel itemModel);



}
