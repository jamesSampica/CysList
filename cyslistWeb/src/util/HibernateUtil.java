/**
 * 
 */
package util;
import java.util.Date;
import java.util.Random;

import model.Post;

import org.apache.struts.upload.FormFile;
import org.hibernate.*;
import org.hibernate.cfg.*;
/**
 * @author James Sampica
 * Defines the session factory for hibernate and common methods used for database queries
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static String createAndStorePost(String topic, String content, String title, String email, FormFile image){
    	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Post newPost = new Post();
        newPost.setContent(content);
        newPost.setEmail(email);
        newPost.setDate(new Date());
        newPost.setTitle(title);
        newPost.setTopic(topic);

        Random gen = new Random();
        String key = String.valueOf(Math.abs(gen.nextLong())) + Math.abs(title.hashCode());
        newPost.setPostKey(key);
        
        session.save(newPost);
        session.getTransaction().commit();
        
        return key;
    }
    public static Post getPostByKey(String key){
    	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Post p = (Post) session.createQuery("from Post where postKey = :pkey")
		.setParameter("pkey", key).uniqueResult();
        
        session.getTransaction().commit();
        
    	return p;
    }
    
    public static void updatePostByKey(String key, String email, String title, String content){
    	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Post postToUpdate = (Post) session.createQuery("from Post where postKey = :pkey")
        .setParameter("pkey", key).uniqueResult();
        
        postToUpdate.setContent(content);
        postToUpdate.setEmail(email);
        postToUpdate.setTitle(title);
        
        session.save(postToUpdate);
        session.getTransaction().commit();
        
    }
    public static void deletePostByKey(String key){
    	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        session.createQuery("delete from Post where postKey = :pkey")
        .setParameter("pkey", key).executeUpdate();
            	
    	session.getTransaction().commit();
    }
}
