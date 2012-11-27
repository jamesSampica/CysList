package com.web.housing;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.hibernate.Session;

import model.Post;
import util.HibernateUtil;

public class HousingPageAction extends org.apache.struts.action.Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        HttpSession httpSession =request.getSession(true);
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        List<?> postList = session.createQuery("from Post where topic='housing'").list();
        
        if(postList != null){
            httpSession.setAttribute("housingResults", postList);
        }
        else{
        	httpSession.setAttribute("housingResults", "No Results");
        }
        
			
		session.getTransaction().commit();
		return mapping.findForward("housingResult");
    }
}