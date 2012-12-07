<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="org.apache.struts.action.ActionMessage"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="org.apache.struts.action.ActionErrors"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	ActionErrors errors = (ActionErrors) request.getAttribute("errors");
	String nameError = "";
	if (errors != null) {
		Iterator<ActionMessage> it = errors.get("userName");
		if (it.hasNext())
			nameError = it.next().getKey();
		request.removeAttribute("errors");
	}
	request.setAttribute("nameError", nameError);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>CysList</title>
<link href="./css/styles.css" rel="stylesheet" media="screen">
</head>
<body>
-	<div class="navbar navbar-inverse navbar-fixed-top">
-		<div class="navbar-inner">
-			<div class="container">
-				<a class="btn btn-navbar" data-toggle="collapse"
-					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
-					class="icon-bar"></span> <span class="icon-bar"></span>
-				</a> <a class="brand" href="/cyslistWeb">CysList</a>
-				<div class="nav-collapse collapse">
-					<ul class="nav">
-						<li class="active"><a href="/cyslistWeb">Home</a></li>
-						<li><html:link action="/UserPostPage">Create Post</html:link></li>
-						<li><html:link action="/ManagePostQueryPage">Manage Post</html:link></li>
-					</ul>
-				</div>
-				<!--/.nav-collapse -->
-			</div>
-		</div>
-	</div>
-	<div class="container">

	<c:if
		test="${sessionScope.active_user == null || !sessionScope.active_user.isAdmin }">
		<logic:redirect action="/cyslistWeb" />
	</c:if>
	<c:if
		test="${sessionScope.active_user != null && sessionScope.active_user.isAdmin}">
		<h1>Delete user by account name</h1>
		<html:form action="/DeleteAccount" method="POST"
			enctype="multipart/form-data">
			<table border="0">
				<tr>
					<td>Account name:</td>
					<td><html:text name="DeleteUserForm" property="userName" /></td>
					<td><font color="red"> <c:out value="${nameError}" /> <c:remove
								var="nameError" />
					</font></td>
				</tr>
				<tr>
					<td></td>
					<td><html:submit value="Submit" /></td>
				</tr>
			</table>
		</html:form>
	</c:if>
	</div>
</body>
</html>