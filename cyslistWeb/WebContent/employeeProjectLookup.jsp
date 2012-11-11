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
        <html:form action="/EmployeeProjectLookup" >
            Project ID : <html:text name="EmployeeProjectLookupForm" property="projectId" /> <br>
            <html:submit value="EmployeeProjectLookup" />
        </html:form>
    </body>
</html>
