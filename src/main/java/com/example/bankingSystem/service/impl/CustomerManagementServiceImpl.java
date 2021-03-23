package com.example.bankingSystem.service.impl;

import com.example.bankingSystem.dao.CustomerDao;
import com.example.bankingSystem.entities.DAOCustomer;
import com.example.bankingSystem.model.CustomerDTO;
import com.example.bankingSystem.service.CustomerManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mandeep.singh on 10:59 AM 23/03/21 Tuesday
 */
@Service
public class CustomerManagementServiceImpl implements CustomerManagementService {
    @Autowired
    private CustomerDao customerDao;

    @Override
    public DAOCustomer addCustomer(CustomerDTO customer) {
        DAOCustomer daoCustomer = new DAOCustomer();
        daoCustomer.setCustomerName(customer.getCustomerName());
        daoCustomer.setKYCDone(customer.isKycDone());
        return customerDao.save(daoCustomer);
    }

    @Override
    public DAOCustomer deleteCustomer(CustomerDTO customer) {
        return customerDao.deleteById(customer.getCustomerId());
    }

    @Override
    public int updateKYC(CustomerDTO customer) {
        int rowsModified =  customerDao.updateKycStatus(customer.isKycDone(), customer.getCustomerId());
        System.out.println(rowsModified);
        return rowsModified;
    }
}
