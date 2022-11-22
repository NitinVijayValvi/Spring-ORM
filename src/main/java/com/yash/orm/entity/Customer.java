package com.yash.orm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "custId")
	private int custId;
	
	public Customer() {}
	@Column(name = "custName")
	private String custName;
	
	@Column(name = "custAddress")
	private String custAddress;
	
	@Column(name = "custDOB")
	private Date custDob;
	
	@Column(name = "custDOR")
	private Date custDor;

	public Customer(int custId, String custName, String custAddress, Date custDob, Date custDor) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custAddress = custAddress;
		this.custDob = custDob;
		this.custDor = custDor;
	}

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

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public Date getCustDob() {
		return custDob;
	}

	public void setCustDob(Date custDob) {
		this.custDob = custDob;
	}

	public Date getCustDor() {
		return custDor;
	}

	public void setCustDor(Date custDor) {
		this.custDor = custDor;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custAddress=" + custAddress + ", custDob="
				+ custDob + ", custDor=" + custDor + "]";
	}
	
	
	

}
