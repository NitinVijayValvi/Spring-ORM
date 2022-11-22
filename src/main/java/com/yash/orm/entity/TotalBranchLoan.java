package com.yash.orm.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TotalBranchLoan {
	
	@Id
	private int loanId;
	
	private String branchName;
	
	private int totalLoanAmount;
	
	private Date loanDate;

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public int getTotalLoanAmount() {
		return totalLoanAmount;
	}

	public void setTotalLoanAmount(int totalLoanAmount) {
		this.totalLoanAmount = totalLoanAmount;
	}

	public Date getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}
	
	

}
