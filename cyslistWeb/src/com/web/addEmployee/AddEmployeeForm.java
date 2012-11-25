/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.web.addEmployee;

public class AddEmployeeForm extends org.apache.struts.action.ActionForm {
    

    private String employeeId;
    private String homezip;
    private String name;
    private String dept;
    private long salary;

    public AddEmployeeForm() {
        super();
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    
    public String getHomezip(){
    	return homezip;
    }
    public void setHomezip(String homezip){
    	this.homezip = homezip;
    }
    
    public String getName(){
    	return name;
    }
    public void setName(String name){
    	this.name = name;
    }
    
    public String getDept(){
    	return dept;
    }
    public void setDept(String dept){
    	this.dept = dept;
    }
    
    public long getSalary(){
    	return salary;
    }
    public void setSalary(long salary){
    	this.salary = salary;
    }
}

