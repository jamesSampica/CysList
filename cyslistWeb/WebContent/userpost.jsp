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
 	        <html:form action="/UserPost" enctype="multipart/form-data">
            	Title : <html:text name="UserPostForm" property="title" /> <br>
            	Content : <br><html:textarea name="UserPostForm" property="content" cols="50" rows="10" /><br>
            	Email : <html:text name="UserPostForm" property="email" /><br>
            	Image : <html:file name="UserPostForm" value="Browse ..." property="image" /><br>
            	Topic : <br>
            		<html:radio property="topic" value="housing" /> housing<br>
            		<html:radio property="topic" value="books" /> books<br> 
                  	<html:radio property="topic" value="tickets"/> tickets<br>
                  	<html:radio property="topic" value="furniture" /> furniture<br>
                  	<html:radio property="topic" value="other"/> other<br>
                  	<html:radio property="topic" value="engineering"/> engineering<br>
                  	<html:radio property="topic" value="art/design"/> art/design<br>
                  	<html:radio property="topic" value="other"/> other<br>
                  	<html:radio property="topic" value="events"/> events<br>
                  	<html:radio property="topic" value="clubs"/> clubs<br>
                  	<html:radio property="topic" value="help/tutoring"/> help/tutoring<br>
                  	<html:radio property="topic" value="jobs"/> jobs<br><br>
                  	<html:submit value="Post" />
           </html:form>
	</body>
</html>
