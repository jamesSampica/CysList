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
 	        <html:form action="/UserPost" >
            	Title : <html:text name="UserPostForm" property="title" /> <br>
            	Content : <html:text name="UserPostForm" property="content" /><br>
            	Topic : <br>
            		<html:radio property="topic" value="housing" /> Housing<br>
            		<html:radio property="topic" value="hooks" /> Books<br> 
            	<html:submit value="Post" />
       		</html:form>
	</body>
</html>
