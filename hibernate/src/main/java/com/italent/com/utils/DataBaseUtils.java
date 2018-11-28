package com.italent.com.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.italent.com.entity.Student;



public class DataBaseUtils {
	public SessionFactory getSessionFactory() {
		SessionFactory sessionFactory = null;
		try {
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
					.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return sessionFactory;
	}
}
