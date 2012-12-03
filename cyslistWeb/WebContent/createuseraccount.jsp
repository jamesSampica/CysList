<%@page import="org.apache.struts.action.ActionMessage"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.struts.action.ActionErrors"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	ActionErrors errors = (ActionErrors) request.getAttribute("errors");
	String nameError = "";
	String passError = "";
	String emailError = "";
	if (errors != null) {
		Iterator<ActionMessage> it = errors.get("name");
		if (it.hasNext())
			nameError = it.next().getKey();

		it = errors.get("password");
		if (it.hasNext())
			passError = it.next().getKey();

		it = errors.get("email");
		if (it.hasNext())
			emailError = it.next().getKey();
		request.removeAttribute("errors");
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>cysList</title>
</head>
<body>
	<h1>cysList</h1>
	<html:form action="/CreateAccount" method="POST"
		enctype="multipart/form-data">
		<table border="0">
			<tr>
				<td>Account name:</td>
				<td><html:text name="CreateUserForm" property="name" /></td>
				<td><font color="red"><%=nameError%></font></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><html:password name="CreateUserForm" property="password" /></td>
				<td><font color="red"><%=passError%></font></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><html:text name="CreateUserForm" property="email" /></td>
				<td><font color="red"><%=emailError%></font></td>
			</tr>
			<tr>
				<td></td>
				<td><html:submit value="Submit" /></td>
			</tr>
		</table>
	</html:form>
</body>
</html>