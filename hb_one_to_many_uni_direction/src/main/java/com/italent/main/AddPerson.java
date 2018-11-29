package com.italent.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.italent.entities.Address;
import com.italent.entities.Person;
import com.italent.entities.Technology;
import com.italent.utils.DataBaseUtils;

public class AddPerson {

	private static DataBaseUtils dataBaseUtils = null;

	public static void main(String[] args) {
		dataBaseUtils = new DataBaseUtils();

		SessionFactory sessionFactory = dataBaseUtils.getSessionFactory();

		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();

			Person person = new Person("iTalent", "India");

			Address address = new Address("Hyderabad", "TS");
			person.setAddress(address);

			Technology technology = new Technology("Java");
			Technology technology2 = new Technology("Angular");
			Technology technology3 = new Technology("Artificial Intelligence");

			technology.setPerson(person);
			technology2.setPerson(person);
			technology3.setPerson(person);

			session.save(person);
			
			session.save(person.getAddress());

			session.save(technology);
			session.save(technology2);
			session.save(technology3);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}
	}

}
