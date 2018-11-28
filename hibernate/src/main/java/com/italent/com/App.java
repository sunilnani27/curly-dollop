package com.italent.com;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.italent.com.entity.Student;
import com.italent.com.utils.DataBaseUtils;
import com.italent.com.utils.DateUtils;

public class App {
	public static DataBaseUtils utils = null;
	public static DateUtils dateUtils = null;
	public static SessionFactory sessionFactory = null;
	public static Session session;

	public static void main(String[] args) throws ParseException {
		utils = new DataBaseUtils();
		dateUtils = new DateUtils();

		String birthDate1 = "01/09/1991";
		Date birthDate = dateUtils.parseDate(birthDate1);
		sessionFactory = utils.getSessionFactory();
		Student student1 = new Student("italent", "Hyderabad", "italent@hyderabad.com", birthDate);
		Student student2 = new Student("italent", "UK", "italent@uk.com", birthDate);
		Student student3 = new Student("italent", "USA", "italent@usa.com", birthDate);
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.save(student1);
			session.save(student2);
			session.save(student3);
			session.getTransaction().commit();
			System.out.println("successfully saved");

			/* retreiving student */
			retriveStudent();

			/* retrive students list */
			retriveStudentsList();

			/* update student */
			updateStudent();

			/* delete student */
			deleteStudent();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}
	}

	public static void retriveStudent() {
		sessionFactory = utils.getSessionFactory();
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Student retrivedStudent = session.get(Student.class, 1);
			System.out.println("retrived student is " + retrivedStudent.getFirstName() + retrivedStudent.getLastName()
					+ retrivedStudent.getEmail());
			session.getTransaction().commit();
		} catch (Exception e) {
			sessionFactory.close();
		}
	}

	public static void retriveStudentsList() {
		sessionFactory = utils.getSessionFactory();
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Student> studentsList = session.createQuery("from Student").getResultList();
			for (Student student : studentsList) {
				System.out.println("First Name: " + student.getFirstName() + " Last Name: " + student.getLastName()
						+ " Email: " + student.getEmail());
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			sessionFactory.close();
		}
	}

	public static void updateStudent() {
		sessionFactory = utils.getSessionFactory();
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Student student = session.get(Student.class, 1);
			student.setEmail("modifiedemail@gmail.com");
			student.setFirstName("modified first name");
			student.setLastName("modified last name");
			session.update(student);
			session.getTransaction().commit();
			System.out.println("student modified successfully");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void deleteStudent() {
		sessionFactory = utils.getSessionFactory();
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Student student = session.get(Student.class, 2);
			session.delete(student);
			session.getTransaction().commit();
			System.out.println("student deleted successfully");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
