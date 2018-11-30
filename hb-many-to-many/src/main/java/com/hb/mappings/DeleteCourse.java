package com.hb.mappings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hb.mappings.entities.Course;
import com.hb.mappings.utils.HibernateUtils;

public class DeleteCourse {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactroy();

		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			Course course = session.get(Course.class, 1);
			course.setStudents(null);
			session.delete(course);
			session.getTransaction().commit();
			System.out.println("Deleted successfully");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
