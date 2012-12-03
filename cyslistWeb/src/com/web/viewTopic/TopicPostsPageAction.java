package com.web.viewTopic;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Post;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.hibernate.Session;

import util.HibernateUtil;

/**
 * 
 * @author James Sampica
 * Defines the action for clicking a category on the homepage, gets a collection of posts associated with that topic
 */
public class TopicPostsPageAction extends org.apache.struts.action.Action {

	/**
	 * @param mapping Actionmapping for struts
	 * @param form Actionform for the form object
	 * @param request Request object 
	 * @param response Response object
	 */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
    	TopicPostsPageForm topicForm = (TopicPostsPageForm) form;

    	System.out.println("Topic: "+topicForm.topic);
    	 
        HttpSession httpSession =request.getSession(true);
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        @SuppressWarnings("unchecked")
		List<String> postList = session.createQuery("from Post where topic=:ttopic")
        		.setParameter("ttopic", topicForm.topic).list(); 
        
        Collections.sort(postList);
        
        if(postList != null){
            httpSession.setAttribute("postResults", postList);
            httpSession.setAttribute("category", topicForm.topic);
        }
        else{
        	httpSession.setAttribute("postResults", "No Results");
        }
        
			
		session.getTransaction().commit();
		return mapping.findForward("topicResults");
    }
}