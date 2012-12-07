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
 	<h1>${category}</h1>
	<a href="/cyslistWeb/" id="home">home</a>
	<div>
	<table border="1" bordercolor="#000000" style="background-color:#FFFFFF" width="40%" cellpadding="5" cellspacing="1">
		<c:set var="counter" value="1" />
		<c:forEach items="${postResults}" var="entry">
			<tr>
				<html:form action="/ViewPostPage">
					<td>
						${counter}
						<html:hidden name="ViewPostForm" property="postNum" value="${counter}"/>
					</td>
    				<td width="50%">
    					 <html:submit value="${entry.title}" styleClass="linkbutton" />				
    				</td>
    			</html:form>
    			<td>${entry.date}</td>
    		</tr>
    		<c:set var="counter" value="${counter+1}" />
		</c:forEach>
		</table>
	</div>
	</div>
</body>
</html>
