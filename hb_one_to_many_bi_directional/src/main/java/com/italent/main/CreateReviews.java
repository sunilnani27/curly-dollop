package com.italent.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.italent.entities.Review;
import com.italent.entities.Technology;
import com.italent.utils.DataBaseUtils;

public class CreateReviews {

	private static DataBaseUtils dbUtils = null;

	public static void main(String[] args) {
		dbUtils = new DataBaseUtils();

		SessionFactory factory = dbUtils.getSessionFactory();

		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("Saving the reviews");

			Review review = new Review("Great post");
			Review review1 = new Review("Good post");
			Review review2 = new Review("Nice post");

			Technology technology = session.get(Technology.class, 1);
			review.setTechnology(technology);
			review1.setTechnology(technology);
			review2.setTechnology(technology);

			session.save(review);
			session.save(review1);
			session.save(review2);

			System.out.println("reviews saved successfully");
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
