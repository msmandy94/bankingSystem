package com.example.bankingSystem.dao;

import com.example.bankingSystem.entities.DAOCustomer;
import com.example.bankingSystem.entities.DAOUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mandeep.singh on 11:12 AM 23/03/21 Tuesday
 */

@Repository
public interface CustomerDao extends CrudRepository<DAOCustomer, Integer> {
    DAOCustomer findById(int id);

    DAOCustomer deleteById(int id);

}