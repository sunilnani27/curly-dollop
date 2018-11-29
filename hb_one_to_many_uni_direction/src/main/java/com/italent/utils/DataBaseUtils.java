package com.italent.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.italent.entities.Address;
import com.italent.entities.Person;
import com.italent.entities.Technology;

public class DataBaseUtils {
	public SessionFactory getSessionFactory() {
		SessionFactory sessionFactory = null;
		try {
			sessionFactory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Person.class)
					.addAnnotatedClass(Address.class)
					.addAnnotatedClass(Technology.class)
					.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sessionFactory;
	}
}
