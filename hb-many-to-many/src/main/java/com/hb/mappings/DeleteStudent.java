package com.hb.mappings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hb.mappings.entities.Student;
import com.hb.mappings.utils.HibernateUtils;

public class DeleteStudent {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactroy();

		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			Student student = session.get(Student.class, 1);
			student.setCourses(null);
			session.delete(student);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
