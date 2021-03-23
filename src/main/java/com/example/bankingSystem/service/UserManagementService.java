package com.example.bankingSystem.service;

import com.example.bankingSystem.model.AddEmployeeDTO;
import com.example.bankingSystem.model.DAOUser;

/**
 * Created by mandeep.singh on 9:03 AM 23/03/21 Tuesday
 */
public interface UserManagementService {
    DAOUser addEmployee(AddEmployeeDTO user);

    DAOUser getUserByUserName(String userName);

}
