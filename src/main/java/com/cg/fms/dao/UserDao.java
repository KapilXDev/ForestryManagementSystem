package com.cg.fms.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.fms.dto.User;



public interface UserDao extends JpaRepository<User, Integer>{
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

}
