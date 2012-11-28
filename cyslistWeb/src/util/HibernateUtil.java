/**
 * 
 */
package util;
import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

import model.Post;

import org.hibernate.*;
import org.hibernate.cfg.*;
/**
 * @author Hibernate download
 *
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
    
    public static String createAndStorePost(String topic, String content, String title){
    	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Post newPost = new Post();
        newPost.setContent(content);
        
        newPost.setDate(new Date());
        
        newPost.setTitle(title);
        newPost.setTopic(topic);
        
        Random gen = new Random();
        String key = String.valueOf(gen.nextLong()) + title.hashCode();
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
}
