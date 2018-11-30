package com.hb.mappings.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hb.mappings.entities.Course;
import com.hb.mappings.entities.Student;

public class HibernateUtils {
	private static SessionFactory sessionFactory;

	private HibernateUtils() {
	}

	public static SessionFactory getSessionFactroy() {
		if (sessionFactory == null) {
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
					.addAnnotatedClass(Course.class).buildSessionFactory();
		}

		return sessionFactory;
	}
}
