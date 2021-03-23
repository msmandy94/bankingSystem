package com.example.bankingSystem.dao;

import com.example.bankingSystem.entities.DAOCustomer;
import com.example.bankingSystem.entities.DAOUser;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by mandeep.singh on 11:12 AM 23/03/21 Tuesday
 */

@Repository
public interface CustomerDao extends CrudRepository<DAOCustomer, Integer> {
    DAOCustomer findById(int id);

    DAOCustomer deleteById(int id);

    @Modifying
    @Transactional
    @Query(value = "update customer set iskycdone = ?1 where id = ?2", nativeQuery = true)
    int updateKycStatus(boolean iskycdone, int customerId);

}