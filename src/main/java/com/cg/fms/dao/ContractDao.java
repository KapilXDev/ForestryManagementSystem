package com.cg.fms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.fms.dto.Contract;

@Repository
public interface ContractDao extends JpaRepository<Contract, Integer>{
	/*
	public Contract findContract(int contractNumber);

	public boolean addContract(Contract contract);

	public boolean updateContract(Contract contract);

	@Query("Delete from Contract a where a.contractnumber=contractNumber")
	public boolean deleteContract(int contractNumber);
	
	public List<Contract> findAllContracts();*/
}
