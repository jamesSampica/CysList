<%@page import="org.apache.struts.action.ActionMessage"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.struts.action.ActionErrors"%>
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
	request.setAttribute("nameError", nameError);
	request.setAttribute("passError", passError);
%>
<html>
<head>
<title>cysList</title>
</head>
<body>
	<c:if test="${sessionScope.active_user == null}">
		<html:form action="/Login" method="POST" enctype="multipart/form-data">
			<table border="0">
				<tr>
					<td>User Name :</td>
					<td><html:text name="LoginForm" property="userName" /></td>
					<td><font color="red"> <c:out value="" /> <c:out
								value="${nameError}" /> <c:remove var="nameError" />
					</font></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><html:password name="LoginForm" property="password" /></td>
					<td><font color="red"><c:out value="${passError}" /> <c:remove
								var="passError" /> </font></td>
				</tr>
				<tr>
					<td></td>
					<td><html:submit value="Login" /></td>
					<td></td>
				</tr>
			</table>
		</html:form>
		<html:link action="/CreateUserAccount">Create Account</html:link>
	</c:if>
	<c:if test="${sessionScope.active_user != null}">
		<html:link action="/Logout">Logout</html:link>
	</c:if>
</body>
</html>