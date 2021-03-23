package com.example.bankingSystem.dao;

import com.example.bankingSystem.entities.DAOAccount;
import com.example.bankingSystem.entities.DAOUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountDao extends CrudRepository<DAOAccount, Integer> {

	DAOAccount findById(int id);

	void deleteById(int id);
	
}