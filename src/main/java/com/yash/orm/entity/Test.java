package com.yash.orm.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Test")
public class Test {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="testId")
	private int testId;
	
	@Column(name = "testName")
	private String testName;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Student student;
	
	@Column(name = "physics")
	private int physics;
	
	@Column(name = "chemistry")
	private int chemistry;
	
	@Column(name = "biology")
	private int biology;
	
	@Column(name = "maths")
	private int maths;
	
	@Column(name = "english")
	private int english;
	
	Test()
	{
		
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getPhysics() {
		return physics;
	}

	public void setPhysics(int physics) {
		this.physics = physics;
	}

	public int getChemistry() {
		return chemistry;
	}

	public void setChemistry(int chemistry) {
		this.chemistry = chemistry;
	}

	public int getBiology() {
		return biology;
	}

	public void setBiology(int biology) {
		this.biology = biology;
	}

	public int getMaths() {
		return maths;
	}

	public void setMaths(int maths) {
		this.maths = maths;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}
	
	



}
