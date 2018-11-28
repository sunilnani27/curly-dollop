package com.italent.com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.italent.com.entity.Student;
import com.italent.com.utils.DataBaseUtils;


/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		DataBaseUtils utils = new DataBaseUtils();
		SessionFactory sessionFactory = utils.getSessionFactory();
		Student student = new Student("test fname", "test lname", "test email");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
			System.out.println("successfully saved");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}
	}

}
