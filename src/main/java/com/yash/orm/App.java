package com.yash.orm;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.yash.orm.dao.TestRepository;
import com.yash.orm.entity.StudentMarks;

public class App {
	public static void main(String[] args) {
//
//		problem 2
		TestRepository test = new TestRepository();

//		System.out.println("Loan which Cmplected");
//		loan.findLoanComplected().forEach(list-> System.out.println(list.getLoanId()+" "+list.getLoanType()+" "+list.getCustId()+" "+list.getBranchId()+" "+list.getBranchId()+" "+list.getLoanAmount()+ " "+list.getLoanDate()+" "+list.getLoanOverDate()));

		// int studentCount=test.findStudnetCount();
//		System.out.println("Stduent count is  :: "+studentCount);

//		List<StudentMarks> studentList=test.findStudnetMarks();
//		studentList.stream().forEach(list -> System.out.println(list.getStudentId()+" "+list.getStudentName()+" "+list.getMarks()));

//		List<Student> studentList = test.findStduentNotAttemptTest();
//		studentList.stream().forEach(
//				list -> System.out.println(list.getStudentId() + " " + list.getRollNo() + " " + list.getStudentName()  ));

//		List<Student> studentList1 = test.findStduentAttemptTest();
//		studentList1.stream().forEach(
//				list -> System.out.println(list.getStudentId() + " " + list.getRollNo() + " " + list.getStudentName()  ));
		
		List<StudentMarks> studentMarksList=test.findStudnetMarks();
		
		Collections.sort(studentMarksList, Comparator.comparing(StudentMarks::getMarks).reversed()
			    .thenComparing(StudentMarks::getStudentName));
		
		studentMarksList.stream().forEach(list -> System.out.println(list.getStudentId()+" "+list.getStudentName()+" "+list.getMarks()));
		
		System.out.println("Fail students");
		List<StudentMarks> failStudentList=test.findFailStudnets();
		failStudentList.stream().forEach(list -> System.out.println(list.getStudentId()+" "+list.getStudentName()+" "+list.getMarks()));
		
		//Problem1
		
		//		LoanRepository loan = new LoanRepository();
//		System.out.println("Customer with max loan Amount");
//		loan.getCustomerWithMaxLoan().forEach(list-> System.out.println(list));
//	
//		System.out.println("Customer with min loan Amount");
//		loan.getCustomerWithMinLoan().forEach(list-> System.out.println(list));

//		System.out.println("Cutomers with total loan Amount: ");
//		loan.getCustomerWiseLoanAmount().forEach(list-> System.out.println(list.getCustId()+" "+list.getCustName()+" "+list.getLoanAmount()));

//		System.out.println("Total loan of branch every month ");
//		loan.getTotalLoanOfBranchEveryMonth().forEach(list-> System.out.println(list.getLoanId()+" "+list.getBranchName()+" "+list.getTotalLoanAmount()+" "+list.getLoanDate()));

//		System.out.println("Total loan of Type wise");
//	    loan.findTotalAmountLoanTypeWise().forEach(list-> System.out.println(list.getLoanId()+" "+list.getLoanType()+" "+list.getTotalLoanAmount()));

//		System.out.println("Loan which going to over in 7 Days ");
//		loan.findLoanOverInNextDays(7).forEach(list-> System.out.println(list.getLoanId()+" "+list.getLoanType()+" "+list.getCustId()+" "+list.getBranchId()+" "+list.getBranchId()+" "+list.getLoanAmount()+ " "+list.getLoanDate()+" "+list.getLoanOverDate()));
//		
//		System.out.println("Loan which going to over in 15 Days ");
//		loan.findLoanOverInNextDays(15).forEach(list-> System.out.println(list.getLoanId()+" "+list.getLoanType()+" "+list.getCustId()+" "+list.getBranchId()+" "+list.getBranchId()+" "+list.getLoanAmount()+ " "+list.getLoanDate()+" "+list.getLoanOverDate()));
//		
//		System.out.println("Loan which going to over in 30 Days ");
//		loan.findLoanOverInNextDays(30).forEach(list-> System.out.println(list.getLoanId()+" "+list.getLoanType()+" "+list.getCustId()+" "+list.getBranchId()+" "+list.getBranchId()+" "+list.getLoanAmount()+ " "+list.getLoanDate()+" "+list.getLoanOverDate()));


	}
}