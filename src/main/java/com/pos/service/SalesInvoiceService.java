package com.pos.service;

import com.pos.dao.SalesInvoiceDao;
import com.pos.dto.SalesInvoice;

import java.util.List;

public interface SalesInvoiceService{

    boolean addSalesInvoice(SalesInvoice salesInvoice);
    boolean addSalesInvoice(SalesInvoice salesInvoice, List<String> macIds);
    boolean updateSalesInvoice(SalesInvoice salesInvoice);
    boolean deleteSalesInvoice(int id);

    List<SalesInvoice> getAllSalesInvoice();
    SalesInvoice getSalesInvoice(int id);

    double getSellPriceByItemModel(int modelId);
    double getTotalSellByQty(int modelId, int quantity);

    SalesInvoice getSalesInvoiceByInvoiceNo(int sellInvoiceNo);


}
