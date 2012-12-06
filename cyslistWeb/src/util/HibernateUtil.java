/**
 * 
 */
package util;

import java.util.Date;
import java.util.List;
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

	public static Post createAndStorePost(String topic, String content,
			String title, String email, FormFile image, String ext) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Post newPost = new Post();
		newPost.setContent(content);
		newPost.setEmail(email);
		newPost.setDate(new Date());
		newPost.setTitle(title);
		newPost.setTopic(topic);
		newPost.setImageExt(ext);

		Random gen = new Random();
		String key = String.valueOf(Math.abs(gen.nextLong()))
				+ Math.abs(title.hashCode());
		newPost.setPostKey(key);

		session.save(newPost);
		session.getTransaction().commit();

		return newPost;
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
	public static void deletePostFromUser(User u, String key){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Post p = (Post) session
				.createQuery("from Post where postKey = :pkey")
				.setParameter("pkey", key).uniqueResult();
		
		User dbUser = (User) session.createQuery("from User as u left join fetch u.posts where u.name = :name")
				.setParameter("name", u.getName()).uniqueResult();
		
		dbUser.getPosts().remove(p);
		
		session.save(dbUser);
		session.getTransaction().commit();
	}
	
	public static void deletePostByKey(String key) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		session.createQuery("delete from Post where postKey = :pkey")
				.setParameter("pkey", key).executeUpdate();

		session.getTransaction().commit();
	}

	public static void addPostToUser(Post p, User u) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		User user = (User) session
				.createQuery(
						"from User as u left join fetch u.posts where u.name = :pname")
				.setParameter("pname", u.getName()).uniqueResult();
		user.getPosts().add(p);

		session.save(user);
		session.getTransaction().commit();
	}

	/**
	 * Creates a new user and attempts to store it in the database. The user
	 * will not be stored if a user with the same account name already exists.
	 * 
	 * @param name
	 *            The name of the account.
	 * @param email
	 *            The email of the account.
	 * @param password
	 *            The password (encrypted) of the account.
	 * @param adminKey
	 *            Whether the user is an admin or not.
	 * @return True if successfully added to the database, false otherwise.
	 */
	@SuppressWarnings("unchecked")
	public static boolean createAndStoreUser(String name, String email,
			String password, String adminKey) {
		User toAdd = new User();
		toAdd.setName(name);
		toAdd.setPassword(password);
		toAdd.setEmail(email);
		toAdd.setRating(0);
		toAdd.setIsAdmin((adminKey.equals(Resources.ADMIN_KEY)) ? true : false);

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		// TODO check for existing account with same email or name.
		List<User> check = (List<User>) session
				.createQuery("from User where name = :pname")
				.setParameter("pname", name).list();

		if (check.isEmpty())
			session.save(toAdd);

		session.getTransaction().commit();

		if (check.isEmpty())
			return true;
		else
			return false;
	}

	/**
	 * Attempts to search for a user with the given account name.
	 * 
	 * @param name
	 *            The name of the user to search for.
	 * @return The user found or null if not (I think).
	 */
	public static User findUserByName(String name) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		User user = (User) session
				.createQuery(
						"from User as u left join fetch u.posts where u.name = :pname")
				.setParameter("pname", name).uniqueResult();
		session.getTransaction().commit();
		return user;
	}

	/**
	 * Attempts to search for a user with the given email.
	 * 
	 * @param email
	 *            The email of the user to search for.
	 * @return The user found or null if not (I think).
	 */
	public static User findUserByEmail(String email) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		User user = (User) session
				.createQuery(
						"from User as u left join fetch u.posts where email = :pemail")
				.setParameter("pemail", email).uniqueResult();
		session.getTransaction().commit();
		return user;
	}

	/**
	 * Deletes a single user from the database.
	 * 
	 * @param toDel
	 *            The User to delete.
	 */
	public static void deleteUser(User toDel) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		session.delete(toDel);

		session.getTransaction().commit();
	}

	/**
	 * Gets a list of all users in the database.
	 * 
	 * @return A list of User.
	 */
	@SuppressWarnings("unchecked")
	public static List<User> getAllUsers() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		List<User> users = session.createQuery("from User").list();

		session.getTransaction().commit();
		return users;
	}

	/**
	 * Deletes all users in the provided list.
	 * 
	 * @param toDel
	 *            A list of User to delete.
	 */
	public static void deleteUser(List<User> toDel) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		for (User u : toDel) {
			session.delete(u);
		}

		session.getTransaction().commit();
	}
}
