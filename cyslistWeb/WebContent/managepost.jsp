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
 	        <html:form action="/UpdatePost" >
            	Title : <html:text name="ManagePostForm" value="${post.title}" property="title" /> <br>
            	Email : <html:text name="ManagePostForm" value="${post.email}" property="email" /> <br>
            	Content :<br> <html:textarea name="ManagePostForm" value="${post.content}" property="content" cols="50" rows="10" /><br> 
            	<html:submit value="Update Post" />
       		</html:form>
       		<html:form action="/DeletePost" >
            	<html:submit value="Delete Post" />
       		</html:form>
	</body>
</html>
