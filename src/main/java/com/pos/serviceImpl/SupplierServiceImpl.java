package com.pos.serviceImpl;

import com.pos.dao.SupplierDao;
import com.pos.dto.Supplier;
import com.pos.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService{

    @Autowired
    private SupplierDao supplierDao;

    @Override
    public boolean addSupplier(Supplier supplier) {
        return supplierDao.add(supplier);
    }

    @Override
    public boolean updateSupplier(Supplier supplier) {
        return supplierDao.update(supplier);
    }

    @Override
    public boolean deleteSupplier(int id) {
        return supplierDao.delete(id);
    }

    @Override
    public List<Supplier> getAllSupplier() {
        return supplierDao.getAll();
    }

    @Override
    public Supplier getSupplier(int id) {
        return supplierDao.get(id);
    }
}
