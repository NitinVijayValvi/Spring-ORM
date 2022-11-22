package com.yash.orm.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Loan")
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="loanId")
	private int loanId;
	
	@Column(name="loanType")
	private String loanType;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="custId")
	private List<Customer>custId;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="branchId")
	private List<Branch> branchId;

	@Column(name="loanDate")
	private Date loanDate;
	
	@Column(name="loanOverDate")
	private Date loanOverDate;
	
	@Column(name="loanAmount")
	private int loanAmount;
	
	public Loan()
	{}

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

	public List<Customer> getCustId() {
		return custId;
	}

	public void setCustId(List<Customer> custId) {
		this.custId = custId;
	}

	
	public List<Branch> getBranchId() {
		return branchId;
	}

	public void setBranchId(List<Branch> branchId) {
		this.branchId = branchId;
	}

	public Date getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}

	public Date getLoanOverDate() {
		return loanOverDate;
	}

	public void setLoanOverDate(Date loandOverDate) {
		this.loanOverDate = loandOverDate;
	}

	public int getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}

	

	
	
}
