package com.pos.dao;

import com.pos.dto.ItemModel;
import com.pos.dto.MacList;
import com.pos.dto.Purchase;
import com.pos.dto.SalesInvoice;

import java.util.List;

public interface MacListDao {

    boolean add(MacList macList);
    boolean update(MacList macList);
    boolean delete(int id);

    List<MacList> getAll();
    MacList get(int id);
    MacList getByMacId(String macId);

    List<MacList> getAllMacByItemModel(ItemModel itemModel);
    List<MacList> getAllMacBySalesInvoice(SalesInvoice salesInvoice);
    boolean deleteByItemModel(ItemModel itemModel);
    List<MacList> getAllUnSoldMacByItemModel(ItemModel itemModel);

    List<MacList> getAllUnsoldMavByPurchase(Purchase purchase);


}
