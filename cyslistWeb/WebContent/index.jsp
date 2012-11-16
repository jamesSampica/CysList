<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>CysList</title>
 		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="./css/styles.css"  type="text/css"/>
	</head>
	<body>
 	<h1> CYLIST</h1>

	<table class="title">
  		<tr><th>Hello,this is ISU Cylist</th></tr>
		<form method="post" action="">
			<textarea rows="2" cols="5">enter here</textarea>
			<input type="submit" value="search"/>
		</form>
		
	</table>
<h4>Sell/Buy</h4>
	<a href="http://www.w3schools.com">sell/buy</a> </br>
	<table>
	<html:link action="/EmployeeLookupForm">housing</html:link> </br>
	<html:link action="/EmployeeLookupForm">books</html:link></br>
	<html:link action="/EmployeeLookupForm">tickets</html:link></br>
	<html:link action="/EmployeeLookupForm">furniture </html:link></br>
	<html:link action="/EmployeeLookupForm">other</html:link></br>
	</table>
	<h4>study groups</h4> </br>
		<html:link action="/EmployeeLookupForm">ISU majors</html:link></br>
		<html:link action="/EmployeeLookupForm">engineering</html:link></br>
		<html:link action="/EmployeeLookupForm">art</html:link></br>
		<html:link action="/EmployeeLookupForm">etc</html:link></br>
		<html:link action="/EmployeeLookupForm">activities/free food</html:link> </br>
		<html:link action="/EmployeeLookupForm">clubs</html:link> </br>
		<html:link action="/EmployeeLookupForm">helps</html:link></br>
		<html:link action="/EmployeeLookupForm">jobs</html:link> </br>
</body>
</html>
