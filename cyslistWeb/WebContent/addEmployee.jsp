<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HW6</title>
    </head>
    <body>
        <html:form action="/AddEmployee" >
            Employee ID : <html:text name="AddEmployeeForm" property="employeeId" /> <br>
            Name : <html:text name="AddEmployeeForm" property="name" /> <br>
            Department : <html:text name="AddEmployeeForm" property="dept" /> <br>
            Homezip : <html:text name="AddEmployeeForm" property="homezip" /> <br>
            Salary : <html:text name="AddEmployeeForm" property="salary" /> <br>
            <html:submit value="AddEmployee" />
        </html:form>
    </body>
</html>
