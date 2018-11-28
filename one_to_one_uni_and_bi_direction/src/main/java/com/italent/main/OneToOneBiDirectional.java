package com.italent.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.italent.entities.Address;
import com.italent.utils.DataBaseUtils;

public class OneToOneBiDirectional {

	private static DataBaseUtils dataBaseUtils = null;
	private static SessionFactory sessionFactory = null;
	private static Session session = null;

	public static void main(String[] args) {
		dataBaseUtils = new DataBaseUtils();
		sessionFactory = dataBaseUtils.getSessionFactory();
		int id = 2;

		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Address address = session.get(Address.class, id);
			System.out.println("Bi directional data Address: " + address);
			System.out.println("Bi directional data Person: " + address.getPerson());
			session.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
