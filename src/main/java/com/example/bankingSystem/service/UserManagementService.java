package com.example.bankingSystem.service;

import com.example.bankingSystem.model.EmployeeDTO;
import com.example.bankingSystem.entities.DAOUser;

/**
 * Created by mandeep.singh on 9:03 AM 23/03/21 Tuesday
 */
public interface UserManagementService {
    DAOUser addEmployee(EmployeeDTO user);
    void deleteEmployee(EmployeeDTO user);

    DAOUser getUserByUserName(String userName);

}
