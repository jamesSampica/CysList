<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HW6</title>
    </head>
    <body>
        <TABLE cellpadding='0' cellspacing='0' class='leftNav'>		
	<TR valign="top">
		<TD class="sideText">
			<div id="navlist" style="padding-top:20px;">
				<UL>
					<LI><html:link action="/EmployeeLookupForm">Search for Employee</html:link></LI>
					<LI><html:link action="/AddEmployeeForm">Add Employee</html:link></LI>
					<LI><html:link action="/EmployeeProjectLookupForm">Search Project Employees</html:link></LI>
				</UL>
			</div>
		</TD>
	</TR>
</TABLE>
    </body>
</html>
