<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd"><html>
<head>
 		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="./css/styles.css"  type="text/css"/>
<title>View Profile</title>
</head>
<body>
	<a href="/cyslistWeb/" id="home">home</a>
	<div>
	<table>
		<h3>Hello! Here is your profile:</h3>
		<tr>
			<h4>Name: ${viewprofile.name}
				</br>
				Email: ${viewprofile.email}
				</br>
				Rating: ${viewprofile.rating}
				</br>
				<c:if test="${active_user.isAdmin==true}">
					isAdmin: Yes
				</c:if>
				
				<c:if test="${active_user.isAdmin==false}">
					isAdmin: No
				</c:if>
			 </h4>
		</tr>
		
		
	</table>
	
	
	</div>
</body>
</html>