package com.pos.serviceImpl;

import com.pos.dao.CustomerDao;
import com.pos.dto.Customer;
import com.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDao customerDao;

    @Override
    public boolean addCustomer(Customer customer) {
        return customerDao.add(customer);
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return customerDao.update(customer);
    }

    @Override
    public boolean deleteCustomer(int id) {
        return customerDao.delete(id);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerDao.getAll();
    }

    @Override
    public Customer getCustomer(int id) {
        return customerDao.get(id);
    }
}
