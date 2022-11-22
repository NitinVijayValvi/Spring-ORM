package com.yash.orm.dao;



import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yash.orm.entity.Student;
import com.yash.orm.entity.StudentMarks;
import com.yash.orm.util.HibernateUtil;

public class TestRepository {
	
	public int findStudnetCount()
	{
		Transaction transaction=null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			String hql = "from Student";
			Query query = session.createQuery(hql);
			int results = query.getResultList().size();

			transaction.commit();
			session.close();

			return results;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
	}
	
	public List<StudentMarks> findStudnetMarks()
	{
		Transaction transaction=null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			String hql = "select t.studentId as studentId,s.studentName as studentName,(sum(t.physics+t.chemistry+t.Biology+t.maths+t.english)/500)*100 as marks \r\n"
					+ "from \r\n"
					+ "test as t\r\n"
					+ "inner join\r\n"
					+ "student as s\r\n"
					+ "on s.studentId=t.studentId \r\n"
					+ "group by studentId";
			Query query = session.createNativeQuery(hql,StudentMarks.class);
			List<StudentMarks> results = query.getResultList();

			transaction.commit();
			session.close();

			return results;

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}
	
	public List<Student> findStduentNotAttemptTest()
	{
		Transaction transaction=null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			String hql = "select * from Student where studentId not in (select studentId  from Test )";
			Query query = session.createNativeQuery(hql,Student.class);
			List<Student> results= query.getResultList();

			transaction.commit();
			session.close();

			return results;

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}
	
	public List<Student> findStduentAttemptTest()
	{
		Transaction transaction=null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			String hql = "select * from Student where studentId in (select studentId  from Test )";
			Query query = session.createNativeQuery(hql,Student.class);
			List<Student> results= query.getResultList();

			transaction.commit();
			session.close();

			return results;

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}

	public List<StudentMarks> findFailStudnets()
	{
		Transaction transaction=null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			String hql = "select * from \r\n"
					+ "(select t.studentId,s.studentName,(sum(t.physics+t.chemistry+t.Biology+t.maths+t.english)/500)*100 as marks \r\n"
					+ "from \r\n"
					+ "test as t\r\n"
					+ "inner join\r\n"
					+ "student as s\r\n"
					+ "on s.studentId=t.studentId \r\n"
					+ "group by studentId) as a\r\n"
					+ "where a.marks < 35.00";
			Query query = session.createNativeQuery(hql,StudentMarks.class);
			List<StudentMarks> results = query.getResultList();

			transaction.commit();
			session.close();

			return results;

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}
}
