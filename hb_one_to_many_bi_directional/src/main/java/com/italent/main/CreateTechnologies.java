package com.italent.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.italent.entities.Person;
import com.italent.entities.Technology;
import com.italent.utils.DataBaseUtils;

public class CreateTechnologies {

	private static DataBaseUtils dbUtils = null;

	public static void main(String[] args) {
		dbUtils = new DataBaseUtils();

		SessionFactory factory = dbUtils.getSessionFactory();

		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("Saving the technologies");
			Person person = session.get(Person.class, 1);
			Technology javaScript = new Technology("Java Script");
			Technology java = new Technology("Java");
			Technology angular = new Technology("angular");
			person.addTechnology(javaScript);
			person.addTechnology(java);
			person.addTechnology(angular);
			
			session.save(javaScript);
			session.save(java);
			session.save(angular);
			System.out.println("technologies saved successfully");
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
