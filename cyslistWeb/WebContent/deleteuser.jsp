<%@ page import="org.apache.struts.action.ActionMessage"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="org.apache.struts.action.ActionErrors"%>
<%@ page import="util.Resources"%>
<%@ page import="model.User"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	boolean anon = (request.getSession().getAttribute(
			Resources.ACTIVE_USER) == null) ? true : false;
	boolean admin = false;
	if (!anon) {
		admin = ((User) request.getSession().getAttribute(
				Resources.ACTIVE_USER)).getIsAdmin();
	}
	ActionErrors errors = (ActionErrors) request.getAttribute("errors");
	String nameError = "";
	if (errors != null) {
		Iterator<ActionMessage> it = errors.get("userName");
		if (it.hasNext())
			nameError = it.next().getKey();
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
	<%
		if (anon || !admin) {
	%>
	<logic:redirect action="/cyslistWeb" />
	<%
		} else {
	%>
	<h1>Delete user by account name</h1>
	<html:form action="/DeleteAccount" method="POST"
		enctype="multipart/form-data">
		<table border="0">
			<tr>
				<td>Account name:</td>
				<td><html:text name="DeleteUserForm" property="userName" /></td>
				<td><font color="red"><%=nameError%></font></td>
			</tr>
			<tr>
				<td></td>
				<td><html:submit value="Submit" /></td>
			</tr>
		</table>
	</html:form>
	<%
		}
	%>
</body>
</html>