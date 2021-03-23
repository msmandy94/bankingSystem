package com.example.bankingSystem.dao;

import com.example.bankingSystem.entities.DAOAccount;
import com.example.bankingSystem.entities.DAOLedger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LedgerDao extends CrudRepository<DAOLedger, Integer> {

	DAOLedger findById(long id);

	void deleteById(long id);

	
}