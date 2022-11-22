package com.yash.orm.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.yash.orm.entity.Branch;
import com.yash.orm.entity.Customer;
import com.yash.orm.entity.Loan;
import com.yash.orm.entity.Student;
import com.yash.orm.util.HibernateUtil;

@Repository
public class CutomerRepository {

	public List<Customer> getAllCustomer() {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			String hql = "FROM Customer";
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
	
	

}
