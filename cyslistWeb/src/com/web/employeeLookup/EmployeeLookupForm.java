/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.web.employeeLookup;

public class EmployeeLookupForm extends org.apache.struts.action.ActionForm {
    

    private String employeeId;

    public EmployeeLookupForm() {
        super();
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}

