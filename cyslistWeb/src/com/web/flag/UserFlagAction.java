package com.web.flag;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Post;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;

import util.HibernateUtil;

public class UserFlagAction extends org.apache.struts.action.Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	
    	UserFlagForm f = (UserFlagForm) form;
//    	HttpSession httpSession = request.getSession(true);
        System.out.println("flag"+f.getPostKey());
        
        setFlagOnPost(f.getPostKey());
		return mapping.findForward("flagsuccess");
    }
    
	public static void  setFlagOnPost(String key) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Post p = (Post) session.createQuery("from Post where postKey = :pkey")
				.setParameter("pkey", key).uniqueResult();
		p.setIsFlag(true);
		session.getTransaction().commit();
	}
	

}
