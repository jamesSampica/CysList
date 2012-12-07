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
						<li><html:link action="/UserPostPage">Create Post</html:link></li>
						<li class="active"><html:link action="/ManagePostQueryPage">Manage Post</html:link></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>
	<div class="container">
 	        <html:form action="/UpdatePost" >
            	Title : <html:text name="ManagePostForm" value="${post.title}" property="title" /> <br>
            	Email : <html:text name="ManagePostForm" value="${post.email}" property="email" /> <br>
            	Content :<br> <html:textarea name="ManagePostForm" value="${post.content}" property="content" cols="50" rows="10" /><br> 
            	<html:submit value="Update Post" />
       		</html:form>
       		<html:form action="/DeletePost" >
            	<html:submit value="Delete Post" />
       		</html:form>
       		</div>
	</body>
</html>
