package com.cg.fms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.dto.Admin;
import com.cg.fms.dto.User;



@Repository
public interface AdminDao extends JpaRepository<Admin, Integer>{
	
	//@Query("Select a from Admin a where a.adminName=adminName")
	//Optional<Admin> findByAdminName(String adminName);

	//Boolean existsByAdminName(String username);
	//Optional<User> findByUsername(String username);
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);
	

	/*@Query("Delete from Admin a where a.adminName=admin.getAdminName()")
	boolean deleteAdmin(Admin admin);
	
	//@Query("Select a from Admin a")
	List<Admin> findAll();*/
}
