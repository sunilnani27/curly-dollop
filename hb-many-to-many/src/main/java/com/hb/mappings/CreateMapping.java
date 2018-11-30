package com.hb.mappings;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hb.mappings.entities.Course;
import com.hb.mappings.entities.Student;
import com.hb.mappings.utils.HibernateUtils;

public class CreateMapping {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactroy();
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();

			// a student can have multiple course
			Student student = new Student("italent", "Hyderabad", 25);
			Course js = new Course("Java SCript", "Master in JS");
			Course java = new Course("Java", "Master in Java");
			List<Course> courses = new ArrayList<>();
			courses.add(js);
			courses.add(java);

			student.setCourses(courses);

			// couses can have multiple students
			Course coveo = new Course("coveo", "Coveo");
			Student cisco = new Student("cisco", "Banglore", 20);
			Student microsoft = new Student("microsoft", "Pune", 25);
			List<Student> students = new ArrayList<>();
			students.add(cisco);
			students.add(microsoft);
			coveo.setStudents(students);

			session.persist(student);
			session.persist(coveo);
			session.getTransaction().commit();
			System.out.println("Saved Successfully <<<<<");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}
	}
}
