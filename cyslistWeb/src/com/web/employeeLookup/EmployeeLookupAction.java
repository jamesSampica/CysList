/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.employeeLookup;

import hw5.Employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.hibernate.Session;

import util.HibernateUtil;

public class EmployeeLookupAction extends org.apache.struts.action.Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        EmployeeLookupForm loginForm = (EmployeeLookupForm) form;
        
        HttpSession httpSession =request.getSession(true);
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Employee emp = (Employee) session
                .createQuery("select e from Employee e inner join fetch e.residence where e.employeeId = :eid")
                .setParameter("eid", loginForm.getEmployeeId())
                .uniqueResult();
        
        
        
        if(emp!=null){
			httpSession.setAttribute("name", emp.getName()); 
			httpSession.setAttribute("residence", emp.getResidence().getHomecity()); 
			httpSession.setAttribute("salary", emp.getSalary()); 
			httpSession.setAttribute("dept", emp.getDepartment());
			
			session.getTransaction().commit();
			return mapping.findForward("employeeResult");
		}
		else
			session.getTransaction().commit();
			return mapping.findForward("empty");
    }
}
