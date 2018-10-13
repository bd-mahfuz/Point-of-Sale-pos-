package com.pos.dao;


import com.pos.dto.SalesInvoice;

import java.util.List;

public interface SalesInvoiceDao {
    public boolean add(SalesInvoice salesInvoice);
    public boolean update(SalesInvoice salesInvoice);
    public boolean delete(int id);

    public List<SalesInvoice> getAll();
    public SalesInvoice get(int id);


}
