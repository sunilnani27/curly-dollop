package com.italent.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.italent.entities.Address;
import com.italent.entities.Person;
import com.italent.utils.DataBaseUtils;

public class DeletePerson {

	private static DataBaseUtils dataBaseUtils = null;

	public static void main(String[] args) {
		dataBaseUtils = new DataBaseUtils();

		SessionFactory sessionFactory = dataBaseUtils.getSessionFactory();

		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Person person = session.get(Person.class, 9);

			Address address  = person.getAddress();
			address.setPerson(null);

			person.getTechnologies().forEach(technology -> technology.setPerson(null));

			session.merge(address);

			person.getTechnologies().forEach(technology -> session.merge(technology));

			session.remove(person);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}
	}

}
