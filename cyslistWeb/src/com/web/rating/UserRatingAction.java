package com.web.rating;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Post;
import model.User;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.classic.Session;

import util.HibernateUtil;

public class UserRatingAction extends org.apache.struts.action.Action {
	/**
	 * if the seller have an account, (preRating+currRating)/2
	 * if the user do not have an account|| no email address on the post, wont do anything
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)
	throws Exception{
		
		UserRatingForm urf = (UserRatingForm) form;
//		HttpSession httpSession = request.getSession(true);
		System.out.println("seller's email:"+urf.getEmail());
		System.out.println("enter rating:"+urf.getRating());
        
		if(urf.getClass()!=null){
			setRating(urf.getEmail(),urf.getRating());
		}
		return mapping.findForward("ratingsuccess");
	}
	
	public static void setRating(String email,int rating)
	{
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		User u = (User)session.createQuery("from User where email = :pemail")
				.setParameter("pemail", email).uniqueResult();
		//if the user exit
		if(u!=null){
			System.out.println("before:"+u.getRating());
			u.setRating((u.getRating()+rating)/2);
		}
		session.getTransaction().commit();
	}
}
