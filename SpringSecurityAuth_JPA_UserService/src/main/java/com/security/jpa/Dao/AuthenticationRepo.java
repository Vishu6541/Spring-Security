package com.security.jpa.Dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.security.jpa.Entity.AuthenticationModel;

public interface AuthenticationRepo extends CrudRepository<AuthenticationModel, Integer> {
	
	public Optional<AuthenticationModel> findByEmail(String email);

}
