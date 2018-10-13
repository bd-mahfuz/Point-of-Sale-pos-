package com.pos.service;

import com.pos.dto.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SupplierService {

    boolean addSupplier(Supplier supplier);
    boolean updateSupplier(Supplier supplier);
    boolean deleteSupplier(int id);

    List<Supplier> getAllSupplier();
    Supplier getSupplier(int id);


}
