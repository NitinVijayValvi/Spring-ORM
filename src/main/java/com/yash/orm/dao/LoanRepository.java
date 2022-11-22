package com.yash.orm.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.yash.orm.entity.Customer;
import com.yash.orm.entity.CustomerLoanAmount;
import com.yash.orm.entity.Loan;
import com.yash.orm.entity.LoanTypeAmount;
import com.yash.orm.entity.TotalBranchLoan;
import com.yash.orm.util.HibernateUtil;

@Repository
public class LoanRepository {
	public List<Loan> getAllLoan() {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			String hql = "FROM Loan";
			Query query = session.createQuery(hql);
			List results = query.getResultList();

			transaction.commit();
			session.close();

			return results;

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}

	public List<Customer> getCustomerWithMinLoan() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Transaction transaction = session.beginTransaction();

			String hql = "select * from Customer where custId= (select custId from loan where loanAmount= (select min(loanAmount) from loan)) ";

			Query query = session.createNativeQuery(hql, Customer.class);
			List<Customer> result = query.getResultList();

			transaction.commit();
			session.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Customer> getCustomerWithMaxLoan() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Transaction transaction = session.beginTransaction();

			String hql = "select * from Customer where custId= (select custId from loan where loanAmount= (select max(loanAmount) from loan)) ";

			Query query = session.createNativeQuery(hql, Customer.class);
			List<Customer> result = query.getResultList();

			transaction.commit();
			session.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<CustomerLoanAmount> getCustomerWiseLoanAmount() {
		// TODO Auto-generated method stub
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Transaction transaction = session.beginTransaction();

			String hql = "select c.custId as custId,c.custName as custName,sum(l.loanAmount) as loanAmount from customer as c inner join loan as l on c.custId=l.custId group by l.custId";

			Query query = session.createNativeQuery(hql, CustomerLoanAmount.class);
			List<CustomerLoanAmount> result = query.getResultList();

			transaction.commit();
			session.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

// 

	public List<TotalBranchLoan> getTotalLoanOfBranchEveryMonth() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Transaction transaction = session.beginTransaction();

			String hql = "select l.loanId as loanId,b.branchname as branchName,sum(l.loanAmount) as totalLoanAmount,l.loanDate as loanDate from branch as b inner join loan as l on b.branchId=l.branchId group by l.loanDate";

			Query query = session.createNativeQuery(hql, TotalBranchLoan.class);
			List<TotalBranchLoan> result = query.getResultList();

			transaction.commit();
			session.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<LoanTypeAmount> findTotalAmountLoanTypeWise() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Transaction transaction = session.beginTransaction();

			String hql = "select loanId ,loanType,sum(loanAmount) as totalLoanAmount from loan group by loanType";

			Query query = session.createNativeQuery(hql, LoanTypeAmount.class);
			List<LoanTypeAmount> result = query.getResultList();

			transaction.commit();
			session.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Loan> findLoanOverInNextDays(int days) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Transaction transaction = session.beginTransaction();

			String hql = "select * from loan where loanOverDate between now() and (now() + INTERVAL (?1) day)";

			Query query = session.createNativeQuery(hql, Loan.class).setParameter(1, days);
			List<Loan> result = query.getResultList();

			transaction.commit();
			session.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Loan> findLoanComplected() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Transaction transaction = session.beginTransaction();

			String hql = "select * from loan where loanOverDate < now()";

			Query query = session.createNativeQuery(hql, Loan.class);
			List<Loan> result = query.getResultList();

			transaction.commit();
			session.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
