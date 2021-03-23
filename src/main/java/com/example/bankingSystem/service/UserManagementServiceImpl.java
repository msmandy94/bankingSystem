package com.example.bankingSystem.service;

import com.example.bankingSystem.dao.UserDao;
import com.example.bankingSystem.model.AddEmployeeDTO;
import com.example.bankingSystem.model.DAOUser;
import com.example.bankingSystem.model.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by mandeep.singh on 9:03 AM 23/03/21 Tuesday
 */
@Service
public class UserManagementServiceImpl implements UserManagementService {

    @Autowired
    UserDao userDao;
    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public DAOUser addEmployee(AddEmployeeDTO user) {
        DAOUser newUser = new DAOUser();
        newUser.setUsername(user.getEmployeeUserName());
        newUser.setPassword(bcryptEncoder.encode(user.getEmployeePassword()));
        newUser.setType(UserType.EMPLOYEE.name());
        return userDao.save(newUser);
    }
}
