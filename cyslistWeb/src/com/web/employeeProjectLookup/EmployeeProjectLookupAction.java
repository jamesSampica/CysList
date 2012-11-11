/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.employeeProjectLookup;

import java.util.List;

import hw5.Employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.hibernate.Session;

import util.HibernateUtil;

public class EmployeeProjectLookupAction extends org.apache.struts.action.Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	
        EmployeeProjectLookupForm lookupForm = (EmployeeProjectLookupForm) form;
        
        HttpSession httpSession =request.getSession(true);
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        List<?> result = session.createQuery("select e from Employee e inner join fetch e.projects as ep where ep.projectCode = :pCode")
        						.setParameter("pCode", lookupForm.getProjectId()).list();
        
        StringBuilder resultConcat = new StringBuilder();
        for(int i = 0; i < result.size(); i++){
        	Employee emp = (Employee)result.get(i);
        	resultConcat.append(emp.geteId() + " "+ emp.getName() +" "+ emp.getDepartment() +" "+ emp.getSalary() + "<br>");
        }
        
        httpSession.setAttribute("result", resultConcat.toString());
			
		session.getTransaction().commit();
		return mapping.findForward("employeeProjectResult");
    }
}
