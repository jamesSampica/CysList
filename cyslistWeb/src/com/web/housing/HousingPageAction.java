package com.web.housing;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.hibernate.Session;

import util.HibernateUtil;

public class HousingPageAction extends org.apache.struts.action.Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        //HttpSession httpSession =request.getSession(true);
        //Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //session.beginTransaction();

        
        //httpSession.setAttribute("result", resultConcat.toString());
			
		//session.getTransaction().commit();
		return mapping.findForward("housingResult");
    }
}