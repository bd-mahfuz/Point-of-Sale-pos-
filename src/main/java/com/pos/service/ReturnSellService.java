package com.pos.service;

import com.pos.dao.ReturnSellDao;
import com.pos.dto.SalesInvoice;

public interface ReturnSellService extends ReturnSellDao{

    boolean returnSell(SalesInvoice salesInvoice, int returnQuantity);
    boolean returnSell(String macId);

}
