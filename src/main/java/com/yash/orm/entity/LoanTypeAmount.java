package com.yash.orm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LoanTypeAmount {
	
	@Id
	private int loanId;
	
	private String loanType;
	
	private int totalLoanAmount;

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public int getTotalLoanAmount() {
		return totalLoanAmount;
	}

	public void setTotalLoanAmount(int totalLoanAmount) {
		this.totalLoanAmount = totalLoanAmount;
	}
	
	

}
