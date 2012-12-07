package com.web.flag;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Post;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;

import util.HibernateUtil;

public class GetFlagAction  extends org.apache.struts.action.Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	
//    	UserFlagForm f = (UserFlagForm) form;
    	HttpSession httpSession = request.getSession(true);
//        System.out.println("flag"+f.getPostKey());
        
        List<Post> p = getFlags();
        httpSession.setAttribute("viewflag", p);
        return mapping.findForward("viewf");
    	
    }
   
	
	public static List<Post> getFlags()
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		List<Post> p =(List<Post>)session.createQuery("from Post where isFlag = true").list();
		Iterator<Post> iter = p.iterator();
		System.out.println("-------------------------------------------------------------");
		while(iter.hasNext())
		{
			Post a = (Post) iter.next();
			System.out.println(""+a.getPostId()+a.getIsFlag());
		}
		System.out.println("-------------------------------------------------------------");
		session.getTransaction().commit();
		return p;
		
	}
}
