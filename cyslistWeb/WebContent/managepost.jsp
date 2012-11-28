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
 	        <html:form action="/ManagePost" >
            	Title : <html:text name="ManagePostForm" property="title" /> <br>
            	Content : <html:textarea name="ManagePostForm" property="content" cols="50" rows="10" /><br>
            	Topic : <br>
            		<html:radio name="ManagePostForm" property="topic" value="housing" /> Housing<br>
            		<html:radio name="ManagePostForm" property="topic" value="hooks" /> Books<br> 
            	<html:submit value="Post" />
       		</html:form>
	</body>
</html>
