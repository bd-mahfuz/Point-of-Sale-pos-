package com.pos.service;

import com.pos.dto.SalesInvoice;

import java.util.List;

public interface SalesInvoiceService {

    public boolean addSalesInvoice(SalesInvoice salesInvoice);
    public boolean updateSalesInvoice(SalesInvoice salesInvoice);
    public boolean deleteSalesInvoice(int id);

    public List<SalesInvoice> getAllSalesInvoice();
    public SalesInvoice getSalesInvoice(int id);

    public double getSellPriceByItemModel(int modelId);
    public double getTotalSellByQty(int modelId, int quantity);

}
