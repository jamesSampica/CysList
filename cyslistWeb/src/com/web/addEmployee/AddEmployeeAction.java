/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.addEmployee;

import hw5.Employee;
import hw5.Residence;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.hibernate.Session;

import util.HibernateUtil;

public class AddEmployeeAction extends org.apache.struts.action.Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        AddEmployeeForm empForm = ( AddEmployeeForm) form;
        
        Employee emp = new Employee();
        emp.setEmployeeId(empForm.getEmployeeId());
        
        Residence r = (Residence) session
                .createQuery("select r from Residence r where r.zipcode = :zip")
                .setParameter("zip",empForm.getHomezip())
                .uniqueResult();
        
        emp.setResidence(r);
        emp.setName(empForm.getName());
        emp.setSalary(empForm.getSalary());
        emp.setDepartment(empForm.getDept());

        session.save(emp);

		session.getTransaction().commit();
		return mapping.findForward("added");
    }
}
