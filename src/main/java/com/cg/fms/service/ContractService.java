package com.cg.fms.service;

import java.util.List;

import com.cg.fms.dto.Contract;

public interface ContractService {
	
	public Contract getContract(int contractNumber) throws Exception;
	public Contract addContract(Contract contract);
	public Contract updateContract(Contract contract) throws Exception;
	public Contract deleteContract(int contractNumber) throws Exception;
	public List<Contract> getAllContracts();
}