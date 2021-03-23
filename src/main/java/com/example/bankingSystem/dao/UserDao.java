package com.example.bankingSystem.dao;

import com.example.bankingSystem.entities.DAOUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {
	
	DAOUser findByUsername(String username);

	@Transactional
	int deleteByUsername(String username);

}