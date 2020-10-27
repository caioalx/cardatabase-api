package com.packt.cardatabase.infra.security.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.packt.cardatabase.infra.security.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);
	
}
