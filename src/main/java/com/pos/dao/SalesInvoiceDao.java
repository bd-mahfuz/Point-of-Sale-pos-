package com.pos.dao;


import com.pos.dto.SalesInvoice;

import java.util.List;

public interface SalesInvoiceDao {
    boolean add(SalesInvoice salesInvoice);
    boolean update(SalesInvoice salesInvoice);
    boolean delete(int id);

    List<SalesInvoice> getAll();
    SalesInvoice get(int id);

    SalesInvoice getSalesInvoiceByInvoiceNo(int sellInvoiceNo);
}
