package com.cg.fms.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Scheduler {
	
	@Id
	@GeneratedValue
	private int schedulerId;
	@NotNull
	@Length(min = 5, max = 20, message = "Scheduler name should be 5 to 25 characters")
	private String schedulerName;
	@NotNull
	@Length(min = 10, max = 10,message="Please provide valid mobile no.")
	private String schedulerContact;
	private String truckNumber;
	
	public int getSchedulerId() {
		return schedulerId;
	}
	public void setSchedulerId(int schedulerId) {
		this.schedulerId = schedulerId;
	}
	public String getSchedulerName() {
		return schedulerName;
	}
	public void setSchedulerName(String schedulerName) {
		this.schedulerName = schedulerName;
	}
	public String getSchedulerContact() {
		return schedulerContact;
	}
	public void setSchedulerContact(String schedulerContact) {
		this.schedulerContact = schedulerContact;
	}
	public String getTruckNumber() {
		return truckNumber;
	}
	public void setTruckNumber(String truckNumber) {
		this.truckNumber = truckNumber;
	}
	
	

}
