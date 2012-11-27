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
 	<h1> CysList</h1>

	<table class="title">
		<form method="post" action="">
			<textarea rows="2" cols="5">enter here</textarea>
			<input type="submit" value="search"/>
		</form>
		
	</table>
	<h4><html:link action="/UserPostPage">Post</html:link> </h4>
	<h4><html:link action="/ManagePostPage">Manage Posts</html:link> </h4>
	<div style="color:red">
    	<html:errors />
    </div>
    <html:form action="/Login" >
    	User Name : <html:text name="LoginForm" property="userName" /> <br>
        Password  : <html:password name="LoginForm" property="password" /> <br>
    	<html:submit value="Login" />
    </html:form>
    
	<h4>Sell/Buy</h4>
	<table>
	<tr><td><html:link action="/HousingPage">housing</html:link> </td></tr>
	<tr><td><html:link action="/BooksPage">books</html:link> </td></tr>
	<tr><td><html:link action="/TicketsPage">tickets</html:link> </td></tr>
	<tr><td><html:link action="/FurniturePage">furniture </html:link> </td></tr>
	<tr><td><html:link action="/OtherPage">other</html:link> </td></tr>
	</table>
	<h4>Study Groups</h4>
	<table>
		<tr><td><html:link action="/EngineeringPage">engineering</html:link></td></tr>
		<tr><td><html:link action="/ArtPage">art</html:link></td></tr>
		<tr><td><html:link action="/OtherPage">other</html:link></td></tr>
	</table>
	<h4>Social</h4>
	<table>
		<tr><td><html:link action="/EventsPage">events</html:link></td></tr>
		<tr><td><html:link action="/ClubsPage">clubs</html:link></td></tr>
		<tr><td><html:link action="/HelpPage">help</html:link></td></tr>
		<tr><td><html:link action="/JobsPage">jobs</html:link></td></tr>
	</table>
</body>
</html>
