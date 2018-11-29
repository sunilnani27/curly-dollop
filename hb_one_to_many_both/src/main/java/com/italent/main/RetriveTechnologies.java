package com.italent.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.italent.entities.Person;
import com.italent.utils.DataBaseUtils;

public class RetriveTechnologies {

	private static DataBaseUtils baseUtils = null;

	public static void main(String[] args) {

		baseUtils = new DataBaseUtils();

		SessionFactory factory = baseUtils.getSessionFactory();

		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			Person person = session.get(Person.class, 5);
			person.getTechnologies().forEach((data) -> 
			System.out.println("Title: "+data.getTitle())
			);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
