package com.web.viewProfile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.classic.Session;

import util.HibernateUtil;

public class ViewProfileAction extends org.apache.struts.action.Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	ViewProfileForm f = (ViewProfileForm) form;
		
    	HttpSession httpSession=request.getSession(true);
    	User u = getUserInfo(f.getName());

		httpSession.setAttribute("viewprofile", u); 
		return mapping.findForward("viewp");
    	
    }

	public static User getUserInfo(String name) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		User u = (User) session.createQuery("from User where name = :pname")
				.setParameter("pname", name).uniqueResult();
		System.out.println("-------------------------------------------------------------");
		System.out.println("NAME:"+u.getName()+" EMAIL:"+u.getEmail());

		System.out.println("-------------------------------------------------------------");

		return u;
	}
}
