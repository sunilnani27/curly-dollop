package com.italent.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.italent.entities.Technology;
import com.italent.utils.DataBaseUtils;

public class DeleteTechnology {

	private static DataBaseUtils dataBaseUtils = null;

	public static void main(String[] args) {
		dataBaseUtils = new DataBaseUtils();

		SessionFactory sessionFactory = dataBaseUtils.getSessionFactory();

		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();

			Technology technology = session.get(Technology.class, 2);

			// technology.setPerson(null);

			session.delete(technology);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}
	}

}
