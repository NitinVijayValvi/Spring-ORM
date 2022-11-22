package com.yash.orm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentMarks {

	@Id
	private int studentId;
	
	private String studentName;
	
	private int marks;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}
	
}
