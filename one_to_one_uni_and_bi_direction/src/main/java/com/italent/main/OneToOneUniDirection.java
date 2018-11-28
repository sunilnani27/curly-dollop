package com.italent.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.italent.entities.Address;
import com.italent.entities.Person;
import com.italent.utils.DataBaseUtils;

public class OneToOneUniDirection {
	private static DataBaseUtils dataBaseUtils = null;
	private static SessionFactory sessionFactory = null;
	private static Session session = null;

	public static void main(String[] args) {
		dataBaseUtils = new DataBaseUtils();

		sessionFactory = dataBaseUtils.getSessionFactory();

		try {
			session = sessionFactory.getCurrentSession();
			Address address = new Address("Hyderabad", "TS");

			Person person = new Person("iTalent", "India");

			person.setAddress(address);

			session.beginTransaction();

			session.save(person);

			session.getTransaction().commit();

			System.out.println("Saved successfully");

			// should update ain address with person when person is updated coz of cascade type
			updatePerson(person);

			// delete person should result delete address also due to cascade type all
			// deletePerson(person);

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sessionFactory.close();
		}
	}

	public static void deletePerson(Person person) {
		try {
			sessionFactory = dataBaseUtils.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.delete(person);
			session.getTransaction().commit();
			System.out.println("Person deleted Successfully");
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	public static void updatePerson(Person person) {
		try {
			sessionFactory = dataBaseUtils.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			person.getAddress().setCity("Banglore");
			person.getAddress().setState("KA");
			person.setFirstName("Sunil");
			person.setLastName("Sarella");
			session.update(person);
			session.getTransaction().commit();
			System.out.println("Person updated Successfully");
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
