package com.hb.mappings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hb.mappings.entities.Course;
import com.hb.mappings.entities.Student;
import com.hb.mappings.utils.HibernateUtils;

public class RetriveData {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactroy();

		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("*****Getting Student Object*****");
			Student student = session.get(Student.class, 1);
			System.out.println("For Student: " + student.getName());
			student.getCourses().forEach(course -> System.out
					.println("Course is: " + course.getName() + " with Title: " + course.getTitle()));
			System.out.println("*****End of getting Student Object*****");
			
			System.out.println("*****Getting Course Object*****");
			Course course = session.get(Course.class, 3);
			System.out.println("For Course: " + course.getName());
			course.getStudents().forEach(studentData -> System.out
					.println("Student is: " + studentData.getName()));
			System.out.println("*****End of getting Course Object*****");
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}
	}

}
