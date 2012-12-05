<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>CysList</title>
 		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="./css/styles.css"  type="text/css"/>
	</head>
	<body>
 	<h1>  ${post.title}</h1>
	<a href="/cyslistWeb/" id="home">home</a>
	<div>
		<table border="1" bordercolor="#000000" style="background-color:#FFFFFF" width="30%" cellpadding="5" cellspacing="1">
			<tr>
    			<td>Date : ${post.date}</td>
    		</tr>
    		<tr>
    			<td>Email : <a href="mailto:${post.email}">${post.email}</a></td>
    		</tr>	
    		<tr>
    			<td>${post.content}</td>
    		</tr>
    		<c:if test="${post.imageExt!='.'}">
    		<tr>
    			<td><img class="imageSizeScale" alt="No image uploaded" src="images/${fn:substring(post.postKey, 12,-1)}${post.imageExt}" /></td>
    		</tr>
    		</c:if>
		</table>
	</div>
	<iframe src="https://www.facebook.com/plugins/like.php?href=YOUR_URL"
        scrolling="no" frameborder="0"
        style="border:none; width:450px; height:80px"></iframe>
</body>
</html>
