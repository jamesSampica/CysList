<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
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
						<li><a href="/cyslistWeb">Home</a></li>
						<li class="active"><html:link action="/UserPostPage">Create Post</html:link></li>
						<li><html:link action="/ManagePostQueryPage">Manage Post</html:link></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>
	<div class="container">
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
                  	<html:radio property="topic" value="engineering"/> engineering<br>
                  	<html:radio property="topic" value="art/design"/> art/design<br>
                  	<html:radio property="topic" value="other"/> other<br>
                  	<html:radio property="topic" value="events"/> events<br>
                  	<html:radio property="topic" value="clubs"/> clubs<br>
                  	<html:radio property="topic" value="help/tutoring"/> help/tutoring<br>
                  	<html:radio property="topic" value="jobs"/> jobs<br><br>
                  	<html:submit value="Post" />
           </html:form>
           </div>
	</body>
</html>
