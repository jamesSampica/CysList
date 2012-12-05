<%@page import="org.apache.struts.action.ActionMessage"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.struts.action.ActionErrors"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	ActionErrors errors = (ActionErrors) request.getAttribute("errors");
	String nameError = "";
	String passError = "";
	if (errors != null) {
		Iterator<ActionMessage> it = errors.get("userName");
		if (it.hasNext())
			nameError = it.next().getKey();

		it = errors.get("password");
		if (it.hasNext())
			passError = it.next().getKey();

		request.removeAttribute("errors");
	}

	boolean anon = (request.getSession().getAttribute("active_user") == null) ? true
			: false;
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>cysList</title>
</head>
<body>
	<%
		if (anon) {
	%>
	<html:form action="/Login" method="POST" enctype="multipart/form-data">
		<table border="0">
			<tr>
				<td>User Name :</td>
				<td><html:text name="LoginForm" property="userName" /></td>
				<td><font color="red"><%=nameError%></font></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><html:password name="LoginForm" property="password" /></td>
				<td><font color="red"><%=passError%></font></td>
			</tr>
			<tr>
				<td></td>
				<td><html:submit value="Login" /></td>
				<td></td>
			</tr>
		</table>
	</html:form>
	<html:link action="/CreateUserAccount">Create Account</html:link>
	<%
		} else {
	%>
	<html:link action="/Logout">Logout</html:link>
	<%
		}
	%>
</body>
</html>