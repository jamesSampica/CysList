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
	<h4>Sell/Buy</h4>
	<table>
	<html:link action="/HousingPage">housing</html:link> </br>
	<html:link action="/BooksPage">books</html:link></br>
	<html:link action="/TicketsPage">tickets</html:link></br>
	<html:link action="/FurniturePage">furniture </html:link></br>
	<html:link action="/OtherPage">other</html:link></br>
	</table>
	<h4>Study Groups</h4> </br>
		<html:link action="/EngineeringPage">engineering</html:link></br>
		<html:link action="/ArtPage">art</html:link></br>
		<html:link action="/OtherPage">other</html:link></br>
	<h4>Social</h4> </br>
		<html:link action="/EventsPage">events</html:link> </br>
		<html:link action="/ClubsPage">clubs</html:link> </br>
		<html:link action="/HelpPage">help</html:link></br>
		<html:link action="/JobsPage">jobs</html:link> </br>
</body>
</html>
