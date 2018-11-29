package com.italent.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.italent.entities.Address;
import com.italent.entities.Person;
import com.italent.utils.DataBaseUtils;

public class CreatePerson {

	private static DataBaseUtils dbUtils = null;

	public static void main(String[] args) {
		dbUtils = new DataBaseUtils();

		SessionFactory factory = dbUtils.getSessionFactory();

		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("Saving the person");
			Address address = new Address("Hyderabad", "TS");
			Person person = new Person("italent", "application");
			person.setAddress(address);
			session.save(address);
			session.save(person);
			System.out.println("person save successfully");
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
