<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>CysList</title>
 		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="./css/styles.css"  type="text/css"/>
	</head>
	<body>
 	<h1> Housing</h1>

	<div>
	<table border="1" bordercolor="#000000" style="background-color:#FFFFFF" width="40%" cellpadding="5" cellspacing="1">
		<c:forEach items="${housingResults}" var="entry">
			<tr>
    			<td><html:link action="/ViewPostPage">${entry.title}</html:link></td>
    			<td>${entry.date}</td>
    		</tr>
		</c:forEach>
		</table>
	</div>
</body>
</html>
