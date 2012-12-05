<%@ page import="util.Emailer"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String name = (String) request.getAttribute("name");
	String email = (String) request.getAttribute("email");

	Emailer.sendConfirmationEmail(email, name);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>CysList</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/styles.css" type="text/css" />
</head>
<body>
	<h1>Thanks for signing up for an account.</h1>
	<p>
		A link to activate your account has been emailed to
		<c:out value="${email}" />
		.
	</p>
	<p>Actually, one hasn't been emailed but it can be done! You're
		account has been created.</p>
	<p>
		Return to
		<html:link action="/cyslistWeb">Cyslist Home</html:link>
		.
	</p>
</body>
</html>
