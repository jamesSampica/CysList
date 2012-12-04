/**
 * 
 */
package util;

import java.util.Date;
import java.util.Random;

import model.Post;
import model.User;

import org.apache.struts.upload.FormFile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author James Sampica Defines the session factory for hibernate and common
 *         methods used for database queries
 */
public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	static {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			sessionFactory = new Configuration().configure()
					.buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static String createAndStorePost(String topic, String content,
			String title, String email, FormFile image) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Post newPost = new Post();
		newPost.setContent(content);
		newPost.setEmail(email);
		newPost.setDate(new Date());
		newPost.setTitle(title);
		newPost.setTopic(topic);

		Random gen = new Random();
		String key = String.valueOf(Math.abs(gen.nextLong()))
				+ Math.abs(title.hashCode());
		newPost.setPostKey(key);

		session.save(newPost);
		session.getTransaction().commit();

		return key;
	}

	public static Post getPostByKey(String key) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Post p = (Post) session.createQuery("from Post where postKey = :pkey")
				.setParameter("pkey", key).uniqueResult();

		session.getTransaction().commit();

		return p;
	}

	public static void updatePostByKey(String key, String email, String title,
			String content) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Post postToUpdate = (Post) session
				.createQuery("from Post where postKey = :pkey")
				.setParameter("pkey", key).uniqueResult();

		postToUpdate.setContent(content);
		postToUpdate.setEmail(email);
		postToUpdate.setTitle(title);
		postToUpdate.setDate(new Date());

		session.save(postToUpdate);
		session.getTransaction().commit();

	}

	public static void deletePostByKey(String key) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		session.createQuery("delete from Post where postKey = :pkey")
				.setParameter("pkey", key).executeUpdate();

		session.getTransaction().commit();
	}

	public static String createAndStoreUser(String name, String email,
			String password) {
		User toAdd = new User();
		toAdd.setName(name);
		toAdd.setPassword(password);
		toAdd.setEmail(email);
		toAdd.setRating(0);

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		// TODO check for existing account with same email.
		session.save(toAdd);

		session.getTransaction().commit();
		return "success";
	}

	public static User findUser(String name, String password) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		User user = (User) session.createQuery("from User where name = :pname")
				.setParameter("pname", name).uniqueResult();
		session.getTransaction().commit();
		return user;
	}
}
