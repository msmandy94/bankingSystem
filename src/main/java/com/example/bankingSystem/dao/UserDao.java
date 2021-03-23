package com.example.bankingSystem.dao;

import com.example.bankingSystem.entities.DAOUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {
	
	DAOUser findByUsername(String username);

	void deleteByUsername(String username);
	
}