package com.cg.fms.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.advices.ResourceNotFoundException;
import com.cg.fms.dao.ContractDao;
import com.cg.fms.dto.Contract;

@Service
public class ContractServiceImpl implements ContractService {
	
	@Autowired
	ContractDao repo;

	@Override
	public Contract getContract(int contractNumber) throws Exception {
		// TODO Auto-generated method stub
		Supplier<Exception> s1 = ()->new ResourceNotFoundException("Contract not present in the database");
		Contract c=repo.findById(contractNumber).orElseThrow(s1);
		return c;
	}

	@Override
	public Contract addContract(Contract contract) {
		// TODO Auto-generated method stub
		repo.save(contract);
			return contract;
	}

	@Override
	public Contract updateContract(Contract contract) throws Exception {
		// TODO Auto-generated method stub
		Supplier<Exception> s1 = ()->new ResourceNotFoundException("Contract not present in the database");
			Contract c=repo.findById(contract.getContractNumber()).orElseThrow(s1);
			repo.save(contract);
			return contract;
	}

	@Override
	public Contract deleteContract(int contractNumber) throws Exception {
		// TODO Auto-generated method stub
		Supplier<Exception> s1 = ()->new ResourceNotFoundException("Contract not present in the database");
		Contract c=repo.findById(contractNumber).orElseThrow(s1);
		repo.delete(c);
			return c;
		
	}

	@Override
	public List<Contract> getAllContracts() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}


/*
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long userId;
@NotNull
@Size(min=3,message="User name should atleast 3 characters")
@Column(name="User_name")
private String name;
@NotNull
@Column(name="email")
private String email;
@NotNull
@Size(min=10,max=10,message="Please provide valid mobile no.")
private String contactNo;
@NotNull
@Pattern(regexp="^\\d{2}-\\d{2}-\\d{4}$",message="Provide Date in the format DD-MM-YYYY")
private String dob;
@NotNull
@OneToOne(cascade=CascadeType.ALL)
private Address address;
@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="appointment_id")
private Appointment appointment;
@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="order_id")
private Order order;
*/
