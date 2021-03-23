package com.example.bankingSystem.service;

import com.example.bankingSystem.entities.DAOCustomer;
import com.example.bankingSystem.entities.DAOUser;
import com.example.bankingSystem.model.CustomerDTO;
import com.example.bankingSystem.model.EmployeeDTO;

/**
 * Created by mandeep.singh on 10:58 AM 23/03/21 Tuesday
 */
public interface CustomerManagementService {
    DAOCustomer addCustomer(CustomerDTO customer);
    DAOCustomer deleteCustomer(CustomerDTO customer);
    int updateKYC(CustomerDTO customer);
}
