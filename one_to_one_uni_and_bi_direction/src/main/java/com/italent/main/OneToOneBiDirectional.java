package com.italent.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.italent.entities.Address;
import com.italent.entities.Person;
import com.italent.utils.DataBaseUtils;

public class OneToOneBiDirectional {

	private static DataBaseUtils dataBaseUtils = null;
	private static SessionFactory sessionFactory = null;
	private static Session session = null;

	public static void main(String[] args) {
		dataBaseUtils = new DataBaseUtils();
		sessionFactory = dataBaseUtils.getSessionFactory();
		int id = 6;

		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Address address = session.get(Address.class, id);
			System.out.println("Bi directional data Address: " + address);
			System.out.println("Bi directional data Person: " + address.getPerson());
			session.getTransaction().commit();

			System.out.println("Deleting the adress which will also delete person");

			deleteAddress(address);

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	public static void deleteAddress(Address address) {
		sessionFactory = dataBaseUtils.getSessionFactory();
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			// just detach or break the bi direction in order to delete address only
			Person person = session.get(Person.class, address.getPerson().getId());

			Address addressToDelete = person.getAddress();

			person.setAddress(null);

			session.merge(person);

			session.remove(addressToDelete);
			session.getTransaction().commit();
			System.out.println("Deleted successfully");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
