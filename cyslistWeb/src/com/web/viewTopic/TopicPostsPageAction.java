package com.web.viewTopic;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.hibernate.Session;

import util.HibernateUtil;

public class TopicPostsPageAction extends org.apache.struts.action.Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        HttpSession httpSession =request.getSession(true);
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        List<String> postList = session.createQuery("from Post where topic='housing'").list();
        Collections.sort(postList);
        
        if(postList != null){
            httpSession.setAttribute("postResults", postList);
        }
        else{
        	httpSession.setAttribute("postResults", "No Results");
        }
        
			
		session.getTransaction().commit();
		return mapping.findForward("housingResult");
    }
}