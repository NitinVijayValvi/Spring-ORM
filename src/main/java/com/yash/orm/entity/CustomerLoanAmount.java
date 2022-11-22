package com.yash.orm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomerLoanAmount {
	
	@Id
	private int custId;
	private String custName;
	private int loanAmount;
	
	CustomerLoanAmount()
	{}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public int getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}

	
	
	
	
	

}
