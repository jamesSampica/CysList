/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.web.employeeProjectLookup;

public class EmployeeProjectLookupForm extends org.apache.struts.action.ActionForm {
    

    private String projectId;

    public EmployeeProjectLookupForm() {
        super();
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}

