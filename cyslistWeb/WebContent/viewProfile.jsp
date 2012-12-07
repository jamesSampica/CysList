<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
<head>
<title>CysList</title>
<link href="./css/styles.css" rel="stylesheet" media="screen">
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="/cyslistWeb">CysList</a>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<li class="active"><a href="/cyslistWeb">Home</a></li>
						<li><html:link action="/UserPostPage">Create Post</html:link></li>
						<li><html:link action="/ManagePostQueryPage">Manage Post</html:link></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>
	<div class="container">
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
	</div>
</body>
</html>