package com.cg.fms.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.fms.dto.ERole;
import com.cg.fms.dto.Role;

public interface RoleDao extends JpaRepository<Role, Long> {

	Optional<Role> findByName(ERole name);
}
